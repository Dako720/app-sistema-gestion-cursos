package co.github.dako720.sistemagestionrecursos.presentation.controller;

import co.github.dako720.sistemagestionrecursos.application.dto.CreateEnrollmentDto;
import co.github.dako720.sistemagestionrecursos.application.dto.EnrollmentDto;
import co.github.dako720.sistemagestionrecursos.application.services.EnrollmentService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentDto> create(
            @Valid @RequestBody CreateEnrollmentDto enrollmentDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(enrollmentService.create(enrollmentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDto> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                enrollmentService.findById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDto>> findAll() {

        return ResponseEntity.ok(
                enrollmentService.findAll()
        );
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<EnrollmentDto> cancel(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                enrollmentService.cancel(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        enrollmentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
