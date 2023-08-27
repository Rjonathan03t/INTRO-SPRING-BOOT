package Service;

import org.springframework.stereotype.Service;
import model.Collaborators;
import repository.CollaboratorsDAO;


import java.sql.SQLException;
import java.util.List;

@Service
public class CollaboratorsService {
    private CollaboratorsDAO dao;

    public CollaboratorsService(CollaboratorsDAO dao) {
        this.dao = dao;
    }

    public List<Collaborators> getAllCollab() throws SQLException {
        return dao.getAll();
    }

    public Collaborators insertCollab(
            int id_collaborators,
            String first_name,
            String last_name,
            String sex,
            String birth_date,
            String email,
            int posts
    ) throws SQLException{
        return  dao.insert(
                id_collaborators,
                first_name,
                last_name,
                sex,
                birth_date,
                email,
                posts
        );
    }

    public Collaborators getCollabById ( int id_collaborators) throws  SQLException{
        Collaborators collab =  dao.getById(id_collaborators);
        if ( collab == null){
            System.out.println("Cette ID n'est pas enregistre dans la base");
        }
        return collab;
    }

    public Collaborators updateCollab (
            int id_collaborators,
            String new_first_name,
            String new_last_name,
            String new_sex,
            String new_birth_date,
            String new_email,
            int new_posts
    ) throws SQLException {
        return dao.update(
                id_collaborators,
                new_first_name,
                new_last_name,
                new_sex,
                new_birth_date,
                new_email,
                new_posts
        );
    }

    public void deleteCollab (int id_collaborators)throws SQLException{
        dao.delete(id_collaborators);
    }
}
