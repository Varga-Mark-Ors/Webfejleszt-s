package hu.unideb.neptun;

import hu.unideb.neptun.model.Program;
import hu.unideb.neptun.repository.StudentRepository;
import hu.unideb.neptun.util.NeptunUtils;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
@Order(1)
public class StudentRunner
        implements CommandLineRunner {

    StudentRepository repository;

    @Override
    public void run(String... args) {
        repository.save(NeptunUtils.nextStudent("NEPTUN", Program.CS_BSC));
        for (int i = 0; i < 100; i++) {
            repository.save(NeptunUtils.nextStudent());
        }
    }
}

