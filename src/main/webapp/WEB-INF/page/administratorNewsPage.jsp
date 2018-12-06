<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>新闻管理界面</title>
    <script type="text/javascript">

    </script>
</head>
<body>
<h1><strong>你好,（管理员）${userName}</strong></h1>
<hr>
<form action="/login" method="post">
    文章搜索：<input type="text" name="searchText" />&nbsp;<select name="newsTypeNum">
    <option value ="1">新闻Id</option>
    <option value ="2">标题</option>
    <option value ="3">分区</option>
    <option value ="4">发布者</option>
    <option value ="5">发布时间</option>
</select><input type="submit" value="查询" name="searchSubmit"/></br>
</form>
    <table border="1px">
        <tr>
            <td>新闻序号</td>
            <td>标题</td>
            <td>分区</td>
            <td>发布者</td>
            <td>是否可见</td>
            <td>发布时间</td>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.key.newsId}</td>
                <td>${item.key.title}</td>
                <td>${item.value}</td>
                <td>${item.key.userAccount}</td>
                <td>${item.key.visible}</td>
                <td>${item.key.gmt_creat}</td>
                <td>
                    <form id="delete_form" method="post" action="/administratorNewsPage/delete">
                        <input type="hidden" name="delete" value="${item.key.newsId}" />
                        <button onclick="document.getElementById('delete_form').submit();">删除</button>
                    </form>
                </td>
                <td>
                    <form id="updateVisible_form" method="post" action="/administratorNewsPage/updateVisible">
                        <input type="hidden" name="visible" value="${item.key.newsId}" />
                        <button onclick="document.getElementById('updateVisible_form').submit();">屏蔽</button>
                    </form>
                </td>
                <td><a href="/administratorNewsPage/reviseNews?newsId=${item.key.newsId}">修改</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
