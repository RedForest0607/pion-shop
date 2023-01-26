<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Title Here</title>
</head>

<%
    String name = (String) request.getParameter("name");
    String price = (String) request.getParameter("price");
%>
<body>

<%=name%>
<%=price%>
</body>
</html>
