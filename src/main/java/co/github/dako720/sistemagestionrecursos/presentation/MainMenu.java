package co.github.dako720.sistemagestionrecursos.presentation;

import java.util.Scanner;

public class MainMenu {

    private final StudentMenu studentMenu;
    private final CourseMenu courseMenu;
    private final EnrollmentMenu enrollmentMenu;
    private final Scanner scanner;

    public MainMenu(StudentMenu studentMenu, CourseMenu courseMenu,
                     EnrollmentMenu enrollmentMenu, Scanner scanner) {
        this.studentMenu = studentMenu;
        this.courseMenu = courseMenu;
        this.enrollmentMenu = enrollmentMenu;
        this.scanner = scanner;
    }

    public void show() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Course Management System ===");
            System.out.println("1. Students");
            System.out.println("2. Courses");
            System.out.println("3. Enrollments");
            System.out.println("0. Exit");
            System.out.print("Option: ");

            switch (readOption()) {
                case 1 -> studentMenu.show();
                case 2 -> courseMenu.show();
                case 3 -> enrollmentMenu.show();
                case 0 -> {
                    exit = true;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
