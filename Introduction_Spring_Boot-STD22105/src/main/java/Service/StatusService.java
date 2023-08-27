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

    public Status insertStatus(int id_status,String status_name) throws SQLException{
       return  dao.insert( id_status, status_name);
    }

    public Status getStatusById ( int id_status) throws  SQLException{
        Status status =  dao.getById(id_status);
        if ( status == null){
            System.out.println("Cette ID n'est pas enregistre dans la base");
        }
        return status;
    }

    public Status updateStatus ( int id_status , String new_status_name) throws SQLException {
         return dao.update(id_status, new_status_name);
    }

    public void deleteStatus (int id_status)throws SQLException{
         dao.delete(id_status);
    }
}
