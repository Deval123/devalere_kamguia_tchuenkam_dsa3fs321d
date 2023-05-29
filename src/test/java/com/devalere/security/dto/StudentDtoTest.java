package com.devalere.security.dto;

import com.devalere.security.entities.Classe;
import com.devalere.security.entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentDtoTest {

    @Test
    public void testFromEntity() {
        Integer id = 1;
        String firstName = "John";
        String lastName = "Doe";
        Classe classe = new Classe();
        classe.setId(2);
        classe.setName("Math");

        Student student = new Student();
        student.setId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setClasse(classe);

        StudentDto studentDto = StudentDto.fromEntity(student);

        Assertions.assertEquals(id, studentDto.getId());
        Assertions.assertEquals(firstName, studentDto.getFirstName());
        Assertions.assertEquals(lastName, studentDto.getLastName());
        Assertions.assertNotNull(studentDto.getClasse());
        Assertions.assertEquals(classe.getId(), studentDto.getClasse().getId());
        Assertions.assertEquals(classe.getName(), studentDto.getClasse().getName());
    }

    @Test
    public void testToEntity() {
        Integer id = 1;
        String firstName = "John";
        String lastName = "Doe";
        ClasseDto classeDto = ClasseDto.builder()
                .id(2)
                .name("Math")
                .build();

        StudentDto studentDto = new StudentDto();
        studentDto.setId(id);
        studentDto.setFirstName(firstName);
        studentDto.setLastName(lastName);
        studentDto.setClasse(classeDto);

        Student student = StudentDto.toEntity(studentDto);

        Assertions.assertEquals(id, student.getId());
        Assertions.assertEquals(firstName, student.getFirstName());
        Assertions.assertEquals(lastName, student.getLastName());
        Assertions.assertNotNull(student.getClasse());
        Assertions.assertEquals(classeDto.getId(), student.getClasse().getId());
        Assertions.assertEquals(classeDto.getName(), student.getClasse().getName());
    }
}
