package Service;

import org.springframework.stereotype.Service;
import model.Status;
import repository.StatusDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class StatusService {
    private StatusDAO dao;

    public StatusService(StatusDAO dao) {
        this.dao = dao;
    }

    public List<Status> getAllStatus() throws SQLException {
        return dao.getAll();
    }

    public Status insertStatus(int id,String name) throws SQLException{
       return  dao.insert( id, name);
    }

    public Status getById ( int id , String name) throws  SQLException{
        return dao.getById(id , name);
    }
}
