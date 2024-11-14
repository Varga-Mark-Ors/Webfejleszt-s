package hu.unideb.neptun.repository;

import org.springframework.data.repository.CrudRepository;
import hu.unideb.neptun.model.Student;

public interface StudentRepository
        extends CrudRepository<Student, String> {

}
