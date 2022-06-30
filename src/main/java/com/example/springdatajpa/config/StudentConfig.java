package com.example.springdatajpa.config;

import com.example.springdatajpa.entities.Guardian;
import com.example.springdatajpa.entities.Student;
import com.example.springdatajpa.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
public class StudentConfig {
    // Just a new line.
    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            save(studentRepository);
//            getAllStudent(studentRepository);
//            saveWithGuardian(studentRepository);
//            findStudentByFirstName(studentRepository);
//            findStudentByLastNameContaining(studentRepository);
//            findByGuardianEmailNotNull(studentRepository);
//            getStudentByEmail(studentRepository);
//            getStudentByEmailNative(studentRepository);
//            updateStudentFirstNameByEmail(studentRepository);
        };
    }

    private void updateStudentFirstNameByEmail(StudentRepository repository) {
        int result = repository.updateStudentFirstNameByEmail("ccc", "c");
        System.out.println("Result is: " + result);
    }

    private void getStudentByEmailNative(StudentRepository repository) {
//        Student student = repository.getStudentByEmailNativeQuery("haris@");
        Student student = repository.getStudentByEmailNativeQueryWithNamedParam("haris@");
        System.out.println(student);
    }

    private void getStudentByEmail(StudentRepository repository) {
        String student = repository.getStudentByEmail("haris@");
        System.out.println(student);
    }

    public void save(StudentRepository studentRepository) {
//        Student s1 = Student.builder()
//                .email("abdullah@")
//                .firstName("abdullah")
//                .lastName("ashfaq")
//                .build();

        Student test = new Student();
        test.setEmail("test6@");
        studentRepository.save(test);

        test.setFirstName("Test 5 first");
        studentRepository.save(test);
    }

    private void saveWithGuardian(StudentRepository studentRepository) {
        Student s1 = Student.builder()
                .email("c")
                .firstName("c")
                .lastName("c")
                .guardian(new Guardian("Alpha", "alpha@alpha", "111"))
                .build();

        studentRepository.save(s1);
    }

    private void getAllStudent(StudentRepository studentRepository) {
        List<Student> students = studentRepository.findAll();
        students.forEach(s -> System.out.println(s));
    }

    private void findStudentByFirstName(StudentRepository repository) {
        List<Student> students = repository.findByFirstName("a");
        System.out.println(students);

        // Q - What if I wanted to make a query where only name should be picked instead of all the fields?
    }

    private void findStudentByLastNameContaining(StudentRepository repository) {
        List<Student> students = repository.findStudentByLastNameContaining("ash");
        students.forEach(student -> System.out.println(student));
    }

    private void findByGuardianEmailNotNull(StudentRepository repository) {
        List<Student> students = repository.findByGuardianEmailNotNull();
        students.forEach(student -> System.out.println(student));
    }
}
