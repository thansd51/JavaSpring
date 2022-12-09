<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href='get'>test1 get</a>
	<br />
	<form action='get' method='post'>
		<button type='submit'>test1 post</button>
	</form>

	<hr />
	<a href='post'>test2 get</a>
	<br />
	<form action='post' method='post'>
		<button type='submit'>test2 post</button>
	</form>
	<hr />
	<a href='test3'>test3 get</a>
	<br />
	<form action='test3' method='post'>
		<button type='submit'>test3 post</button>
	</form>
	<hr />
	<a href='test'>test get</a>
	<br />
	<form action='test' method='post'>
		<button type='submit'>test post</button>
	</form>
</body>
</html>