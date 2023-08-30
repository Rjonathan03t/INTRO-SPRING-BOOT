package controller;
import Service.SchedulesService;
import model.Schedules;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@RestController
public class SchedulesController {
    private SchedulesService service;

    public SchedulesController(SchedulesService service) {
        this.service = service;
    }

    @GetMapping("/schedule")
    public List<Schedules> getAllSchedules() throws SQLException {
        return service.getAllSchedules();
    }

    @GetMapping("/schedule/{id_schedules}")
    public Schedules getSchedulesById(@PathVariable int id_schedules) throws SQLException {
        return service.getSchedulesById(id_schedules);
    }

    @PostMapping("/schedule")
    public Schedules insertSchedules(@RequestBody Schedules schedules) throws SQLException {
        return service.insertSchedules(
                schedules.getId_Schedules(),
                schedules.getWorking_time(),
                schedules.getBreak_time(),
                schedules.getId_posts()
        );
    }

    @PutMapping("/schedule/{id_schedules}")
    public Schedules updateSchedules(@PathVariable int id_schedules,@RequestBody Schedules schedules) throws SQLException {
        return service.updateSchedules(
                id_schedules,
                schedules.getWorking_time(),
                schedules.getBreak_time(),
                schedules.getId_posts()
        );
    }

    @DeleteMapping("/schedule")
    public void deleteSchedules(@RequestBody Schedules schedules) throws SQLException {
        service.deleteSchedules(schedules.getId_Schedules());
    }

}
