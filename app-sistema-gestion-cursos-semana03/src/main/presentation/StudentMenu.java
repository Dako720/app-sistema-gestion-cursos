package co.github.dako720.sistemagestionrecursos.presentation;

import co.github.dako720.sistemagestionrecursos.application.Excepciones.BusinessException;
import co.github.dako720.sistemagestionrecursos.application.dto.StudentDTO;
import co.github.dako720.sistemagestionrecursos.application.services.StudentService;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentMenu {

    private final StudentService studentService;
    private final Scanner scanner;

    public StudentMenu(StudentService studentService, Scanner scanner) {
        this.studentService = studentService;
        this.scanner = scanner;
    }

    public void show() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Students ---");
            System.out.println("1. Create");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Back");
            System.out.print("Option: ");

            switch (readOption()) {
                case 1 -> create();
                case 2 -> findById();
                case 3 -> listAll();
                case 4 -> update();
                case 5 -> delete();
                case 0 -> back = true;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void create() {
        try {
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Birth date (yyyy-MM-dd): ");
            LocalDate birthDate = LocalDate.parse(scanner.nextLine());

            StudentDTO created = studentService.create(new StudentDTO(null, firstName, lastName, email, birthDate));
            System.out.println("Created: " + created);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void findById() {
        try {
            Long id = readId();
            System.out.println(studentService.findById(id));
        } catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listAll() {
        studentService.findAll().forEach(System.out::println);
    }

    private void update() {
        try {
            Long id = readId();
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Birth date (yyyy-MM-dd): ");
            LocalDate birthDate = LocalDate.parse(scanner.nextLine());

            StudentDTO updated = studentService.update(id, new StudentDTO(null, firstName, lastName, email, birthDate));
            System.out.println("Updated: " + updated);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void delete() {
        try {
            Long id = readId();
            studentService.delete(id);
            System.out.println("Deleted student " + id);
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
