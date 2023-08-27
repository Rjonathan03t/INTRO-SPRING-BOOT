package DAOinterface;

import model.Posts;

import java.sql.SQLException;
import java.util.List;

public interface PostsDAOInterface {
    Posts insert(
            int id_posts,
            String posts_name,
            String difficulty,
            int importance,
            String description
    ) throws SQLException;


    List<Posts> getAll() throws SQLException;

    Posts getById(int id_posts) throws SQLException;

    Posts update(
            int id_posts,
            String new_posts_name,
            String new_difficulty,
            int new_importance,
            String new_description
    ) throws SQLException;


    void delete(int id_posts) throws SQLException;
}
