package com.devalere.security.service.impl;

import com.devalere.security.dto.ClasseDto;
import com.devalere.security.entities.Classe;
import com.devalere.security.exception.EntityNotFoundException;
import com.devalere.security.exception.InvalidEntityException;
import com.devalere.security.repositories.ClasseRepository;
import com.devalere.security.utils.ErrorCodes;
import com.devalere.security.validator.ClasseValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ClasseServiceImplTest {

    @Mock
    private ClasseRepository classeRepository;

    @InjectMocks
    private ClasseServiceImpl classeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


/*@Test
    public void testSaveValidClasse() {
        ClasseDto classeDto = new ClasseDto();
        // Set up the classeDto object

        Classe savedClasse = new Classe();
        // Set up the savedClasse object

        when(classeRepository.save(any(Classe.class))).thenReturn(savedClasse);

        ClasseDto resultDto = classeService.save(classeDto);

        Assertions.assertNotNull(resultDto);
        // Add more assertions as per your requirements
    }
*/


/*@Test
    public void testSaveInvalidClasse() {
        ClasseDto classeDto = new ClasseDto();
        // Set up the invalid classeDto object

        List<String> validationErrors = new ArrayList<>();
        // Set up the validation errors

        doReturn(validationErrors).when(ClasseValidator.validate(classeDto));

        InvalidEntityException exception = Assertions.assertThrows(
                InvalidEntityException.class,
                () -> classeService.save(classeDto)
        );

        Assertions.assertEquals("Class is not valid", exception.getMessage());
       // Assertions.assertEquals(ErrorCodes.CLASS_NOT_VALID, exception.getErrorCode());
        // Add more assertions as per your requirements
    }
*/

    @Test
    public void testFindByIdExistingClasse() {
        Integer id = 1;
        Classe classe = new Classe();
        // Set up the existing classe object

        when(classeRepository.findById(id)).thenReturn(Optional.of(classe));

        ClasseDto resultDto = classeService.findById(id);

        Assertions.assertNotNull(resultDto);
        // Add more assertions as per your requirements
    }

    @Test
    public void testFindByIdNonExistingClasse() {
        Integer id = 1;

        when(classeRepository.findById(id)).thenReturn(Optional.empty());

        EntityNotFoundException exception = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> classeService.findById(id)
        );

        Assertions.assertEquals("No Class with ID =1 was found in the database", exception.getMessage());
        //Assertions.assertEquals(ErrorCodes.CLASS_NOT_FOUND, exception.getErrorCode());
        // Add more assertions as per your requirements
    }

    @Test
    public void testFindAll() {
        List<Classe> classeList = new ArrayList<>();
        // Set up the classeList with some Classe objects

        when(classeRepository.findAll()).thenReturn(classeList);

        List<ClasseDto> resultDtoList = classeService.findAll();

        Assertions.assertNotNull(resultDtoList);
        // Add more assertions as per your requirements
    }

    @Test
    public void testDeleteExistingClasse() {
        Integer id = 1;

        classeService.delete(id);

        verify(classeRepository, times(1)).deleteById(id);
        // Add more assertions as per your requirements
    }

    @Test
    public void testDeleteNonExistingClasse() {
        Integer id = 1;

        classeService.delete(id);

        verify(classeRepository, never()).deleteById(id);
        // Add more assertions as per your requirements
    }
}
