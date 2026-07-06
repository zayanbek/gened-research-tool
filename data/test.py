import requests

url = "https://courses.illinois.edu/cisapp/rest/catalog"

response = requests.get(url)

print(response.status_code)
print(response.headers.get("Content-Type"))
print(response.text[:500])