package co.github.dako720.sistemagestionrecursos.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateStudentDto(

        @NotNull
        Long id,

        @NotBlank
        String firstName,

        String lastName,
        @NotBlank

        @NotBlank
        @Email
        String email,

        @NotBlank
        String phoneNumber
) {
    public String birthDate() {
        return "";
    }
}
