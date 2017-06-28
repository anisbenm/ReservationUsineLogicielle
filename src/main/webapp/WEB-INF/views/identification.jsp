<%-- 
    Document   : identification.jsp
    Created on : 31 mai 2017, 11:43:26
    Author     : Administrateur
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="_MENU.jsp"></c:import>
        <form:form modelAttribute="util">
            <label>Identifiant</label>
            <form:input path="login"/>
            <label>Mot de passe</label>
            <form:password path="mdpasse"/>
            <input type="submit"/>
        </form:form>
    <c:import url="_PIED.jsp"></c:import>
</body>
</body>
</html>
