package info.solidsoft.blog.boot.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionalEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalEventsApplication.class, args);
    }
}
