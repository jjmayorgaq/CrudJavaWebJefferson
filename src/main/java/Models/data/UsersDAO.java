package Models.data;

import Models.domain.UsersDTO;
import java.sql.SQLException;

public interface UsersDAO {

    public boolean insert(UsersDTO usersDTO) throws SQLException;

    public boolean login(UsersDTO usersDTO) throws SQLException;
}
