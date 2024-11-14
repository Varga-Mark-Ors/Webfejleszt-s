package hu.unideb.neptun.web.instructor;

import hu.unideb.neptun.model.Program;
import hu.unideb.neptun.model.Student;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface StudentController {
    @GetMapping("/student")
    List<Student> findAll();

    @GetMapping("/student/{neptun}")
    Student findOne(
            @NonNull @PathVariable String neptun);

    @PostMapping("/student")
    Student createOne(
            @NonNull @RequestBody Student student);

    @PutMapping("/student")
    Student updateOne(
            @NonNull @RequestBody Student updated);

    @DeleteMapping("/student/{neptun}")
    void deleteOne(
            @NonNull @PathVariable String neptun);

    @GetMapping("/search")
    List<Student> search(
            @NonNull @RequestParam Optional<String> neptun,
            @NonNull @RequestParam Optional<String> name,
            @NonNull @RequestParam Optional<Program> program);
}
