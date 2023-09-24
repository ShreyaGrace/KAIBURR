# Task 1. Java REST API
To implement a Java application that provides a REST API with endpoints for searching, creating, and deleting "server" objects, a web framework like Spring Boot can be used. Spring Boot simplifies the process of building RESTful applications in Java.

A new Spring Boot project using the build tool Maven was created. Spring Initializr was used to generate the project template with the necessary dependencies.
A Server class was created to represent the server objects.JPA annotations were used to store the server data in a database.
A REST controller was created to define the endpoints for searching, creating, and deleting servers.

# Task 2. Swagger codegen
Added the necessary dependencies for Swagger.
Created a configuration class to enable Swagger in the Spring Boot application.
Created a controller class with the API endpoints.

# Task 6. Data Science
Performing text classification on a consumer complaint dataset involves training a machine learning model to categorize text complaints into predefined categories or labels.
Initially imported the necessary Python libraries and loaded the consumer complaint dataset into a pandas DataFrame.
Performed the preprocessing the text data to make it suitable for model training. This included steps like lowercasing, tokenization, removing stopwords, and stemming or lemmatization.
Split the dataset into a training set and a testing set to evaluate the model's performance on unseen data.
Converted the text data into numerical features that machine learning models can understand.
Selected a machine learning model for text classification such as Naive Bayes classifier.
Used the trained model to make predictions on the test set and evaluate its performance using metrics like accuracy, precision, recall, and F1-score.
