package co.github.dako720.sistemagestionrecursos.domain.repositories;

import co.github.dako720.sistemagestionrecursos.domain.models.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {

    Enrollment save(Enrollment enrollment);

    Optional<Enrollment> findById(Long id);

    List<Enrollment> findAll();

    List<Enrollment> findByCourseId(Long courseId);

    Enrollment update(Enrollment enrollment);

    void deleteById(Long id);

    boolean existsById(Long id);
}
