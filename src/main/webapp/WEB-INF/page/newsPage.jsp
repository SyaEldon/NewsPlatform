<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<div align="center">
    <font size="40">${title}</font>
</div>
<div>
    ${content}
</div>
<div>
    <c:forEach items="${list}" var="item">
        <div style="border:1px solid rgba(0,0,0,0.47);">
            <h3>
                <a href="/page/newsPage?newsId=${item.newsId}">${item.title}</a>
            </h3>
            <p style="width:600px;height:40px;overflow:hidden;text-overflow:ellipsis;">${item.content}</p>
            <p style="color:  #008000">作者:${item.userAccount}&nbsp&nbsp&nbsp&nbsp浏览次数:${item.viewCount}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
