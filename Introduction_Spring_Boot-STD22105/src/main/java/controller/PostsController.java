package controller;
import Service.PostsService;
import model.Posts;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@RestController
public class PostsController {
    private PostsService service;

    public PostsController(PostsService service) {
        this.service = service;
    }

    @GetMapping("/post")
    public List<Posts> getAllPost() throws SQLException {
        return service.getAllPost();
    }
    @GetMapping("/post/{id_posts}")
    public Posts getPostById(@PathVariable int id_posts) throws SQLException{
        return service.getPostById(id_posts);
    }

    @PostMapping("/post")
    public Posts insertPost (@RequestBody Posts posts) throws SQLException {
        return service.insertPost(
                posts.getId_posts(),
                posts.getPosts_name(),
                posts.getDifficulty(),
                posts.getImportance(),
                posts.getDescription()
        );
    }

    @PutMapping("/post")
    public Posts updatePost (@RequestBody Posts posts) throws SQLException {
        return service.updatePost(
                posts.getId_posts(),
                posts.getPosts_name(),
                posts.getDifficulty(),
                posts.getImportance(),
                posts.getDescription()
        );
    }

    @DeleteMapping("/post")
    public void deletePost ( @RequestBody Posts posts)throws SQLException{
        service.deletePost(posts.getId_posts());
    }

}
