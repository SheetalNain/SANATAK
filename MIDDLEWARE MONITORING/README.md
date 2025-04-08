 #  **Documentation on Identify Key Performance Metrics and Requirements for Middleware Monitoring**

<p align="center">
 <img src="https://github.com/SheetalNain/salary/blob/main/assets/monitoring.png" alt="image" width="600" height="300" />
</p>


| **Author**            | **Created on** | **Version** | **Last updated by**       | **Last edited on** | **Reviewer** |**L0 Reviewer** |**L1 Reviewer** |**L2 Reviewer** |
|-----------------------|----------------|-------------|----------------------------|---------------------|-------------------|-------------------|-------------------|-------------------|
| Sheetal      | 08-04-25       | Version 1 | Sheetal         |  08-04-25   | Siddharth Pawar    | Shikha  | Kirti  | Ashwani Singh  |


---

## Table of Contents
- [Introduction](#introduction)
- [What is Monitoring?](#what-is-monitoring)
- [Why do we need Monitoring?](#why-do-we-need-monitoring)
- [Key Performance Metrics ](#key-performance-metrics-)
  - [CPU Utilization](#CPU-utilization)
  - [Memory Usage](#Memory-usage)
  - [Connection Metrics](#connection-metrics)
  - [Keyspace Metrics](#keyspace-metrics)
  - [Latency](#latency)
  - [Cache hit ratio](cache-hit-ratio#)
  - [Rejected connections](#rejected-connections)
  - [Eviction policies](#eviction-policies)
  - [Connected slaves](#connected-slaves)
  - [Hot Keys](#hot-keys)
- [Best Practices](#best-practices)
- [Conclusion](#conclusion)
- [Contact Information](#contact-information)
- [References](#references)

---

## Introduction

This document provides a comprehensive guide to monitoring Redis, covering key performance metrics and best practices. Monitoring Redis is essential for ensuring the stability, performance, and reliability of applications that depend on it.

---

## What is Monitoring?

Monitoring is an ongoing process of gathering, analyzing, and utilizing information to assess the progress of a project, program, or policy in achieving its intended goals. It includes the routine observation and documentation of activities to ensure they are proceeding as planned and to identify any needed changes to enhance results.

---

## Why do we need Monitoring?

| Reason                  | Description                                             |
|-------------------------|---------------------------------------------------------|
| **Track Progress**       | Ensure things are moving as planned.                   |
| **Identify Problems**    | Identify issues early on before they escalate into more serious problems.  |
| **Make Improvements**    | Adjust plans to improve results.            |
| **Ensure Success**       | Make sure goals are being met on time and within budget.|
| **Stay Informed**        | Ensure everybody stay informed about the project's progress.|

---

## Key Performance Metrics 


| **Key Performance Metric**   | **Description**                                                                                   | **Priority** |
|------------------------------|---------------------------------------------------------------------------------------------------|---------------|
| **CPU Utilization**           | Monitor CPU usage to identify potential bottlenecks or resource constraints.  | High  |
| **Memory Usage**              | Total memory used by Redis. Monitoring memory usage is crucial as Redis is an in-memory database.  | High|
| **Connection Metrics**        | Monitor and identify total number of client connections.       | Medium|
| **Keyspace Metrics**          | Total number of keys in the database. | Low |
| **Latency**                   | Monitor latency to ensure fast response times.  | High |
| **Cache hit ratio**           | Cache hit ratio quantifies the proportion of requests a cache can fulfill from its storage compared to the total number of requests it receives.  | High |
| **Rejected connections**      | The number of connections rejected because of the maxclients limit. | Medium |
| **Eviction policies**         | Removes least recently used keys with the expire field set to true.| Medium |
| **Connected slaves**          |  This tracks the number of slave instances connected to the Redis master server, providing insights into replication status. | Medium |
| **Hot Keys**                  | A hot key is a key that is accessed extremely frequently (for example, thousands of times a second or more). | Medium |

---
## Best Practices

| Best Practice           | Description                                             |
|-------------------------|---------------------------------------------------------|
| **Establish a Baseline**                     | Track key metrics over time to identify trends and seasonal behaviors.                   |
| **Monitor Critical Metrics Continuously**    | More focus on high-priority metrics.  |
| **Set Thresholds and Alerts**                | Use monitoring tools to configure alerts .            |
| **Track Replication Status**                 | Keep an eye on connected replicas to ensure data consistency.|
| **Review and Update Monitoring Strategy**    | Adjust based on system growth, usage patterns, or Redis version updates.|

---

## Conclusion

Effective monitoring of Redis is critical for maintaining the health, performance, and reliability of systems that rely on it. By keeping a close eye on key performance metrics such as CPU and memory usage, latency, and cache efficiency, teams can proactively detect issues, optimize performance, and ensure high availability. 

---
## Contact Information

| Name| Email Address      |
|-----|--------------------------|
| Sheetal | sheetal.nain@mygurukulam.co |

---

## References


| **Links**                                           | 
|-----------------------------------------------------|
| [Redis monitoring guide](https://www.site24x7.com/learn/redis-monitoring-metrics.html)  | 
| [What are Hit and Miss Ratios?](https://wp-rocket.me/blog/calculate-hit-and-miss-ratios/) |   





