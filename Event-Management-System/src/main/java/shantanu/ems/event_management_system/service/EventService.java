package shantanu.ems.event_management_system.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shantanu.ems.event_management_system.entity.Event;
import shantanu.ems.event_management_system.repository.EventRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {


    private  EventRepository eventRepository;

    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    @Transactional
    public List<Event> getAllEvents(){
        try {
            System.out.println("Fetching all events");
            return eventRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public Event updateEvent(Long id, Event event) {
        Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        existingEvent.setName(event.getName());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setDate(event.getDate());
        return eventRepository.save(existingEvent);
    }
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
