package co.github.dako720.sistemagestionrecursos.infrastructure.repositories;

import co.github.dako720.sistemagestionrecursos.domain.models.Course;
import co.github.dako720.sistemagestionrecursos.domain.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryCourseRepository implements CourseRepository {

    private final Map<Long, Course> storage = new HashMap<>();
    private final AtomicLong idSequence = new AtomicLong(1);

    @Override
    public Course save(Course course) {
        Long id = idSequence.getAndIncrement();
        course.setId(id);
        storage.put(id, course);
        return course;
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Course update(Course course) {
        storage.put(course.getId(), course);
        return course;
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
