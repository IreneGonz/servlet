<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*,es.salesianos.repository.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de jugadores</title>
</head>
<body>
<form method="post" action="/listado">
    <input type="submit" value="Verlistado">
</form>

<table>
<!-- TAGLIB -->
    <thead>
       <th>ID</th>
       <th>Nombre</th>
       <th>Apellido</th>
       <th>NumEquipo</th>
       <th>NomEquipo</th>
       <th>Eliminar</th>
       <th>Actualizar</th>
    </thead>

	<c:forEach items="${listOfJugadores}" var="jugador">
	    <tr>
	    	<td>${jugador.id}</td>
	        <td>${jugador.nombre}</td>
	        <td>${jugador.apellido}</td>
	        <td>${jugador.codEquipo}</td>
	        <td>${jugador.nomEquipo}</td>
	        <td><a href="/delete?id=${jugador.id}&name=${jugador.nombre}&surname=${jugador.apellido}&codEquipo=${jugador.codEquipo}">Eliminar</a></td>
	        <td><a href="/update?id=${jugador.id}&name=${jugador.nombre}&surname=${jugador.apellido}&codEquipo=${jugador.codEquipo}">Update</a></td>
	    </tr>
	</c:forEach>
</table>
<table>	
	<thead>
       <th>Numero equipo</th>
       <th>Nombre</th>
       <th>Eliminar</th>
       <th>Actualizar</th>
    </thead>
    
	<c:forEach items="${listOfEquipos}" var="equipo">
	    <tr>
	    	<td>${equipo.id}</td>
	        <td>${equipo.nombre}</td>
	        <td><a href="/delete?idEquipo=${equipo.id}&nomEquipo=${equipo.nombre}">Eliminar</a></td>
	        <td><a href="/update?idEquipo=${equipo.id}&nomEquipo=${equipo.nombre}">Update</a></td>
	    </tr>
	</c:forEach>
	    
</table>

<br/>
<br/>
<a href="index.jsp">Volver a index</a>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<table>
<%
//scriplet
/*	EquipoRepositorio er = new EquipoRepositorio();
 List<Jugador> jugadores = (List<Jugador>)request.getAttribute("listOfJugadores");
if(jugadores!= null && !jugadores.isEmpty()){
	for(Jugador jugador : jugadores){
	    out.println("<tr>");
	    out.println("<td>");
	    out.println(jugador.getNombre());
	    out.println("</td>");
	    out.println("<td>");
        out.println(jugador.getApellido());
        out.println("</td>");
        out.println("<td>");
        out.println(jugador.getCodEquipo());
        out.println("</td>");
        
        out.println("</td>");
        //out.println(er.findNombreById(3));
        
	    out.println("</tr>");
		
	}
}

List<Equipo> equipos = (List<Equipo>)request.getAttribute("listOfEquipos");
if(equipos!= null && !equipos.isEmpty()){
	for(Equipo equipo : equipos){
	    out.println("<tr>");
	    out.println("<td>");
	    out.println(equipo.getId());
	    out.println("</td>");
	    out.println("<td>");
       out.println(equipo.getNombre());
       out.println("</td>");
       out.println("</tr>");
		
	}
}*/
%>
</table>
</body>
</html>