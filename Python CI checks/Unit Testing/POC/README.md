# Pytest POC

<p align="center">
    <img src="https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/pt.png" alt="image" width="600" height="200" />
</p>


| **Author**            | **Created on** | **Version** | **Last updated by**       | **Last edited on** | **Reviewer** |**L0 Reviewer** |**L1 Reviewer** |**L2 Reviewer** |
|-----------------------|----------------|-------------|----------------------------|---------------------|-------------------|-------------------|-------------------|-------------------|
| Sheetal      | 28-02-25       | Version 1 | Sheetal         | 28-02-25     | Siddharth Pawar    | Shikha  | Kirti  | Ashwani Singh  |


## Table of Contents

- [Introduction](#Introduction)
- [POC steps](#POC-steps)
- [Report Link](#report-link)
- [Conclusion](#Conclusion)
- [Contact](#Contact)
- [Refrence](#Refrence)


## Introduction
 In this Document we are creating the POC of unit testing for the Pyhton based API, to get the errors by performing the unit testing.


## POC steps 

### 1. Update and upgrade package list.


```
sudo apt update
```

```
sudo apt upgrade -y
```

### 2. Install Pytest

```
pip install pytest
```

### 3. Performing Unit Testing
 Now [clone the repo](https://github.com/OT-MICROSERVICES/attendance-api.git) to your system, and run the below command.

 ```
pytest
```

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/result.png)

It provides us the warning summary info where the test cases are facing issues.


### 4. To generate the html report,install the pytest-html plugin.

```
pip3 install pytest-html
```

### 5. Now run the following command-

```
pytest --html=report.html
```

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/html.png)


## Report Link

### [Unit Testing Report]()  


## Conclusion
After performing unit tests in Python code through pytest framework, we are getting a detailed report regarding that each unit, such as a function or method, works as intended and produces the expected output.


## Contact Information 

| Name| Email Address      |
|-----|--------------------------|
| Sheetal | sheetal.nain@mygurukulam.co |


## References


| **Links**                                           | **Description**         |
|-----------------------------------------------------|-------------------------|
| [Pytest](https://realpython.com/pytest-python-testing/)          |  Effective Python Testing With pytest   |



