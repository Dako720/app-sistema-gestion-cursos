package co.github.dako720.sistemagestionrecursos.application.dto;

public record StudentDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String birthDate
) {
}
