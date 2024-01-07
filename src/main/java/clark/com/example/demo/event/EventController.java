package clark.com.example.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/event")
public class EventController {
    private final EventService eventService;
@Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping
    public List<Event> getEvents(){
        return eventService.getEvents();
    }
@PostMapping
    public void addNewEvent(@RequestBody Event event){
        eventService.addNewEvent(event);
    }
@DeleteMapping(path = "{id}")
    public void deleteEvent(@PathVariable("id") Long id){
        eventService.deleteEvent(id);
    }
    @PutMapping(path = "{id}")
    public void updateEvent(@PathVariable("id") Long id,
                            @RequestParam(required = false)String eventName,
                            @RequestParam(required = false)String eventDescription){
    eventService.updateEvent(id,eventName,eventDescription);

    }
}
