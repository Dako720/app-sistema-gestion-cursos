package co.github.dako720.sistemagestionrecursos.infrastructure.repositories;

import co.github.dako720.sistemagestionrecursos.domain.models.Student;
import co.github.dako720.sistemagestionrecursos.domain.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryStudentRepository implements StudentRepository {

    private final Map<Long, Student> storage = new HashMap<>();
    private final AtomicLong idSequence = new AtomicLong(1);

    @Override
    public Student save(Student student) {
        Long id = idSequence.getAndIncrement();
        student.setId(id);
        storage.put(id, student);
        return student;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Student update(Student student) {
        storage.put(student.getId(), student);
        return student;
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }
}
