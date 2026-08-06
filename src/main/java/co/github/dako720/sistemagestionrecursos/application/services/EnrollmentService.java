package co.github.dako720.sistemagestionrecursos.application.services;

import co.github.dako720.sistemagestionrecursos.application.dto.EnrollmentDTO;

import java.util.List;

public interface EnrollmentService {

    EnrollmentDTO create(EnrollmentDTO enrollmentDTO);

    EnrollmentDTO findById(Long id);

    List<EnrollmentDTO> findAll();

    EnrollmentDTO cancel(Long id);

    void delete(Long id);
}
