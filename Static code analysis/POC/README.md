# Sonarqube POC

<p align="center">
    <img src="https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/sqube.png" alt="image" width="600" height="200" />
</p>

| **Author**            | **Created on** | **Version** | **Last updated by**       | **Last edited on** | **Reviewer** |**L0 Reviewer** |**L1 Reviewer** |**L2 Reviewer** |
|-----------------------|----------------|-------------|----------------------------|---------------------|-------------------|-------------------|-------------------|-------------------|
| Sheetal      | 26-02-25       | Version 1 | Sheetal         | 26-02-25     | Siddharth Pawar    | Shikha  | Kirti  | Ashwani Singh  |

---

# Table of Contents
1. [Purpose](#purpose)
2. [Pre-requisites](#pre-requisites)
3. [Security](#security)
4. [Steps of POC](#steps-of-poc)
5. [Contact Information](#contact-information)
6. [References](#references)

---
# Purpose

The purpose of this POC is to evaluate and demonstrate the capabilities of SonarQube in analyzing code quality, enforcing coding standards, and detecting security vulnerabilities.

---
# Pre-requisites 


| **Specification**      | **Details**         |
|-------------------------|---------------------|
| **Operating System**    | Ubuntu 22.04      |
| **CPU**                | 2 vCPU             |
| **Hard Disk**             | 20 GB              |
| **RAM**                | 4 GB               |

---

# Security 

| **Port** | **Protocol** | **Use Case**       |
|----------|--------------|--------------------|
| 22       | TCP          |    SSH Access for remote login | 
| 80       | TCP          |     HTTP traffic for web applications            |                
| 443      | TCP          |    Secure HTTPS web traffic             |             
| 5432     | TCP          | PostgreSQL database access  |    
| 9000     | TCP          |      SonarQube           |    

---

# Steps of POC

## Step 1: First of all create a instance t2.medium or t3.large with security group that have the above mentioned configuration.

## Step 2: Update and Upgrade System Packages.

```
sudo apt update
```

```
sudo apt upgrade -y
```


## Step 3: Java installation

```
sudo apt install -y openjdk-17-jdk
```


##  Step 4: Verify the installed Java version
```
java -version
```
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/1.png)

## Step 5. Install and configure PostgreSQL
[PostgreSQL installation guide](https://github.com/Snaatak-Skyops/Documentation/tree/main/OT%20MS%20Understanding/Database/PostgreSQL/POC)

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/2.png)

#### 1. Switch to the Postgres user account for further configuration.
```
sudo -i -u postgres
```

#### 2. Create a new database user to manage the sqube database
```
createuser sona
```
#### 3. Log in to the PostgreSQL database to proceed with database operations.
```
psql
```

#### 4. Set a strong password for the “sona” user. Use a password

```
ALTER USER sona WITH ENCRYPTED password 'Sona@987';
```

#### 5. Create a sqube database and assign the ownership to the “sona” user.
```
CREATE DATABASE sqube OWNER sona;
```
Grant all privileges on the “sqube” database to the “sona” user

```
GRANT ALL PRIVILEGES ON DATABASE sqube to sona;
```
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/3.png)


#### 6. To exit the PostgreSQL command-line interface, use the following command:
```
\q
```

## Step 6: Install and configure SonarQube.

### 1.Install the zip utility, required for extracting the SonarQube files
```
sudo apt install zip -y
```

```
sudo wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-10.4.1.88267.zip
```

### 2. Move the unzipped files to the /opt/sonarqube directory

```
sudo unzip sonarqube-10.4.1.88267.zip
sudo mv sonarqube-10.4.1.88267 sonarqube
sudo mv sonarqube /opt/
```

### 3. Setting Up SonarQube: Adding Group and User

```
sudo groupadd sona
sudo useradd -d /opt/sonarqube -g sona sona
```

### 4. Grant the “sona” user access to the /opt/sonarqube directory

```
sudo chown -R sona:sona /opt/sonarqube
```

### 5. Edit the SonarQube configuration file 

```
sudo nano /opt/sonarqube/conf/sonar.properties
```

### 6. Changes to be made, Uncomment the following lines in the SonarQube configuration file.

```
sonar.jdbc.username=sona
sonar.jdbc.password=password
sonar.jdbc.url=jdbc:postgresql://localhost:5432/sqube
```
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/4.png)

### 7. To edit the SonarQube script file
```
sudo nano /opt/sonarqube/bin/linux-x86-64/sonar.sh
```
```
RUN_AS_USER=sona
```
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/5.png)

### 8. Enable the SonarQube service to start at boot

```
sudo systemctl enable sonar
```

### 9. start the SonarQube service

```
sudo systemctl start sonar
```

### 10. Check status .

```
sudo systemctl status sonar
```
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/6.png)


### 11. Edit the sysctl configuration file and add the following lines to the end of the file.

```
sudo nano /etc/sysctl.conf
```
```
vm.max_map_count=262144
fs.file-max=65536
ulimit -n 65536
ulimit -u 4096
```

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/7.png)


### 12. To apply the changes, reboot the system.
```
sudo reboot
```

### 13. Access SonarQube in a web browser by entering your server’s IP address followed by port 9000

```
http://44.222.210.210:9000
```

### 14.  Log in to SonarQube.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/8.png)

After logging in, SonarQube will prompt you to change your password.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/9.png)


### 15. Create a Local Project: Set up a new or existing project on your machine.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/10.png)


### 16. Configure the Project by configuring the necessary files.
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/11.png)


### 17. How do you want to analyze your repo?

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/12.png)

### 18. Generate Token.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/13.png)


### 19. Run Analyze on your project
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/15.png)


### 20. Paste the scan command

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/16.png)


### 21. Result
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/17.png)


# Contact Information 

| Name| Email Address      |
|-----|--------------------------|
| Sheetal | sheetal.nain@mygurukulam.co |


# References


| **Links**                                           | **Description**         |
|-----------------------------------------------------|-------------------------|
| [Sonarqube](https://www.sonarsource.com/learn/static-code-analysis-using-sonarqube/)          | Static Code Analysis Using SonarQube    |
