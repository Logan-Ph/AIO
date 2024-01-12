import pandas as pd
import json

# Load the JSON file into a DataFrame
df = pd.read_json('rBuy.products.json')

# Change the format of 'owner' and '_id' attributes
# df['_id'] = df['_id'].apply(lambda x: x['$oid'] if isinstance(x, dict) and '$oid' in x else x)
df = df.rename(columns={'_id': 'objectID'})

# Save the modified DataFrame back to the JSON file
df.to_json('rBuy.products.json', orient='records')