package co.github.dako720.sistemagestionrecursos.infrastructure.repositories;

import co.github.dako720.sistemagestionrecursos.domain.models.Student;
import co.github.dako720.sistemagestionrecursos.domain.repositories.StudentRepository;
import co.github.dako720.sistemagestionrecursos.infrastructure.repositories.jpa.StudentJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentJpaRepository jpaRepository;

    public StudentRepositoryImpl(StudentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Student save(Student student) {
        return jpaRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Student update(Student student) {
        return jpaRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }
}
