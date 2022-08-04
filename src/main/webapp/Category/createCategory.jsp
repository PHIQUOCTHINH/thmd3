
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category Management Application</title>
</head>
<body>
<center>
    <h1>Category Management</h1>
    <h2>
        <a href="/list?action=createC">ADD NEW BOOK</a>
    </h2>
</center>
<div align="center">
    <form  method="post" >
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Category</h2>
            </caption>
            <tr>
                <th>Category Name:</th>
                <td>
                    <input type="text" name="category_name" id="category_name" size="45"/>
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
