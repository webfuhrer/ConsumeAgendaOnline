<%-- 
    Document   : mostrardatos
    Created on : 11-dic-2018, 12:08:23
    Author     : Mañanas
--%>

<%@page import="paqueteconsumidor.PintaHTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paqueteconsumidor.Contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.
    Object o=request.getAttribute("lista");
    ArrayList<Contacto> lista=(ArrayList<Contacto>)o;
    String tabla=PintaHTML.pintarTabla(lista);
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=tabla%>
    </body>
</html>
