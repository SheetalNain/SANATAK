# **POC for AMI Creation**

<p align="center">
 <img src="https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/packer.png" alt="image" width="500" height="200" />
</p>


| **Author**            | **Created on** | **Version** | **Last updated by**       | **Last edited on** | **Reviewer** |**L0 Reviewer** |**L1 Reviewer** |**L2 Reviewer** |
|-----------------------|----------------|-------------|----------------------------|---------------------|-------------------|-------------------|-------------------|-------------------|
| Sheetal      | 06-03-25       | Version 1 | Sheetal         | 06-03-25     | Siddharth Pawar    | Shikha  | Kirti  | Ashwani Singh  |

---

## **Table of Contents**
- [Introduction](#introduction)
- [Pre-requisites](#pre-requisites)
- [AMI Creation Steps](#ami-creation-steps)
- [Conclusion](#conclusion)
- [Contact Information](#contact-information)
- [References](#references)

---

## **Introduction**

In this document we will discover Packer, developed by HashiCorp, which is a popular open-source tool for creating Amazon Machine Images (AMIs). It enables automation, multi-platform support, and infrastructure-as-code principles, simplifying the AMI creation process.


---

## **Pre-requisites**

| **Tool** | **Version** |
|---------|-------------|
| **Packer** | v1.12.0 |

---

## **AMI Creation Steps**

### **1. Create an EC2 Instance and AMI**
- Launch an EC2 instance (`New_Instance`).
- Customize it as needed.
- Create an AMI (`New_Image`).

---

### **2. Install Packer**
- Download and install Packer with the help of the following commands -

```
curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
sudo apt-get update && sudo apt-get install packer
```
- Verify the installation using the below command -

```
packer --version
```
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/pac-1.png)

---

### **3. Create a Packer Template**
- Define the AMI configuration in a `nano ubuntu-ami.pkr.hcl` file.

```

packer {
  required_plugins {
    amazon = {
      version = ">= 1.0.0"
      source  = "github.com/hashicorp/amazon"
    }
  }
}

variable "aws_region" {
  default = "us-east-1"
}

variable "ami_name" {
  default = "packer-ubuntu-instance-image"
}

source "amazon-ebs" "ubuntu" {
  source_ami_filter {
    filters = {
      name                = "ubuntu/images/hvm-ssd/ubuntu-focal-20.04-amd64-server-*"
      root-device-type    = "ebs"
      virtualization-type = "hvm"
    }
    owners      = ["099720109477"]
    most_recent = true
  }

  instance_type = "t2.micro"
  ssh_username  = "ubuntu"
  region        = var.aws_region

  ami_name        = var.ami_name
  ami_description = "Ubuntu AMI created using Packer inside an EC2 instance"
}

build {
  sources = ["source.amazon-ebs.ubuntu"]

  provisioner "shell" {
    inline = [
      "sudo apt update"
    ]
  }
}

```

---

### **4. Initialize and Build the AMI**
- Run the below command to initialixe packer -
```
packer init ubuntu-ami.pkr.hcl
```

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/pac-2.png)

- Validate the Template-
```
packer validate ubuntu-ami.pkr.hcl
```


- Use this command to start the AMI creation process -

```
packer build ubuntu-ami.pkr.hcl
```

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/pac-3.png)

- Verify the AMI in the AWS Console.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/pac-4.png)


---

## **Conclusion**

Packer is a powerful tool for automating AMI creation, ensuring consistency and scalability. Its integration with other HashiCorp tools makes it a valuable asset for cloud infrastructure management.

---

## Contact Information 

| Name| Email Address      |
|-----|--------------------------|
| Sheetal | sheetal.nain@mygurukulam.co |


---

## References


| **Links**                                           | **Description**         |
|-----------------------------------------------------|-------------------------|
| [Packer](https://developer.hashicorp.com/packer/tutorials/docker-get-started/get-started-install-cli)          |  Installation Guide   |
| [AMI](https://medium.com/@ahmedSalem2020/creating-aws-ami-using-packer-628b5a40bb64)          |  Building AWS AMI Using Packer   |
