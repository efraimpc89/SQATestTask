# SQA Test Task

This repository is home to the SQA Test Task, a RestAssured-based automated testing solution. This project is specifically designed for testing https://jsonplaceholder.typicode.com/ REST APIs.

The framework follows a service object model approach to accommodate scalable testing needs, leveraging Java as the main programming language and TestNG as the testing framework.

## Project Structure
```
SQATestTask
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───constants
│   │   │   ├───helpers
│   │   │   └───models
│   │   └───resources
│   └───test
│       └───java
│           └───tests
├───.gitignore
├───pom.xml
└───README.md
```

## Service Object Model Pattern

The project uses the **Service Object Model pattern** which organizes the code into **three distinct layers**: Service, Model, and Test.

### 1. Service Layer
The service layer is responsible for interacting with the REST API. It does this by acting as a client to the API and executing interactions such as sending GET, POST, PUT, PATCH, DELETE requests, and receiving responses. 

For instance, in this specific project, classes corresponding to the service layer can be found under the `helpers` folder. These classes define methods to send requests to API endpoints such as '`/posts`, `/comments`, and more.

### 2. Model Layer
The model layer is essential for representing the data models. These models usually map directly to either the database schema or the structure of the web resource's data. The classes in this layer will contain properties of the resources and can also include methods for performing operations on the properties.

In reference to the project in question, the classes pertaining to the model layer are located in the `models` directory. These classes (such as Comment, Post, etc.) each have properties that match the data structure for the corresponding API resource.

### 3. Test Layer
The test layer is the layer where all the tests are defined and carried out. The service layer is employed for making requests and validating the response against the expected results. Moreover, for many tests, this layer may include logic for set up and tear down of conditions needed to execute tests.

In the given project, the test layer is found under the `tests` directory. Each file housed in this directory represents a test suite specific to a particular resource, and uses the methods from the service layer to test the behavior of the API.

The Service Object Model pattern brings about a separation of concerns which grants the code into clean and modifiable sections. While the service layer involves interactions with the API, the model layer represents the data. The test layer works to combine the previous two layers to assert and verify correct behavior of the system.


## Tech Stack Overview
* **Java** - The main programming language used in this project. Version 17.
* **RestAssured** - A Java DSL for simplifying testing of REST based services.
* **TestNG** - A testing framework used to drive all kinds of testing.
* **Maven** - The build tool used for managing dependencies, compiling, running tests, and reporting.

## How to Execute
To execute the project normally, you can simply right-click on the TestNG test suite XML file and run as a TestNG Suite.

Alternatively, you can execute the test suite via Maven command:

Using Terminal, navigate to the project root and execute the following command:

```shell
mvn clean test
```

Note: Make sure that Maven is installed on your machine and the environment variables are properly set up.

For more information, please check the source codes and comments for each class and method.
