package com.devalere.security.controller.api;

import com.devalere.security.dto.ClasseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.devalere.security.utils.Constants.*;

public interface ClasseApi {

    @PostMapping(value = CLASS_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClasseDto save(@RequestBody ClasseDto dto);

    @GetMapping(value = FIND_CLASS_BY_ID_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ClasseDto findById(@PathVariable("idClass") Integer id);

    @GetMapping(value = FIND_ALL_CLASSES_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClasseDto> findAll();

    @DeleteMapping(value = DELETE_CLASS_ENDPOINT)
    void delete(@PathVariable("idClass") Integer id);


}
