# DisplayServlet

## Overview
`DisplayServlet` is a Java Servlet that handles HTTP requests and displays user details such as username, mail ID, and phone number.

## Features
- Accepts user input through request parameters.
- Processes and displays user details.
- Implements `Servlet` interface with lifecycle methods.

## Technologies Used
- Java (Jakarta EE)
- Servlets
- HTML
- Web Container (Tomcat/Jetty)

## Installation & Setup

### Prerequisites
- Java Development Kit (JDK 8 or higher)
- Apache Tomcat or any Servlet-compatible web server
- IDE (Eclipse/IntelliJ/VS Code) with Servlet support

### Steps
1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Open the project in your IDE.
3. Ensure `jakarta.servlet-api.jar` is added to the classpath.
4. Deploy the project to Tomcat.
5. Access the servlet by visiting:
   ```
   http://localhost:8080/<your-app-name>/dis?uname=John&mid=john@example.com&phno=1234567890
   ```

## Code Explanation
The servlet extracts parameters from the request:
- `uname`: User's name
- `mid`: Mail ID
- `phno`: Phone number

### Example Request
```
http://localhost:8080/app/dis?uname=Alice&mid=alice@mail.com&phno=9876543210
```

### Expected Output
```html
****** User Details ******<br>
UserName: Alice<br>
MailId: alice@mail.com<br>
PhoneNo: 9876543210<br>
```

---
## Creating & Executing a Web Application in Eclipse

### Step 1: Open Eclipse
- Select a workspace and click **Launch**.

### Step 2: Create a Dynamic Web Project
- `File` → `New` → `Project` → `Web` → `Dynamic Web Project` → `Next` → Name the project → `Finish`.

### Step 3: Add `servlet-api.jar` to the Project
- Right-click on project → `Build Path` → `Configure Build Path` → `Libraries` → `Classpath` → `Add External JARs` → Select `servlet-api.jar` from Tomcat’s `lib` folder → `Open` → `Apply and Close`.

### Step 4: Add Tomcat Server to Eclipse
- `Servers` → `Click to Create New Server` → Select Tomcat version → `Next` → Browse Tomcat installation directory → `Finish`.

### Step 5: Create an HTML File for User Input
Create `user.html`:
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Input Form</title>
</head>
<body>
<form action="dis" method="post">
UserName: <input type="text" name="uname"><br>
MailId: <input type="text" name="mid"><br>
PhoneNo: <input type="text" name="phno"><br>
<input type="submit" value="Display">
</form>
</body>
</html>
```

### Step 6: Create `web.xml` (Servlet Mapping File)
Create `web.xml`:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
  <welcome-file-list>
      <welcome-file>user.html</welcome-file>
  </welcome-file-list>
</web-app>
```

### Step 7: Create a Package in `src/main/java`
- Create a package named `test`.

### Step 8: Create a Servlet Program
Create `DisplayServlet.java`:
```java
package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/dis")
public class DisplayServlet implements Servlet {
    @Override
    public void init(ServletConfig scf) throws ServletException {
        // No Code
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String uName = req.getParameter("uname");
        String mId = req.getParameter("mid");
        long phNo = Long.parseLong(req.getParameter("phno"));
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.println("******User Details*****<br>");
        pw.println("UserName: " + uName + "<br>");
        pw.println("MailId: " + mId + "<br>");
        pw.println("PhoneNo: " + phNo + "<br>");
    }

    @Override
    public void destroy() {
        // No Code
    }

    @Override
    public String getServletInfo() {
        return "Servlet displaying User details...";
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.getServletConfig();
    }
}
```

### Step 9: Run the Web Application
- Right-click the project → `Run As` → `Run on Server` → Select Tomcat → `Finish`.
- Open browser and go to `http://localhost:8082/App_Servlet_1/`.

---
**This completes the setup and execution of a Servlet-based web application using Eclipse and Tomcat.**
