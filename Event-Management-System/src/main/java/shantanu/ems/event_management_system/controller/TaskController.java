package shantanu.ems.event_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.ems.event_management_system.entity.Task;
import shantanu.ems.event_management_system.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/event/{eventId}")
    public List<Task> getTasksForEvent(@PathVariable Long eventId) {
        return taskService.getTasksForEvent(eventId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestParam String status) {
        return new ResponseEntity<>(taskService.updateTaskStatus(id, status), HttpStatus.OK);
    }
}
