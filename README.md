## Test automation Framework

### Tech stack
- Language: JAVA 11
- Testing framework: TestNG
- Build tool: Maven
- UI Automation Library: Selenium
- API Automation Library: Rest Assured

### What should you learn to use the framework?
##### JAVA
- Basics
  - static, final, modifiers, methods and return type
  - Datatype, Collections (Map, List, Array)
  - Loops ( for, for each, while)
  - Conditions (if else, switch case)
  - Exception handling (try catch finally)
- Class and Objects
  - this, constructor
- Inheritance
  - extends, super() 
- Design pattern
  - Page object Model
  - Page Factory model
  - singleton pattern
    - Threadlocal
    - getInstance
#### TestNG
- Annotations like @Test, @BeforeTest/AfterTest, @Before/AfterMethods
- DataProvider, parallel 
#### Maven
- maven lifecycle
- maven env variables
#### 
#### WEB
- Locators (css, xpath )
- API basics
- Chrome devtools for network calls inspection

### Framework Features
- Multiple environment handling via default or env variable 
  - Reading different properties files for configurations
- Supports multiple browsers via default or env variable - pending
  - Browser name, test suite name , environment name can be passed via env variable or else it will pick up from properties file
- Managing Tests and Suites via TestNG - pending
  - Different testng.xml files for different suites
  - Controlling .xml file to pick via environment variable via pom.xml
- Dependency management using maven
- Running Parallel Tests
  - Run parallel by classes or methods
- HTML Report generation
  - screenshot on failure
  - generate Beautiful HTML report, using Extent Report library
- CI/CD compatible - pending
- Readable and easily maintainable code
- Password encryption
### Setting up framework
- Download the code from this repository link (main/master branch) : 

### How to write functional Test cases

### How to write unit Test cases


### How to run Testcases
#### via IntelliJ IDE
- Click on Run button beside method (To run individual Test) or beside class to runn all Tests
#### via xml suite
- Run sanity.xml
- Using tags / groups
  - Running all sanity
    - mvn clean test -DtagName
  - Running all regression
    - mvn clean test -DtagName
  - Running via feature tag
    - mvn clean test -DtagName
#### via maven command line
- Open terminal and navigate to root folder of project
- ``` mvn clean test -DBROWSER_NAME=chrome -DIS_HEADLESS=true -DENV=QA```

