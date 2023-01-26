<%--
  Created by IntelliJ IDEA.
  User: ingyu
  Date: 2023/01/26
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Root 템플릿</title>
</head>
<body>
<%--static way--%>
	<%@include file="header.jsp"%>
	<%@include file="product/productList.jsp"%>
	<%@include file="footer.jsp"%>
</body>
</html>