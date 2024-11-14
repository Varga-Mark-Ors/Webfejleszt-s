package hu.unideb.neptun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import hu.unideb.neptun.model.Enrollment;

public interface EnrollmentRepository
    extends JpaRepository<Enrollment, UUID> {
}
