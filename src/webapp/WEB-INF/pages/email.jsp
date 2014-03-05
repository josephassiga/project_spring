<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<meta content="charset=UTF-8">
<script>
	$(function() {
		$("input[type=submit], a, button").button();
		$("#datepicker").datepicker();
	});
</script>
<style type="text/css">
input[type=submit] {
	margin-top: 20px;
	margin-left: 20px;
	width: 8em;
	height: 4em;
}

input[type=text]:focus,textarea:focus {
  background-color: yellow;
}


input[type=text]{
 margin-bottom: 20px;
 height: 30px;
 font-size:12px;
 font-family:'Lucida Casual', 'Comic Sans MS';  
}

label {
	display: inline-block;
	width: 250px;
	text-align: left;
	margin-left: 30px
}

body {
	margin-left: auto;
	margin-right: auto;
	width: 800px;
	margin-top: 100px
}


h1 {
	font-size: 40px;
	margin-left: 20px;
	color: green;
	font-family: monospace;
	text-align: center;
}

#note{
color: red;
font-weight: bold;

}
</style>
<title>JSON | SpringMVC</title>
</head>
<body>
	<h1>TP SPRING FRAMEWORK</h1>
	<h1>ENVOI DE MAIL AVEC JAVAX.MAIL</h1>
	<h1 id="note">Veuillez changer les paramètres de connexions dans le fichier applicationContext sur le bean senderMail</h1>
	<form:form commandName="email">
		<label> From : </label>
		<form:input path="from"  size="65px"/>
		<label> To : </label>
		<form:input path="to" size="65px" />
		<label> Subject : </label>
		<form:input path="Subject" size="65px" />
		<label> Message : </label>
		<form:textarea path="message"  rows="10" cols="50"/><br><br>
		<input type="submit" id="mail" formaction="email/sendMail"
			value="Send Mail" />
	</form:form>
</body>
</html>