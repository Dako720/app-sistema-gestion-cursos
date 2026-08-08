package co.github.dako720.sistemagestionrecursos.application.services.impl;

import co.github.dako720.sistemagestionrecursos.domain.models.Student;
import co.github.dako720.sistemagestionrecursos.domain.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService implements StudentRepository {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Student save(Student student) {
        if (repository.existsById(student.getId())) {
            throw new RuntimeException("Student with id " + student.getId() + " already exists");
        }
        return repository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        if (repository.findById(id).isPresent()) {
            throw new RuntimeException("Student with id " + id + " already exists");
        }

        if (repository.existsByEmail(String.valueOf(id))) {
            throw new RuntimeException("Email already exists");
        }
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        if (repository.findAll().isEmpty()) {
            throw new RuntimeException("No students found");
        }
        return repository.findAll();
    }

    @Override
    public Student update(Student student) {
        if (repository.findById(student.getId()).isPresent()) {
            throw new RuntimeException("Student with id " + student.getId() + " already exists");
        }
        return repository.update(student);
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            throw new RuntimeException("Student deleted with id " + id);
        }
        repository.deleteById(id);

    }

    @Override
    public boolean existsById(Long id) {
        if (repository.existsById(id)) {
            throw new RuntimeException("Student with id " + id + " already exists");
        }
        return repository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
