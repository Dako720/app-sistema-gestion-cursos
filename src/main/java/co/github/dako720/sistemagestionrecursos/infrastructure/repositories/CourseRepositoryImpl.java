package co.github.dako720.sistemagestionrecursos.infrastructure.repositories;

import co.github.dako720.sistemagestionrecursos.domain.models.Course;
import co.github.dako720.sistemagestionrecursos.domain.repositories.CourseRepository;
import co.github.dako720.sistemagestionrecursos.infrastructure.repositories.jpa.CourseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final CourseJpaRepository jpaRepository;

    public CourseRepositoryImpl(CourseJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Course save(Course course) {
        return jpaRepository.save(course);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Course update(Course course) {
        return jpaRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
