<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <script type="text/javascript">
        function reloadRegister(){
            window.location="/register";
        }
    </script>
</head>
<body>
${check}
<form action="/login" method="post">
    账号：<input type="text" name="account" /></br>
    密码：<input type="password" name="password" /></br>
    <input type="submit" value="登陆" />
</form>
<button onclick="reloadRegister()">注册</button>
</body>
</html>
