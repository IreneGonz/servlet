<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1-Anade nuevo equipo</title>
</head>
<body>
	<!-- <form action="welcomeEquipo.jsp" method="post">-->
	<!-- ESTE NO VA, usar el Jugador.jsp que es el que por alguna razon funciona bien -->
	<form action="welcome?eq=1" method="post">
		<span>Nombre Equipo:</span> <input type="text" name="nomEquipo"> <br/>
		<input type="submit">
	</form>
	<a href="index.jsp">Volver a index</a>
</body>
</html>