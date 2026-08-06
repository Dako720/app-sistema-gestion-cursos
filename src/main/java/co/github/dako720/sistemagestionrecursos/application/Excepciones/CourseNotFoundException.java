package co.github.dako720.sistemagestionrecursos.application.Excepciones;

public class CourseNotFoundException extends BusinessException {

    public CourseNotFoundException(Long id) {
        super("Course not found: " + id);
    }
}
