package repository;

import DAOinterface.SchedulesDAOInterface;
import model.Schedules;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SchedulesDAO implements SchedulesDAOInterface {
    private Connection connection;

    public SchedulesDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Schedules insert(
            int id_schedules,
            LocalDateTime working_time,
            LocalDateTime break_time,
            int id_posts
    ) throws SQLException {
        Schedules schedules = new Schedules(
                id_schedules,
                working_time,
                break_time,
                id_posts
        );
        String sql = "INSERT INTO schedules values (" +
                id_schedules +
                ",'" + working_time +
                "','" + break_time +
                "','" + id_posts +
                "')";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("INSERT 01");
        return schedules;
    }

    @Override
    public List<Schedules> getAll() throws SQLException {
        List<Schedules> allSchedules = new ArrayList<>();
        String sql = "SELECT * FROM schedules";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                convertToList(allSchedules, result);
            }
        }
        return allSchedules;
    }

    @Override
    public Schedules getById(int id_schedules) throws SQLException {
        String sql = "SELECT * FROM schedules where id_schedules=" + id_schedules;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return new Schedules(
                        result.getInt("id_schedules"),
                        result.getTimestamp("working_time").toLocalDateTime(),
                        result.getTimestamp("beak_time").toLocalDateTime(),
                        result.getInt("id_posts")
                );
            }
        }
        return null;
    }

    @Override
    public Schedules update(
            int id_schedules,
            LocalDateTime new_working_time,
            LocalDateTime new_break_time,
            int new_id_posts
    ) throws SQLException {
        Schedules uSchedules = new Schedules(
                id_schedules,
                new_working_time,
                new_break_time,
                new_id_posts
        );
        String sql = "UPDATE schedules SET working_time =" +
                "'" + new_working_time +
                "' , break_time = '" + new_break_time +
                "' , id_posts = '" + new_id_posts +
                "' WHERE id_schedules = " + id_schedules;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("UPDATE 01");
        return uSchedules;
    }

    @Override
    public void delete(int id_schedules) throws SQLException {
        String sql = "DELETE FROM schedules WHERE id_schedules = " + id_schedules;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("DELETE 01");
    }

    private void convertToList(List<Schedules> allSchedules, ResultSet result) throws SQLException {
        allSchedules.add(new Schedules(
                result.getInt("id_schedules"),
                result.getTimestamp("working_time").toLocalDateTime(),
                result.getTimestamp("break_time").toLocalDateTime(),
                result.getInt("id_posts")
        ));
    }
}
