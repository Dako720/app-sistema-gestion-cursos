package co.github.dako720.sistemagestionrecursos.domain.models;

import java.time.LocalDate;
import co.github.dako720.sistemagestionrecursos.domain.models.Enrollment;

public class Enrollment {

  private  Long id;

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Enrollment(Long id) {
        this.id = id;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    private Long studentId;
   private Long courseId;

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    private LocalDate enrollmentDate;
    private EnrollmentStatus status;
}
