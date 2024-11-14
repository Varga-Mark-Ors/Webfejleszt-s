package hu.unideb.neptun.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "SUBJECT")
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subject {
    @EqualsAndHashCode.Include
    @Id
    String code;
    String name;
    int kredits;
    int studentLimit;
    @Enumerated(EnumType.STRING)
    Program program;
}
