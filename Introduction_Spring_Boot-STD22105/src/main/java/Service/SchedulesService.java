package Service;

import model.Schedules;
import org.springframework.stereotype.Service;
import repository.SchedulesDAO;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SchedulesService {
    private SchedulesDAO dao;

    public SchedulesService(SchedulesDAO dao) {
        this.dao = dao;
    }

    public List<Schedules> getAllSchedules() throws SQLException {
        return dao.getAll();
    }

    public Schedules insertSchedules(
            int id_schedules,
            LocalDateTime working_time,
            LocalDateTime break_time,
            int id_posts
    ) throws SQLException {
        return dao.insert(
                id_schedules,
                working_time,
                break_time,
                id_posts
        );
    }

    public Schedules getSchedulesById(int id_schedules) throws SQLException {
        Schedules schedules= dao.getById(id_schedules);
        if (schedules == null) {
            System.out.println("This ID is not saved in the database");
        }
        return schedules;
    }

    public Schedules updateSchedules(
            int id_schedules,
            LocalDateTime new_working_time,
            LocalDateTime new_break_time,
            int new_id_posts
    ) throws SQLException {
        return dao.update(
                id_schedules,
                new_working_time,
                new_break_time,
                new_id_posts
        );
    }

    public void deleteSchedules(int id_schedules) throws SQLException {
        dao.delete(id_schedules);
    }
}
