package repository;

import DAOinterface.PostsDAOInterface;
import org.springframework.stereotype.Repository;
import model.Posts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostsDAO implements PostsDAOInterface {
    private Connection connection;

    public PostsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Posts insert(
            int id_posts,
            String posts_name,
            String difficulty,
            int importance,
            String description
    ) throws SQLException {
        Posts post = new Posts(
                id_posts,
                posts_name,
                difficulty,
                importance,
                description
        );
        String sql = "INSERT INTO posts values (" +
                id_posts +
                ",'" + posts_name +
                "','" + difficulty +
                "','" + importance +
                "','" + description +
                "')";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("INSERT 01");
        return post;
    }

    @Override
    public List<Posts> getAll() throws SQLException {
        List<Posts> allPost = new ArrayList<>();
        String sql = "SELECT * FROM posts";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                convertToList(allPost, result);
            }
        }
        return allPost;
    }

    @Override
    public Posts getById(int id_posts) throws SQLException {
        String sql = "SELECT * FROM posts where id_posts=" + id_posts;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return new Posts(
                        result.getInt("id_posts"),
                        result.getString("posts_name"),
                        result.getString("difficulty"),
                        result.getInt("importance"),
                        result.getString("description")
                );
            }
        }
        return null;
    }

    @Override
    public Posts update(
            int id_posts,
            String new_posts_name,
            String new_difficulty,
            int new_importance,
            String new_description
    ) throws SQLException {
        Posts uPost = new Posts(
                id_posts,
                new_posts_name,
                new_difficulty,
                new_importance,
                new_description
        );
        String sql = "UPDATE posts SET posts_name =" +
                "'" + new_posts_name +
                "' , difficulty = '" + new_difficulty +
                "' , importance = '" + new_importance +
                "' , description = '" + new_description +
                "' WHERE id_posts = " + id_posts;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("UPDATE 01");
        return uPost;
    }

    @Override
    public void delete(int id_posts) throws SQLException {
        String sql = "DELETE FROM posts WHERE id_posts = " + id_posts;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        System.out.println("DELETE 01");
    }

    private void convertToList(List<Posts> allPost, ResultSet result) throws SQLException {
        allPost.add(new Posts(
                result.getInt("id_posts"),
                result.getString("posts_name"),
                result.getString("difficulty"),
                result.getInt("importance"),
                result.getString("description")
        ));
    }
}
