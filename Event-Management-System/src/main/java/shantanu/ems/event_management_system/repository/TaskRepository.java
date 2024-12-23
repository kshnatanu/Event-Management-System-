package shantanu.ems.event_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shantanu.ems.event_management_system.entity.Attendees;
import shantanu.ems.event_management_system.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByEventId(Long eventId);
}
