<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x8132
  Date: 2019/1/2
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息主页</title>
</head>
<body>
用户姓名：${user.name}<br>
邮箱：${user.email} <br>
手机号：${user.telephone}<br>
用户权限：<c:choose>
            <c:when test="${user.userRight==1}">
                (注册用户)
            </c:when>
            <c:when test="${user.userRight==2}">
                (新闻发布员)
            </c:when>
            <c:when test="${user.userRight==3}">
                (管理员)
            </c:when>
        </c:choose><br>
用户评论数：${replyCount}<br>
发布新闻数：<c:choose>
    <c:when test="${user.userRight==1}">
        注册用户没有发布权限
    </c:when>
    <c:when test="${user.userRight>1}">
        ${userNewsCount}
    </c:when>
</c:choose><br>


</body>
</html>
