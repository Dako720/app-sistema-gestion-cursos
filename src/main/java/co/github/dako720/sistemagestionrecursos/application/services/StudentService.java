package co.github.dako720.sistemagestionrecursos.application.services;

import co.github.dako720.sistemagestionrecursos.application.dto.CreateStudentDto;
import co.github.dako720.sistemagestionrecursos.application.dto.StudentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {

    StudentDto create(@Valid CreateStudentDto studentDTO);

    StudentDto findById(Long id);

    List<StudentDto> findAll();

    StudentDto update(Long id, CreateStudentDto studentDTO);

    void delete(Long id);
}
