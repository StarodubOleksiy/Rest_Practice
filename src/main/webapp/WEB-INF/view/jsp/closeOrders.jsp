<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<table style="align-items: center">
  <tr>
    <th>Name </th>
  </tr>

  <c:forEach items="${orders}" var="orders">
    <tr>
      <td>${orders.orderDate}</td>

    </tr>
  </c:forEach>
</table>


</body>
</html>