package com.example.springdatajpa.config;

import com.example.springdatajpa.entities.Course;
import com.example.springdatajpa.entities.CourseMaterial;
import com.example.springdatajpa.repositories.CourseMaterialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class CourseMaterialConfig {

//    @Bean
    public CommandLineRunner commandLineRunner(CourseMaterialRepository repository) {
        return args -> {
//            saveCourseMaterial(repository);
//            getAllCourseMaterials(repository);
        };
    }

    private void getAllCourseMaterials(CourseMaterialRepository repository) {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

    private void saveCourseMaterial(CourseMaterialRepository repository) {
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }
}
