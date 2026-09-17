package co.github.dako720.sistemagestionrecursos.application.services.impl;

import co.github.dako720.sistemagestionrecursos.application.Excepciones.BusinessException;
import co.github.dako720.sistemagestionrecursos.application.Excepciones.CourseNotFoundException;
import co.github.dako720.sistemagestionrecursos.application.Excepciones.EnrollmentNotFoundException;
import co.github.dako720.sistemagestionrecursos.application.Excepciones.StudentNotFoundException;
import co.github.dako720.sistemagestionrecursos.application.dto.CreateEnrollmentDto;
import co.github.dako720.sistemagestionrecursos.application.dto.EnrollmentDto;
import co.github.dako720.sistemagestionrecursos.application.services.EnrollmentService;
import co.github.dako720.sistemagestionrecursos.domain.models.Course;
import co.github.dako720.sistemagestionrecursos.domain.models.Enrollment;
import co.github.dako720.sistemagestionrecursos.domain.models.EnrollmentStatus;
import co.github.dako720.sistemagestionrecursos.domain.repositories.CourseRepository;
import co.github.dako720.sistemagestionrecursos.domain.repositories.EnrollmentRepository;
import co.github.dako720.sistemagestionrecursos.domain.repositories.StudentRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
                                  StudentRepository studentRepository,
                                  CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public EnrollmentDto create(CreateEnrollmentDto enrollmentDTO) {

        if (!studentRepository.existsById(enrollmentDTO.studentId())) {
            throw new StudentNotFoundException(enrollmentDTO.studentId());
        }

        Course course = courseRepository.findById(enrollmentDTO.courseId())
                .orElseThrow(() -> new CourseNotFoundException(enrollmentDTO.courseId()));

        long activeEnrollments = enrollmentRepository.findByCourseId(course.getId()).stream()
                .filter(e -> e.getStatus() == EnrollmentStatus.ACTIVE)
                .count();

        if (activeEnrollments >= course.getMaxCapacity()) {
            throw new BusinessException("Course " + course.getCode() + " has reached its max capacity");
        }

        Enrollment enrollment = new Enrollment(
                null,
                enrollmentDTO.studentId(),
                enrollmentDTO.courseId(),
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        );

        Enrollment saved = enrollmentRepository.save(enrollment);
        return toDTO(saved);
    }

    @Override
    public EnrollmentDto findById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));
        return toDTO(enrollment);
    }

    @Override
    public List<EnrollmentDto> findAll() {
        return enrollmentRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EnrollmentDto cancel(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));

        if (enrollment.getStatus() == EnrollmentStatus.CANCELLED) {
            throw new BusinessException("Enrollment " + id + " is already cancelled");
        }

        enrollment.setStatus(EnrollmentStatus.CANCELLED);
        Enrollment updated = enrollmentRepository.update(enrollment);
        return toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new EnrollmentNotFoundException(id);
        }
        enrollmentRepository.deleteById(id);
    }

    private EnrollmentDto toDTO(Enrollment enrollment) {
        return new EnrollmentDto(enrollment.getId(), enrollment.getStudentId(), enrollment.getCourseId(),
                enrollment.getEnrollmentDate(), enrollment.getStatus());
    }
}
