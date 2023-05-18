from polygon import RESTClient
import config
import json
from typing import cast
from urllib3 import HTTPResponse

client = RESTClient(config.API_KEY)



ticker = "CLF"
info = client.get_aggs(ticker=ticker, multiplier=1, timespan="day", from_="2023-01-09", to="2023-05-10")
for line in info:
    print(line)

