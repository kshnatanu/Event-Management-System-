package shantanu.ems.event_management_system.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.ems.event_management_system.entity.Attendees;
import shantanu.ems.event_management_system.repository.AttendeesRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class AttendeeService {

    @Autowired
    private AttendeesRepository attendeesRepository;

    public Attendees addAttendee(Attendees attendee) {
        return attendeesRepository.save(attendee);
    }

    public List<Attendees> getAllAttendees() {
        return attendeesRepository.findAll();
    }

    public void deleteAttendee(Long id) {
        attendeesRepository.deleteById(id);
    }
}
