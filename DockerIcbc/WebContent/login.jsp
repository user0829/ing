<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录注册</title>
<%--  <link rel="shortcut icon" href="${basePath}/images/favicon.ico" type="image/x-icon" /> --%>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/login.css">
<script type="text/javascript">
var basePath="${basePath}";
</script>
<script src="${basePath}/static/js/jquery-1.11.3.min.js"></script>
<script src="${basePath}/static/js/login.js"></script>
</head>
<body>
<div id="wrapper" class="login-page">
    <div id="login_form" class="form">
	    <form class="login-form" >
		    <input type="text" placeholder="用户名" id="user_name" name="user_name" />
		    <input type="password" placeholder="密码" id="password"/>
		    <input id="login" type="submit" value="登&nbsp;&nbsp;&nbsp;录"  onclick="submitData()">
		    <p class="message">使用统一认证账号密码登录</p>
	    </form>
    </div>
</div>
</body>

</html>