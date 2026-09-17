package co.github.dako720.sistemagestionrecursos.application.services;

import co.github.dako720.sistemagestionrecursos.application.dto.CourseDto;
import co.github.dako720.sistemagestionrecursos.application.dto.CreateCourseDto;

import java.util.List;

public interface CourseService {

    CourseDto create(CreateCourseDto courseDTO);

    CourseDto findById(Long id);

    List<CourseDto> findAll();

    CourseDto update(Long id, CreateCourseDto courseDTO);

    void delete(Long id);
}
