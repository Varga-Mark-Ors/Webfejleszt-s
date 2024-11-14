package hu.unideb.neptun.web.instructor;

/*
@RestController
@AllArgsConstructor
public class StudentControllerImpl implements StudentController {
    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentControllerImpl.class);

    // @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll() {
        LOGGER.info("findAll()");
        return repository.findAll();
    }

    @Override
    public Student findOne(@NonNull String neptun) {
        LOGGER.info("findOne({})", neptun);
        return repository.findById(neptun)
                .orElseThrow(() -> new IllegalArgumentException("Student does not exist"));
    }

    @Override
    public Student createOne(@NonNull Student student) {
        LOGGER.info("createOne({})", student);
        return repository.save(student
                .withCreated(OffsetDateTime.now())
                .withUpdated(OffsetDateTime.now())
                .withNeptun(NeptunUtils.nextNeptun()));
    }

    @Override
    public Student updateOne(@NonNull Student updated) {
        LOGGER.info("updateOne({})", updated);
        return repository.save(updated
                .withUpdated(OffsetDateTime.now()));
    }

    @Override
    public void deleteOne(@NonNull String neptun) {
        LOGGER.info("deleteOne({})", neptun);
        repository.deleteById(neptun);
    }

    @Override
    public List<Student> search(
            @NonNull final Optional<String> neptun,
            @NonNull final Optional<String> name,
            @NonNull final Optional<Program> program) {

        return repository.findAll()
                .stream()
                .filter(student -> neptun
                        .map(s -> student.getNeptun().contains(s))
                        .orElse(true))
                .filter(student -> name
                        .map(n -> student.getName().contains(n))
                        .orElse(true))
                .filter(student -> program
                        .map(p -> p == student.getProgram())
                        .orElse(true))
                .toList();
    }
}
 */
