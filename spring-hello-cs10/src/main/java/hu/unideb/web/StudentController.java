package hu.unideb.web;

import hu.unideb.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StudentController {
    @GetMapping("/student")
    List<Student> findAll();

    @GetMapping("/student/{neptun}")
    Student findOne(@PathVariable String neptun);

    @PutMapping("/student")
    Student createOne(@RequestBody Student student);

    @PostMapping("/student")
    Student updateOne(@RequestBody Student updated);

    @DeleteMapping("/student/{neptun}")
    void deleteOne(@PathVariable String neptun);
}
