package co.github.dako720.sistemagestionrecursos.domain.repositories;

import co.github.dako720.sistemagestionrecursos.domain.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    Course save(Course course);

    Optional<Course> findById(Long id);

    List<Course> findAll();

    Course update(Course course);

    void deleteById(Long id);

    boolean existsById(Long id);
}
