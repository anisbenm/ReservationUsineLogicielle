<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="menu">
    <c:choose>

        <c:when test="${userType=='ADMIN'}">
            <a href="<spring:url value="/hotel/lister"/>">Gestion hotels</a>
            <a href="<spring:url value="/chambre/lister"/>">Gestion chambres</a>
            <a href="<spring:url value="/client/lister"/>">Gestion clients</a>
            <a href="<spring:url value="/reservation/lister"/>">Gestion réservations</a>
            <a href="<spring:url value="/recherche"/>">Recherche</a>
            <a href="<spring:url value="/deconnexion"/>">Déconnexion</a>
        </c:when>
        <c:when test="${userType=='CLIENT'}">
            <a href="<spring:url value="/hotel/lister"/>">Gestion hotels</a>
            <a href="<spring:url value="/chambre/lister"/>">Gestion chambres</a>
            <a href="<spring:url value="/recherche"/>">Recherche</a>
            <a href="<spring:url value="/deconnexion"/>">Déconnexion</a>
        </c:when>
        <c:otherwise>
            <a href="<spring:url value="/identification"/>">Identification</a>
            <a href="<spring:url value="/inscription"/>">Inscription</a>
            ${userType}
        </c:otherwise>        
    </c:choose>
</div>
