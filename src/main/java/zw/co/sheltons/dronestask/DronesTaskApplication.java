package zw.co.sheltons.dronestask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DronesTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DronesTaskApplication.class, args);
    }

}
