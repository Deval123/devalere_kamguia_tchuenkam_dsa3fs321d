package com.devalere.security.service;

import com.devalere.security.dto.StudentDto;
import com.devalere.security.entities.Student;

import java.util.List;

public interface StudentService {

    StudentDto save(StudentDto dto);

    StudentDto findById(Integer id);

    List<Student> getStudents(String className, String teacherFullName, int page, int size);

    List<StudentDto> findAll();

    void delete(Integer id);

}
