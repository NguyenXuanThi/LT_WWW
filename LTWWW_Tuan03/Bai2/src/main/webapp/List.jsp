<%@ page import="iuh.fit.se.bai2.model.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Xuan Thi
  Date: 08/09/2025
  Time: 04:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Account> accountList = (List<Account>) request.getAttribute("accounts");
%>
<h2>Danh sách tài khoản đã đăng ký</h2>
<table border="1" cellpadding="5">
    <tr>
        <th>Username</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Birthdate</th>
        <th>Gender</th>
    </tr>
    <% if (accountList != null) {
        for (Account acc : accountList) { %>
    <tr>
        <td><%= acc.getFirstName() %>
        </td>
        <td><%= acc.getLastName()%>
        </td>
        <td><%= acc.getEmail() %>
        </td>
        <td><%= acc.getBirthDate() %>
        </td>
        <td><%= acc.getGender() %>
        </td>
    </tr>
    <% }
    }
    %>
</table>
<br>
<a href="index.jsp">Đăng ký thêm</a>
</body>
</body>
</html>
