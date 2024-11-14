package hu.unideb.neptun;

import hu.unideb.neptun.model.Program;
import hu.unideb.neptun.model.Subject;
import hu.unideb.neptun.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@AllArgsConstructor
@Order(1)
public class SubjectRunner  implements CommandLineRunner {
    private final SubjectRepository repository;

    @Override
    public void run(String... args) throws Exception {
        try(final var br = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("subjects.tsv")))) {
            br.lines()
                    .map(line -> {
                        final var tokens = line.split("\t");
                        return Subject.builder().code(tokens[0])
                                .name(tokens[1])
                                .kredits(Integer.parseInt(tokens[2]))
                                .studentLimit(Integer.parseInt(tokens[3]))
                                .program(Program.valueOf(tokens[4]))
                                .build();
                    }).map(repository::save)
                            .forEach(System.out::println);
        }
    }
}
