# appium-test-sample
Appium Automation Project
This repository contains the solution for mobile automation assessment. The goal of this assessment is to automate tests for the sample mobile application using Appium.

Introduction
This project demonstrates the solution for automating tests for the sample mobile application using Appium. The tests cover various scenarios such as user registration, login, and other relevant use cases specified in the assessment.

Project Structure
 pintu-mobile-test
    ├── app
    │   └── sample.apk
    ├── pom.xml
    ├── src
    │   ├── main
    │   │   └── java
    │   │       └── com
    │   │           └── pintu
    │   │               ├── assertion
    │   │               │   └── Assertions.java
    │   │               ├── helper
    │   │               │   ├── GeneralHelper.java
    │   │               │   └── ScrollHelper.java
    │   │               └── pages
    │   │                   ├── HomePage.java
    │   │                   ├── LoginPage.java
    │   │                   └── RegisterPage.java
    │   └── test
    │       └── java
    │           └── com
    │               └── pintu
    │                   └── tests
    │                       ├── LoginNegativeTest.java
    │                       ├── LoginTest.java
    │                       ├── RegisterNegativeTest.java
    │                       └── RegisterTest.java


Prerequisites
Java Development Kit (JDK)
Apache Maven
Android Studio (for Appium dependencies and Android SDK)
Appium server installed and running
Mobile device/emulator setup for testing

Setup
Clone this repository to your local machine.
Install the necessary dependencies by running mvn clean install.


Running Tests
Make sure your Appium server is running and your mobile device/emulator is ready.
Open a terminal and navigate to the project directory.
Run the tests using the following command:
mvn test

Test Reports
After running the tests, the test reports will be generated in the test-output directory. You can open the HTML reports in a web browser to view the test results.



    
  

