# Tranzact Automation Assessment

This is the project where the automation assessment exercises were developed.

Author: Guillermo Velasquez



## Pre-requisites:

- Eclipse installed  ->  Download [here](https://www.eclipse.org/downloads/)
- TestNG Eclipse plugin installed  -  (Eclipse Marketplace)
- Cucumber Eclipse plugin installed  -  (Eclipse Marketplace)
- Chromedriver downloaded  ->  Download [here](https://chromedriver.chromium.org/)



## Project Structure


**Package features:**

In this package is stored the feature file , file where is defined the test cases created in Gherkin language.
- TranzactTestFeature.feature


**Package pages:**

In this package are stored the pages for the created test following the Page Object Model design pattern.
- BasePage.java
- HomePage.java
- MyAccountPage.java
- RegistrationPage.java


**Package resources:**

In this package are stored some support files for the execution of the test.
- framework.properties
- testng.xml


**Package services:**

In this package are stored the files where the rest services tests requested in the assessment have been elaborated.
- ServicesTest.java
- TranzactServicesTest.java


**Package tests:**

In this package are stored the files where they are developed and the necessary methods for the execution of the test are found.
- BaseTest.java
- TranzactTest.java


**pom.file**

File where we define the necessary dependencies for the creation of the different tests (Selenium, RestAssured, TestNG, Cucumber).



## Test Execution


###Exercise 1

To execute the first exercise "UI Automated test using Selenium WebDriver" you must select (shade) the scenario in the TranzactTestFeature.feature file and then right click and in the menu that appears select the option Run AS -> Cucumber Feature.

![CucumberExecution](https://user-images.githubusercontent.com/21127768/105649583-c9d4f880-5e7e-11eb-87ca-42ee77a7da41.png)


The execution is initialized and you will be able to see the test in execution, at the end you will also see the results in the Eclipse console.


![CucumberTestResult](https://user-images.githubusercontent.com/21127768/105649991-343a6880-5e80-11eb-8324-119954b852e0.png)



###Excercise 2

To execute the second exercise "API Automated test" you must select the test to run in the "TranzactServicesTest.java" file, you can use the "Run" option that the TestNG Test tag offers us in each test or also select the whole class and run it with TestNG by right clicking and selecting the option Run As -> TestNG

![RestServiceExecution](https://user-images.githubusercontent.com/21127768/105650224-16b9ce80-5e81-11eb-9d33-f5b7a2fe01be.png)


The execution is initialized and you will be able to see the test result for each service test in the Eclipse console.

![RestServiceResult](https://user-images.githubusercontent.com/21127768/105650338-8039dd00-5e81-11eb-935a-2812952e05c7.png)
