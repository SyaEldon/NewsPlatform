
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻修改页面</title>
</head>
<body>
<div>
    <form action="/administratorNewsPage/reviseNews" method="post">
        <label><strong>正在修改:${title}</strong></label><br>
        <label>位于:${type}区</label>
        <hr>
        新闻标题：<input id="newsTitle" type="text"  name="newsTitle" value="${title}"/>&nbsp;<select name="newsTypeNum">
        <option value ="1">国外</option>
        <option value ="2">国内</option>
        <option value="3">体育</option>
        <option value="4">娱乐</option>
        <option value="5">旅游</option>
        <option value="6">教育</option>
    </select>
        <hr>
        <textarea name="newsContent" style="resize: none" cols="50" rows="10">${content}</textarea>
        <input id="newsId" type="hidden" name="newsId" value="${newsId}" /></br>
        <input type="submit" value="提交修改" name="postNewsSubmit"/>
    </form>
</div>

</body>
</html>
