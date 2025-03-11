# Student Registration and Login System

## Diagram
![Diagram]()

## Description

This is a Java-based console application that implements a **Student Registration and Login System** using **JDBC** with an Oracle Database. The system allows students to:

- Register with their details.
- Log in using their roll number and first name.
- Perform various database operations such as updating contact information, viewing records, and deleting records.

## Features

- **Student Registration**: New students can register by entering their roll number, name, percentage, email, and phone number.
- **Login System**: Allows students to log in using roll number and first name.
- **Database Operations**:
  - Show students with percentage > 60%.
  - Update email and phone number.
  - Delete students whose percentage is between 30% and 60%.
  - Find students with a percentage greater than 80%.
  - View all student records.

---

## Database Setup

### **Table Structure**

Run the following SQL command to create the required **StudentInfo** table in Oracle Database:

```sql
CREATE TABLE StudentInfo (
    rollno NUMBER(3) PRIMARY KEY,
    name VARCHAR2(30),
    percentage DECIMAL(3,2),
    fname VARCHAR2(10),
    lname VARCHAR2(10),
    mailid VARCHAR2(30),
    phno NUMBER(10)
);
```

### **Sample Data (Insert Queries)**

```sql
INSERT INTO StudentInfo VALUES (101, 'Lalit Patil', 70.23, 'Lalit', 'Patil', 'lp@gmail.com', 7038898336);
INSERT INTO StudentInfo VALUES (102, 'Amit Sharma', 85.50, 'Amit', 'Sharma', 'amit.sh@gmail.com', 9876543210);
INSERT INTO StudentInfo VALUES (103, 'Priya Desai', 45.67, 'Priya', 'Desai', 'priya.d@gmail.com', 9234567890);
INSERT INTO StudentInfo VALUES (104, 'Rahul Verma', 59.80, 'Rahul', 'Verma', 'rahul.v@gmail.com', 8345678901);
INSERT INTO StudentInfo VALUES (105, 'Neha Joshi', 90.00, 'Neha', 'Joshi', 'neha.j@gmail.com', 9123456789);
INSERT INTO StudentInfo VALUES (106, 'Vikram Singh', 78.45, 'Vikram', 'Singh', 'vikram.s@gmail.com', 9345678901);
INSERT INTO StudentInfo VALUES (107, 'Sneha More', 32.50, 'Sneha', 'More', 'sneha.m@gmail.com', 9456789012);
INSERT INTO StudentInfo VALUES (108, 'Rajesh Gupta', 66.80, 'Rajesh', 'Gupta', 'rajesh.g@gmail.com', 9765432108);
INSERT INTO StudentInfo VALUES (109, 'Swati Pandey', 55.90, 'Swati', 'Pandey', 'swati.p@gmail.com', 8890123456);
INSERT INTO StudentInfo VALUES (110, 'Karan Mehta', 48.20, 'Karan', 'Mehta', 'karan.m@gmail.com', 9543216789);
```

---

## Prerequisites

- **Java JDK 8+**
- **Oracle Database 11g or higher**
- **Oracle JDBC Driver** (ojdbc8.jar)

### **Add JDBC Driver to Project**

1. Download the **ojdbc8.jar** file from Oracle’s website.
2. Add it to your project’s classpath.
3. If using an IDE like **Eclipse** or **IntelliJ IDEA**:
   - Right-click on the project → Properties → Java Build Path → Add External JARs.
   - Select **ojdbc8.jar** and apply the changes.

---

## How to Run

1. **Compile the program:**
   ```sh
   javac LoginRegisterDBcon.java
   ```
2. **Run the program:**
   ```sh
   java test.LoginRegisterDBcon
   ```

---

## Execution Flow

### **Main Menu**

```
**** Choose option ****
 1. Register
 2. Login
 3. Exit
Enter your Choice:
```

### **If Register (Option 1)**

```
Enter your RollNo: 101
Enter your name: Lalit Patil
Enter your percentage: 70.23
Enter your mailID: lp@gmail.com
Enter your PhoneNumber: 7038898336
Student record inserted successfully.
```

### **If Login (Option 2)**

```
Enter your RollNo: 101
Enter your name: Lalit
Login Successful.

**Menu**
--------------------------------------------------
1. Show Students Whose percentage > 60%
2. Update Mailid & Phone Number based on RollNo
3. Delete student whose Percentage is between 30% to 60%
4. Find how many students got more than 80%
5. View All records
6. Exit
Choose Option:
```

---

## Error Handling

The program handles errors using `try-catch` blocks for:

- **Duplicate Roll Numbers** (`SQLIntegrityConstraintViolationException`)
- **Invalid Data Entries** (`SQLDataException` and `InputMismatchException`)
- **Unexpected Errors** (Generic `Exception` handling)

---

## Contribution

Feel free to modify and improve the code. If you find bugs or want to add features, create a pull request or fork the repository.

---

## Author

👤 **Lalit Patil**
