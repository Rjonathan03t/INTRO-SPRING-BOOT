package repository;

import model.Status;

import java.sql.SQLException;
import java.util.List;

public interface StatusDAOInterface {
    Status insert (int id , String name) throws SQLException;
    List <Status> getAll() throws SQLException;
    Status getById(int id,String name) throws SQLException;
    void update(int newId, String newName) throws SQLException;
    void delete(int id) throws SQLException;
}
