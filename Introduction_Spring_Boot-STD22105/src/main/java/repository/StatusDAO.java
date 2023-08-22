package repository;

import org.springframework.stereotype.Repository;
import model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StatusDAO implements StatusDAOInterface {
    private Connection connection;

    public StatusDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Status insert(int id_status, String status_name) throws SQLException {
        Status status = new Status(id_status , status_name);
        String sql = "INSERT INTO status values ("+id_status+",'"+status_name+"')";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("INSERT 01");
        return status;
    }

    @Override
    public List<Status> getAll() throws SQLException {
        List <Status> allStatus = new ArrayList<>();
        String sql = "SELECT * FROM status";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                convertToList(allStatus, result);
            }
        }
        return allStatus;
    }

    @Override
    public Status getById(int id_status) throws SQLException {
        String sql = "SELECT * FROM status where id_status ="+ id_status;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                return new Status(
                        result.getInt("id_status"),
                        result.getString("status_name")
                );
            }
        }
        return null;
    }

    @Override
    public Status update(int id_status, String status_newName) throws SQLException {
        Status uStatus = new Status (id_status , status_newName);
        String sql = "UPDATE status SET status_name = '"+ status_newName + "' WHERE id_status = "+id_status;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
           preparedStatement.executeUpdate();
        }
        System.out.println("UPDATE 01");
        return uStatus;
    }

    @Override
    public void delete(int id_status) throws SQLException{
        String sql = "DELETE FROM status WHERE id_status = "+id_status;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.executeUpdate();
        }
        System.out.println("DELETE 01");
    }

    private void convertToList(List<Status> allStatus, ResultSet result) throws SQLException {
        allStatus.add(new Status(
                result.getInt("id_status"),
                result.getString("status_name")
        ));
    }
}
