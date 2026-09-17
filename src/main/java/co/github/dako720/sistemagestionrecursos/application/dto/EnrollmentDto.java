package co.github.dako720.sistemagestionrecursos.application.dto;

import co.github.dako720.sistemagestionrecursos.domain.models.EnrollmentStatus;

import java.time.LocalDate;

public record EnrollmentDto(
        Long id,
        Long studentId,
        Long courseId,
        LocalDate enrollmentDate,
        EnrollmentStatus status
) {
}
