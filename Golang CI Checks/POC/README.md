# POC for Dependency Scanning

<p align="center">
    <img src="https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/owasp.jpg" alt="image" width="600" height="200" />
</p>


| **Author**            | **Created on** | **Version** | **Last updated by**       | **Last edited on** | **Reviewer** |**L0 Reviewer** |**L1 Reviewer** |**L2 Reviewer** |
|-----------------------|----------------|-------------|----------------------------|---------------------|-------------------|-------------------|-------------------|-------------------|
| Sheetal      | 03-03-25       | Version 1 | Sheetal         | 03-03-25     | Siddharth Pawar    | Shikha  | Kirti  | Ashwani Singh  |



## Table of Contents

- [Introduction](#Introduction)
- [Pre-requisites](#pre-requisities)
- [POC steps](#POC-steps)
- [Contact](#Contact)
- [Refrence](#Refrence)


## Introduction

In this document, we are creating a POC for performing dependency scanning on a Go based API to identify vulnerabilities and security risks in dependencies, following OWASP guidelines.

## Pre-requisities

| Requirement | 
|------------|
| **Java** | 
| **OWASP Dependency Check** | 
| **Unzip** | 

## POC Steps 

### 1. Download OWASP Dependency Check.

```
curl -sLO https://github.com/jeremylong/DependencyCheck/releases/download/v8.4.0/dependency-check-8.4.0-release.zip
```

```
unzip dependency-check-8.4.0-release.zip
```

### 2. Verify the installation.

```
./bin/dependency-check.sh --version
```

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/version.png)

### 3. Clone the Repository.

```
git clone https://github.com/OT-MICROSERVICES/employee-api.git
```

### 4. Run OWASP Dependency Check.

```
../dependency-check/bin/dependency-check.sh \
  --project "employee-api" \
  --scan . \
  --format HTML \
  --out security-reports
```

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/go-1.png)
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/go-2.png)

### 5. To view the report on the EC2 Instance follow the below steps : 

- We are using **lynx** for this purpose. Lynx is a text-based browser.

```
sudo apt install lynx -y
```
```
lynx dependency-check-report.html
```

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/go-3.png)
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/go-4.png)


## Contact Information 

| Name| Email Address      |
|-----|--------------------------|
| Sheetal | sheetal.nain@mygurukulam.co |


## References


| **Links**                                           | 
|-----------------------------------------------------|
| [OWASP Dependency Check](https://owasp.org/www-project-dependency-check/)          | 



