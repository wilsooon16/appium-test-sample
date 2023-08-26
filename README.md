# Appium Test Sample

## Appium Automation Project

This repository contains the solution for a mobile automation assessment. The goal of this assessment is to automate tests for a sample mobile application using Appium.

### Introduction

This project demonstrates the solution for automating tests for the sample mobile application using Appium. The tests cover various scenarios such as user registration, login, and other relevant use cases specified in the assessment.

### Project Structure

<img width="441" alt="Screenshot 2023-08-26 at 17 13 34" src="https://github.com/wilsooon16/appium-test-sample/assets/45891415/91b9e96a-9e3b-4b28-b5a5-3f51d46b15da">


### Prerequisites

- Java Development Kit (JDK) (min Java 8)
- Apache Maven (Apache Maven 3.9.2)
- Android Studio (for Appium dependencies and Android SDK)
- Appium server installed and running (Appium version 1.22.3)
- Mobile device/emulator setup for testing

### Setup

1. Clone this repository to your local machine.
2. Install the necessary dependencies by running `mvn clean install`.

### Running Tests

1. Make sure your Appium server is running and your mobile device/emulator is ready.
2. Open a terminal and navigate to the project directory.
3. Run the tests using the following command:
`mvn test -DsuiteXmlFile=testng.xml`


### Test Reports

After running the tests, the test reports will be generated in the `test-output` directory. You can open the HTML reports in a web browser to view the test results.
