package co.github.dako720.sistemagestionrecursos.application.dto;

public record CreateCourseDto(
        Long id,
        String code,
        String name,
        String description,
        Integer maxCapacity
) {
}
