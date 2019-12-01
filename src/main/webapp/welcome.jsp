<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*,es.salesianos.repository.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
</head>
<body>

<% 
EquipoRepositorio er = new EquipoRepositorio();

if(request.getParameter("jug") != null){ //Si acabo de crear un jugador
	out.println("<b>Bienvenido "+request.getParameter("nombre")+"</b>");
	out.println("<b>"+request.getParameter("apellido")+"</b>");
	int id = Integer.parseInt(request.getParameter("codEquipo"));
	out.println("<b>tu equipo se llama "+er.findNombreById(id)+"</b>");
	out.println("<b>y es el numero "+request.getParameter("codEquipo")+"</b>");
}else{ //Si no he creado un jugador es porque he creado un equipo
	out.println("<b>Tu equipo se llama "+request.getParameter("nomEquipo")+"</b>");
	//out.println("<b>y es el numero "+request.getParameter("codEquipo")+"</b>");
}
%>
<a href="index.jsp">Volver a index</a>
</body>
</html>