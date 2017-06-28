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
        <contenue>
            <table border="2px">
                <thead><th>id</th><th>Date</th><th>Prix</th><th>Etat</th><th>action</th></thead>
                <c:forEach items="${reservations}" var="r">
                <tr>
                    <td>${r.id}</td>
                    <td>${r.date}</td>
                    <td>${r.prix}</td>
                    <td>${r.etatReservation}</td>
                    <td>
                        <a href="<spring:url value='/reservation/supprimer/${r.id}'/>">supprimer</a>
                        <a href="<spring:url value='/reservation/modifier/${r.id}'/>">modifier</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
            <a href="<spring:url value='/reservation/ajouter/${r.id}'/>">ajouter</a>
    </contenue>

    <c:import url="../_PIED.jsp"></c:import>
</body>
</html>
