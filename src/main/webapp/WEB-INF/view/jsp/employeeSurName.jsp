<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<table style="align-items: center">
  <tr>
    <th>First Name </th>
    <th>Last Name </th>
    <th>Position</th>
    <th>Salary</th>
  </tr>

  <c:forEach items="${employee}" var="employee">
    <tr>
      <td>${employee.name}</td>
      <td>${employee.surname}</td>
    </tr>
  </c:forEach>
</table>


</body>
</html>
