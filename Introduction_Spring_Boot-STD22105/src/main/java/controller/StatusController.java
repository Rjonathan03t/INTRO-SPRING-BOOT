package controller;
import org.springframework.web.bind.annotation.*;
import model.Status;
import Service.StatusService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StatusController {
    private StatusService service;

    public StatusController(StatusService service) {
        this.service = service;
    }
    @PostMapping("/insert")
    public Status insertStatus (@RequestBody Status status) throws SQLException {
        return service.insertStatus(status.getId(), status.getName());
    }
    @GetMapping({"/status"})
    public List<Status> getAllStatus() throws SQLException {
        return service.getAllStatus();
    }
    @GetMapping("/status/{id}/{name}")
    public Status getById(@PathVariable int id, @PathVariable String name) throws SQLException{
        return service.getById(id , name);
    }

}
