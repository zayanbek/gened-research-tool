import os
import psycopg
from dotenv import load_dotenv
    
load_dotenv()

# establish database connection
 
db_connection = psycopg.connect(
        host="localhost",
        port=5432,
        dbname="uiuc-gened-gpa-database",
        user=os.getenv("DB_USERNAME"),
        password=os.getenv("DB_PASSWORD")
    )

cur = db_connection.cursor()

############################################################
# Reset counts
############################################################

cur.execute("""
UPDATE instructors
SET times_excellent = 0,
    times_outstanding = 0
""")

############################################################
# Load instructors
############################################################

cur.execute("""
SELECT id, name
FROM instructors
""")

instructors = {}

# (lname, firstname)
full_lookup = defaultdict(list)

# (lname, initial)
initial_lookup = defaultdict(list)

for instructor_id, name in cur.fetchall():
    last, firsts = name.split(",", 1)

    last = last.strip().upper()

    first = firsts.strip().split()[0].upper()

    initial = first[0]

    instructor = {
        "id": instructor_id,
        "last": last,
        "first": first,
        "initial": initial,
    }

    instructors[instructor_id] = instructor

    full_lookup[(last, first)].append(instructor)

    initial_lookup[(last, initial)].append(instructor)

############################################################
# Load course history
############################################################

cur.execute("""
SELECT
    instructor_id,
    subject,
    year,
    term
FROM course_information
""")

course_lookup = defaultdict(set)

for instructor_id, subject, year, term in cur.fetchall():

    course_lookup[
        (
            subject.upper(),
            year,
            term.upper()
        )
    ].add(instructor_id)

############################################################
# Read TRE rows
############################################################

cur.execute("""
SELECT
    term,
    unit,
    lname,
    fname,
    ranking
FROM load_tre_csv
""")

counts = defaultdict(lambda: {"excellent": 0, "outstanding": 0})

unresolved = []


def parse_term(term):
    code = term[:2].lower()
    year = int(term[2:])

    mapping = {
        "fa": "FALL",
        "sp": "SPRING",
        "su": "SUMMER",
        "wi": "WINTER",
    }

    return year, mapping[code]


############################################################
# Matching
############################################################

for term, subject, lname, fname, ranking in cur.fetchall():

    lname = lname.strip().upper()
    fname = fname.strip().upper()

    year, semester = parse_term(term)

    ########################################################
    # 1) Full first name
    ########################################################

    candidates = full_lookup.get((lname, fname), [])

    ########################################################
    # 2) Initial
    ########################################################

    if not candidates:

        candidates = initial_lookup.get((lname, fname[0]), [])

    ########################################################
    # 3) Resolve using course history
    ########################################################

    if len(candidates) > 1:

        teaching = course_lookup.get(
            (
                subject.upper(),
                year,
                semester,
            ),
            set(),
        )

        candidates = [
            c for c in candidates
            if c["id"] in teaching
        ]

    ########################################################
    # Count
    ########################################################

    if len(candidates) == 1:

        instructor_id = candidates[0]["id"]

        if ranking.lower() == "excellent":
            counts[instructor_id]["excellent"] += 1
        elif ranking.lower() == "outstanding":
            counts[instructor_id]["outstanding"] += 1

    else:

        unresolved.append(
            (lname, fname, subject, term, ranking)
        )

############################################################
# Update database
############################################################

updates = []

for instructor_id in instructors:

    excellent = counts[instructor_id]["excellent"]
    outstanding = counts[instructor_id]["outstanding"]

    updates.append(
        (
            excellent,
            outstanding,
            instructor_id,
        )
    )

cur.executemany(
    """
    UPDATE instructors
    SET
        times_excellent = %s,
        times_outstanding = %s
    WHERE id = %s
    """,
    updates,
)

conn.commit()

print(f"Updated {len(updates)} instructors")
print(f"Unresolved rows: {len(unresolved)}")

for row in unresolved:
    print(row)

# close database connection
cur.close()
db_connection.close()
