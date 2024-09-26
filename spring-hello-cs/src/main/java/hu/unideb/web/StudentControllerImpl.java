package hu.unideb.web;

import hu.unideb.model.Student;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class StudentControllerImpl implements StudentController{


    @Override
    public List<Student> findAll() {
        System.out.println("findAll");
        return null;
    }

    @Override
    public Student findOne(String neptun) {
        System.out.println("findOne");
        return new Student(
                neptun,
                "Tiszt Elek",
                Student.Program.CS_BSC,
                OffsetDateTime.now(),
                OffsetDateTime.now());
    }

    @Override
    public Student createOne(Student student) {
        System.out.println("createOne");
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

