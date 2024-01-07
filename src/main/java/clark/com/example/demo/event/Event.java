package clark.com.example.demo.event;

import jakarta.persistence.*;


import java.time.LocalDate;
@Entity
@Table
public class Event {
    @Id
    @SequenceGenerator(
            name="event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )
    private long id;
    private String eventName;
    private String eventDescription;
    private LocalDate dateAdded;
    public Event() {
    }

    public Event(long id, String eventName, String eventDescription, LocalDate dateAdded) {
        this.id = id;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.dateAdded = dateAdded;
    }

    public Event(String eventName, String eventDescription, LocalDate dateAdded) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.dateAdded = dateAdded;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
