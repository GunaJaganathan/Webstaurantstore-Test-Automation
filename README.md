@ -7,19 +7,18 @@ An automation script to test WebstaurantStore web application with test case men
3. TestNG
4. Maven
5. Log4j2
6. random

## Pre-requisities:


Below are the pre-requisities to use the framework
Below are the required pre-requisities to use the framework
    
  1. Java 17 or above
  2. Any IDE of your choice
  3. Internet access to maven repository from local machine 
  3. Internet access 

## Test Cases:
- At the moment, the repository has one test cases automated for [WebstaurantStore Web Application](https://www.webstaurantstore.com/). However, the framework can be re-used to automate additional test cases.
- At the moment, the repository has one test cases automated for [WebstaurantStore Web Application](https://www.webstaurantstore.com/). However, the framework can be used to automate additional test cases.


**Test Case 1 : Search Item and Add To Cart**
@ -33,24 +32,35 @@ Below are the pre-requisities to use the framework
  
 ```

**Note**: The above test case was tested for different search input. Currently, the repository contains two instances of test for two search input('stainless work table' and 'wood work table') 
**Note**: The above test case was tested for different search inputs. Currently, the repository contains two instances of test for two search input('stainless work table' and 'wood work table') 

## Steps to re-run the test case:

1. Clone the repository to your local machine
2. Open the project in any IDE
3. Run below maven commands from project root folder to install and validate the dependencies
3. Run below maven commands from project root folder to install and validate the dependencies or by following the approach that are specific to your IDE

```
mvn install
mvn validate

```
4.Run the test with below maven command or by following the specific approach that is specific to your IDE
4.Run the test with below maven command or by following the approach that are specific to your IDE

```
mvn test

```

**Note**: The framework was tested in windows and mac OS
## Compatibility

The framework was tested on both mac and windows OS. Below are the list of supported browsers. Browser name can be updated in the file [test.properties](src/test/resources/test.properties)

1. Chrome
2. Safari
3. Firefox
4. Edge

## Results File

The framework uses log4j2 and testNG default report to store the results.log4j2 logs can be accessed under 'test-output/log4j/log' folder. Default report can be viewed by opening 'index.html' file under 'test-output' folder
