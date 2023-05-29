package com.devalere.security.repositories;

import com.devalere.security.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories()
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT s FROM Student s WHERE CONCAT(s.classe.teacher.firstName, ' ', s.classe.teacher.lastName) = :teacherFullName")
    List<Student> findByTeacherFullName(String teacherFullName, Pageable pageable);

    @Query(value = "SELECT s FROM Student s WHERE s.classe = :className")
    List<Student> findByClassName(String className, Pageable pageable);

    @Query(value = "SELECT s FROM Student s WHERE s.classe.name = :className AND CONCAT(s.classe.teacher.firstName, ' ', s.classe.teacher.lastName) = :teacherFullName")
    List<Student> findByClassNameAndTeacherFullName(String className, String teacherFullName, Pageable pageable);
}