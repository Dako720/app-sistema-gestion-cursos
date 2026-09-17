package co.github.dako720.sistemagestionrecursos.infrastructure.repositories.jpa;

import co.github.dako720.sistemagestionrecursos.domain.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<Course, Long> {
}
