package co.github.dako720.sistemagestionrecursos.presentation;

import co.github.dako720.sistemagestionrecursos.application.Excepciones.BusinessException;
import co.github.dako720.sistemagestionrecursos.application.dto.EnrollmentDTO;
import co.github.dako720.sistemagestionrecursos.application.services.EnrollmentService;
import co.github.dako720.sistemagestionrecursos.domain.models.EnrollmentStatus;

import java.util.Scanner;

public class EnrollmentMenu {

    private final EnrollmentService enrollmentService;
    private final Scanner scanner;

    public EnrollmentMenu(EnrollmentService enrollmentService, Scanner scanner) {
        this.enrollmentService = enrollmentService;
        this.scanner = scanner;
    }

    public void show() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Enrollments ---");
            System.out.println("1. Create Enrollment");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Cancel Enrollment");
            System.out.println("5. Delete Enrollment");
            System.out.println("0. Back");
            System.out.print("Option: ");

            switch (readOption()) {
                case 1 -> create();
                case 2 -> findById();
                case 3 -> listAll();
                case 4 -> cancel();
                case 5 -> delete();
                case 0 -> back = true;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void create() {
        try {
            System.out.print("Student id: ");
            Long studentId = Long.parseLong(scanner.nextLine().trim());
            System.out.print("Course id: ");
            Long courseId = Long.parseLong(scanner.nextLine().trim());

            EnrollmentDTO created = enrollmentService.create(
                    new EnrollmentDTO(null, studentId, courseId, null, EnrollmentStatus.ACTIVE));
            System.out.println("Created: " + created);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void findById() {
        try {
            Long id = readId();
            System.out.println(enrollmentService.findById(id));
        } catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listAll() {
        enrollmentService.findAll().forEach(System.out::println);
    }

    private void cancel() {
        try {
            Long id = readId();
            EnrollmentDTO cancelled = enrollmentService.cancel(id);
            System.out.println("Cancelled: " + cancelled);
        } catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void delete() {
        try {
            Long id = readId();
            enrollmentService.delete(id);
            System.out.println("Deleted enrollment " + id);
        } catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private Long readId() {
        System.out.print("Id: ");
        return Long.parseLong(scanner.nextLine().trim());
    }
}
