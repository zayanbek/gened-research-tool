# Print the column headers and there lengths as a string"
# Used for import csv data into a SQL table

import pandas as pd

file_name = "uiuc-gpa-dataset.csv"

df = pd.read_csv(file_name)

for column in df.columns:
    max_length = df[f"{column}"].astype(str).str.len().max()
    
    print(f"\"{column}\" \t	 {max_length}")