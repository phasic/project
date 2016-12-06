<%-- 
    Document   : start
    Created on : 22-nov-2016, 12:25:28
    Author     : student
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="controllers.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<link rel="stylesheet" type="text/css" href="bootstrap.min.css">-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start</title>
    </head>
    <body>
        <h1>Overview of all expenses</h1>
        
         <c:forEach var="loc" items="${requestScope.locatie}">
             
        </c:forEach>
        <c:forEach var="onkost" items="{requestScope.onkosten}">
            <div class="table table-striped row">
                
<!--                <div class="col-sm-1">
                    ${onkost.onkostnr}
                </div>
                <div class="col-sm-1">
                    ${onkost.omschrijving}
                </div>
                <div class="col-sm-1">
                    ${onkost.datum}
                </div>
                <div class="col-sm-1">
                    ${onkost.bedrag}
                </div>
                <div class="col-sm-1">
                    ${onkost.status}
                </div>
                <div class="col-sm-1">
                    ${onkost.usernr}
                </div>
                <div class="col-sm-1">
                    ${onkost.kredietnr}
                </div>-->
            </div>           
            <div class="col-sm-1">
                <form method="POST" action="Controller">
                    <button type="submit" class=" glyphicon glyphicon-search btn btn-sm btn-success"></button>
                    <input type="hidden" name="navigatieknop" value="naarAanpassenOnkost"/>    
                </form> 
            </div>
                <div class="col-sm-1">
                    <form method="POST" action="Controller">
                        <button type="submit" class="glyphicon glyphicon-remove btn btn-sm btn-danger"></button>
                        <input type="hidden" name="navigatieknop" value="naarVerwijdereOnkost"/> 
                    </form> 
                </div>
        </c:forEach>         

        
     
        
        <%--<c:forEach var="krediet" items="${requestScope.kredieten}">--%>
        <!--<ul>-->
              <!--${krediet.saldo}-->
        <!--</ul>-->
        <%--</c:forEach>--%>
       
        
        
        
            <div class='well'>
        TODO:
        tabel met alle onkosten van persoonlijke onkosten.<br>
        Met optie om te verwijderen bij de 'in maak' zijn.<br> 
            
        Als je op een een onkost klikt --> naar detail<br>
        Voorwaarde: onkost is al doorgestuurd (niet meer 'in maak')<br>
            
        Als in maak: naar aanpassen onkost.<br>
            
        Als nieuwe aanmaken: ook naar aanpassen onkost (leeg).<br>
            </div>
    </body>
</html>

      <jsp:include page="footer.jsp" />

