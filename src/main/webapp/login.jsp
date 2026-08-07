<%--
  Created by IntelliJ IDEA.
  User: Maleesha
  Date: 8/7/2026
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>J2EE Security ORM | LOGIN</title>
</head>
<body>
<h1>Login</h1>
<form method="POST" action="${pageContext.request.contextPath}/login">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"/></td>
        </tr>
    </table>
</form>
</body>
</html>
