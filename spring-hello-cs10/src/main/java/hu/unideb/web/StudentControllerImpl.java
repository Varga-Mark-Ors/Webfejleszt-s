package hu.unideb.web;

import hu.unideb.model.Student;
import hu.unideb.repository.StudentRepository;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StudentControllerImpl
        implements StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            StudentControllerImpl.class
    );

    // @Autowired
    private final StudentRepository repository;

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
        LOGGER.info("findOne({})", neptun);
        return repository.findOne(neptun)
                .orElseThrow(() -> new RuntimeException("No student found with name " + neptun));
    }

    @Override
    public Student createOne(Student student) {
        LOGGER.info("createOne({})", student);
        return repository.createOne(student);
    }

    @Override
    public Student updateOne(Student updated) {
        LOGGER.info("updateOne({})", updated);
        return repository.updateOne(updated);
    }

    @Override
    public void deleteOne(String neptun) {
        LOGGER.info("deleteOne({})", neptun);
        repository.deleteOne(neptun);
    }

    @Override
    public List<Student> search(Optional<String> neptun, Optional<String> name, Optional<Student.Program> program) {
        LOGGER.info("search({}, {}, {})",
                neptun, name ,program);

        return repository.findAll()
                .stream()
                .filter(student -> neptun.map(s -> student.getNeptun().contains(s))
                        .orElse(true))
                .filter(student -> name
                        .map(s -> student.getName().contains(s))
                        .orElse(true))
                .filter(student -> program
                        .map(p -> p == student.getProgram())
                        .orElse(true))
                .toList();
    }

    @Override
    public ResponseEntity<String> downloadStudents() {
        final var headers = new HttpHeaders();
        headers.set("Content-Type", "text/csv");
        headers.set("Content-Disposition", "attachment; filename=\"students.csv\"");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(
                        repository.findAll()
                                .stream()
                                .map(student -> student.getNeptun() +
                                        ";" + student.getName())
                                .collect(Collectors.joining("\n"))
                );
    }

    @Override
    public ResponseEntity<byte[]> getImage() {
        final var headers = new HttpHeaders();
        headers.set("Content-Type", "image/jpeg");
        headers.set("Content-Disposition", "attachment; filename=\"Bober.jpg\"");

        try {
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(IOUtils.toByteArray(
                            getClass().getResourceAsStream("Bober.jpg")
                    ));
        } catch (Exception ignored) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

}
