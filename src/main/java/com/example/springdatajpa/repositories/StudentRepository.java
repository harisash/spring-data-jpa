package com.example.springdatajpa.repositories;

import com.example.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findStudentByLastNameContaining(String name);

    List<Student> findByGuardianEmailNotNull();

    // JPQL query
    @Query("Select s.firstName from Student s where s.email = ?1")
    String getStudentByEmail(String email);

    // Native query
    @Query(value = "select * from tbl_student s where s.email = ?1", nativeQuery = true)
    Student getStudentByEmailNativeQuery(String email);

    // Native query with named params
    @Query(value = "select * from tbl_student s where s.email = :email", nativeQuery = true)
    Student getStudentByEmailNativeQueryWithNamedParam(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email = ?2", nativeQuery = true)
    int updateStudentFirstNameByEmail(String firstName, String email);
}
