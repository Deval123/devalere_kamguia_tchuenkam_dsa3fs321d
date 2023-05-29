package com.devalere.security.controller;

import com.devalere.security.controller.api.ClasseApi;
import com.devalere.security.dto.ClasseDto;
import com.devalere.security.service.ClasseService;
import com.devalere.security.utils.ErrorCodes;
import com.devalere.security.handlers.ErrorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ClasseControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClasseService classeService;

    @InjectMocks
    private ClasseController classeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(classeController).build();
    }

    @Test
    public void testSaveClasse() throws Exception {
        ClasseDto classeDto = new ClasseDto();
        classeDto.setId(1);
        classeDto.setName("Math");

        when(classeService.save(any())).thenReturn(classeDto);

        String requestBody = new ObjectMapper().writeValueAsString(classeDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/classe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assertions.assertEquals(HttpStatus.OK.value(), status);

        ClasseDto responseDto = new ObjectMapper().readValue(result.getResponse().getContentAsString(), ClasseDto.class);
        Assertions.assertEquals(classeDto.getId(), responseDto.getId());
        Assertions.assertEquals(classeDto.getName(), responseDto.getName());

        verify(classeService, times(1)).save(any());
        verifyNoMoreInteractions(classeService);
    }

    @Test
    public void testFindClasseById() throws Exception {
        Integer id = 1;
        ClasseDto classeDto = new ClasseDto();
        classeDto.setId(id);
        classeDto.setName("Math");

        when(classeService.findById(eq(id))).thenReturn(classeDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/classe/{id}", id))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assertions.assertEquals(HttpStatus.OK.value(), status);

        ClasseDto responseDto = new ObjectMapper().readValue(result.getResponse().getContentAsString(), ClasseDto.class);
        Assertions.assertEquals(classeDto.getId(), responseDto.getId());
        Assertions.assertEquals(classeDto.getName(), responseDto.getName());

        verify(classeService, times(1)).findById(eq(id));
        verifyNoMoreInteractions(classeService);
    }

    @Test
    public void testFindAllClasses() throws Exception {
        ClasseDto classeDto1 = new ClasseDto();
        classeDto1.setId(1);
        classeDto1.setName("Math");

        ClasseDto classeDto2 = new ClasseDto();
        classeDto2.setId(2);
        classeDto2.setName("Science");

        List<ClasseDto> classeDtoList = Arrays.asList(classeDto1, classeDto2);

        when(classeService.findAll()).thenReturn(classeDtoList);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/classe"))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assertions.assertEquals(HttpStatus.OK.value(), status);

        List<ClasseDto> responseDtoList = new ObjectMapper().readValue(result.getResponse().getContentAsString(),
                List.class);
        Assertions.assertEquals(2, responseDtoList.size());

        verify(classeService, times(1)).findAll();
        verifyNoMoreInteractions(classeService);
    }

    @Test
    public void testDeleteClasse() throws Exception {
        Integer id = 1;

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/classe/{id}", id))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), status);

        verify(classeService, times(1)).delete(eq(id));
        verifyNoMoreInteractions(classeService);
    }

}
