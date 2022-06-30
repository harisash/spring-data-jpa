package com.example.springdatajpa.config;

import com.example.springdatajpa.entities.Course;
import com.example.springdatajpa.entities.Guardian;
import com.example.springdatajpa.entities.Student;
import com.example.springdatajpa.entities.Teacher;
import com.example.springdatajpa.repositories.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

//@Configuration
public class CourseConfig {

//    @Bean
    public CommandLineRunner commandLineRunner(CourseRepository repository) {
        return args -> {
//            getCourses(repository);
//            saveCourseWithTeacher(repository);
//            courseByPagination(repository);
//            saveCourseWithStudentAndTeacher(repository);
        };
    }

    private void saveCourseWithStudentAndTeacher(CourseRepository repository) {
        Teacher teacher = Teacher.builder()
                .firstName("Liz")
                .lastName("morgan")
                .build();

        Student s1 = Student.builder()
                .email("x")
                .firstName("x")
                .lastName("x")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(6)
                .teacher(teacher)
                .build();

        course.addStudents(s1);

        repository.save(course);
    }

    private void findByTitleContaining(CourseRepository repository) {
        Pageable firstPage10Records = PageRequest.of(0, 10);
        List<Course> courses = repository.findByTitleContaining("D", firstPage10Records).getContent();
        System.out.println("courses = " + courses);
    }

    private void findAllSorting(CourseRepository repository) {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

        Pageable sortByTitleAndCredit = PageRequest.of(0, 2, Sort.by("tile").and(Sort.by("credit")));


       List<Course> list = repository.findAll(sortByTitle).getContent();
        System.out.println("list = " + list);
    }

    private void courseByPagination(CourseRepository repository) {
        Pageable pageable = PageRequest.of(0, 2);
        List<Course> list = repository.findAll(pageable).getContent();

        System.out.println("list = " + list);

        long totalElements = repository.findAll(pageable).getTotalElements();
        System.out.println("totalElements = " + totalElements);

        long totalPages = repository.findAll(pageable).getTotalPages();
        System.out.println("totalPages = " + totalPages);
    }

    private void saveCourseWithTeacher(CourseRepository repository) {
        Teacher teacher = Teacher.builder()
                .firstName("Ali")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        repository.save(course);
    }

    private void getCourses(CourseRepository repository) {
        List<Course> courses = repository.findAll();
        System.out.println(courses);
    }
}
