# WebstaurantStore Web Application Automation
## Overview:
An automation script to test WebstaurantStore web application with test case mentioned in section [Test case](Test Cases:). The framework used to automate the test case is built using Page Object Model. The framework uses following technology stack:

1. Java
2. Selenium
3. TestNG
4. Maven
5. Log4j2
6. random

## Pre-requisities:


Below are the pre-requisities to use the framework
    
  1. Java 17 or above
  2. Any IDE of your choice
  3. Internet access to maven repository from local machine 

## Test Cases:
- At the moment, the repository has one test cases automated for [WebstaurantStore Web Application](https://www.webstaurantstore.com/). However, the framework can be re-used to automate additional test cases.


**Test Case 1 : Search Item and Add To Cart**

```
    1. Go to https://www.webstaurantstore.com/
    2. Search for 'stainless work table'.
    3. Check the search result ensuring every product has the word 'Table' in its title.
    4. Add the last of found items to Cart.
    5. Empty Cart.
  
 ```

**Note**: The above test case was tested for different search input. Currently, the repository contains two instances of test for two search input('stainless work table' and 'wood work table') 

## Steps to re-run the test case:

1. Clone the repository to your local machine
2. Open the project in any IDE
3. Run below maven commands from project root folder to install and validate the dependencies

```
mvn install
mvn validate

```
4.Run the test with below maven command or by following the specific approach that is specific to your IDE

```
mvn test

```

**Note**: The framework was tested in windows and mac OS
