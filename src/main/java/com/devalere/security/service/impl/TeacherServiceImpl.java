package com.devalere.security.service.impl;

import com.devalere.security.dto.TeacherDto;
import com.devalere.security.entities.Teacher;
import com.devalere.security.exception.EntityNotFoundException;
import com.devalere.security.exception.InvalidEntityException;
import com.devalere.security.repositories.TeacherRepository;
import com.devalere.security.service.TeacherService;
import com.devalere.security.utils.ErrorCodes;
import com.devalere.security.validator.TeacherValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDto save(TeacherDto dto) {
        List<String> errors = TeacherValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Teacher is not valid{}", dto);
            throw new InvalidEntityException("Teacher is not valid", ErrorCodes.TEACHER_NOT_VALID, errors);
        }
        Teacher savedTeacher = teacherRepository.save(TeacherDto.toEntity(dto));
        return TeacherDto.fromEntity(savedTeacher);
    }

    @Override
    public TeacherDto findById(Integer id) {
        if (id == null) {
            log.error("Teacher ID is null");
            return null;
        }
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return Optional.of(TeacherDto.fromEntity(teacher.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "No Teacher with ID =" + id + "was found in the database",
                        ErrorCodes.TEACHER_NOT_FOUND)
        );
    }

    @Override
    public List<TeacherDto> findAll() {
        return teacherRepository.findAll().stream()
                .map(TeacherDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Teacher ID is null");
            return;
        }
        teacherRepository.deleteById(id);
    }
}
