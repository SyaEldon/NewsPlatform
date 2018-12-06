<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
${check}
<form action="/register" method="post">
    用户名:<input type="text" name="name" /></br>
    账号:<input type="text" name="account" /></br>
    密码:<input type="password" name="password" /></br>
    <input type="submit" value="注册">
</form>
</body>
</html>
