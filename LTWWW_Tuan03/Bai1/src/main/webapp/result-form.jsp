<%@ page import="iuh.fit.se.ltwww_tuan03.Student" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="iuh.fit.se.ltwww_tuan03.Qualification" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2025
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result submit</title>
</head>
<body>
<%
    Student student = new Student();
    student = (Student) request.getAttribute("student");
    Qualification[] qualifications = student.getQualifications().toArray(new Qualification[0]);
    PrintWriter out1 = response.getWriter();
    out1.println(
            "First name: "+ student.getFirstName()
            + "<br/> Last name: " + student.getLastName()
            + "<br/> Email: " + student.getEmail()
            + "<br/> Birth day: " + student.getBirthday()
            + "<br/> Gender: " + student.getGender()
    );
    // In ra bảng HTML cho qualifications
    out1.println("<h3>Qualifications:</h3>");
    out1.println("<table border='1' cellpadding='5' cellspacing='0'>");
    out1.println("<tr><th>Sl.No.</th><th>Examination</th><th>Board</th><th>Percentage</th><th>Year of Passing</th></tr>");

    String[] examNames = {"Class X", "Class XII", "Graduation", "Masters"};

    for (int i = 0; i < qualifications.length; i++) {
        Qualification q = qualifications[i];
        out1.println("<tr>");
        out1.println("<td>" + (i + 1) + "</td>");
        out1.println("<td>" + examNames[i] + "</td>");
        out1.println("<td>" + q.getBoard() + "</td>");
        out1.println("<td>" + q.getPercentage() + "</td>");
        out1.println("<td>" + q.getYearOfPassing() + "</td>");
        out1.println("</tr>");
    }

    out1.println("</table>");
%>
</body>
</html>
