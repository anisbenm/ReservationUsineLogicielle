<%-- 
    Document   : _TAMPLATE
    Created on : 29 mai 2017, 14:29:22
    Author     : Administrateur
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="pathAjout">
    <spring:url value="/client/ajouter"/>
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
    <form:form modelAttribute="client" action="${pathAjout}">
            
            <label>Nom  : </label>
            <form:input path="nom"/>
            <label>prenom : </label>
            <form:input path="prenom"/>
            <label>reservations : </label>
            <%--<form:select items="${reservation}" itemValue="id" itemLabel="nom" path="reservation.id"></form:select>--%>
            <input type="Submit"/>
        </form:form>        
    </contenue>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>
