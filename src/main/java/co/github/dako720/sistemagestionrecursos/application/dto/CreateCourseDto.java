package co.github.dako720.sistemagestionrecursos.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateCourseDto(

        Long id,

        @NotBlank(message = "El código del curso es obligatorio")
        @Size(max = 20, message = "El código no puede superar 20 caracteres")
        String code,

        @NotBlank(message = "El nombre del curso es obligatorio")
        @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
        String name,

        @Size(max = 255, message = "La descripción no puede superar 255 caracteres")
        String description,

        @NotNull(message = "La capacidad máxima es obligatoria")
        @Positive(message = "La capacidad máxima debe ser un número positivo")
        Integer maxCapacity
) {
}
