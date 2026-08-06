package co.github.dako720.sistemagestionrecursos;

import co.github.dako720.sistemagestionrecursos.application.services.CourseService;
import co.github.dako720.sistemagestionrecursos.application.services.EnrollmentService;
import co.github.dako720.sistemagestionrecursos.application.services.StudentService;
import co.github.dako720.sistemagestionrecursos.application.services.impl.CourseServiceImpl;
import co.github.dako720.sistemagestionrecursos.application.services.impl.EnrollmentServiceImpl;
import co.github.dako720.sistemagestionrecursos.application.services.impl.StudentServiceImpl;
import co.github.dako720.sistemagestionrecursos.domain.repositories.CourseRepository;
import co.github.dako720.sistemagestionrecursos.domain.repositories.EnrollmentRepository;
import co.github.dako720.sistemagestionrecursos.domain.repositories.StudentRepository;
import co.github.dako720.sistemagestionrecursos.infrastructure.repositories.InMemoryCourseRepository;
import co.github.dako720.sistemagestionrecursos.infrastructure.repositories.InMemoryEnrollmentRepository;
import co.github.dako720.sistemagestionrecursos.infrastructure.repositories.InMemoryStudentRepository;
import co.github.dako720.sistemagestionrecursos.presentation.CourseMenu;
import co.github.dako720.sistemagestionrecursos.presentation.EnrollmentMenu;
import co.github.dako720.sistemagestionrecursos.presentation.MainMenu;
import co.github.dako720.sistemagestionrecursos.presentation.StudentMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentRepository studentRepository = new InMemoryStudentRepository();
        CourseRepository courseRepository = new InMemoryCourseRepository();
        EnrollmentRepository enrollmentRepository = new InMemoryEnrollmentRepository();

        StudentService studentService = new StudentServiceImpl(studentRepository);
        CourseService courseService = new CourseServiceImpl(courseRepository);
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(
                enrollmentRepository, studentRepository, courseRepository);

        Scanner scanner = new Scanner(System.in);
        StudentMenu studentMenu = new StudentMenu(studentService, scanner);
        CourseMenu courseMenu = new CourseMenu(courseService, scanner);
        EnrollmentMenu enrollmentMenu = new EnrollmentMenu(enrollmentService, scanner);
        MainMenu mainMenu = new MainMenu(studentMenu, courseMenu, enrollmentMenu, scanner);

        mainMenu.show();
    }
}
