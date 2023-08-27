package DAOinterface;

import model.Status;

import java.sql.SQLException;
import java.util.List;

public interface StatusDAOInterface {
    Status insert (int id_status , String status_name) throws SQLException;
    List <Status> getAll() throws SQLException;
    Status getById(int id_status) throws SQLException;
    Status update(int id_status, String new_status_name) throws SQLException;
    void delete(int id_status) throws SQLException;
}
