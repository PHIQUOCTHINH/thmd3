<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/ProductServlet?action=create">Add New Product</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name_product</th>
            <th>Price</th>
            <th>Amount</th>
            <th>Color</th>
            <th>Describe_product</th>
            <th>Category</th>

        </tr>
        <c:forEach var="b" items="${lb}">
            <tr>
                <td>${b.getId_product()}</td>
                <td>${b.getName_product()}</td>
                <td>${b.getPrice()}</td>
                <td>${b.getAmount()}</td>
                <td>${b.getColor()}</td>
                <td>${b.getDescribe_product()}</td>
                <td>${b.getCategory()}</td>
                <td>
                    <a href="/ProductServlet?action=edit&id=${b.id_product}">Edit</a>
                    <a href="/ProductServlet?action=delete&id=${b.id_product}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <form action="/CategoryServlet?action=category" method="post">
        <table border="1px"  >
            <tr>
                <th>THỂ LOẠI:</th>
                <td >
                    <c:forEach    items="${categories}" var="l">
                        <li>
                            <ul class="list-group">
                                <li class="list-group-item"><a href="CategoryServlet?action=category&cid=${l.getId_category()}"><option value="${l.getId_category()}">${l.getCategory()}</option></a></li>

                            </ul>
                        </li>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>