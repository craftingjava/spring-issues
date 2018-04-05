package com.example.springdatajpa1317;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;

@Data
@Entity
//@EntityListeners(AuditingEntityListener.class)
public class Record implements Persistable<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private LocalDateTime dateCreated;

    @Override
    public boolean isNew() {
        return id == null;
    }

}
