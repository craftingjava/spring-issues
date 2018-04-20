package com.example.springdatarest111;

import java.util.Optional;
import java.util.stream.LongStream;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringDataRest111Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRest111Application.class, args);
    }

    @Bean
    CommandLineRunner init(RecordRepository recordRepository) {
        return args -> {
            LongStream.range(0, 10).mapToObj(Record::of).iterator()
                    .forEachRemaining(recordRepository::save);
        };
    }
}

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
class Record {

    @Id
    Long id;

}

@RepositoryRestResource(path = "records", collectionResourceRel = "records")
interface RecordRepository extends JpaRepository<Record, Long> {

}

@Slf4j
@RestController
class RecordController {

    private final RecordRepository recordRepository;

    public RecordController(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @GetMapping("/{version}/records/{id}")
    Optional<Record> getRecord(@PathVariable String version, @PathVariable Long id) {
        log.info("CONTROLLER");
        return recordRepository.findById(id);
    }

}
