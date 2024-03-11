# WebstaurantStore Web Application Automation
## Overview
An automation script to test WebstaurantStore Web Application with test case mentioned in section (Test case). The framework used to automate the test case is built using Page Object Model. The framework uses following technology stack:

1. Java
2. Selenium
3. TestNG
4. Maven
5. Log4j2
6. random

## Pre-requisities


Below are the pre-requisities to use the framework
    
  1. Java 17 or above
  2. Any IDE of your choice
  3. Internet access to maven repository from local machine 

## Test Cases:
- At the moment, the repository has one test cases automated for [WebstaurantStore Web Application](https://www.webstaurantstore.com/). However, the framework can be re-used to automate additional test cases.


**_Test Case 1 : Search Item and Add To Cart_**
```
    1. Go to [WebstaurantStore Web Application](https://www.webstaurantstore.com/)
    2. Search for 'stainless work table'.
    3. Check the search result ensuring every product has the word 'Table' in its title.
    4. Add the last of found items to Cart.
    5. Empty Cart.
  ```  

Note: The above test case is tested for different search input. Currently, the repository contains two insantaces of test for two search input('stainless work table' and 'wood work table') 
