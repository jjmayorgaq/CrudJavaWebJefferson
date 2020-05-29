<%--
  Created by IntelliJ IDEA.
  User: jmayo
  Date: 16/05/2020
  Time: 4:17 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Controllers.ControllerUser" language="java" %>

<% String action = request.getParameter("action") == null ? "login" : request.getParameter("action"); %>

<% if ( action != null && action.equals("login")) { %>
<main class="card-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Login</div>
                    <div class="card-body">
                        <form action="login" method="post">
                            <div class="form-group row">
                                <label for="email_address" class="col-md-4 col-form-label text-md-right">E-Mail Address</label>
                                <div class="col-md-6">
                                    <input type="text" id="email_address" class="form-control" name="email" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                                <div class="col-md-6">
                                    <input type="password" id="password" class="form-control" name="password" required>
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    Ingresar
                                </button>
                                <a href="?action=register" class="btn btn-link">
                                    Registrate
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<% } else { %>

<main class="card-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Registrate</div>
                    <div class="card-body">
                        <form action="register" method="POST">

                            <div class="form-group row">
                                <label for="name" class="col-md-4 col-form-label text-md-right">Nombre</label>
                                <div class="col-md-6">
                                    <input type="text" id="name" class="form-control" name="name" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="lastName" class="col-md-4 col-form-label text-md-right">Apellido</label>
                                <div class="col-md-6">
                                    <input type="text" id="lastName" class="form-control" name="lastName" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="phone" class="col-md-4 col-form-label text-md-right">Telefono</label>
                                <div class="col-md-6">
                                    <input type="text" id="phone" class="form-control" name="phone" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="postalCode" class="col-md-4 col-form-label text-md-right">Codigo postal</label>
                                <div class="col-md-6">
                                    <input type="text" id="postalCode" class="form-control" name="postalCode" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="address" class="col-md-4 col-form-label text-md-right">Direccion</label>
                                <div class="col-md-6">
                                    <input type="text" id="address" class="form-control" name="address" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="email" class="col-md-4 col-form-label text-md-right">E-Mail Address</label>
                                <div class="col-md-6">
                                    <input type="text" id="email" class="form-control" name="email" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                                <div class="col-md-6">
                                    <input type="password" id="password" class="form-control" name="password" required>
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary btn-block">
                                    Registrar
                                </button>
                            </div>

                            <div class="col-md-6 offset-md-4 mt-20">
                                <a href="?action=login" class="btn btn-primary btn-block">
                                   Login
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<% } %>