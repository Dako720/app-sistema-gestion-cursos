package co.github.dako720.sistemagestionrecursos.application.services.impl;

import co.github.dako720.sistemagestionrecursos.application.Excepciones.CourseNotFoundException;
import co.github.dako720.sistemagestionrecursos.application.dto.CourseDto;
import co.github.dako720.sistemagestionrecursos.application.dto.CreateCourseDto;
import co.github.dako720.sistemagestionrecursos.application.services.CourseService;
import co.github.dako720.sistemagestionrecursos.domain.models.Course;
import co.github.dako720.sistemagestionrecursos.domain.repositories.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto create(CreateCourseDto courseDTO) {
        Course course = toModel(courseDTO);
        Course saved = courseRepository.save(course);
        return toDTO(saved);
    }

    @Override
    public CourseDto findById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        return toDTO(course);
    }

    @Override
    public List<CourseDto> findAll() {
        return courseRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto update(Long id, CreateCourseDto courseDTO) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException(id);
        }
        Course course = toModel(courseDTO);
        course.setId(id);
        Course updated = courseRepository.update(course);
        return toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException(id);
        }
        courseRepository.deleteById(id);
    }

    private Course toModel(CreateCourseDto dto) {
        return new Course(dto.id(), dto.code(), dto.name(), dto.description(), dto.maxCapacity());
    }

    private CourseDto toDTO(Course course) {
        return new CourseDto(course.getId(), course.getCode(), course.getName(),
                course.getDescription(), course.getMaxCapacity());
    }
}
