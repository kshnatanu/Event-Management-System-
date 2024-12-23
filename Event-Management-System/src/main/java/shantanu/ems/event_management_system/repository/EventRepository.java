package shantanu.ems.event_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shantanu.ems.event_management_system.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

}
