from pathlib import Path


TARGET_DIR = Path(".") / "database" / "data" / "tre"

for year in range(2007, 2026):
    folder_path = TARGET_DIR / str(year)
    folder_path.mkdir(parents=True, exist_ok=True)

print(f"Folders successfully created in: {TARGET_DIR.resolve()}")
