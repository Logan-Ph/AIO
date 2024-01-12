import json
import os

def convert_json_to_jsonl(filename):
    json_filepath = os.path.join(os.getcwd(), filename + '.json')
    jsonl_filepath = os.path.join(os.getcwd(), filename + '.jsonl')

    with open(json_filepath, 'r', encoding='utf-8') as json_file:
        data = json.load(json_file)

    with open(jsonl_filepath, 'w', encoding='utf-8') as jsonl_file:
        for entry in data:
            json.dump(entry, jsonl_file)
            jsonl_file.write('\n')

convert_json_to_jsonl("rBuy.products")