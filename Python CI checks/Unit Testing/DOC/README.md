#    **Documentation of Unit Testing | Python CI Checks**

<p align="center">
 <img src="https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/UT.jpg" alt="image" width="600" height="400" />
</p>


| **Author**            | **Created on** | **Version** | **Last updated by**       | **Last edited on** | **Reviewer** |**L0 Reviewer** |**L1 Reviewer** |**L2 Reviewer** |
|-----------------------|----------------|-------------|----------------------------|---------------------|-------------------|-------------------|-------------------|-------------------|
| Sheetal      | 28-02-25       | Version 1 | Sheetal         | 28-02-25     | Siddharth Pawar    | Shikha  | Kirti  | Ashwani Singh  |


---
## Table of Contents

- [**Introduction**](#Introduction)
- [**What is Unit testing?**](#what-is-static-code-analysis?)
- [**Why Unit testing**](#why-static-code-anaylysis?)
- [**Different tools and comparison**](#different-tools-and-comparison)
- [**Advantages of Unit Testing**](#Advantages-of-CI-with-Unit-Testing)
- [**Best Practices**](#Best-practices)
- [**Conclusion**](#Conclusion)
- [**Contact**](#Contact)
- [**References**](#References)
---

## Introduction
This document focuses on unit testing in Python, providing a comparison of popular tools available in the market, highlighting their features, and offering guidance on selecting and using the best tools effectively.


---
## What is Unit testing?
Unit testing is the process of testing individual units or components of a software application in isolation. The scope is limited to testing the smallest functional parts of the code, such as functions or methods.

### Characteristics of Unit Tests
| Characteristic | Description                                           |
|----------------|-------------------------------------------------------|
| **Isolation**      | Tests should be independent of each other.            |
| **Repeatability**  | Tests should produce consistent results when executed multiple times. |
| **Speed**          | Tests should run quickly to encourage frequent execution. |
| **Readability**    | Tests should be easy to understand and maintain.      |


---
## Why Unit Testing?
| Reason                                | Description                                                                                         |
|---------------------------------------|-----------------------------------------------------------------------------------------------------|
| **Early bug detection**                 | Unit tests allow developers to catch and fix bugs early in the development process, reducing the cost of fixing defects in later stages.                        |
| **Code Refactoring and Maintenance**      |Unit tests give developers a safety net while they are making changes or reworking code.  If a modification causes a regression, the unit test that goes along with it will fail. |
| **Ensuring Code Quality**                 | Unit testing contributes to overall code quality by validating that each unit of code works as expected. This helps in building reliable and robust software.  |
| **Ensuring Trust in Code Modifications**   | Developers may be sure that their modifications won't interfere with already-existing functionality thanks to unit testing.  Having this confidence is essential for continuously improving the codebase. |


---
## Different tools and comparison
| Tool        | Ease of Use            | Flexibility                | Community Support        | Documentation                  | CI/CD Integration          | Test Discovery             | Fixture Support               |
|-------------|------------------------|----------------------------|---------------------------|--------------------------------|-----------------------------|-----------------------------|-------------------------------|
| **unittest**  | Requires more boilerplate code | Follows xUnit conventions | Part of Python standard library | Well-documented                | Easily integrated            | Supports test discovery     | Supports fixtures but may be less convenient |
| **pytest**    | Concise syntax          | Highly flexible            | Large and active community | Extensive documentation         | Widely used in CI/CD        | Powerful and automatic     | Advanced fixture support with fixtures as first-class citizens |
| **nose2**     | Strikes a balance between simplicity and features | Flexible with a plugin architecture | Community support has decreased over time | Documentation is available but may not be as comprehensive | Integration is possible but may require additional setup | Supports automatic test discovery | Supports fixtures             |
| **doctest**   | Simple and readable      | Limited flexibility        | Part of Python standard library | Limited support for complex scenarios | Integration is possible but may be limited | Extracts tests from docstrings | Limited support for fixtures   |


---
## Advantages of Unit Testing

| Objective                   | Description                                                                                                       |
|-----------------------------|-------------------------------------------------------------------------------------------------------------------|
| **Bug Detection**               | Unit testing helps identify and fix bugs early in the development process, reducing the overall cost of bug fixing.|
| **Code Quality Improvement**    | By validating the correctness of individual units, unit testing contributes to the overall quality of the codebase. |
| **Regression Testing**          | Unit tests serve as a safety net, ensuring that changes and enhancements do not introduce regressions in existing functionality. |
| **Documentation by Example**    | Well-written unit tests serve as executable documentation, providing examples of how the code should behave.        |


---
## Best Practices 
| Best Practice                   | Description                                                                                                       | 
|----------------------------------|-------------------------------------------------------------------------------------------------------------------|
| **Isolation of Tests**               | Ensure that each unit test is independent and does not rely on the state or results of other tests.                 | 
| **Use of Descriptive Test Names**    | Write clear and descriptive test names to communicate the purpose and expected behavior of each test.                | 
| **Test Data Management**             | Separate test data from test code and use fixtures or data factories to manage test data.                             | 
| **Regular Test Execution**           | Run unit tests frequently during development to catch issues early and maintain a responsive feedback loop.         | 
| **Continuous Integration**           | Integrate unit tests into the continuous integration (CI) process to automatically run tests on each code commit.  | 
| **Test-Driven Development (TDD)**    | Consider adopting Test-Driven Development (TDD) practices, where tests are written before writing the actual code. | 


---
## Pytest POC
#### [Pytest POC]()


---
##  Frequently Asked Questions (FAQ)
#### [FAQs]()

---
## Conclusion

Pytest offers a wide feature set for both basic and complicated testing scenarios, making it the perfect choice for Python unit testing due to its versatility and scalability.  Developers favour it because of its support for fixtures, parameterised tests, and thorough assertion methods.  Pytest is ideal for projects of any size since it facilitates effective test development and management through its vibrant community and vast plugin ecosystem.

---
## Contact Information 

| Name| Email Address      |
|-----|--------------------------|
| Sheetal | sheetal.nain@mygurukulam.co |


---
## References


| **Links**                                           | **Description**         |
|-----------------------------------------------------|-------------------------|
| [Unit Testing](https://www.geeksforgeeks.org/unit-testing-software-testing/)          | Unit Testing – Software Testing   |
| [The Ultimate Guide to Unit Testing](https://www.testdevlab.com/blog/the-ultimate-guide-to-unit-testing) | Benefits, Challenges, and Best Practices |
