<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualiza los datos</title>
</head>
<body>
<form action="/update?id=<%= request.getParameter("idEquipo") %>" method="post">  
        <span>ID:</span> <input type="text" value="<%= request.getParameter("idEquipo") %>" disabled="disabled" name="id"> <br />
        <span>Nombre:</span> <input type="text" value="<%= request.getParameter("nomEquipo") %>" name="name"> <br />
        <input type="submit">
    </form>
</body>
</html>