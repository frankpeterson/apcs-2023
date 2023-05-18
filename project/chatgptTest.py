import requests
from openpyxl import Workbook

# Function to retrieve stock prices from the Polygon API
def get_stock_prices(symbol):
    api_key = "TdipY0qGvrRit_CZUytOB60H4sgkWqOy"  # Replace with your Polygon API key
    url = f"https://api.polygon.io/v1/open-close/{symbol}/2021-01-01?apiKey={api_key}"

    response = requests.get(url)
    data = response.json()
    
    if 'status' in data and data['status'] == 'OK':
        return data['symbol'], data['open'], data['close']
    else:
        return None

# Define the symbols of the stocks you want to retrieve data for
symbols = ["AAPL", "MSFT", "GOOGL"]

# Create a new workbook
workbook = Workbook()

# Select the active sheet
sheet = workbook.active

# Write headers to the sheet
sheet.append(["Symbol", "Open", "Close"])

# Retrieve and write stock data to the sheet
for symbol in symbols:
    stock_data = get_stock_prices(symbol)
    if stock_data:
        symbol, open_price, close_price = stock_data
        sheet.append([symbol, open_price, close_price])

# Save the workbook to a file
workbook.save("stock_prices.xlsx")
