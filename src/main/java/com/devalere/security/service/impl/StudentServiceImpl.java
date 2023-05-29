package com.devalere.security.service.impl;

import com.devalere.security.dto.StudentDto;
import com.devalere.security.entities.Student;
import com.devalere.security.exception.EntityNotFoundException;
import com.devalere.security.exception.InvalidEntityException;
import com.devalere.security.repositories.StudentRepository;
import com.devalere.security.service.StudentService;
import com.devalere.security.utils.ErrorCodes;
import com.devalere.security.validator.StudentValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto save(StudentDto dto) {
        List<String> errors = StudentValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Student is not valid{}", dto);
            throw new InvalidEntityException("Student is not valid", ErrorCodes.STUDENT_NOT_VALID, errors);
        }
        Student savedStudent = studentRepository.save(StudentDto.toEntity(dto));
        return StudentDto.fromEntity(savedStudent);
    }

    @Override
    public StudentDto findById(Integer id) {
        if(id == null){
            log.error("Student ID is null");
            return null;
        }
        Optional<Student> student = studentRepository.findById(id);
        return Optional.of(StudentDto.fromEntity(student.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "No students with ID =" + id + "was found in the database",
                        ErrorCodes.STUDENT_NOT_FOUND)
        );
    }

    @Override
    public List<Student> getStudents(String className, String teacherFullName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (className != null && teacherFullName != null) {
            return studentRepository.findByClassNameAndTeacherFullName(className, teacherFullName, pageable);
        } else if (className != null) {
            return studentRepository.findByClassName(className, pageable);
        } else if (teacherFullName != null) {
            return studentRepository.findByTeacherFullName(teacherFullName, pageable);
        } else {
            return studentRepository.findAll(pageable).getContent();
        }
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(StudentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Student ID is null");
            return ;
        }
        studentRepository.deleteById(id);
    }
}
