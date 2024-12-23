package shantanu.ems.event_management_system.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shantanu.ems.event_management_system.entity.Task;
import shantanu.ems.event_management_system.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {


    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksForEvent(Long eventId) {
        try {
            System.out.println("Fetching tasks for eventId: " + eventId);
            if (eventId == null) {
                return taskRepository.findAll();  // Fetch all tasks
            } else {
                return taskRepository.findByEventId(eventId);  // Fetch tasks by eventId
            }
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();  // Return empty list if error occurs
        }

    }

    public Task updateTaskStatus(Long id, String status) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(status);
        return taskRepository.save(task);
    }
}
