package co.github.dako720.sistemagestionrecursos.application.services;

import co.github.dako720.sistemagestionrecursos.application.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO create(CourseDTO courseDTO);

    CourseDTO findById(Long id);

    List<CourseDTO> findAll();

    CourseDTO update(Long id, CourseDTO courseDTO);

    void delete(Long id);
}
