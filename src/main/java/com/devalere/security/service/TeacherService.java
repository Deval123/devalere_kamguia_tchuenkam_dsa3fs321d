package com.devalere.security.service;

import com.devalere.security.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    TeacherDto save(TeacherDto dto);

    TeacherDto findById(Integer id);

    List<TeacherDto> findAll();

    void delete(Integer id);

}
