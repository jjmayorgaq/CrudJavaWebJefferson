package Models.data;

import Config.Connect;
import Models.domain.CategoriesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriesDAO_JDBC implements CategoriesDAO {

    private static  final String SQL_SELECT= "select idCategory, name from categories";
    private static final  String SQL_INSERT= "insert into categories(name) value(?)";
    private static final String SQL_UPDATE= "update categories set name=? where idCategory=?";
    private static  final String SQL_SELECT_BY_ID= "select * from categories where idCategory= ? ";

    public CategoriesDAO_JDBC() {
    }

    @Override
    public ArrayList<CategoriesDTO> select() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CategoriesDTO categoryDTO = null;

        ArrayList<CategoriesDTO> categoriesDTOArrayList = new ArrayList<CategoriesDTO>();

        try {
            
            connection = Connect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                categoryDTO = new CategoriesDTO();
                categoryDTO.setIdCategory(resultSet.getInt("idCategory"));
                categoryDTO.setName(resultSet.getString("name"));

                categoriesDTOArrayList.add(categoryDTO);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {

            preparedStatement.close();
            connection.close();
            resultSet.close();
        }

        return categoriesDTOArrayList;
    }

    @Override
    public boolean insert(CategoriesDTO categoriesDTO) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isCategorySuccess = false;
        int row = 0;

        try {

            connection = Connect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, categoriesDTO.getName());

            row = preparedStatement.executeUpdate();

            isCategorySuccess = row == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {

            preparedStatement.close();
            connection.close();
        }

        return isCategorySuccess;
    }

    @Override
    public boolean update(CategoriesDTO categoriesDTO) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isCategorySuccess = false;
        int row = 0;

        try {

            connection = Connect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, categoriesDTO.getName());
            preparedStatement.setInt(2, categoriesDTO.getIdCategory());
            row = preparedStatement.executeUpdate();

            isCategorySuccess = row == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {

            preparedStatement.close();
            connection.close();
        }

        return isCategorySuccess;
    }
    
    @Override
    public CategoriesDTO getById(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CategoriesDTO categoryDTO = null;

        connection = Connect.getConnection();

        preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
        preparedStatement.setInt(1, id);

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {

            categoryDTO = new CategoriesDTO();
            categoryDTO.setIdCategory(resultSet.getInt("idCategory"));
            categoryDTO.setName(resultSet.getString("name"));
        }

        preparedStatement.close();
        connection.close();
        resultSet.close();

        return categoryDTO;
    }
}
