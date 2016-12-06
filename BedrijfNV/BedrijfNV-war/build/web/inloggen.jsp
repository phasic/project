<%-- 
    Document   : inloggen
    Created on : 22-nov-2016, 12:25:10
    Author     : student
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <!--<link rel="stylesheet" type="text/css" href="bootstrap.min.css">-->
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inloggen</title>
    </head>
    <body>
  
        <div class="col-sm-4 col-sm-offset-4">
          
        <form method= "post" action="j_security_check" class="form-signin"> 
            <h3 class="form-signin-heading">Please enter your credentials</h3>
            
            
            
            <label for="input" class="sr-only">Employee number</label>
                <input type="text" id="input" class="form-control" placeholder="Employee number" name= "j_username" required autofocus>
                <br>
            <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name= "j_password" required>
                
<!--            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>-->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <input type="hidden" name="navigatieknop" value="naarStart"/>    
    </form>          
        </div>  
                
        
    </body>
</html>
