## BookTrackDBcon - JDBC Oracle Database Connectivity

### Project Overview
BookTrackDBcon is a Java-based console application that interacts with an Oracle database to manage book records. The application allows users to:
- Insert multiple book records
- View all book details
- Search for a book by its book code

### Features
- Uses JDBC to connect to an Oracle database
- Supports inserting, viewing, and searching book records
- Handles user input errors gracefully
- Implements exception handling for robustness

### Technologies Used
- Java
- JDBC (Java Database Connectivity)
- Oracle Database

### Database Schema
Table: **BookDetails72**
```
BCODE    NUMBER(38)     PRIMARY KEY
BNAME    VARCHAR2(100)  NOT NULL
BAUTHOR  VARCHAR2(100)  NOT NULL
BPRICE   NUMBER(10,2)   NOT NULL
BQTY     NUMBER(38)     NOT NULL
```

### Setup Instructions
1. Install Oracle Database and create a schema.
2. Create the **BookDetails72** table using the following SQL command:
```sql
CREATE TABLE BookDetails72 (
    bcode NUMBER(38) PRIMARY KEY,
    bname VARCHAR2(100) NOT NULL,
    bauthor VARCHAR2(100) NOT NULL,
    bprice NUMBER(10,2) NOT NULL,
    bqty NUMBER(38) NOT NULL
);
```
3. Update database credentials in the `BookTrackDBcon.java` file:
```java
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "your_username", "your_password");
```
4. Compile and run the Java program:
```sh
javac BookTrackDBcon.java
java test.BookTrackDBcon
```

### Usage
1. **Insert Book Details**: Allows the user to insert multiple book records.
2. **View All Book Details**: Displays all stored book records.
3. **Find Book by Code**: Searches for a book using its unique book code.

### Error Handling
- Prevents SQL injection risks by ensuring correct data types.
- Catches `InputMismatchException` if non-integer values are entered where integers are expected.
- Displays meaningful error messages when queries fail.
