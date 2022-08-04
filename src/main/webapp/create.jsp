
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
        <a href="ProductServlet?action=">List All Product</a>
    </h2>
</center>
<div align="center" >
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name_product" id="name_product" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Amount:</th>
                <td>
                    <input type="text" name="amount" id="amount" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" id="color" size="45"/>
                </td>
            </tr>
            <tr>
            <tr>
                <th>Describe_product:</th>
                <td>
                    <input type="text" name="describe_product" id="describe_product" size="45"/>
                </td>
            </tr>
                <th>Category:</th>
                <td>
                    <select name="category" id="category">
                        <c:forEach items="${categories}" var="c">
                            <option value="${c.getId_category()}">${c.getCategory()}</option>
                        </c:forEach>

                    </select>
                    <a href="/CategoryServlet?action=createC">new </a>
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
