<%--
  Created by IntelliJ IDEA.
  User: jmayo
  Date: 16/05/2020
  Time: 4:17 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@page import="Models.domain.ProductsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Controllers.ControllerProduct" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title>JavaWebCrud/Productos</title>
  </head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <link  rel="stylesheet" href="assets/styles.css" >
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
    
    <% if ( request.getParameter("isProductDeleteSuccess") != null && request.getParameter("isProductDeleteSuccess").equals("true") ) { %>
        <div class="container mt-20 mb-20">
            <div class="alert alert-success" role="alert">
                Se Elimino correctamente
            </div>
        </div>
    <% } %>
      
    <% if ( request.getParameter("isProductEditSuccess") != null && request.getParameter("isProductEditSuccess").equals("true") ) { %>
       <div class="container mt-20 mb-20">
           <div class="alert alert-success" role="alert">
               Se edito correctamente
           </div>
       </div>
    <% } %>

    <% if ( request.getParameter("isProductSuccess") != null && request.getParameter("isProductSuccess").equals("true") ) { %>
        <div class="container mt-20 mb-20">
            <div class="alert alert-success" role="alert">
                Se guardo correctamente
            </div>
        </div>
    <% } %>

    <% if ( request.getParameter("isProductSuccess") != null && request.getParameter("isProductSuccess").equals("false") ) { %>
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
                    <a href="/CrudJavaWebJefferson/products?action=list&isAdd=false" class="btn btn-primary btn-block">
                        Listar Products
                    </a>
                </div>
                <div class="col-md-8">
                    <div class="card">
                        <% if ( request.getParameter("action") != null && request.getParameter("action").equals("addView") ) { %>

                       <div class="card-header">Guardar un producto</div>

                        <% } else if ( request.getParameter("action") != null && request.getParameter("action").equals("editView") ) { %>

                        <div class="card-header">Editar producto</div>

                        <% } %>
                            <div class="card-body">

                                <% if ( request.getParameter("action") != null && request.getParameter("action").equals("addView") ) { %>

                                    <form action="products?action=addProduct" method="POST">

                                    <% } else { %>

                                    <form action="products?action=editProduct&id=<c:out value="${product.idProduct}" />" method="POST">

                                    <% } %>

                                    <div class="form-group row">
                                        <label for="name" class="col-md-4 col-form-label text-md-right">Nombre</label>
                                        <div class="col-md-6">
                                            <input type="text" id="name" class="form-control" name="name" value="<c:out value="${product.name}" default=""/>" required autofocus>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="price" class="col-md-4 col-form-label text-md-right">Precio</label>
                                        <div class="col-md-6">
                                            <input type="number" id="price" class="form-control" name="price" value="<c:out value="${product.price}" default=""/>" required autofocus>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="stock" class="col-md-4 col-form-label text-md-right">Stock</label>
                                        <div class="col-md-6">
                                            <input type="number" id="stock" class="form-control" name="stock" value="<c:out value="${product.stock}" default=""/>" required autofocus>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="idCategory" class="col-md-4 col-form-label text-md-right">Categoria</label>
                                        <div class="col-md-6">
                                          
                                            <select id="idCategory" name="idCategory" class="form-control">
                                               <option selected>Seleccione...</option>
                                                <c:forEach items="${categories}" var="category">
                                                    <option 
                                                        selected="
                                                    <c:choose>
                                                        <c:when test="product.categories_idcategory = category.idCategory">
                                                            true
                                                        </c:when><c:otherwise>false</c:otherwise>
                                                    </c:choose>" value="<c:out value="${category.idCategory}" default=""/>"> <c:out value="${category.name}"/> </option>
                                                </c:forEach>
                                            </select>
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
                        <a href="/CrudJavaWebJefferson/products?action=addView&isAdd=true" class="btn btn-primary btn-block">
                            Agregar producto
                        </a>
                    </div>
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header">Productos</div>
                            <table class="table">
                                <thead class="thead-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">nombre</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Stock</th>
                                    <th scope="col">Categoria</th>
                                    <td colspan=3>ACCIONES</td>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${productsList}" var="product">
                                    <tr>
                                        <th scope="row"><c:out value="${product.idProduct}"/></th>
                                        <th scope="row"><c:out value="${product.name}"/></th>
                                        <th scope="row"><c:out value="${product.price}"/></th>
                                        <th scope="row"><c:out value="${product.stock}"/></th>
                                        <th scope="row"><c:out value="${product.categoryName}"/></th>
                                        <td><a href="/CrudJavaWebJefferson/products?action=editView&isAdd=true&id=<c:out value="${product.idProduct}" />">Editar</a></td>
                                        <td><a href="/CrudJavaWebJefferson/products?action=delete&id=<c:out value="${product.idProduct}" />">Eliminar</a></td>
                                    </tr>
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



