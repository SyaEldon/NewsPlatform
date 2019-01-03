<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新闻发布系统</title>
    <script type="text/javascript">
        function login() {
            window.location = "/login";
        }

        function logout() {
            window.location = "/logout";
        }

    </script>
<style type="text/css">
    div.menu ul
    {
        list-style:none; /* 去掉ul前面的符号 */
        margin: 0px; /* 与外界元素的距离为0 */
        padding: 0px; /* 与内部元素的距离为0 */
        width: auto; /* 宽度根据元素内容调整 */
    }
    /* 所有class为menu的div中的ul中的li样式 */
    div.menu ul li
    {
        float:left; /* 向左漂移，将竖排变为横排 */
    }
    /* 所有class为menu的div中的ul中的a样式(包括尚未点击的和点击过的样式) */
    div.menu ul li a, div.menu ul li a:visited
    {
        background-color: #465c71; /* 背景色 */
        border: 1px #4e667d solid; /* 边框 */
        color: #dde4ec; /* 文字颜色 */
        display: block; /* 此元素将显示为块级元素，此元素前后会带有换行符 */
        line-height: 1.35em; /* 行高 */
        padding: 4px 20px; /* 内部填充的距离 */
        text-decoration: none; /* 不显示超链接下划线 */
        white-space: nowrap; /* 对于文本内的空白处，不会换行，文本会在在同一行上继续，直到遇到 <br> 标签为止。 */
    }
    /* 所有class为menu的div中的ul中的a样式(鼠标移动到元素中的样式) */
    div.menu ul li a:hover
    {
        background-color: #bfcbd6; /* 背景色 */
        color: #465c71; /* 文字颜色 */
        text-decoration: none; /* 不显示超链接下划线 */
    }
    /* 所有class为menu的div中的ul中的a样式(鼠标点击元素时的样式) */
    div.menu ul li a:active
    {
        background-color: #465c71; /* 背景色 */
        color: #cfdbe6; /* 文字颜色 */
        text-decoration: none; /* 不显示超链接下划线 */
    }
</style>
</head>

<body>

<div style="position:absolute;  right:20px ;height:20px; ">
    <c:choose>
        <c:when test="${user.userRight==0}">
            (游客)
            <button onclick="login()" id="loginButton">登陆</button>
        </c:when>
        <c:when test="${user.userRight==1}">
            (注册用户)<a href="/userpage">${user.name}</a>
            <button onclick="logout()" id="loginButton">退出</button>
        </c:when>
        <c:when test="${user.userRight==2}">
            <a href="/postNewsPage" id="loginButton" target="_blank" >发布新文章</a>
            (新闻发布员)<a href="/userpage">${user.name}</a>
            <button onclick="logout()" id="loginButton">退出</button>
        </c:when>
        <c:when test="${user.userRight==3}">
            <a href="/administratorNewsPage"  target="_blank" >新闻管理</a>
            <a href="/administratorUserPage"  target="_blank" >用户管理</a>
            <a href="/postNewsPage" id="loginButton" target="_blank" >发布新文章</a>
            (管理员)<a href="/userpage">${user.name}</a>
            <button onclick="logout()" id="loginButton">退出</button>
        </c:when>
    </c:choose>
</div>

<div align="center">
    <font size="40">新闻发布系统</font>
</div>
<div align="center" class="menu" id="channel" style="height: 31.6px ;width: 100%" >
    <ul>
        <li>
            <a href="/homepage?type=1">国外</a>
        </li>
        <li>
            <a href="/homepage?type=2">国内</a>
        </li>
        <li>
            <a href="/homepage?type=3">体育</a>
        </li>
        <li>
            <a href="/homepage?type=4">娱乐</a>
        </li>
        <li>
            <a href="/homepage?type=5">旅游</a>
        </li>
        <li>
            <a href="/homepage?type=6">教育</a>
        </li>
    </ul>
</div>
<c:forEach items="${list}" var="item">
    <div style="border:1px solid rgba(0,0,0,0.47);">
        <h3>
            <a href="/page/newsPage?newsId=${item.newsId}"  target="_blank">${item.title}</a>
        </h3>
        <p style="width:600px;height:40px;overflow:hidden;text-overflow:ellipsis;">${item.content}</p>
        <p style="color:  #008000">作者:${item.userAccount}&nbsp;&nbsp;&nbsp;&nbsp;浏览次数:${item.viewCount}&nbsp;&nbsp;&nbsp;&nbsp;发布时间:${item.gmt_creat} </p>
    </div>
</c:forEach>

</body>
</html>
