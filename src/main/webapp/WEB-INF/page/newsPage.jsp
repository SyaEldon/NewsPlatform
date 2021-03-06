<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${viewNews.title}</title>
    <script type="text/javascript">
        window.onload=function () {
            var newsId=window.location.search.substring(8);
            document.getElementById("newsId").value=newsId;
        }
    </script>
</head>
<body>
<div align="center">
    <font size="40">${viewNews.title}</font>
</div>
<div style="border:3px solid rgba(0,0,0,0.7);">
    ${viewNews.content}
        <br>
        <p align="center" style="color:  #008000 ;font-size: 12px" >作者:${newsUser}&nbsp;&nbsp;&nbsp;&nbsp;发布时间:${viewNews.gmt_creat}</p>
        <p align="center" style="color:  #008000 ;font-size: 12px" >浏览次数:${viewNews.viewCount}</p>
</div>

<br><br><br><hr>
<div>
    <c:forEach items="${list}" var="item">
        <div style="border:1px solid rgba(10,65,80,0.47);">
                <p style="color:  #008000 ;font-size: 12px" >回复用户:${item.value.name}&nbsp;&nbsp;&nbsp;&nbsp;发布时间:${item.key.gmt_creat}</p>
            <form id="replyDelete_form" method="post" action="/deleteReply">
                <input type="hidden" name="replyId" value="${item.key.replyId}" />
                <input  type="hidden" name="deleteReplyNewsId" value="${item.key.newsId} "/>
                 <c:choose>
                     <c:when test="${viewUser.userRight==3}">
                         <button onclick="document.getElementById('replyDelete_form').submit();">删除</button>
                     </c:when>
                 </c:choose>
            </form>


            <div style="border:1px solid rgba(38,11,80,0.47);">
                <p >${item.key.content}</p>
            </div>
        </div>
    </c:forEach>
</div>
<div>
    <form action="/postReply" method="post">
        <label><strong>reply</strong></label><br>
        <textarea name="replyContent" style="resize: none" cols="100" rows="10"></textarea>
        <input type="submit" value="reply" name="replySubmit"/>
        <input id="newsId" type="hidden" name="newsId"  /></br>
    </form>
</div>
</body>
</html>
