from flask import Flask, request, render_template
import pickle
import numpy as np
import pandas as pd

app = Flask(__name__)

# Load trained model and transformers
lrmodel = pickle.load(open('models/logistic.pkl', 'rb'))
ctransforms = pickle.load(open('models/ct.pkl', 'rb'))

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        try:
            # Collecting user input
            time_spent = float(request.form['time_spent'])
            age = int(request.form['age'])
            income = float(request.form['income'])
            internet_usage = float(request.form['internet_usage'])
            male = int(request.form['male'])

            # Creating DataFrame
            input_data = pd.DataFrame([[time_spent, age, income, internet_usage, male]], 
                                      columns=['Daily Time Spent on Site', 'Age', 'Area Income', 'Daily Internet Usage', 'Male'])

            # Apply transformations
            new_data = ctransforms.transform(input_data)

            # Make prediction
            prediction = lrmodel.predict(new_data)[0]

            return render_template('index.html', prediction=prediction)
        
        except Exception as e:
            return render_template('index.html', prediction=f"Error: {str(e)}")

    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
