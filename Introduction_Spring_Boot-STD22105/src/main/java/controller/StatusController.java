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

    @GetMapping("/get/status")
    public List<Status> getAllStatus() throws SQLException {
        return service.getAllStatus();
    }
    @GetMapping("/get/status/{id}")
    public Status getById(@PathVariable int id_status) throws SQLException{
        return service.getStatusById(id_status);
    }

    @PostMapping("/insert/status")
    public Status insertStatus (@RequestBody Status status) throws SQLException {
        return service.insertStatus(status.getId_status(), status.getStatus_name());
    }

    @PutMapping("/update/status/{id_status}")
    public Status updateStatus (@PathVariable int id_status , @RequestBody Status status) throws SQLException {
        return service.updateStatus(id_status, status.getStatus_name());
    }

    @DeleteMapping("/delete/status")
    public void deleteStatus ( @RequestBody Status status)throws SQLException{
        service.deleteStatus(status.getId_status());
    }

}
