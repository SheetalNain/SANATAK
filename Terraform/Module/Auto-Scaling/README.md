# **Documentation on designing Auto-Scaling Module**

<p align="center">
 <img src="https://github.com/SheetalNain/salary/blob/main/assets/AWS-autoscaling-logo.png" alt="image" width="300" height="200" />
</p>

| **Author**            | **Created on** | **Version** | **Last updated by**       | **Last edited on** | **Reviewer** |**L0 Reviewer** |**L1 Reviewer** |**L2 Reviewer** |
|-----------------------|----------------|-------------|----------------------------|---------------------|-------------------|-------------------|-------------------|-------------------|
| Sheetal      | 01-04-25       | Version 1 | Sheetal         | 01-04-25     | Siddharth Pawar    | Shikha  | Kirti  | Ashwani Singh  |

---

## Table of Contents

1. [Introduction](#Introduction)
3. [Requirements](#requirements)
4. [Resources Table](#resources-table)
5. [Launch Template Configuration](#launch-template-configuration)
6. [Auto Scaling Group Configuration](#auto-scaling-group-configuration)
7. [Load balancer](#load-balancer)
8. [Target group](#target-group)
9. [Scaling Policies](#scaling-policies)
10. [Example Usage](#example-usage)
11. [Tags](#tags)
12. [AWS Resources Overview](#aws-resources-overview)
13. [Conclusion](#conclusion)
14. [Contact Information](#contact-information)
15. [References](#References)

---
## Introduction

This module provisions an auto-scaling environment in AWS by combining an **Auto Scaling Group (ASG)**, a **Launch Template**, and an **Application Load Balancer (ALB)**. The goal of this module is to automatically scale EC2 instances based on defined metrics or thresholds.

## Requirements

| Requirement           | Details                                      |
|-----------------------|----------------------------------------------|
| **Terraform Version**  | version>=5.0                  |
| **AWS CLI** | Installed and configured |

---

## Resources Table

| Name                       | Type                  | Description                                           |
|----------------------------|-----------------------|-------------------------------------------------------|
| `aws_launch_template`       | Resource              | Defines the launch configuration for the EC2 instances in ASG. |
| `aws_autoscaling_group`     | Resource              | Creates the Auto Scaling Group with desired capacity and scaling policies. |
| `aws_lb`                   | Resource              | Creates an Application Load Balancer for distributing traffic across instances. |
| `aws_lb_target_group`      | Resource              | Defines target groups for routing traffic to instances in the ASG. |
| `aws_autoscaling_policy`   | Resource              | Defines scaling policies based on CloudWatch metrics. |

---

## Launch Template Configuration

The **Launch Template** defines the configuration for EC2 instances that will be launched within the Auto Scaling Group.

### Key Parameters

| Name                 | Type   | Description                                  |
|----------------------|--------|----------------------------------------------|
| `ami_id`             | string | The Amazon Machine Image (AMI) for the EC2 instance. |
| `instance_type`      | string | The instance type (e.g., `t2.micro`, `t2.large`). |
| `security_group_ids` | list   | List of security group IDs to associate with the instances. |
| `key_name`           | string | The name of the EC2 key pair to allow SSH access. |

### Example Launch Template Configuration

```
resource "aws_launch_template" "example" {
  name          = "example-launch-template"
  image_id      = "ami-0c55b159cbfafe1f0"  
  instance_type = "t2.micro"
  
  network_interfaces {
    associate_public_ip_address = true
    security_groups = ["${aws_security_group.sg.id}"]
  }
  
  key_name = "my-ssh-key"
}
```
---

## Auto Scaling Group Configuration

The **Auto Scaling Group** will use the Launch Template to launch instances and scale them according to traffic demands.

### Key Parameters

| Name                 | Type   | Description                                  |
|----------------------|--------|----------------------------------------------|
| `desired_capacity`   | number | The number of EC2 instances to maintain. |
| `min_size`           | number | Minimum number of instances in the ASG. |
| `max_size `          | number   | 	Maximum number of instances in the ASG. |
| `vpc_zone_identifier` | list| | Subnet IDs in which to launch the instances. |
| `target_group_arn` | string| | The ARN of the target group for ALB integration. |
 

### Example Auto Scaling Group Configuration

```
resource "aws_autoscaling_group" "example" {
  desired_capacity     = 2
  min_size             = 1
  max_size             = 3
  vpc_zone_identifier  = ["subnet-0bb1c79de3EXAMPLE", "subnet-8fcb28e4EXAMPLE"]
  launch_template {
    id      = "${aws_launch_template.example.id}"
    version = "$Latest"
  }
  
  target_group_arns = ["${aws_lb_target_group.example.arn}"]

  health_check_type          = "EC2"
  health_check_grace_period  = 300
  
}

```
---

## Load balancer configuration

A simple application load balancer is created, and it is placed in two subnets. 

### Example load balancer configuration

```
resource "aws_lb" "example" {
  name               = "example-alb"
  internal           = false
  load_balancer_type = "application"
  security_groups    = ["${aws_security_group.example.id}"]
  subnets            = ["subnet-0bb1c79de3EXAMPLE", "subnet-8fcb28e4EXAMPLE"]

}
```
---

## Target group for load balancer 

The target group is used to register instances. Modify the health check parameters as needed for your use case.

### Example target group configuration

```
esource "aws_lb_target_group" "example" {
  name     = "example-target-group"
  port     = 80
  protocol = "HTTP"
  vpc_id   = "vpc-0bb1c79de3EXAMPLE"  

  health_check {
    path                = "/"
    interval            = 30
    timeout             = 5
    healthy_threshold   = 5
    unhealthy_threshold = 2
  }
}
```
---

## Scaling Policies
Scaling policies are defined to automatically scale in or scale out the Auto Scaling Group based on metrics like CPU usage.

### Example Scaling Policy Configuration

```
resource "aws_autoscaling_policy" "scale_up" {
  name                  = "scale-up"
  scaling_adjustment    = 1
  adjustment_type       = "ChangeInCapacity"
  cooldown              = 300
  policy_type           = "SimpleScaling"
  autoscaling_group_name = "${aws_autoscaling_group.example.name}"
  
  estimated_instance_warmup = 120
}

resource "aws_autoscaling_policy" "scale_down" {
  name                  = "scale-down"
  scaling_adjustment    = -1
  adjustment_type       = "ChangeInCapacity"
  cooldown              = 300
  policy_type           = "SimpleScaling"
  autoscaling_group_name = "${aws_autoscaling_group.example.name}"
  
  estimated_instance_warmup = 120
}
```
---

## Example Usage

```
provider "aws" {
  region = "x-y-z"  

# Auto Scaling Module Configuration
module "auto_scaling" {
  source                                  = "../auto-scaling"
  ami_id                                  = "ami-0c55b159cbfafe1f0"  
  instance_type                           = "t2.micro"              
  security_group_ids                      = ["${aws_security_group.example.id}"]  
  key_name                                = "my-ssh-key" 
  
  # Auto Scaling settings
  min_size                                = 1
  max_size                                = 5
  desired_capacity                        = 2
  
  # Subnet IDs where instances will be launched
  vpc_zone_identifier                     = ["subnet-0bb1c79de3EXAMPLE", "subnet-8fcb28e4EXAMPLE"]  
  
  # Referencing the target group ARN of the already created ALB
  target_group_arn                        = "${aws_lb_target_group.example.arn}"
}


```
---

## Tags

As with other resources, tags can be applied to EC2 instances, Load Balancers, Auto Scaling Groups, etc., to identify and organize them.

### Example:
```
tags = {
  Name        = "auto-scaling-group"
  Environment = "Dev"
}
```
---

## AWS Resources Overview


| Name                 |  Description                                  |
|----------------------|----------------------------------------------|
| `asg_id`   |  Auto Scaling Group ID |
| `launch_template_id`           | Launch Template ID |
| `lb_arn `          |	Load Balancer ARN |
| `target_group_arn` | Target Group ARN for routing traffic to instances |
| `scaling_policy_id` |  Scaling Policy ID |
 
---

## Conclusion

This auto-scaling module allows for the dynamic scaling of EC2 instances based on predefined conditions, making it perfect for managing fluctuating workloads while optimizing both availability and costs. When combined with the original AWS network skeleton, it enables the deployment of a scalable, resilient infrastructure.

---

## Contact Information 

| Name| Email Address      |
|-----|--------------------------|
| Sheetal | sheetal.nain@mygurukulam.co |

---

## References
| Links |
|-------|
| [AWS Auto Scaling](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-autoscaling-autoscalinggroup.html) | 
| [Attaching load balancer to auto scaling group](https://docs.aws.amazon.com/autoscaling/ec2/userguide/attach-load-balancer-asg.html)  | 














