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
    public Status insert(Status toInsert) {
        return null;
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
    public Status getById(int id) {
        return null;
    }

    @Override
    public void update(int newId, String newName) {

    }

    @Override
    public void delete(int id) {

    }

    private void convertToList(List<Status> allStatus, ResultSet result) throws SQLException {
        allStatus.add(new Status(
                result.getInt("id_status"),
                result.getString("status_name")
        ));
    }
}
