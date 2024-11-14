package hu.unideb.neptun.util;

import com.github.javafaker.Faker;
import hu.unideb.neptun.model.Program;
import hu.unideb.neptun.model.Student;
import lombok.NonNull;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NeptunUtils {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final Random RANDOM;
    private static final Faker FAKER;

    static {
        RANDOM = new Random();
        FAKER = new Faker();
    }

    public static String nextNeptun() {
        return IntStream.range(0, 6)
                .mapToObj(pos -> pos == 0
                        ? LETTERS.charAt(RANDOM.nextInt(26))
                        : (LETTERS + DIGITS).charAt(RANDOM.nextInt(36)))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static Program nextProgram() {
        final var programs = Arrays
                .stream(Program.values())
                .collect(Collectors.toList());
        Collections.shuffle(programs);
        return programs.getFirst();
    }

    public static Student nextStudent() {
        return nextStudent(nextNeptun(), nextProgram());
    }

    public static Student nextStudent(
            @NonNull final String neptun,
            @NonNull final Program program) {

        final var name = FAKER.name();
        return Student.builder()
                .neptun(neptun)
                .name(name.firstName() + " " + name.lastName())
                .program(program)
                .created(OffsetDateTime.now())
                .updated(OffsetDateTime.now())
                // .enrollments(Set.of()) TODO
                .build();
    }
}
