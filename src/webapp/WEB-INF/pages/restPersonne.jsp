<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<style type="text/css">
body {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

h1 {
	font-size: 40px;
	margin-left: 20px;
	color: green;
	font-family: monospace;
}
</style>
<title>REST | SpringMVC</title>
</head>
<body>
	<h1>TP SPRING FRAMEWORK CRUD</h1>
	<h1>REST SERVICES</h1>
	<h1>
		Réalisé avec le plugin rest de chrome :<a
			href="https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo"
			target="_blank">Advanced Rest Plugin</a>
	</h1>
	<h1>Le contrôlleur chargé du traitement se nomme :
		DefaultRestController</h1>
	<h2>GET : paramètre {id} pour obtenir les informations sur une
		personne.</h2>
	<h2>DELETE : paramètre {id} suppression d'une personne en
		fonction. de son identifiant.</h2>
	<h2>PUT : paramètres {id - nom - date} pour mettre à jour une
		personne.</h2>
	<h2>POST : paramètres {id - nom - date} pour créer une personne.</h2>
	<h2>Exemple : http:localhost:8080/rest/1</h2>
</body>
</html>