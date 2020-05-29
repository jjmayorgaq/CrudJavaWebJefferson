<%--
  User: jmayo
  Date: 12/05/2020
  Time: 7:59 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <link  rel="stylesheet" href="assets/styles.css" >
  <body>
      
  <% if ( request.getParameter("register") != null && request.getParameter("register").equals("true")  ) { %>
    <div class="container mt-20 mb-20">
        <div class="alert alert-success" role="alert">
            Tu registro fue exitoso, por favor inicia sesion
        </div>
    </div>
  <% } %>
  
  <% if ( request.getParameter("register") != null && request.getParameter("register").equals("false")  ) { %>
    <div class="container mt-20 mb-20">
        <div class="alert alert-danger" role="alert">
            ups, hubo un error por favor intenta registrarte de nuevo
        </div>
    </div>
  <% } %>

  <div class="mt-20">
    <jsp:include page='views/Login.jsp'>
     <jsp:param name='products' value='products' />
   </jsp:include>   
  </div>

  <% if ( request.getParameter("error") != null && request.getParameter("error").equals("true")  ) { %>
    <div class="container mt-20">
        <div class="alert alert-danger" role="alert">
            Tu contraseña o email son invalidos
        </div>
    </div>
  <% } %>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>
