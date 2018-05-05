<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.div1 {
	width: 300px;
	height: 600px;
}
</style>
</head>
<body>
	<form action="/Spider/SpiderServlet" method="post">
		<div calss="div1">
			<input type="text" name="word" placeholder="请输入你要查询的关键字"> <input
				type="text" name="num" placeholder="请输入你要查询多少条数据"> <input
				type="submit" value="提交">
		</div>
	</form>

</body>
</html>