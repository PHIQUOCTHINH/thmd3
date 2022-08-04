<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="list?action=book">List All Product</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Book
                </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="id_product" value="<c:out value='${product.id_product}' />"/>
            </c:if>
            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name_product" size="45"
                           value="<c:out value='${product.name_product}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Describe:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Image:</th>
                <td>
                    <input type="text" name="amount" size="15"
                           value="<c:out value='${product.amount}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Status:</th>
                <td><select name="color" id="status">
                    value="<c:out value='${product.color}' />"
                    />

                </select>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select name="category" id="category">
                        <c:forEach items="${categories}" var="c">
                            <option value="${c.getId_category()}">${c.getCategory()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>