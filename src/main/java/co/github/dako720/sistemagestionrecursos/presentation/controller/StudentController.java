package co.github.dako720.sistemagestionrecursos.presentation.controller;

import co.github.dako720.sistemagestionrecursos.application.dto.CreateStudentDto;
import co.github.dako720.sistemagestionrecursos.application.dto.StudentDto;
import co.github.dako720.sistemagestionrecursos.application.services.StudentService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(
            @Valid @RequestBody CreateStudentDto studentDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.create(studentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studentService.findById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll() {

        return ResponseEntity.ok(
                studentService.findAll()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(
            @PathVariable Long id,
            @RequestBody CreateStudentDto studentDTO) {

        return ResponseEntity.ok(
                studentService.update(id, studentDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        studentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}