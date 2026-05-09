package tn.isett.etudiantservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EtudiantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantServiceApplication.class, args);
    }

}
