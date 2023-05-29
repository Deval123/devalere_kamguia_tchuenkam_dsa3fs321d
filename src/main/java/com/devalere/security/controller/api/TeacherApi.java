package com.devalere.security.controller.api;

import com.devalere.security.dto.TeacherDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.devalere.security.utils.Constants.*;

public interface TeacherApi {

    @PostMapping(value = TEACHER_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    TeacherDto save(@RequestBody TeacherDto dto);

    @GetMapping(value = FIND_TEACHER_BY_ID_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    TeacherDto findById(@PathVariable("idTeacher") Integer id);

    @GetMapping(value = FIND_ALL_TEACHER_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    List<TeacherDto> findAll();

    @DeleteMapping(value = DELETE_TEACHER_ENDPOINT)
    void delete(@PathVariable("idTeacher") Integer id);

}
