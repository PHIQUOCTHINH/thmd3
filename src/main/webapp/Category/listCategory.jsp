<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1> Management</h1>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of </h2></caption>
        <tr>
            <th>ID</th>
            <th>Category</th>
        </tr>
        <c:forEach var="categories" items="${categories}">
            <tr>
                <td>${categories.getId_category()}</td>
                <td>${categories.getCategory()}></td>

                <a href="${pageContext.request.contextPath}/CategoryServlet?action=edit&id=${categories.id_category}">Edit</a>
                <a href="${pageContext.request.contextPath}/CategoryServlet?action=delete&id=${categories.id_category}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>