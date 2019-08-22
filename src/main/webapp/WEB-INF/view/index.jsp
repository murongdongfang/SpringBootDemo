<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<title>登录页面-(</title>
</head>
<body
	style="background: url(img/bg.jpg) repeat; background-size: cover; background-color: black">

	<div class="container">
		<form action="loginCheck" method="POST" class="form-signin">
			<h2 class="form-signin-heading"
				style="margin-top: 10px; margin-bottom: 45px; color: white;">
				登录页面-此网站注册人数：${count}</h2>
				<div style="color:white">${msg}</div>
			<input name="name" placeholder="用户名" class="form-control"
				style="margin-top: 10px; margin-bottom: 10px;"> <input
				name="pwd" placeholder="密码" type="password" class="form-control"
				style="margin-top: 10px; margin-bottom: 10px;">
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				style="margin-top: 20px; margin-bottom: 10px;">登录</button>
			<div>
				<a href="/qq"
					style="text-decoration: none; color: #ddddff; line-height: 20px"><img
					src="https://sqimg.qq.com/qq_product_operations/im/qqlogo/logo.png"
					width=26 style="vertical-align: -8px;" />QQ登录</a>
			</div>
		</form>
	</div>
</body>
</html>