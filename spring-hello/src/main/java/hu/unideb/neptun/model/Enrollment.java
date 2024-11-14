package hu.unideb.neptun.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Enrollment {
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    UUID id;
    @ManyToOne
    Student student;
    @ManyToOne
    Subject subject;
    OffsetDateTime created;
    OffsetDateTime updated;
    Integer grade;
}
