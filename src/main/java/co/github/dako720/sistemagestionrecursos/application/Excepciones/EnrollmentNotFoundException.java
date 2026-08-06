package co.github.dako720.sistemagestionrecursos.application.Excepciones;

public class EnrollmentNotFoundException extends BusinessException {

    public EnrollmentNotFoundException(Long id) {
        super("Enrollment not found: " + id);
    }
}
