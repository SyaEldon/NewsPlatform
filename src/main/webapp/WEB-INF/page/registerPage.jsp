<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>

<script language="JavaScript">
    function check() {
        checkName();checkAccount();checkPassword();checkEmail();checkIdCard();checkPhone();
        return checkName()&&checkAccount()&&checkPassword()&&checkEmail()&&checkIdCard()&&checkPhone();
    }

    function checkName() {
        var name=document.getElementById("name").value;
        if(name.length==0){
            document.getElementById("nameCheckText").innerHTML="姓名不能为空";
            return false;
        }
        else if (name.length>8) {
            document.getElementById("nameCheckText").innerHTML="姓名最多8位";
            return false;
        }
        else {
            document.getElementById("nameCheckText").innerHTML="√";
            return true;
        }
    }
    function checkAccount() {
        var account=document.getElementById("account").value;
        if(account.length==0){
            document.getElementById("accountCheckText").innerHTML="账号不能为空";
            return false;
        }
        else if (account.length>12) {
            document.getElementById("accountCheckText").innerHTML="account最多12位";
            return false;
        }
        else {
            document.getElementById("accountCheckText").innerHTML="√";
            return true;
        }
    }
    function checkPassword() {
        var password=document.getElementById("password").value;
        if(password.length==0){
            document.getElementById("passwordCheckText").innerHTML="密码不能为空";
            return false;
        }
        else if (password.length>20||password.length<8) {
            document.getElementById("passwordCheckText").innerHTML="密码最少8位,最多20位";
            return false;
        }
        else {
            document.getElementById("passwordCheckText").innerHTML="√";
            return true;
        }
    }
    function checkEmail() {
        var email = document.getElementById('email').value;
        var pattern =  /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/; //验证邮箱正则表达式
        if(!pattern.test(email)){
            document.getElementById("emailCheckText").innerHTML="邮箱格式不合规范";
            return false;
        }
        else {
            document.getElementById("emailCheckText").innerHTML="√";
            return true;
        }
    }
    function checkIdCard() {
        var idCard = document.getElementById('idCard').value;
        var pattern = /^(\d{15})|(\d{18})|(\d{17}(\d|X|x))$/; //验证手机号正则表达式
        if(!pattern.test(idCard)){
            document.getElementById("idCardCheckText").innerHTML="身份证号码不合规范";
            return false;
        }
        else {
            document.getElementById("idCardCheckText").innerHTML="√";
            return true;
        }
    }
    function checkPhone(){
        var telephone = document.getElementById('telephone').value;
        var pattern = /^1[34578]\d{9}$/; //验证手机号正则表达式
        if(!pattern.test(telephone)){
            document.getElementById("telephoneCheckText").innerHTML="手机号码不合规范";
            return false;
        }
        else {
            document.getElementById("telephoneCheckText").innerHTML="√";
            return true;
        }
    }
</script>

<body>
${check}
<form action="/register" method="post" onsubmit="return check()">
    用户名:<input type="text" name="name" id="name" onblur="checkName()"/>
    <span id="nameCheckText"></span> </br>
    账号:<input type="text" name="account" id="account" onblur="checkAccount()"/>
    <span id="accountCheckText"></span> </br>
    密码:<input type="password" name="password" id="password" onblur="checkPassword()"/>
    <span id="passwordCheckText"></span> </br>
    邮箱:<input type="text" name="email" id="email" onblur="checkEmail()"/>
    <span id="emailCheckText"></span> </br>
    身份证:<input type="text" name="idCard" id="idCard" onblur="checkIdCard()"/>
    <span id="idCardCheckText"></span> </br>
    手机:<input type="text" name="telephone" id="telephone" onblur="checkPhone()"/>
    <span id="telephoneCheckText"></span> </br>
    <input type="submit" value="注册">
</form>
</body>
</html>
