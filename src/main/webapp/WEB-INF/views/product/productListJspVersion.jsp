<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.pion.product.dto.ProductResponse" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<script src="/js/jquery-3.6.3.min.js"></script>
<body>

<%
    ArrayList<ProductResponse> list = (ArrayList<ProductResponse>) request.getAttribute("list");
%>

<div class="container" style="max-width: 600px">
    <div class="py-5 text-center">
        <h2>상품 목록</h2>
    </div>
    <div class="row">
        <div class="col">
            <button class="btn btn-primary float-end"
            	onclick="location.href='/product/addProductForm'" 
	             type="button">
                상품 등록
            </button>
        </div>
    </div>
    <hr class="my-4">
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>상품명</th>
                <th>가격</th>
            </tr>
            </thead>
            <tbody class = "product_list">
            <%
                for (int i = 0; i < list.size(); i++) {

                    out.println("<tr>");
                    out.println("<td>" + (i+1) + "</td>");
                    out.print("<td> <a href=\"/main/detail/"+(i+1) + "\">"+ list.get(i).getName() + "</td>");
                    out.print("<td>"+ list.get(i).getPrice() + "</td>");
                    out.print("</tr>");
                }
            %>
            </tbody>
        </table>
    </div>
</div> 
</body>
</html>
