package co.github.dako720.sistemagestionrecursos.infrastructure.repositories.jpa;

import co.github.dako720.sistemagestionrecursos.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);
}
