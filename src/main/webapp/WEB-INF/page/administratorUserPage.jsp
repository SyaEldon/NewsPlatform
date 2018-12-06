<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理界面</title>
</head>
<body>
<h1><strong>你好,（管理员）${userName}</strong></h1>
<hr>
<table border="1px">
    <tr>
        <td>用户Id</td>
        <td>姓名</td>
        <td>账号</td>
        <td>等级</td>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.key.userId}</td>
            <td>${item.key.name}</td>
            <td>${item.key.account}</td>
            <td>${item.value}</td>

            <td>
                <form id="updateUserRight_form" method="post" action="/administratorUserPage/updateUserRight">
                    <input type="hidden" name="userId" value="${item.key.userId}" />
                    <input type="hidden" name="userAccount" value="${item.key.account}" />
                    <select name="userRight">
                        <option value ="0">删除用户</option>
                        <option value ="1">更改为注册用户</option>
                        <option value ="2">更改为新闻发布员</option>
                    </select>
                    <button onclick="document.getElementById('updateUserRight_form').submit();">修改</button>
                </form>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
