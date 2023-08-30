package controller;
import Service.CollaboratorsService;
import model.Collaborators;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@RestController
public class CollaboratorsController {
    private CollaboratorsService service;

    public CollaboratorsController(CollaboratorsService service) {
        this.service = service;
    }

    @GetMapping("/collab")
    public List<Collaborators> getAllCollab() throws SQLException {
        return service.getAllCollab();
    }
    @GetMapping("/collab/{id_collaborators}")
    public Collaborators getCollabById(@PathVariable int id_collaborators) throws SQLException{
        return service.getCollabById(id_collaborators);
    }
    @PostMapping("/collab")
    public Collaborators insertCollab (@RequestBody Collaborators collaborators) throws SQLException {
        return service.insertCollab(
                collaborators.getId_collaborators(),
                collaborators.getFirst_name(),
                collaborators.getLast_name(),
                collaborators.getSex(),
                collaborators.getBirth_date(),
                collaborators.getEmail(),
                collaborators.getPosts(),
                collaborators.getStatus()
        );
    }

    @PutMapping("/collab/{id_collaborators}")
    public Collaborators updateCollab (@PathVariable int id_collaborators ,@RequestBody Collaborators collaborators) throws SQLException {
        return service.updateCollab(
                id_collaborators,
                collaborators.getFirst_name(),
                collaborators.getLast_name(),
                collaborators.getSex(),
                collaborators.getBirth_date(),
                collaborators.getEmail(),
                collaborators.getPosts(),
                collaborators.getStatus()
        );
    }

    @DeleteMapping("/collab")
    public void deleteCollab ( @RequestBody Collaborators collaborators)throws SQLException{
        service.deleteCollab(collaborators.getId_collaborators());
    }

}
