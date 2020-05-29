package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Connect {

    private static final String url = "jdbc:mysql://localhost:3306/mydb?usesSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {

        try {

            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName); // here is the ClassNotFoundException
            return DriverManager.getConnection(url,user,password);
        }catch (Exception e) {

          return null;
        }

    }
}
