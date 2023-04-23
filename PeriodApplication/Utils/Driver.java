package PeriodApplication.Utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Driver {
    public static void main(String[] args) {
        SpringApplication.run(Driver.class, args);
    }
}
