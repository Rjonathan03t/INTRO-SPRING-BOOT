package controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/status")
    public List<Status> getAllStatus() throws SQLException {
        return service.getAllStatus();
    }
}
