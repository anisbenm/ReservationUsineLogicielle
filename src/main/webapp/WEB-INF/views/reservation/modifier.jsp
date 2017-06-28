<%-- 
    Document   : _TAMPLATE
    Created on : 29 mai 2017, 14:29:22
    Author     : Administrateur
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="pathModif">
    <spring:url value="/reservation/modifier"/>

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
    <form:form modelAttribute="reservation" action="${pathModif}">
        <form:hidden path="id"/>
            <label>Date</label>
            <form:input path="date"/>
            <label>Prix : </label>
            <form:input path="prix"/>
            <label>Etat réservation : </label>
            <form:input path="etatReservation"/>            
            <input type="Submit"/>
        </form:form>  
    </contenue>
    <c:import url="../_PIED.jsp"></c:import></contenue>
</body>
</html>
