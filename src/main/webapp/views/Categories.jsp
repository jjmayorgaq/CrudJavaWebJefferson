<%--
  Created by IntelliJ IDEA.
  User: jmayo
  Date: 16/05/2020
  Time: 4:17 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <link rel="stylesheet" href="assets/styles.css" >
  <body>
      
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/CrudJavaWebJefferson/views/Main.jsp">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/CrudJavaWebJefferson/products?action=list">Productos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/CrudJavaWebJefferson/categories?action=list">Categorias</a>
                </li>
            </ul>
        </div>
    </nav>
      
    <% if ( request.getParameter("isCategoryEditSuccess") != null && request.getParameter("isCategoryEditSuccess").equals("true") ) { %>
       <div class="container mt-20 mb-20">
           <div class="alert alert-success" role="alert">
               Se edito correctamente
           </div>
       </div>
    <% } %>

    <% if ( request.getParameter("isCategorySuccess") != null && request.getParameter("isCategorySuccess").equals("true") ) { %>
        <div class="container mt-20 mb-20">
            <div class="alert alert-success" role="alert">
                Se guardo correctamente
            </div>
        </div>
    <% } %>

    <% if ( request.getParameter("isCategorySuccess") != null && request.getParameter("isCategorySuccess").equals("false") ) { %>
        <div class="container mt-20 mb-20">
            <div class="alert alert-danger" role="alert">
                ups, hubo un error por favor intenta de nuevo
            </div>
        </div>
    <% } %>

    <% if ( request.getParameter("isAdd") != null && request.getParameter("isAdd").equals("true") ) { %>

       <main class="card-form mt-20">
            <div class="cotainer">
                <div class="row justify-content-center">
                    <div class="col-md-8 mb-20">
                        <a href="/CrudJavaWebJefferson/categories?action=list&isAdd=false" class="btn btn-primary btn-block">
                            Listar Categorias
                        </a>
                    </div>
                    <div class="col-md-8">
                        <div class="card">
                        <% if ( request.getParameter("action") != null && request.getParameter("action").equals("addView") ) { %>

                       <div class="card-header">Guardar una categoria</div>

                        <% } else if ( request.getParameter("action") != null && request.getParameter("action").equals("editView") ) { %>

                        <div class="card-header">Editar categoria</div>

                        <% } %>
                            <div class="card-body">

                                <% if ( request.getParameter("action") != null && request.getParameter("action").equals("addView") ) { %>

                                    <form action="categories?action=addCategory" method="POST">

                                    <% } else { %>

                                    <form action="categories?action=editCategory&id=<c:out value="${category.idCategory}" />" method="POST">

                                    <% } %>
                                    <div class="form-group row">
                                        <label for="name" class="col-md-4 col-form-label text-md-right">Nombre</label>
                                        <div class="col-md-6">
                                            <input type="text" id="name" class="form-control" name="name" value="<c:out value="${category.name}" default=""/>" required autofocus>
                                        </div>
                                    </div>

                                    <div class="col-md-6 offset-md-4">
                                        <button type="submit" class="btn btn-primary btn-block">
                                            Guardar
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>                         

    <% } else { %>

      <main class="card-form mt-20">
            <div class="cotainer">
                <div class="row justify-content-center">
                    <div class="col-md-8 mb-20">
                        <a href="/CrudJavaWebJefferson/categories?action=addView&isAdd=true" class="btn btn-primary btn-block">
                            Agregar categoria
                        </a>
                    </div>
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header">Categorias</div>
                            <table class="table">
                                <thead class="thead-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">nombre</th>
                                    <td colspan=3>ACCIONES</td>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${categoriesList}" var="category">
                                    <tr>
                                        <th scope="row"><c:out value="${category.idCategory}"/></th>
                                        <th scope="row"><c:out value="${category.name}"/></th>
                                        <td><a href="/CrudJavaWebJefferson/categories?action=editView&isAdd=true&id=<c:out value="${category.idCategory}" />">Editar</a></td>                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </main>

    <% } %>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>

