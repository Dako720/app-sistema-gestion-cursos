package co.github.dako720.sistemagestionrecursos.application.Excepciones;

public class StudentNotFoundException extends BusinessException {

    public StudentNotFoundException(Long id) {
        super("Student not found: " + id);
    }
}
