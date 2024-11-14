package hu.unideb.neptun.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.time.OffsetDateTime;

@Entity(name = "STUDENT")
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student implements Comparable<Student> {
    @EqualsAndHashCode.Include
    @Id
    String neptun;
    String name;
    @Enumerated(EnumType.STRING)
    Program program;

    OffsetDateTime created;
    OffsetDateTime updated;

    @Override
    public int compareTo(Student o) {
        return this.neptun.compareTo(o.getNeptun());
    }
}
