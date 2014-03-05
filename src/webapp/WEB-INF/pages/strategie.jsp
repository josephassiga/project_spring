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
	width: 850px;
}

h1 {
	font-size: 40px;
	margin-left: 20px;
	color: green;
	font-family: monospace;
}

h1,p {
	text-align: center;
}

#lien {
	margin-top: 50px;
}

table {
	/* 	border-width: 1px; */
	border-style: solid;
	border-color: black;
	width: 650px;
	background-color: #89CFF0;
}

td {
	border-width: 1px;
	border-style: solid;
	width: 100px;
}

tr {
	border-width: 1px;
	border-style: solid;
	border: 1px;
	width: 100px;
}

table,th,td {
	border: 1px solid black;
}

tr:hover {
	background-color: #7BB661;
}

#note{
 color : red;
 font-weight: bold;
 
}
</style>
<title>Strategie | SpringMVC</title>
</head>
<body>
	<h1>SPRING MVC FRAMEWORK</h1>
	<p>Il existe 3 strategies d'héritage pour stocker le contenu d'un
		model object dans un model relationnel.</p>
		<p>Les Stratégies ont été réalisées en test avec la classe strategiesTest.</p>
		<p id="note">Important: Seule la strategie 2  cause des problèmes au niveau des tests.</p>
	<p>Les Strategies d'héritages présentées sont :</p>
	
	<ol>
		<li>Une seule Table :
			<h2>Dans cette strategie qui est par défaut,le modèle
				relationnel est fait d'une seule table pour toutes la hierachie de
				classes.</h2>
			<h2 id="annotation">Annotation :
				@Inheritance(strategy=InheritanceType.SINGLE_TABLE).</h2>
		</li>

		<li>Une Table par classe :
			<h2>Avec cette strategie de mapping, il y'a une seule table pour
				chaque classe concrète,chaque type de Personne(Homme,Femme) est
				tocker dans sa propre table.</h2>
			<h2>Par contre les classes abstraites comme Personne ne seront
				pas représentées.</h2>
			<h2 id="annotation">Annotation :
				@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS).</h2>
		</li>
		<li>Une Table et une jointure par classe:
			<h2>Ce model relationnel est plus proche du model objet,à chaque
				classe qu'elle soit concrète ou abstraite correspond une table.</h2>
			<h2>Autrement dit les informations concernant une instance de
				Personne sont reparties sur plusieurs tables,la seule colonne
				commune entre les tables est la colonne idPersonne.</h2>
			<h2 id="annotatiion">Annotation :
				@Inheritance(strategy=InheritanceType.JOINED).</h2>
		</li>
	</ol>
</body>
<h1>BILAN</h1>
<table align="center">
	<thead>
		<tr>
			<th>Caractéristiques</th>
			<th>Une Seule Table</th>
			<th>Une Table par Classe</th>
			<th>Une Table et une jointure par classe</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Colonnes Repétées</td>
			<td>Colonnes des classes Filles cumulées + discriminant.</td>
			<td>Colonnes des classes mères cumulées</td>
			<td></td>
		</tr>
		<tr>
			<td>Clés Etrangères</td>
			<td>Relation sur la classe mère uniquement</td>
			<td>Relation sur la classe fille uniquement</td>
			<td></td>
		</tr>
		<tr>
			<td>Unicité</td>
			<td></td>
			<td>Unicité à cheval sur plusieurs tables</td>
			<td></td>
		</tr>
		<tr>
			<td>Non Nulité</td>
			<td>Les colonnes d'une classes filles sont laissées nulles chez
				ses soeurs</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Ecriture(Insert,Update,Delete)</td>
			<td></td>
			<td></td>
			<td>Plusieurs écritures pour une même instance.</td>
		</tr>
		<tr>
			<td>Recherche sur classe mère</td>
			<td></td>
			<td>Une union sur plusieurs table</td>
			<td>Des jointures sur toutes les tables.</td>
		</tr>
		<tr>
			<td>Recherche classe fille</td>
			<td></td>
			<td></td>
			<td>Beaucoup de jointure</td>
		</tr>
	</tbody>
</table>

</html>