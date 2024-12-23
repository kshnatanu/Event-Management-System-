package shantanu.ems.event_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.ems.event_management_system.entity.Attendees;
import shantanu.ems.event_management_system.service.AttendeeService;

import java.util.List;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;

    @PostMapping("/attendees")
    public ResponseEntity<Attendees> addAttendee(@RequestBody Attendees attendees){
        return new ResponseEntity<>(attendeeService.addAttendee(attendees), HttpStatus.CREATED);
    }

    @GetMapping("/attendees")
    public List<Attendees>getAllAttendees(){
        return attendeeService.getAllAttendees();
    }
    @DeleteMapping("/attendees/{id}")
    public ResponseEntity<Void> deleteAttendee(@PathVariable Long id) {
        attendeeService.deleteAttendee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
