package Controllers;

import Models.data.UsersDAO_JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Models.domain.UsersDTO;
import java.sql.SQLException;

@WebServlet(name = "User")
public class ControllerUser extends HttpServlet {

    UsersDAO_JDBC usersDAO_JDBC = new UsersDAO_JDBC();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String name = request.getParameter("name");
         String lastName = request.getParameter("lastName");
         String phone = request.getParameter("phone");
         String postalCode = request.getParameter("postalCode");
         String address = request.getParameter("address");
         String email = request.getParameter("email");
         String password = request.getParameter("password");

        UsersDTO user = new UsersDTO(name, lastName, phone, postalCode, address, email, password);
        if (this.register(user)) {

            response.sendRedirect("/CrudJavaWebJefferson/?register=true");
        } else {

            response.sendRedirect("/CrudJavaWebJefferson/?register=false");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean register(UsersDTO usersDTO) {

        boolean isRegister = false;

        try {
            isRegister = usersDAO_JDBC.insert(usersDTO);
        }catch (SQLException e) {

            System.out.println("Fallo guardar datos " + e);
        }
        return isRegister;
    }
}
