package hu.unideb.repository;

import hu.unideb.model.Student;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.*;

@Repository
public class StudentRepositoryImpl  implements StudentRepository{

    private final Map<String, Student> students;

    public StudentRepositoryImpl() {
        students = new TreeMap<>();
    }

    @Override
    public List<Student> findAll() {
        return students.values()
                .stream()
                .toList();
    }

    @Override
    public Optional<Student> findOne(@NonNull String neptun) {
        return Optional.ofNullable(students.get(neptun));
    }

    @Override
    public Student createOne(@NonNull Student student) {

        if (students.containsKey(student.getNeptun())) {
            throw new IllegalArgumentException("Neptun already exists");
        }

        final OffsetDateTime now = OffsetDateTime.now();

        student.setCreated(now);
        student.setUpdated(now);
        students.put(student.getNeptun(), student);

        return student;
    }

    @Override
    public Student updateOne(@NonNull Student student) {

        Student original =
                findOne(student.getNeptun()).orElseThrow(() -> new IllegalArgumentException("Neptun does not exist"));

        original.setName(student.getName());
        original.setProgram(student.getProgram());
        original.setUpdated(student.getUpdated());

        return null;
    }

    @Override
    public void deleteOne(@NonNull String neptun) {

        findOne(neptun).orElseThrow(() -> new IllegalArgumentException("Neptun does not exist"));

        students.remove(neptun);

    }
}