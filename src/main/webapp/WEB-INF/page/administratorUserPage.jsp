<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x8132
  Date: 2018/12/6
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
