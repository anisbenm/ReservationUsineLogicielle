<%-- 
    Document   : _TAMPLATE
    Created on : 29 mai 2017, 14:29:22
    Author     : Administrateur
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
            <table border="2px">
                <thead>
                	<th>ID</th><th>Nom</th><th>Numéro</th><th>Rue</th><th>Adresse</th><th>Localité</th><th>Code Postal</th><th>Pays</th><th>Action</th>
                </thead>
                <c:forEach items="${hotels}" var="h">
                <tr> 
                	<td>${h.id}</td>
                	<td>${h.nom}</td>           	
                	<td>${h.adresse.num}</td>
                	<td>${h.adresse.rue}</td>
                	<td>${h.adresse.localite}</td>
                	<td>${h.adresse.codepostal}</td>
                	<td>${h.adresse.pays}</td>         	
                    <td>
                        <a href="<spring:url value='/hotel/supprimer/${h.id}'/>">supprimer</a>
                        <a href="<spring:url value='/hotel/modifier/${h.id}'/>">modifier</a>
                    </td>
                    </tr>
                
            </c:forEach>
        </table>
            <a href="<spring:url value='/hotel/ajouter/${r.id}'/>">ajouter</a>
    <c:import url="../_PIED.jsp"></c:import>
</body>
</html>
