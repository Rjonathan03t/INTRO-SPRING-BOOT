package Service;

import model.Posts;
import org.springframework.stereotype.Service;
import repository.CollaboratorsDAO;
import repository.PostsDAO;


import java.sql.SQLException;
import java.util.List;

@Service
public class PostsService {
    private PostsDAO dao;

    public PostsService(PostsDAO dao) {
        this.dao = dao;
    }

    public List<Posts> getAllPost() throws SQLException {
        return dao.getAll();
    }

    public Posts insertPost(
            int id_posts,
            String posts_name,
            String difficulty,
            int importance,
            String description
    ) throws SQLException {
        return dao.insert(
                id_posts,
                posts_name,
                difficulty,
                importance,
                description
        );
    }

    public Posts getPostById(int id_posts) throws SQLException {
        Posts post = dao.getById(id_posts);
        if (post == null) {
            System.out.println("This ID is not saved in the database");
        }
        return post;
    }

    public Posts updatePost(
            int id_posts,
            String new_posts_name,
            String new_difficulty,
            int new_importance,
            String new_description
    ) throws SQLException {
        return dao.update(
                id_posts,
                new_posts_name,
                new_difficulty,
                new_importance,
                new_description
        );
    }

    public void deletePost(int id_posts) throws SQLException {
        dao.delete(id_posts);
    }
}
