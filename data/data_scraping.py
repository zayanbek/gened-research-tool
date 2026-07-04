import os
import psycopg
from dotenv import load_dotenv

load_dotenv()
def get_connection():
    return psycopg.connect(
        host="localhost",
        port=5432,
        dbname="uiuc-gened-gpa-database",
        user="postgres",
        password=os.getenv("DB_PASSWORD")
    )
    
conn = get_connection()
cur = conn.cursor()

cur.execute("SELECT * FROM distinct_courses LIMIT 10;")

for row in cur.fetchall():
    print(row)

cur.close()
conn.close()