<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bsoimu
  Date: 7/30/2016
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DOREL UI</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/create"
      method="get">
    <p>
        Name <input type="text" name="name" />
    </p>

    <p>
        Password <c:out value="${user.pass}"></c:out>
    </p>

</form>

<button type="button" onclick="window.location='/dorel-ui';">Home</button>

</body>
</html>
