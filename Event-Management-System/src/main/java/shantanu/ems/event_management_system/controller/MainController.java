package shantanu.ems.event_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shantanu.ems.event_management_system.entity.Attendees;
import shantanu.ems.event_management_system.entity.Event;
import shantanu.ems.event_management_system.entity.Task;
import shantanu.ems.event_management_system.service.AttendeeService;
import shantanu.ems.event_management_system.service.EventService;
import shantanu.ems.event_management_system.service.TaskService;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final EventService eventService;
    private final AttendeeService attendeeService;
    private final TaskService taskService;

    public MainController(EventService eventService, AttendeeService attendeeService, TaskService taskService) {
        this.eventService = eventService;
        this.attendeeService = attendeeService;
        this.taskService = taskService;
    }

    @GetMapping("events")
    public String eventsPage(Model model) {
        List<Event> events = eventService.getAllEvents();

        // Debugging output to check if events are empty
        if (events.isEmpty()) {
            System.out.println("No events found.");
        }

        model.addAttribute("page", "events");
        model.addAttribute("events", events);
        return "index"; // Ensure 'index.html' exists in the 'templates' folder
    }

    @GetMapping("attendees")
    public String attendeesPage(Model model) {
        List<Attendees> attendees = attendeeService.getAllAttendees();
        model.addAttribute("page", "attendees");
        model.addAttribute("attendees", attendees);
        return "index"; // Ensure 'index.html' exists in the 'templates' folder
    }

    @GetMapping("tasks")
    public String tasksPage(Model model) {
        Long eventId = null; // You can modify this logic to pass a valid eventId if needed
        List<Task> tasks = taskService.getTasksForEvent(eventId);

        // Check if tasks are empty and debug output
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        }

        model.addAttribute("page", "tasks");
        model.addAttribute("tasks", tasks);
        return "index"; // Ensure 'index.html' exists in the 'templates' folder
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Ensure 'login.html' exists in the 'templates' folder
    }
}
