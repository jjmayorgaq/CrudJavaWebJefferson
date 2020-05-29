package Models.data;

import Config.Connect;
import Models.domain.ProductsDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class ProductsDAO_JDBC implements ProductsDAO {

    private static final String SQL_SELECT= "select p.idProduct, p.name, p.price, p.stock, p.categories_idcategory, c.name as categoryName from products "
            + "as p inner join categories as c on p.categories_idcategory = c.idCategory";
    private static final String SQL_INSERT= "insert into products(name, price, stock, categories_idcategory) value(?, ?, ?, ?)";
    private static final String SQL_UPDATE= "update products set name=?, price=?, stock=?, categories_idcategory=? where idProduct=?";
    private static final String SQL_DELETE= "delete from products where idProduct=?";
    private static final String SQL_SELECT_BY_ID= "select * from products where idProduct=? ";

    public ProductsDAO_JDBC() {
    }

    @Override
    public ArrayList<ProductsDTO> select() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ProductsDTO productDTO = null;

        ArrayList<ProductsDTO> productsDTOArrayList = new ArrayList<ProductsDTO>();

        try {

            connection = Connect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                productDTO = new ProductsDTO();
                productDTO.setIdProduct(resultSet.getInt("idProduct"));
                productDTO.setName(resultSet.getString("name"));
                productDTO.setPrice(resultSet.getString("price"));
                productDTO.setStock(resultSet.getString("stock"));
                productDTO.setIdCategory(resultSet.getString("categories_idcategory"));
                productDTO.setCategoryName(resultSet.getString("categoryName"));

                productsDTOArrayList.add(productDTO);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {

            connection.close();
            preparedStatement.close();
        }

        return productsDTOArrayList;
    }

    @Override
    public boolean insert(ProductsDTO productsDTO) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isProductSave = false;
        int row = 0;

        try {
            
            connection = Connect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            
            preparedStatement.setString(1, productsDTO.getName());
            preparedStatement.setString(2, productsDTO.getPrice());
            preparedStatement.setString(3, productsDTO.getStock());
            preparedStatement.setString(4, productsDTO.getIdCategory());
           
            row = preparedStatement.executeUpdate();

            isProductSave = row == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {

            preparedStatement.close();
            connection.close();
        }

        return isProductSave;
    }

    @Override
    public boolean update(ProductsDTO productsDTO) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isProductSave = false;
        int row = 0;

        try {
            
            connection = Connect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            
            preparedStatement.setString(1, productsDTO.getName());
            preparedStatement.setString(2, productsDTO.getPrice());
            preparedStatement.setString(3, productsDTO.getStock());
            preparedStatement.setString(4, productsDTO.getIdCategory());
            preparedStatement.setInt(5, productsDTO.getIdProduct());
           
            row = preparedStatement.executeUpdate();

            isProductSave = row == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {

            preparedStatement.close();
            connection.close();
        }

        return isProductSave;
    }

    @Override
    public boolean delete(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isDelete = false;
        int row = 0;

        try {

            connection = Connect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);

            row = preparedStatement.executeUpdate();

            isDelete = row == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {

             preparedStatement.close();
            connection.close();
        }

        return isDelete;
    }
    
    @Override
    public ProductsDTO getById(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ProductsDTO productDTO = null;

        connection = Connect.getConnection();

        preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
        preparedStatement.setInt(1, id);

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {

            productDTO = new ProductsDTO();
            productDTO.setIdProduct(resultSet.getInt("idProduct"));
            productDTO.setName(resultSet.getString("name"));
            productDTO.setPrice(resultSet.getString("price"));
            productDTO.setStock(resultSet.getString("stock"));
            productDTO.setIdCategory(resultSet.getString("categories_idcategory"));
        }

        preparedStatement.close();
        connection.close();
        resultSet.close();

        return productDTO;
    }
}
