## SonarQube Quality Gates Setup

### 1. Login to SonarQube
- Open your SonarQube instance (e.g., `http://localhost:9000`).
- Login using your credentials.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/Q-1.png)

---

### 2. Go to Quality Gates

- Click on **Quality Gates** in the top menu.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/Q-2.png)

---

### 3. Create or Edit a Quality Gate

- If you want to modify an existing Quality Gate (like **SonarWay**), click on it. Otherwise, click **Create** to create a new one.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/QG-1.png)


- Give the gate a meaningful name if creating a new one.
 
![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/QG-2.png)

---

#### **Step 3.1: Navigate to the Quality Gates Tab**

- Open SonarQube and log in as an administrator.

- Click on the **"Quality Gates"** tab in the top navigation bar.

#### **Step 3.2: Create a New Quality Gate**

- On the left side, click the **"Create"** button to add a new Quality Gate.

- A pop-up window will appear to enter details for the new Quality Gate.

#### **Step 3.3: Name the Quality Gate and Save**

- Enter a name for the Quality Gate (e.g., **"Salary-QG"**) in the input field.
- Click on the **"Save"** button to create the Quality Gate.

---

### 4. Add Conditions for Failing Quality Gate

#### Code Coverage:

- **Condition**: If **Code Coverage** is less than **85%**, the project should fail.
  **Add Condition**:
  - **Metric**: `Coverage`
  - **Operator**: `is less than`
  - **Value**: `85%`
  - **Status**: `Error` (This will fail the project if coverage is below 85%).

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/QG-5.png)

4.1. **Conditions on Overall Code:**
  - A new condition is set for **Coverage**:
    - **Operator:** "is less than"
    - **Value:** "85.0%"

4.2. **Project Section**
  - 1. Go to **Quality Gates** → Select your **Quality Gate**. 
  - 2. Scroll to the **Projects** section. 
  - 3. Click **"With"**, search for the project, and select it. 

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/Q-3.png)

---

### 5. Apply Quality Gate to Your Project

- Once you have added the conditions, save the quality gate.
- Set the quality gate you just created as the default quality gate.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/QG-6.png)


---

### 6. Test the Quality Gate

- Run the SonarQube analysis for your project to check if the quality gate fails based on these conditions:

```
  mvn clean verify sonar:sonar -Dsonar.projectKey=<project.key>  -Dsonar.projectName='project.Name'  -Dsonar.host.url=http://localhost:9000  -Dsonar.token=<your_token>
```

> [!NOTE]
 >* sonar:sonar → Triggers the SonarQube analysis.
 >* -Dsonar.projectKey → Specifies the unique project identifier in SonarQube.
 >* -Dsonar.projectName → Defines the human-readable project name in SonarQube.
 >* -Dsonar.host.url → Sets the SonarQube server URL.
 >* -Dsonar.token → Provides authentication credentials via a token.

- After the analysis, go to the SonarQube dashboard for your project.

- Check the Quality Gate status:

  - If any condition (e.g., Code Coverage < 85% ) is not met, the project will show as Failed.

![image](https://github.com/SheetalNain/SANATAK/blob/SCRUM-63/Static%20code%20analysis/Assets/QG-7.png)

