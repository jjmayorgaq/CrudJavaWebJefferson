package Models.data;

import Models.domain.ProductsDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductsDAO {

    public ArrayList<ProductsDTO> select() throws SQLException;

    public boolean insert(ProductsDTO productsDTO) throws SQLException;

    public boolean update(ProductsDTO productsDTO) throws SQLException;

    public boolean delete(int id) throws SQLException;
    
    public ProductsDTO getById(int id) throws SQLException;
}
