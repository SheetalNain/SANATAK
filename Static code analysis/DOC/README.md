#    **Documentation of Static Code Anaylysis in Java CI Checks**

<p align="center">
 <img src="https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/sca.jpg" alt="image" width="600" height="400" />
</p>

| **Author**            | **Created on** | **Version** | **Last updated by**       | **Last edited on** | **Reviewer** |**L0 Reviewer** |**L1 Reviewer** |**L2 Reviewer** |
|-----------------------|----------------|-------------|----------------------------|---------------------|-------------------|-------------------|-------------------|-------------------|
| Sheetal      | 26-02-25       | Version 1 | Sheetal         | 26-02-25     | Siddharth Pawar    | Shikha  | Kirti  | Ashwani Singh  |

---
**Table of Contents**

1. [**Introduction**](#introduction)
2. [**What is Static Code Anaylysis?**](#what-is-static-code-analysis?)
3. [**Why Static Code Anaylysis**](#why-static-code-anaylysis?)
4. [**Different Tools used in Static Code Anaylysis**](#different-tools-used-in-static-code-anaylysis)
5. [**Best Practices for Static code analysis**](#best-practices-for-static-code-analysis)
6. [**POC**](#poc)
7. [**Conclusion**](#conclusion)
8. [**Frequently Asked Questions (FAQ)**](#frequently-asked-questions-faq)
9. [**Contact Information**](#contact-information)
10. [**References**](#references)

---
# Introduction

Static code analysis in Java is a valuable method for reviewing source code without running it. This approach enables developers to detect errors, potential bugs, and ensure adherence to coding standards by evaluating the code against predefined rules and patterns.

---

# What is Static Code Anaylysis?

Static code analysis in Java is a technique for analyzing source code. SCA tools help developers detect potential performance or security issues without executing the program.

---
# Why Static Code Anaylysis?

| **Reasons**                   | **Description**                                                                                                    |
|-------------------------------|--------------------------------------------------------------------------------------------------------------------|
| **Enhanced Code Quality**     | Enables developers to create cleaner, more maintainable, and dependable code.                                              |
| **Enhanced Security**        | Identifies security vulnerabilities such as SQL injection, unprotected data, and inadequate encryption.            |
| **Lower Maintenance Expenses** | Long-term maintenance costs are decreased by clean code with fewer errors.                                                 |
| **Enhanced Cooperation Among Team** | Consistent code style and fewer errors make teamwork easier and more effective.                                    |
| **Increased Productivity**    | Automates code analysis, streamlining the development process and boosting productivity.                           |

---
# Different Tools used in Static Code Anaylysis
Tools for static analysis are crucial for evaluating the calibre of code.  These tools examine the code without actually running it, which aids in identifying faults such as straightforward errors or more intricate design flaws. Here's a look at some popular static analysis tools used in Java.


| Tool               | Primary Focus              | Why                                           | Features                          | Pros                                             | Cons                                                |
|--------------------|---------------------------|-----------------------------------------------|-----------------------------------|-------------------------------------------------|----------------------------------------------------|
| **Checkstyle**     | Code style enforcement    | Ensures uniform coding style and readability. | Teams requiring consistent formatting. |  Highly customizable rules.                     | Focuses only on style; no bug detection.         |
| **FindBugs/SpotBugs** | Detecting runtime risks    | Focuses on identifying actual bugs like null pointers. | Preventing common runtime issues. | Strong at finding runtime errors.             | Does not handle modern Java well (older syntax). |
| **SonarQube**      | Comprehensive code analysis | Tracks technical debt, provides dashboards for trends. | Managing overall code quality at scale. | All-in-one solution for code quality.         | Resource-intensive.                             |

---
# Best Practices for Static code analysis

| **Best Practice**            | **Description**                                                                 |
|-------------------------------|---------------------------------------------------------------------------------|
| **Set Up CI Properly**         | Automate builds, tests, and analysis to run on every commit or pull request.                     |
| **Scan for Security Vulnerabilities**       | Implement SonarQube Security Rules for secure coding practices.    |
| **Regularly Update Dependencies** | Regularly check for security patches and updates. |
| **Code Reviews & PR Checks** | Require peer reviews before merging code.    |
| **Monitor & Improve**      | Continuously refine static analysis rules to reduce false positives.             |

---
# POC 


---
# Frequently Asked Questions (FAQ)
#### [FAQs]()

---
# Contact Information 

| Name| Email Address      |
|-----|--------------------------|
| Sheetal | sheetal.nain@mygurukulam.co |
---

# References


| **Links**                                           | **Description**         |
|-----------------------------------------------------|-------------------------|
| [Code quality](https://medium.com/@AlexanderObregon/java-code-quality-and-static-analysis-tools-d9abdcdc633a)          | Java Code Quality and Static Analysis Tools   |
| [Tool comparison](https://thectoclub.com/tools/best-static-code-analysis-tools-java/) | Choosing the right Static Code Analysis Tool for Java |


