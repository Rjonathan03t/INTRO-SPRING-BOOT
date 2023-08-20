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
}
