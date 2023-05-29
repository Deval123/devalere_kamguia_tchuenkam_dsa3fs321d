package com.devalere.security.service;

import com.devalere.security.dto.ClasseDto;

import java.util.List;

public interface ClasseService {

    ClasseDto save(ClasseDto dto);

    ClasseDto findById(Integer id);


    List<ClasseDto> findAll();

    void delete(Integer id);

}
