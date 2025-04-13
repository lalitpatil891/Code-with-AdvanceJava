<%@page import="test.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	BookBean bb = (BookBean) request.getAttribute("bbean");
	out.println(bb.getCode() + "&nbsp&nbsp" + bb.getName() + "&nbsp&nbsp" + bb.getAuthor() + "&nbsp&nbsp" + bb.getPrice()
			+ "&nbsp&nbsp" + bb.getQty() + "<br>");
	%>
	<a href="BookDetails.html">AddBookDetails</a>
	<a href="code.html">ViewBookDetailsByCode</a>
</body>
</html>
