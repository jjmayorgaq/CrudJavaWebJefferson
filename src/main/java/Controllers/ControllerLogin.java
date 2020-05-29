package Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Models.data.UsersDAO_JDBC;
import Models.domain.UsersDTO;
import java.sql.SQLException;

@WebServlet(name = "Login")
public class ControllerLogin extends HttpServlet {

  UsersDAO_JDBC usersDAO_JDBC = new UsersDAO_JDBC();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password =  request.getParameter("password");

        UsersDTO user = new UsersDTO(email, password);
        if (this.login(user)) {

            response.sendRedirect("views/Main.jsp");
        } else {

            response.sendRedirect("/PruebaYohan/?error=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean login(UsersDTO usersDTO) {

        boolean isSession = false;

        try {

           isSession = usersDAO_JDBC.login(usersDTO);
        }catch (SQLException e) {

            System.out.println("Fallo login " + e);
        }
        return isSession;
    }

}
