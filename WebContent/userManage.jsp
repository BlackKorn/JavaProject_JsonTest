<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.* , com.test.utils.DBCounter"%>
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
					<li><a href="GoodsManage.jsp"><span
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
				<h1>用户管理界面</h1>
			</hgroup>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 div3" id="myScrollspy">
			 <div class="div4">
				<a class="list-group-item" id="btn1" href="javascript:void(0);">查看用户</a>
				<a class="list-group-item" href="/JsonTest/userAdd.jsp">新增用户</a>
			</div>
		</div>
		<div class="col-md-9" id="content">
			<div class="div2 container">
				<div class="row">
					<div class="col-md-8 ">
						<table class="table table-striped table-bordered table-hover"
							id="table1" style="display: none;">
							<thead>
								<tr>
									<th><span class="glyphiconglyphicon-user"></span>&nbsp&nbsp用户名</th>
									<th><span class="glyphiconglyphicon-lock"></span>&nbsp&nbsp密码</th>
									<th><span class="glyphiconglyphicon-remove"></span>&nbsp&nbsp删除用户</th>
									<th><span class="glyphiconglyphicon-refresh"></span>&nbsp&nbsp修改用户</th>
								</tr>
							</thead>
							<tbody id="tbody-result">
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-push-3">
						<ul class="pagination" id="li-result" value="ul"
							style="display: none;">
							<%
								int pageSize = 3;
								int pageNow = 1;
								int pageCount = 0;//共有多少页
								int rowCount = 0;

								DBCounter dbCounter = new DBCounter("users");
								rowCount = dbCounter.dbCount();
								pageCount = (rowCount - 1) / pageSize + 1;

								String str = "<li value=" + 0 + "><a href='#'>&laquo;</a></li>";
								for (int i = 0; i < pageCount; i++) {
									str = str + "<li value=" + (i + 1) + "><a href='#'>" + (i + 1) + "</a></li>";
								}
								str = str + "<li value=" + 99 + "><a href='#'>&raquo;</a></li>";
								out.println(str);
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			var $btn = $("#btn1");
			$btn
					.on(
							"click",
							function() {
								$
										.ajax({
											url : "http://localhost:8080/JsonTest/BackShowUsers",
											dataType : "json",
											type : "POST",
											success : function(result) {
												var str = "";
												//var liStr="";
												for (var i = 0; i < result.rows.length; i++) {
													str = str
															+ "<tr>"
															+ "<td>"
															+ result.rows[i].userName
															+ "</td>"
															+ "<td>"
															+ result.rows[i].passWord
															+ "</td>"
															+ "<td>"
															+ "<a href='/JsonTest/BackDeleteUsers?userName="
															+ result.rows[i].userName
															+ "'>删除</a>"
															+ "</td>"
															+ "<td>"
															+ "<a href='/JsonTest/userUpdate.jsp?userName="
															+ result.rows[i].userName
															+ "&userPassword="
															+ result.rows[i].passWord
															+ "'>修改</a>"
															+ "</td></tr>";
												}
												$("#tbody-result").html(str);
												$("#li-result").show();
												$("#table1").show();
											},
											err : function(result) {
											}
										})
							})
		})

		$(function() {
			var $li = $("li");
			$li
					.on(
							"click",
							function() {
								//alert($(this).val());
								$
										.ajax({
											url : "http://localhost:8080/JsonTest/BackShowUsers",
											data : {
												pageNow : $(this).val(),
											},
											dataType : "json",
											type : "POST",
											success : function(result) {
												//alert(result);
												var str = "";
												for (var i = 0; i < result.rows.length; i++) {
													if (result.rows[i].userName != ""
															& result.rows[i].userName != null) {
														str = str
																+ "<tr>"
																+ "<td>"
																+ result.rows[i].userName
																+ "</td>"
																+ "<td>"
																+ result.rows[i].passWord
																+ "</td>"
																+ "<td>"
																+ "<a href='/JsonTest/BackDeleteUsers?userName="
																+ result.rows[i].userName
																+ "'>删除</a>"
																+ "</td>"
																+ "<td>"
																+ "<a href='/JsonTest/userUpdate.jsp?userName="
																+ result.rows[i].userName
																+ "&userPassword="
																+ result.rows[i].passWord
																+ "'>修改</a>"
																+ "</td></tr>";
													}
												}
												alert(1);
												alert($("#tbody-result").html(str));
											},
											err : function(result) {
											}
										})
							})
		})
	</script>
</body>
</html>