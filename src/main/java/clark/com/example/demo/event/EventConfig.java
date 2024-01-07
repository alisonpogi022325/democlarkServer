package clark.com.example.demo.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static javax.xml.datatype.DatatypeConstants.JANUARY;

@Configuration
public class EventConfig {
    @Bean
    CommandLineRunner commandLineRunner(EventRepository repository){
        return args -> {
            Event event1 = new Event(
                    "Birthday",
                    "Birthday Description",
                    LocalDate.of(2000, JANUARY, 9)
            );
            Event event2 = new Event(
                    "Wedding",
                    "Wedding Description",
                    LocalDate.of(2000, JANUARY, 9)
            );
            repository.saveAll(List.of(event1,event2));
        };
    }
}
