package com.devalere.security.controller;

import com.devalere.security.controller.api.TeacherApi;
import com.devalere.security.dto.TeacherDto;
import com.devalere.security.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController implements TeacherApi {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public TeacherDto save(TeacherDto dto) {
        return teacherService.save(dto);
    }

    @Override
    public TeacherDto findById(Integer id) {
        return teacherService.findById(id);
    }

    @Override
    public List<TeacherDto> findAll() {
        return teacherService.findAll();
    }

    @Override
    public void delete(Integer id) {
        teacherService.delete(id);
    }
}
