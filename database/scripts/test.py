from bs4 import BeautifulSoup
import csv

with open("data\websiteCopied.txt", encoding="utf-8") as f:
    soup = BeautifulSoup(f.read(), "html.parser")

# Find the table by ID
table = soup.find("table", id="schedule-term-table")

rows = []

# Iterate over each row in the table body
for tr in table.find("tbody").find_all("tr"):
    tds = tr.find_all("td")

    code = tds[0].get_text(strip=True)

    link = tds[1].find("a")
    subject = link.get_text(strip=True)
    href = link["href"]

    rows.append({
        "Code": code,
        "Subject": subject
    })
    
    #print(code, subject)

# Write to CSV
with open("subjects.csv", "w", newline="", encoding="utf-8") as f:
    writer = csv.DictWriter(f, fieldnames=["Code", "Subject"])
    writer.writeheader()
    writer.writerows(rows)

print(f"Wrote {len(rows)} subjects.")