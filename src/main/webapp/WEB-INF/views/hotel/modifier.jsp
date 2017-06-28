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
    <spring:url value="/hotel/modifier"/>

</c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
 		<form:form modelAttribute="hotel" action="${pathModif}">
 		
            <form:hidden path="id"/>
            <label>Nom hotel:</label>
            <form:input path="nom"/>
			<label>Numéro : </label>
            <form:input path="adresse.num"/>
            <label>Rue : </label>
            <form:input path="adresse.rue"/>
            <label>Localite : </label>
            <form:input path="adresse.localite"/>
            <label>Code postal : </label>
            <form:input path="adresse.codepostal"/>
            <label>Pays : </label>
            <form:input path="adresse.pays"/>
            <input type="Submit"/> 
        </form:form> 
    <c:import url="../_PIED.jsp"></c:import>
</body>
</html>
