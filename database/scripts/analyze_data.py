# Print the column headers and there lengths as a string"
# Used for import csv data into a SQL table

import pandas as pd

file_name = "../data/uiuc-tre-dataset.csv"

df = pd.read_csv(file_name)

for column in df.columns:
    max_length = df[f"{column}"].astype(str).str.len().max()
    
    print(f"\"{column}\"\t\t{max_length}")
    
print()

"""
CREATE TABLE load_tre_csv (
    "term" VARCHAR(10),
    "unit" VARCHAR(100),
    "lname" VARCHAR(50),
    "fname" VARCHAR(10),
    "role" VARCHAR(50),
    "ranking" VARCHAR(50),
    "course" VARCHAR(10)
);  

"""



"""
CREATE TABLE load_courses_gen_ed_csv (
    Year INTEGER,
    Term VARCHAR(10),
    TermYear VARCHAR(10),
    Course VARCHAR(10),
    Course Title VARCHAR(100),
    ACP VARCHAR(5),
    CS VARCHAR(5),
    HUM VARCHAR(5),
    NAT VARCHAR(5),
    QR VARCHAR(5),
    SBS VARCHAR(5)
);  
  
"""

"""

CREATE TABLE course_catalog (
	Year INTEGER,
	Term VARCHAR(10),
	Subject VARCHAR(10),
	Number INTEGER,
	Name TINYTEXT,
	
    Description TEXT(3000),
	Credit Hours VARCHAR(50),
	Section Info TEXT(1000),
    Section Title TEXT(50),
    Section Credit Hours INTEGER,
);

"""