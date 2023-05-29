package com.devalere.security.controller.api;

import com.devalere.security.dto.StudentDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.devalere.security.utils.Constants.*;

public interface StudentApi {

    @PostMapping(value = STUDENT_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    StudentDto save(@RequestBody StudentDto dto);

    @GetMapping(value = FIND_STUDENT_BY_ID_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    StudentDto findById(@PathVariable("idStudent") Integer id);

    @GetMapping(value = FIND_ALL_STUDENT_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    List<StudentDto> findAll();


    @DeleteMapping(value = DELETE_STUDENT_ENDPOINT)
    void delete(@PathVariable("idStudent") Integer id);
}
