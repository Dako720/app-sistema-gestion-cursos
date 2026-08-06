package co.github.dako720.sistemagestionrecursos.infrastructure.repositories;

import co.github.dako720.sistemagestionrecursos.domain.models.Enrollment;
import co.github.dako720.sistemagestionrecursos.domain.repositories.EnrollmentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryEnrollmentRepository implements EnrollmentRepository {

    private final Map<Long, Enrollment> storage = new HashMap<>();
    private final AtomicLong idSequence = new AtomicLong(1);

    @Override
    public Enrollment save(Enrollment enrollment) {
        Long id = idSequence.getAndIncrement();
        enrollment.setId(id);
        storage.put(id, enrollment);
        return enrollment;
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public List<Enrollment> findByCourseId(Long courseId) {
        return storage.values().stream()
                .filter(e -> e.getCourseId().equals(courseId))
                .collect(Collectors.toList());
    }

    @Override
    public Enrollment update(Enrollment enrollment) {
        storage.put(enrollment.getId(), enrollment);
        return enrollment;
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
