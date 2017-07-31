<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>商城后台管理</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="#" class="navbar-brand" style="margin: 0; padding: 5;">商城后台管理</a>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-collapse">
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right" style="margin-top: 0;">
					<li><a href="index.html"><span
							class="glyphicon
        glyphicon-home"></span> 首页</a></li>
					<li class="active"><a href="#"><span
							class="glyphicon
          glyphicon-user"></span> 用户</a></li>
					<li><a href="goods.html"><span
							class="glyphicon
            glyphicon-shopping-cart"></span> 商品</a></li>
					<li><a href="#"><span
							class="glyphicon
              glyphicon-question-sign"></span>
							关于</a></li>
				</ul>
			</div>
		</div>
	</nav>
<div class="jumbotron">
	<div class="container">
		<hgroup>
			<h1>新增用户</h1>
			<h4>可增加用户名、用户密码...</h4>
		</hgroup>
	</div>
</div>
	<form role="form" action='/JsonTest/BackDeleteUsers' method='post'>
	<div class="form-group">
			<div class="div1 container">
				<div class="row">
					<div class="col-md-3 col-md-push-2">
					<label>用户名</label>
						<input name="userAddName" type="text" class="form-control"  placeholder="请输入新用户名" >
					</div>
				</div>
			</div>
		</div>
	<div class="form-group">
			<div class="div1 container">

				<div class="row">
					<div class="col-md-3 col-md-push-2">
						<label>用户密码</label> <input name="userAddPassword" type="text" class="form-control" placeholder="请输入密码">
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 col-md-push-2">
						<button type="submit" class="btn btn-info update-btn-1">提交</button>
					</div>
				</div>
			</div>

		</div>
	</form>
</body>
</html>