
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻发布页面</title>
</head>
<body>
<div>
    <form action="/postNews" method="post">
        <label><strong>新闻发布页面</strong></label><br>
        <hr>
        新闻标题：<input id="newsId" type="text"  name="newsTitle" />&nbsp;<select name="newsTypeNum">
        <option value ="1">国外</option>
        <option value ="2">国内</option>
        <option value="3">体育</option>
        <option value="4">娱乐</option>
        <option value="5">旅游</option>
        <option value="6">教育</option>
    </select>
        <hr>
        <textarea name="newsContent" style="resize: none" cols="50" rows="10"></textarea>
        <input type="submit" value="发布" name="postNewsSubmit"/>
    </form>
</div>

</body>
</html>
