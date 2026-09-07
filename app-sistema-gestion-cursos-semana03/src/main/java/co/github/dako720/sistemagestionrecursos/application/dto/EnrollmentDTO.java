package co.github.dako720.sistemagestionrecursos.application.dto;

import co.github.dako720.sistemagestionrecursos.domain.models.EnrollmentStatus;

import java.time.LocalDate;

public record EnrollmentDTO(
        Long id,
        Long studentId,
        Long courseId,
        LocalDate enrollmentDate,
        EnrollmentStatus status
) {
}
