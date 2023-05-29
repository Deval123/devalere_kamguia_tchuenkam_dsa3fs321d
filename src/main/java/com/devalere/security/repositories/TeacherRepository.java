package com.devalere.security.repositories;

import com.devalere.security.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories()
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
