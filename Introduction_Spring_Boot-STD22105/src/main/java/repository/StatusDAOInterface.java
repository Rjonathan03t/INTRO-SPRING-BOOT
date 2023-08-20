package repository;

import model.Status;

import java.sql.SQLException;
import java.util.List;

public interface StatusDAOInterface {
    Status insert (Status toInsert);
    List <Status> getAll() throws SQLException;
    Status getById(int id);
    void update(int newId, String newName);
    void delete(int id);
}
