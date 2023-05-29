package com.devalere.security.controller;

import com.devalere.security.controller.api.StudentApi;
import com.devalere.security.dto.StudentDto;
import com.devalere.security.entities.Student;
import com.devalere.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.devalere.security.utils.Constants.GET_ALL_STUDENT_ENDPOINT;

@RestController
public class StudentController implements StudentApi {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public StudentDto save(StudentDto dto) {
        return studentService.save(dto);
    }

    @Override
    public StudentDto findById(Integer id) {
        return studentService.findById(id);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }

    @Override
    public void delete(Integer id) {
        studentService.delete(id);
    }


    @PostMapping(value = GET_ALL_STUDENT_ENDPOINT)
    public ResponseEntity<List<Student>> getStudents(
            @RequestParam(value = "className", required = false) String className,
            @RequestParam(value = "teacherFullName", required = false) String teacherFullName,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        List<Student> students = studentService.getStudents(className, teacherFullName, page, size);
        return ResponseEntity.ok(students);
    }
}
