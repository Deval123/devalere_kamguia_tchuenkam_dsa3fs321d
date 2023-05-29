package com.devalere.security.service.impl;

import com.devalere.security.dto.ClasseDto;
import com.devalere.security.entities.Classe;
import com.devalere.security.exception.EntityNotFoundException;
import com.devalere.security.exception.InvalidEntityException;
import com.devalere.security.repositories.ClasseRepository;
import com.devalere.security.service.ClasseService;
import com.devalere.security.utils.ErrorCodes;
import com.devalere.security.validator.ClasseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;

    @Autowired
    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public ClasseDto save(ClasseDto dto) {
        List<String> errors = ClasseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Class is not valid{}", dto);
            throw new InvalidEntityException("Class is not valid", ErrorCodes.CLASS_NOT_VALID, errors);
        }
        Classe savedClasse = classeRepository.save(ClasseDto.toEntity(dto));
        return ClasseDto.fromEntity(savedClasse);
    }

    @Override
    public ClasseDto findById(Integer id) {
        if (id == null) {
            log.error("Class ID is null");
            return null;
        }
        Optional<Classe> classe = classeRepository.findById(id);
        return Optional.of(ClasseDto.fromEntity(classe.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "No Class with ID =" + id + "was found in the database",
                        ErrorCodes.CLASS_NOT_FOUND)
        );
    }

    @Override
    public List<ClasseDto> findAll() {
        return classeRepository.findAll().stream()
                .map(ClasseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Class ID is null");
            return;
        }
        classeRepository.deleteById(id);
    }
}
