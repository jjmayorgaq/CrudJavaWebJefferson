package Models.data;

import Config.Connect;
import Models.domain.UsersDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO_JDBC implements UsersDAO {

    private static final  String SQL_LOGIN= "select count(*) from user where email=? and password=?";
    private static final  String SQL_INSERT= "insert into user(name, lastName, phone, " +
            "postalCode, address, email, password) value(?, ?, ?, ?, ?, ?, ?)";

    public UsersDAO_JDBC() {
    }

    @Override
    public boolean login(UsersDTO usersDTO) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isSession = false;

        try {

            connection = Connect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_LOGIN);
            
            preparedStatement.setString(1, usersDTO.getEmail());
            preparedStatement.setString(2, usersDTO.getPassword());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                isSession = true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {

            preparedStatement.close();
            connection.close();
        }

        return isSession;
    }

    @Override
    public boolean insert(UsersDTO usersDTO) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isRegister = false;
        int row = 0;

        try {

            connection = Connect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            
            preparedStatement.setString(1, usersDTO.getName());
            preparedStatement.setString(2, usersDTO.getLastName());
            preparedStatement.setString(3, usersDTO.getPhone());
            preparedStatement.setString(4, usersDTO.getPostalCode());
            preparedStatement.setString(5, usersDTO.getAddress());
            preparedStatement.setString(6, usersDTO.getEmail());
            preparedStatement.setString(7, usersDTO.getPassword());

            row = preparedStatement.executeUpdate();

            isRegister = row == 1;

        } catch (SQLException e) {
            
            System.out.print(e);
        }
        finally {

            preparedStatement.close();
            connection.close();
        }

        return isRegister;
    }
}
