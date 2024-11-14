package hu.unideb.neptun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hu.unideb.neptun.model.Subject;

public interface SubjectRepository
    extends JpaRepository<Subject, String> {

}
