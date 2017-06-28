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
    <contenu>
        
        <h1> La liste des reservations a Payée  </h1>
          <table border="1px">
              <thead><th>id</th>
              <th>date Reservation</th>
              <th> Date checkIn </th>
              <th> Date checkOut </th>
              <th> Prix </th>
              <th> Details </th>
          </thead>
                <c:forEach items="${reservationsAPayee}" var="rap">
                <tr> <td>${rap.id}</td>*
                     <td>${rap.date}</td>
                     <td>${rap.dateCheckIn}</td>
                     <td>${rap.dateCheckOut}</td>
                     <td>${rap.prix}</td>
                     <td>
                      <a href="<spring:url value='/reservationClient/details/${rap.id}'/>">Details</a>
                     </td>
            </c:forEach>
        </table>
        <h1> La liste des reservations Payées </h1>
          <table border="1px">
              <thead><th>id</th><th>date Reservation</th><th> Date checkIn </th><th> Date checkOut </th><th> Prix</th></thead>
                <c:forEach items="${reservationsPayee}" var="r">
                <tr> <td>${r.id}</td>*
                     <td>${r.date}</td>
                     <td>${r.dateCheckIn}</td>
                     <td>${r.dateCheckOut}</td>
                     <td>${r.prix}</td>
                
            </c:forEach>
        </table>
        
        <h1> La liste des reservations Annulées </h1>
          <table border="1px">
              <thead><th>id</th><th>date Reservation</th><th> Date checkIn </th><th> Date checkOut </th><th>Prix </th></thead>
                <c:forEach items="${reservationsAnnulee}" var="ra">
                <tr> <td>${ra.id}</td>*
                     <td>${ra.date}</td>
                     <td>${ra.dateCheckIn}</td>
                     <td>${ra.dateCheckOut}</td>
                     <td>${ra.prix}</td>
                
            </c:forEach>
        </table>
    </contenu>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>