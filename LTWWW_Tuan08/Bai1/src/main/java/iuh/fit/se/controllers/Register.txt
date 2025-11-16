<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee</title>
</head>
<body>
<h1>Employee Register</h1>
<%--@elvariable id="employee" type="java"--%>
<form:form action="${pageContext.request.contextPath}/save" method = "post" modelAttribute="employee">
    <table>
        <tr>
            <td>First Name</td>
            <td>
                <form:hidden path="id"/>
                <form:input path="firstName" placeholder = "First Name"/>
                <form:errors path="firstName" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>
                <form:input path="lastName" placeholder = "Last Name"/>
                <form:errors path="lastName" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <form:input path="email" placeholder = "Email"/>
                <form:errors path="email" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>Date of birth</td>
            <td>
                <form:input path="dateOfBirth" type="date"/>
                <form:errors path="dateOfBirth" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td>
                <form:input path="phone" placeholder = "Phone"/>
                <form:errors path="phone" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
        <tr>
            <td>Gender</td>
            <td>
                <form:radiobutton path="gender" value="Male" label="Male"/>
                <form:radiobutton path="gender" value="Female" label="Female"/>
                <form:errors path="gender" cssStyle="color:red"/>
            </td>
        </tr>

        </tr>
        <tr>
            <td>Address</td>
            <td>
                <form:input path="address" placeholder = "Address"/>
                <form:errors path="address" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <form:button name="action" value="back">Back</form:button>
                <form:button name="action" value="submit">Register</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>