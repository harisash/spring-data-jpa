package com.example.springdatajpa.config;

import com.example.springdatajpa.entities.Course;
import com.example.springdatajpa.entities.Teacher;
import com.example.springdatajpa.repositories.CourseRepository;
import com.example.springdatajpa.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class TeacherConfig {

//    @Bean
    public CommandLineRunner commandLineRunner(TeacherRepository repository) {
        return args -> {
//            saveTeacher(repository);
        };
    }

    private void saveTeacher(TeacherRepository repository) {
        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Alpha")
                .lastName("Charlie")
//                .courses(List.of(course))
                .build();

        repository.save(teacher);
    }
}
