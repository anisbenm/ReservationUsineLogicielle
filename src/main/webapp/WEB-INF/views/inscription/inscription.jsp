<%-- 
    Document   : _TAMPLATE
    Created on : 29 mai 2017, 14:29:22
    Author     : Administrateur
--%>


<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="pathInscription">
    <spring:url value="/inscription"/>
</c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
    <contenue>
         <form:form modelAttribute="utilisateur" action="${pathInscription}">
            
            <label> Login:</label>
            <form:input path="login"/>
            <label>Mot de passe : </label>
            <form:input path="mdpasse" type="password"/>
            <label>Email : </label>
            <form:input path="email"/>            
            <input type="Submit"/>
        </form:form>        
    </contenue>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>