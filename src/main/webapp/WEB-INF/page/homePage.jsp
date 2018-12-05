<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新闻发布系统</title>
    <script type="text/javascript">
        function login(){
            window.location="/login";
        }
        function logout(){
            window.location="/logout";
        }

    </script>
</head>

<body>

<div style="position:absolute;  right:20px ;height:20px; ">
    ${userRight}<button onclick="login()" id="loginButton"  style="display:${loginButton}">登陆/注册</button>
    <button onclick="logout()" id="logoutButton" style="display: ${logoutButton}">退出</button>
</div>

<div align="center">
    <font size="40">新闻发布系统</font>
</div>
<c:forEach items="${list}" var="item" >
    <div style="border:1px solid rgba(0,0,0,0.47);">
        <h3 >
            <a href="/page/newsPage?newsId=${item.newsId}">${item.title}</a>
        </h3>
        <p style="width:600px;height:40px;overflow:hidden;text-overflow:ellipsis;">${item.content}</p>
        <p style="color:  #008000">作者：${item.userAccount}         浏览次数：${item.viewCount}</p>
    </div>
</c:forEach>

</body>
</html>
