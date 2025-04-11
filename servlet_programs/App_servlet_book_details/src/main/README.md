# 📚 Book Details Servlet Application

This is a simple Java Servlet-based web application that reads and displays **Book Details** from an HTML form. It demonstrates basic use of Servlet API to handle form input, process the request, and generate a dynamic HTML response.

## 🧩 Features

- Collects book information via a web form.
- Displays the entered book details using a Servlet.
- Implements the `Servlet` interface directly (without extending `HttpServlet`).
- Uses `@WebServlet` annotation for URL mapping.

## 💻 Technologies Used

- Java
- Jakarta Servlet API (`jakarta.servlet`)
- HTML
- Apache Tomcat (or any servlet container)

---

## 📥 Input Fields

The HTML form accepts the following book details:

- `BookCode` (Integer)
- `BookName` (String)
- `BookAuthor` (String)
- `BookPrice` (Double)
- `BookQty` (Integer)

---

## 📄 HTML Form (`index.html`)

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Entry Form</title>
</head>
<body>
    <h2>Enter Book Details</h2>
    <form action="set" method="post">
        Book Code: <input type="text" name="bcode"><br>
        Book Name: <input type="text" name="bname"><br>
        Book Author: <input type="text" name="bauthor"><br>
        Book Price: <input type="text" name="bprice"><br>
        Book Quantity: <input type="text" name="bqty"><br><br>
        <input type="submit" value="Display Book Details">
    </form>
</body>
</html>
```

---

## 🔧 Servlet Code (`BookDetails.java`)

```java
@WebServlet("/set")
public class BookDetails implements Servlet {
    public void init(ServletConfig scf) { /* No code */ }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        int bCode = Integer.parseInt(req.getParameter("bcode"));
        String bName = req.getParameter("bname");
        String bAuthor = req.getParameter("bauthor");
        double bPrice = Double.parseDouble(req.getParameter("bprice"));
        int bQty = Integer.parseInt(req.getParameter("bqty"));

        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        pw.println("<h2>**** Book Details ****</h2>");
        pw.println("Book Code: " + bCode + "<br>");
        pw.println("Book Name: " + bName + "<br>");
        pw.println("Book Author: " + bAuthor + "<br>");
        pw.println("Book Price: " + bPrice + "<br>");
        pw.println("Book Quantity: " + bQty + "<br>");
    }

    public void destroy() { /* No code */ }

    public ServletConfig getServletConfig() { return null; }

    public String getServletInfo() { return "Servlet displaying Book details"; }
}
```

---

## 🚀 How to Run

1. Set up your servlet container (e.g., Apache Tomcat).
2. Place the HTML file in the `webapp` directory.
3. Place the compiled servlet `.class` file in the `WEB-INF/classes/test/` directory.
4. Deploy the project on the server.
5. Open the form in your browser, input book details, and submit.
6. The servlet will display the entered book details.

---

## 📌 Note

- Make sure the Servlet API is available in your classpath during compilation.
- Exception handling is not implemented in this example. You can enhance the application by adding form validation and exception handling.

---

## 📚 Output Example

```
**** Book Details ****
Book Code: 101
Book Name: Java Programming
Book Author: James Gosling
Book Price: 499.99
Book Quantity: 50
```

---
