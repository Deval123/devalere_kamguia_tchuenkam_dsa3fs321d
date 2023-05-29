package com.devalere.security.controller;

import com.devalere.security.controller.api.ClasseApi;
import com.devalere.security.dto.ClasseDto;
import com.devalere.security.repositories.ClasseRepository;
import com.devalere.security.service.ClasseService;
import com.devalere.security.service.impl.ClasseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClasseController implements ClasseApi {

    @Qualifier("classeService")
    private final ClasseService classeService;

    @Bean
    @Qualifier("classeService")
    public ClasseService classeService(ClasseRepository classeRepository) {
        return new ClasseServiceImpl(classeRepository);
    }

    @Autowired
    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }


    @Override
    public ClasseDto save(ClasseDto dto) {
        return classeService.save(dto);
    }

    @Override
    public ClasseDto findById(Integer id) {
        return classeService.findById(id);
    }

    @Override
    public List<ClasseDto> findAll() {
        return classeService.findAll();
    }

    @Override
    public void delete(Integer id) {
        classeService.delete(id);
    }
}
