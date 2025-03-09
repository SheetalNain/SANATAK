# POC for Static Code Analysis

| **Author**            | **Created on** | **Version** | **Last updated by**       | **Last edited on** | **Reviewer** |**L0 Reviewer** |**L1 Reviewer** |**L2 Reviewer** |
|-----------------------|----------------|-------------|----------------------------|---------------------|-------------------|-------------------|-------------------|-------------------|
| Sheetal      | 07-02-25       | Version 1 | Sheetal         | 07-02-25     | Siddharth Pawar    | Shikha  | Kirti  | Ashwani Singh  |

---

## Table of Contents
1. [Purpose](#purpose)
2. [Pre-requisites](#pre-requisites)
3. [Steps of POC](#steps-of-poc)
4. [Contact Information](#contact-information)
5. [References](#references)

---

## Purpose
To implement static code analysis in a ReactJS project using ESLint to ensure code quality, identify syntax errors, and enforce coding standards.

---

## Pre-requisites

| **Requirements**      | 
|-------------------------|
| **Node.js**    | 
| **NPM**                | 

---
## Steps of POC

### Step 1. Set up the React Application .
For setting up our React Application i.e. Frontend Server for our OT-MS Understanding project please follow this Link [Frontend Doc](https://github.com/Snaatak-Skyops/Documentation/blob/eec3174c783c51f363a335ac55aa3eab1c0cf5a3/OT%20MS%20Understanding/Application/Frontend/Documentation/README.md)

---

### Step 2. Install Node.js with the help of the following commangs- 

```
sudo apt update
sudo apt install nodejs npm -y
curl -fsSL https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.4/install.sh | bash
source ~/.bashrc
nvm install --lts
```

---

### Step 3. Verify the Installation

```
node -v
npm -v
```
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/fe-1.png)

---

### Step 4. Install ESLint

```
npm install eslint --save-dev
```

---

### Step 5. Initialize ESLint configuration by running the below command - 

```
npx eslint --init
```
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/fs-2.png)

---
### Step 6. Run ESLint to analyze the project files -

```
npx eslint src/
```

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/fs-3.png)
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/fs-4.png)

---

## Contact Information 

| Name| Email Address      |
|-----|--------------------------|
| Sheetal | sheetal.nain@mygurukulam.co |


## References


| **Links**                                           | **Description**         |
|-----------------------------------------------------|-------------------------|
| [Code Analysis using ESLint](https://medium.com/@katie.wan/static-code-analysis-in-react-using-eslint-683cc6292e69)          | Static Code Analysis in React using ESLint    |







