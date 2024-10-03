package hu.unideb.web;

import hu.unideb.model.Student;
import hu.unideb.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class StudentControllerImpl
        implements StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            StudentControllerImpl.class);

    //@Autowired
    private StudentRepository repository;

    public StudentControllerImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> findAll() {
        LOGGER.info("findAll()");
        return repository.findAll();
    }

    @Override
    public Student findOne(String neptun) {
        System.out.println("findOne()");
        return new Student(
                neptun,
                "Teszt Elek",
                Student.Program.CS_BSC,
                OffsetDateTime.now(),
                OffsetDateTime.now()
        );
    }

    @Override
    public Student createOne(Student student) {
        System.out.println("createOne()");
        return student;
    }

    @Override
    public Student updateOne(Student updated) {
        return null;
    }

    @Override
    public void deleteOne(String neptun) {

    }
}
