package co.github.dako720.sistemagestionrecursos.application.services;

import co.github.dako720.sistemagestionrecursos.application.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO create(StudentDTO studentDTO);

    StudentDTO findById(Long id);

    List<StudentDTO> findAll();

    StudentDTO update(Long id, StudentDTO studentDTO);

    void delete(Long id);
}
