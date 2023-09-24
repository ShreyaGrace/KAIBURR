from flask import Flask, request, render_template, redirect, url_for
import requests

app = Flask(__name__)

API_URL = 'http://localhost:8080/api/servers'

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        name = request.form.get('name')
        language = request.form.get('language')
        framework = request.form.get('framework')
        requests.put(API_URL, json={'name': name, 'language': language, 'framework': framework})
        return redirect(url_for('index'))

    servers = requests.get(API_URL).json()
    return render_template('index.html', servers=servers)

@app.route('/delete/<id>', methods=['POST'])
def delete(id):
    requests.delete(f'{API_URL}/{id}')
    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)
