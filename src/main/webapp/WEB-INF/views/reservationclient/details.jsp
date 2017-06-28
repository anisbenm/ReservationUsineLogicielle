<%-- 
    Document   : _TAMPLATE
    Created on : 29 mai 2017, 14:29:22
    Author     : Administrateur
--%>

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
        
        
       
        
       
                <c:forEach items="${reservation}" var="r">
                <tr> <td>${r.id}</td>
                     <td>${r.date}</td>
                     <td>${r.dateCheckIn}</td>
                     <td>${r.dateCheckOut}</td>
                     <td>${r.prix}</td>
                
            </c:forEach>
        </table>
    </contenu>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>
