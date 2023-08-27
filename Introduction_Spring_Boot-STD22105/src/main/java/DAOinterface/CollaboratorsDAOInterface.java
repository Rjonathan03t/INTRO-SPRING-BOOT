package DAOinterface;

import model.Collaborators;
import model.Status;

import java.sql.SQLException;
import java.util.List;

public interface CollaboratorsDAOInterface {
    Collaborators insert(
            int id_collaborators,
            String first_name,
            String last_name,
            String sex,
            String birth_date,
            String email,
            int posts
    ) throws SQLException;

    List <Collaborators> getAll() throws SQLException;
    Collaborators getById(int id_collaborators) throws SQLException;

    Collaborators update(
            int id_collaborators,
            String new_first_name,
            String new_last_name,
            String new_sex,
            String new_birth_date,
            String new_email,
            int new_posts
    ) throws SQLException;

    void delete(int id_collaborators) throws SQLException;
}
