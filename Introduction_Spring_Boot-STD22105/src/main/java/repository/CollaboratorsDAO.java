package repository;

import DAOinterface.CollaboratorsDAOInterface;
import org.springframework.stereotype.Repository;
import model.Collaborators;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CollaboratorsDAO implements CollaboratorsDAOInterface {
    private Connection connection;

    public CollaboratorsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Collaborators insert(
            int id_collaborators,
            String first_name,
            String last_name,
            String sex,
            String birth_date,
            String email,
            int posts
    ) throws SQLException {
        Collaborators collaborators = new Collaborators(
                id_collaborators,
                first_name,
                last_name,
                sex,
                birth_date,
                email,
                posts
        );
        String sql = "INSERT INTO collaborators values (" +
                id_collaborators +
                ",'" + first_name +
                "','" + last_name +
                "','" + sex +
                "','" + birth_date +
                "','" + email +
                "'," + posts +
                ")";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("INSERT 01");
        return collaborators;
    }

    @Override
    public List<Collaborators> getAll() throws SQLException {
        List<Collaborators> allCollab = new ArrayList<>();
        String sql = "SELECT * FROM collaborators";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                convertToList(allCollab, result);
            }
        }
        return allCollab;
    }

    @Override
    public Collaborators getById(int id_collaborators) throws SQLException {
        String sql = "SELECT * FROM collaborators where id_collaborators =" + id_collaborators;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return new Collaborators(
                        result.getInt("id_collaborators"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("sex"),
                        result.getString("birth_date"),
                        result.getString("email"),
                        result.getInt("id_posts")
                );
            }
        }
        return null;
    }

    @Override
    public Collaborators update(
            int id_collaborators,
            String new_first_name,
            String new_last_name,
            String new_sex,
            String new_birth_date,
            String new_email,
            int new_posts
    ) throws SQLException {
        Collaborators uCollab = new Collaborators(
                id_collaborators,
                new_first_name,
                new_last_name,
                new_sex,
                new_birth_date,
                new_email,
                new_posts
        );
        String sql = "UPDATE collaborators SET first_name =" +
                "'" + new_first_name +
                "' , last_name = '" + new_last_name +
                "' , sex = '" + new_sex +
                "' , birth_date = '" + new_birth_date +
                "' , email = '" + new_email +
                "' , id_posts = " + new_posts +
                " WHERE id_collaborators = " + id_collaborators;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("UPDATE 01");
        return uCollab;
    }

    @Override
    public void delete(int id_collaborators) throws SQLException {
        String sql = "DELETE FROM collaborators WHERE id_collaborators = " + id_collaborators;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("DELETE 01");
    }

    private void convertToList(List<Collaborators> allCollab, ResultSet result) throws SQLException {
        allCollab.add(new Collaborators(
                result.getInt("id_collaborators"),
                result.getString("first_name"),
                result.getString("last_name"),
                result.getString("sex"),
                result.getString("birth_date"),
                result.getString("email"),
                result.getInt("id_posts")
        ));
    }
}
