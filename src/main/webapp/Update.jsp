<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualiza los datos</title>
</head>
<body>
	<!--<form action="/update?id=<%= request.getParameter("id") %>" method="post">  
        <span>ID:</span> <input type="text" value="<%= request.getParameter("id") %>" disabled="disabled" name="id"> <br />
        <span>Nombre:</span> <input type="text" value="<%= request.getParameter("name") %>" name="name"> <br />
        <span>Apellido:</span> <input type="text" value="<%= request.getParameter("surname") %>" name="surname"> <br />
        <span>NumEquipo:</span> <input type="text" value="<%= request.getParameter("codEquipo") %>" name="codEquipo"> <br />
        <input type="submit">
    </form>-->
<% if(request.getParameter("id") != null){
	out.println("<form action='/update?id="+request.getParameter("id")+"' method='post'>");
	out.println("<span>ID:</span> <input type='text' disabled='disabled' name='id' value="+request.getParameter("id")+"> <br />");
	out.println("<span>Nombre:</span> <input type='text' name='name' value="+request.getParameter("name")+"> <br />");
	out.println("<span>Apellido:</span> <input type='text' name='surname' value="+request.getParameter("surname")+"> <br />");
	out.println("<span>NumEquipo:</span> <input type='text' name='codEquipo' value="+request.getParameter("codEquipo")+"> <br />");
	out.println("<input type='submit'>");
	out.println("</form>");
}else{
	out.println("<form action='/update?idEquipo="+request.getParameter("idEquipo")+"' method='post'>");
	out.println("<span>ID:</span> <input type='text' value='"+request.getParameter("idEquipo")+"' disabled='disabled name='idEquipo'> <br />");
	out.println("<span>Nombre:</span> <input type='text' value='"+request.getParameter("nomEquipo")+"' name='nomEquipo'> <br />");
	out.println("<input type='submit'>");
	out.println("</form>");
}%>
<a href="index.jsp">Volver a index</a>
</body>
</html>