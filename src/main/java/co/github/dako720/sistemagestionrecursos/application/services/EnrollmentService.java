package co.github.dako720.sistemagestionrecursos.application.services;

import co.github.dako720.sistemagestionrecursos.application.dto.CreateEnrollmentDto;
import co.github.dako720.sistemagestionrecursos.application.dto.EnrollmentDto;

import java.util.List;

public interface EnrollmentService {

    EnrollmentDto create(CreateEnrollmentDto enrollmentDTO);

    EnrollmentDto findById(Long id);

    List<EnrollmentDto> findAll();

    EnrollmentDto cancel(Long id);

    void delete(Long id);
}
