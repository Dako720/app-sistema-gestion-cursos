package co.github.dako720.sistemagestionrecursos.application.services.impl;

import co.github.dako720.sistemagestionrecursos.application.Excepciones.StudentNotFoundException;
import co.github.dako720.sistemagestionrecursos.application.dto.CreateStudentDto;
import co.github.dako720.sistemagestionrecursos.application.dto.StudentDto;
import co.github.dako720.sistemagestionrecursos.application.services.StudentService;
import co.github.dako720.sistemagestionrecursos.domain.models.Student;
import co.github.dako720.sistemagestionrecursos.domain.repositories.StudentRepository;
import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto create(@Valid CreateStudentDto studentDTO) {
        Student student = toModel(studentDTO);
        Student saved = studentRepository.save(student);
        return toDTO(saved);
    }

    @Override
    public StudentDto findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return toDTO(student);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto update(Long id, CreateStudentDto studentDTO) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        Student student = toModel(studentDTO);
        student.setStudentId(id);
        Student updated = studentRepository.update(student);
        return toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }

    private Student toModel(@Valid CreateStudentDto dto) {
        return new Student(dto.id(), dto.firstName(), dto.lastName(), dto.email(), dto.birthDate());
    }

    private StudentDto toDTO(Student student) {
        return new StudentDto(student.getStudentId(), student.getFirstName(), student.getLastName(),
                student.getEmail(), student.getPhoneNumber());
    }
}
