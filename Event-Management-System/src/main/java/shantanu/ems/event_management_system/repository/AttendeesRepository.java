package shantanu.ems.event_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shantanu.ems.event_management_system.entity.Attendees;

import java.util.List;

public interface AttendeesRepository extends JpaRepository<Attendees,Long> {

}
