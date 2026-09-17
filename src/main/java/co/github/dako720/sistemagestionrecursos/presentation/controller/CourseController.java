package co.github.dako720.sistemagestionrecursos.presentation.controller;

import co.github.dako720.sistemagestionrecursos.application.dto.CourseDto;
import co.github.dako720.sistemagestionrecursos.application.dto.CreateCourseDto;
import co.github.dako720.sistemagestionrecursos.application.services.CourseService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDto> create(
            @Valid @RequestBody CreateCourseDto courseDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseService.create(courseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                courseService.findById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> findAll() {

        return ResponseEntity.ok(
                courseService.findAll()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody CreateCourseDto courseDTO) {

        return ResponseEntity.ok(
                courseService.update(id, courseDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        courseService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
