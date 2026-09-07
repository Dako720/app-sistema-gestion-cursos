package co.github.dako720.sistemagestionrecursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan("co.github.dako720.sistemagestionrecursos.domain.models")
public class SgcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgcApplication.class, args);
    }
}

