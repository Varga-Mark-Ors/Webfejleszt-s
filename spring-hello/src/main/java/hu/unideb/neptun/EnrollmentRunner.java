package hu.unideb.neptun;

import hu.unideb.neptun.model.Enrollment;
import hu.unideb.neptun.model.Student;
import hu.unideb.neptun.repository.EnrollmentRepository;
import hu.unideb.neptun.repository.StudentRepository;
import hu.unideb.neptun.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class EnrollmentRunner
implements CommandLineRunner {

    StudentRepository studentRepository;
    SubjectRepository subjectRepository;
    EnrollmentRepository enrollmentRepository;

    @Transactional
    @Override
    @Order(2)
    public void run(String... args) throws Exception {
        final var student = studentRepository
                .findById("NEPTUN")
                .orElseThrow();

        Stream.of("INBPM0101-21", "INBPM0102-17", "INBPM0103-17")
                .map(code -> {
                    final var subject = subjectRepository
                            .findById(code)
                            .orElseThrow();

                    final var enrollment = Enrollment.builder()
                            .student(student)
                            .subject(subject)
                            .created(OffsetDateTime.now())
                            .updated(OffsetDateTime.now())
                            .grade(5)
                            .build();

                    return enrollmentRepository.save(enrollment);
                })
                .forEachOrdered(System.out::println);
    }
}
