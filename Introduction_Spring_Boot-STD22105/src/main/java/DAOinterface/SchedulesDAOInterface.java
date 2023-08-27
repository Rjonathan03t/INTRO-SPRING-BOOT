package DAOinterface;

import model.Schedules;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface SchedulesDAOInterface {
    Schedules insert(
            int id_schedules,
            LocalDateTime working_time,
            LocalDateTime break_time,
            int id_posts
    ) throws SQLException;


    List<Schedules> getAll() throws SQLException;

    Schedules getById(int id_Schedules) throws SQLException;

    Schedules update(
            int id_schedules,
            LocalDateTime new_working_time,
            LocalDateTime new_break_time,
            int new_id_posts
    ) throws SQLException;


    void delete(int id_Schedules) throws SQLException;
}
