# Nakyaa Clone Website Automation Project

## **Introduction**  
This project focuses on automating key functionalities of the Nakyaa Clone website, which includes **user registration**, **login**, **product search**, **adding products to the cart**, **checkout process**,. The goal is to ensure these essential user flows work flawlessly through both automated and manual testing methods.

## **Project Type**  
Testing Automation using Selenium and Cucumber

## **Deployed App**  
Since this project is about testing, the Nakyaa Clone website is used as the testing platform.  
[Nakyaa Clone Website](https://sweet-donut-1ca8e9.netlify.app/)

---

## **Project Highlights**  

1. **Comprehensive Functional Coverage**:  
   - Validating user **registration** and **login** functionality.  
   - Automated testing of **product search** and **filtering**.  
   - Automation of the **cart functionality** including adding, viewing, and removing products.  
   - Ensuring a smooth **checkout process** with payment simulation.  
  
2. **Manual Testing**:  
   Detailed manual testing was performed to identify edge cases and usability issues not covered by automation.

3. **Technology Stack**:  
   - **Selenium**: For automating browser interactions for web applications.  
   - **Java**: Used for writing test scripts in a clean and reusable manner.  
   - **Cucumber**: For behavior-driven development (BDD) and writing human-readable test scenarios.  
   - **TestNG**: For managing test execution and reporting. 
   - **Maven**: For managing dependencies and building the project.  

---

## **Design Decisions or Assumptions**  

### **Design Pattern**:  
The project follows the **Page Object Model (POM)** design pattern to ensure scalability, modularity, and maintainability of test scripts. This approach separates the page-specific actions (like clicking buttons or entering text) from the test scripts, making the code more reusable, easier to maintain, and scalable as the application grows.

---

## **Credentials**  
For this project, no special credentials are required to access the Nakyaa Clone website (demo environment used for testing purposes).

## **APIs Used**  
This project focuses on UI automation, and does not directly interact with any APIs.

## **Directory Structure**  
CucumberNakyaaProject/  
├── src/  
│   ├── main/  
│   │   ├── java/  
│   │   │   ├── extent.properties  
│   │   │   ├── extent-config.xml  
│   │   └── resources/  
│   ├── test/  
│   │   ├── java/  
│   │   │   ├── PageObject/  
│   │   │   │   ├── Login.java  
│   │   │   │   ├── PurchaseProduct.java  
│   │   │   │   ├── Search.java  
│   │   │   ├── StepDefination/  
│   │   │   │   ├── stepDef.java  
│   │   │   └── TestRunner/  
│   │   │       ├── TestRunner.java  
│   │   └── resources/  
│   │       ├── features/  
│   │       │   ├── Login.feature  
│   │       │   ├── purchase.feature  
│   │       │   ├── Search.feature  
├── JRE System Library [JavaSE-1.8]/  
├── Maven Dependencies/  
├── Screenshot/  
├── target/  
│   ├── cucumber-reports/  
│   │   ├── cucumber.html  
├── test-output/  
├── pom.xml  
