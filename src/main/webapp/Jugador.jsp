<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*,es.salesianos.repository.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2-Anade nuevo jugador</title>
</head>
<body>
	<form action="welcome?jug=1" method="post">
		<!--<span>Nombre Equipo:</span> <input type="text" name="nomEquipo"> <br/>-->
		<span>Nombre:</span> <input type="text" name="nombre"> <br />
		<span>Apellido:</span> <input type="text" name="apellido"> <br />
		<!--<span>Num Equipo:</span> <input type="text" name="codEquipo"> <br/>-->
		<span>Num Equipo:</span>
		<select name="codEquipo">
		<% EquipoRepositorio r = new EquipoRepositorio();
		List<Equipo> equipos = r.listAll();
		if(equipos!= null && !equipos.isEmpty()){
			for(Equipo equipo : equipos){
			    out.println("<option>");
			    out.println(equipo.getId());
			}
		} %>
		</select>
		<input type="submit">
	</form>
	<a href="index.jsp">Volver a index</a>
</body>
</html>