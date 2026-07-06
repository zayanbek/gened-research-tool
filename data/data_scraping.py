import os
import psycopg
from dotenv import load_dotenv

import requests
from bs4 import BeautifulSoup
    
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

# Start data scraping

url = "https://courses.illinois.edu/gened/2026/fall/ACP"

response = requests.get(url)

print(response.status_code)
print(response.url)
print(response.text[:1000])

soup = BeautifulSoup(response.text, "html.parser")

tbody = soup.find("table", id="gened-req-table").find("tbody")

tbody_rows = tbody.find_all("tr")

for row in tbody_rows:
    cells = row.find_all("td")
    print(cells)

# close database connection
cur.close()
db_connection.close()
