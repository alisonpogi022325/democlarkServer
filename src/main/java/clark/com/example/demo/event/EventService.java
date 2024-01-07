package clark.com.example.demo.event;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    public void addNewEvent(Event event) {
        Optional<Event> eventOptional=eventRepository.findById(event.getId());
        if(eventOptional.isPresent()){
            throw new IllegalStateException("id taken");
        }
        eventRepository.save(event);
//        System.out.println(event);
    }

    public void deleteEvent(Long id) {
        boolean exist= eventRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException(id + " does not exist!");
        }
        eventRepository.deleteById(id);
    }

@Transactional
    public void updateEvent(Long id, String eventName, String eventDescription) {
    Event event=eventRepository.findById(id).orElseThrow(()-> new IllegalStateException(id + " does not exist"));
    if(eventName !=null && !eventName.isEmpty() && !Objects.equals(event.getEventName(),eventName)){
        event.setEventName(eventName);
    };

    if(eventDescription !=null && !eventDescription.isEmpty() && !Objects.equals(event.getEventDescription(),eventDescription)){
        event.setEventDescription(eventDescription);
    };


    }
}
