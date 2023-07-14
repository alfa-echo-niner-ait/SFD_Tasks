from flask import Flask, jsonify

app = Flask(__name__)

employees = [
    {"name": "Shawn", "title": "CEO"},
    {"name": "Elon", "title": "CTO"},
    {"name": "Mark", "title": "Senior Developer"},
    {"name": "Emon", "title": "Junior Developer"},
    {"name": "Bill", "title": "Junior Developer"},
    {"name": "Puna", "title": "Product Manager"}
]

@app.route('/employees', methods=['GET'])
def get_employees():
    response = jsonify(employees)
    # Add this to ignore CORS Policy blocking
    response.headers.add("Access-Control-Allow-Origin", "*")
    return response

if __name__ == '__main__':
    app.run(debug=True)
