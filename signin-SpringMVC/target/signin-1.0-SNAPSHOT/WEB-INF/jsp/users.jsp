<%--
  Created by IntelliJ IDEA.
  User: bsoimu
  Date: 8/1/2016
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Web Fundamentals - Signin App">
    <meta name="author" content="Florin Stancu">

    <title>Web Fundamentals - Signin App</title>

    <%--<link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/login.css"/>" rel="stylesheet">--%>
</head>
<body>
<div class="container">
    <form class="form-signin" method="GET" action="<c:url value="/user/users"/>">
        <h2 class="form-signin-heading">User Table</h2>
        <table>
            <c:forEach items="${requestScope.userList}" var="user">
                <tr>
                    <td>Username: <c:out value="${user.username}"></c:out></td>
                    <td>Password: <c:out value="${user.password}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
