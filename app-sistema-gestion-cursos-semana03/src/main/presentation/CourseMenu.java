package co.github.dako720.sistemagestionrecursos.presentation;

import co.github.dako720.sistemagestionrecursos.application.Excepciones.BusinessException;
import co.github.dako720.sistemagestionrecursos.application.dto.CourseDTO;
import co.github.dako720.sistemagestionrecursos.application.services.CourseService;

import java.util.Scanner;

public class CourseMenu {

    private final CourseService courseService;
    private final Scanner scanner;

    public CourseMenu(CourseService courseService, Scanner scanner) {
        this.courseService = courseService;
        this.scanner = scanner;
    }

    public void show() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Courses ---");
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
            System.out.print("Code: ");
            String code = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Max capacity: ");
            Integer maxCapacity = Integer.parseInt(scanner.nextLine().trim());

            CourseDTO created = courseService.create(new CourseDTO(null, code, name, description, maxCapacity));
            System.out.println("Created: " + created);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void findById() {
        try {
            Long id = readId();
            System.out.println(courseService.findById(id));
        } catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listAll() {
        courseService.findAll().forEach(System.out::println);
    }

    private void update() {
        try {
            Long id = readId();
            System.out.print("Code: ");
            String code = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Max capacity: ");
            Integer maxCapacity = Integer.parseInt(scanner.nextLine().trim());

            CourseDTO updated = courseService.update(id, new CourseDTO(null, code, name, description, maxCapacity));
            System.out.println("Updated: " + updated);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void delete() {
        try {
            Long id = readId();
            courseService.delete(id);
            System.out.println("Deleted course " + id);
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
