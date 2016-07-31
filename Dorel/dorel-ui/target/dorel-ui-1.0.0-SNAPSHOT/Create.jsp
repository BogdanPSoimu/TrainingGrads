<%--
  Created by IntelliJ IDEA.
  User: bsoimu
  Date: 7/28/2016
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
            Password <input type="password" name="pass" />
        </p>

        <p>
            Submit <input type="submit" name="submit" value="Submit"/>
        </p>
    </form>

    <button type="button" onclick="window.location='/dorel-ui';">Home</button>

</body>
</html>
