<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$("a").button();
	});
</script>
<style type="text/css">
body {
	background: #7BA05B;
	margin-left: auto;
	margin-right: auto;
	width: 900px;
	margin-top: 20px;
	text-align: center;
	font-family: monospace;
}

h1 {
	font-size: 50px;
	font-weight: bold;
	color: black;
}

h1+h1+h1 {
	margin-bottom: -10px;
}

a {
	margin-top: 10px;
	width: 20em;
	height: 4em;
}
</style>
<title>Spring MVC</title>

</head>
<body>
	<h1>TP FRAMEWORK SPRING : JAVA EE</h1>
	<h1>HIBERNATE</h1>
	<h1>JPA</h1>
	
	<div id="menu">
		<a href="formPersonne" target="_blank">SPRING CRUD SIMPLE</a><br>
		<a href="rest" target="_blank">SPRING CRUD REST</a><br> <a
			href="email" target="_blank">EMAIL</a><br> <a href="json"
			target="_blank">JSON</a><br> <a href="xml" target="_blank">XML</a><br>
		<a href="strategie" target="_blank">STRATEGIES</a>
	</div>
</body>
</html>