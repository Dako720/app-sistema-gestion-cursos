package co.github.dako720.sistemagestionrecursos.application.dto;

import jakarta.validation.constraints.NotNull;

public record CreateEnrollmentDto(

        Long id,

        @NotNull(message = "El ID del estudiante es obligatorio")
        Long studentId,

        @NotNull(message = "El ID del curso es obligatorio")
        Long courseId
) {
}
