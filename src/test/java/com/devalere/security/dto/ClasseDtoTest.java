package com.devalere.security.dto;


import com.devalere.security.entities.Classe;
import com.devalere.security.entities.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClasseDtoTest {

    @Test
    public void testFromEntity() {
        Integer id = 1;
        String name = "Math";
        Teacher teacher = new Teacher();
        teacher.setId(2);
        teacher.setFirstName("John");
        teacher.setLastName("Doe");

        Classe classe = new Classe();
        classe.setId(id);
        classe.setName(name);
        classe.setTeacher(teacher);

        ClasseDto classeDto = ClasseDto.fromEntity(classe);

        Assertions.assertEquals(id, classeDto.getId());
        Assertions.assertEquals(name, classeDto.getName());
        Assertions.assertNotNull(classeDto.getTeacher());
        Assertions.assertEquals(teacher.getId(), classeDto.getTeacher().getId());
        Assertions.assertEquals(teacher.getFirstName(), classeDto.getTeacher().getFirstName());
        Assertions.assertEquals(teacher.getLastName(), classeDto.getTeacher().getLastName());
    }

    @Test
    public void testToEntity() {
        Integer id = 1;
        String name = "Math";
        TeacherDto teacherDto = TeacherDto.builder()
                .id(2)
                .firstName("John")
                .lastName("Doe")
                .build();

        ClasseDto classeDto = new ClasseDto();
        classeDto.setId(id);
        classeDto.setName(name);
        //classeDto.setTeacher(teacherDto);

        Classe classe = ClasseDto.toEntity(classeDto);

        Assertions.assertEquals(id, classe.getId());
        Assertions.assertEquals(name, classe.getName());
        Assertions.assertNotNull(classe.getTeacher());
        Assertions.assertEquals(teacherDto.getId(), classe.getTeacher().getId());
        Assertions.assertEquals(teacherDto.getFirstName(), classe.getTeacher().getFirstName());
        Assertions.assertEquals(teacherDto.getLastName(), classe.getTeacher().getLastName());
    }

    @Test
    public void testFromEntity_WithNull() {
        Classe classe = null;
        ClasseDto classeDto = ClasseDto.fromEntity(classe);
        Assertions.assertNull(classeDto);
    }

    @Test
    public void testToEntity_WithNull() {
        ClasseDto classeDto = null;
        Classe classe = ClasseDto.toEntity(classeDto);
        Assertions.assertNull(classe);
    }

    @Test
    public void testFromEntity_WithEmptyStudentList() {
        Integer id = 1;
        String name = "Math";
        Teacher teacher = new Teacher();
        teacher.setId(2);
        teacher.setLastName("John");
        teacher.setLastName("Doe");

        Classe classe = new Classe();
        classe.setId(id);
        classe.setName(name);
        classe.setTeacher(teacher);
        classe.setStudent(new ArrayList<>());

        ClasseDto classeDto = ClasseDto.fromEntity(classe);

        Assertions.assertEquals(id, classeDto.getId());
        Assertions.assertEquals(name, classeDto.getName());
        Assertions.assertNotNull(classeDto.getTeacher());
        Assertions.assertEquals(teacher.getId(), classeDto.getTeacher().getId());
        Assertions.assertEquals(teacher.getLastName(), classeDto.getTeacher().getFirstName());
        Assertions.assertEquals(teacher.getLastName(), classeDto.getTeacher().getLastName());
        Assertions.assertNotNull(classeDto.getStudent());
        Assertions.assertTrue(classeDto.getStudent().isEmpty());
    }

    @Test
    public void testToEntity_WithEmptyStudentList() {
        Integer id = 1;
        String name = "Math";
        TeacherDto teacherDto = TeacherDto.builder()
                .id(2)
                .firstName("John")
                .lastName("Doe")
                .build();
        List<StudentDto> studentDtoList = new ArrayList<>();

        ClasseDto classeDto = new ClasseDto();
        classeDto.setId(id);
        classeDto.setName(name);
        //classeDto.setTeacher(teacherDto);
        classeDto.setStudent(studentDtoList);

        Classe classe = ClasseDto.toEntity(classeDto);

        Assertions.assertEquals(id, classe.getId());
        Assertions.assertEquals(name, classe.getName());
        Assertions.assertNotNull(classe.getTeacher());
        Assertions.assertEquals(teacherDto.getId(), classe.getTeacher().getId());
        Assertions.assertEquals(teacherDto.getFirstName(), classe.getTeacher().getFirstName());
        Assertions.assertEquals(teacherDto.getLastName(), classe.getTeacher().getLastName());
        Assertions.assertNotNull(classe.getStudent());
        Assertions.assertTrue(classe.getStudent().isEmpty());
    }
}
