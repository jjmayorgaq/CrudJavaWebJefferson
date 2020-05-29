package Models.data;

import Models.domain.CategoriesDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoriesDAO {

    public ArrayList<CategoriesDTO> select() throws SQLException;

    public boolean insert(CategoriesDTO categoriesDTO) throws SQLException;

    public boolean update(CategoriesDTO categoriesDTO) throws SQLException;
    
    public CategoriesDTO getById(int id) throws SQLException;
}
