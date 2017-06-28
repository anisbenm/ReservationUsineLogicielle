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
    <spring:url value="/reservation/ajouter"/>
</c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ajout reservation</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
    <contenue>
    <form:form modelAttribute="rese" action="${pathAjout}">
            <label>Client</label>
            <form:select items="${clients}" itemValue="id" itemLabel="nom" path="client.id"/><br/>
            <label>Chambre</label>
            <form:checkboxes items="${chambres}" itemValue="id"  path="chambres"/><br/>
            <label>Date</label>
            <form:input  path="date"/><br/>
            <label>Prix : </label>
            <form:input path="prix"/><br/>
            <label>Etat réservation : </label>
            <form:select items="${etats}" path="etatReservation"/>  <br/>          
            <input type="Submit"/>
        </form:form>        
    </contenue>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>
