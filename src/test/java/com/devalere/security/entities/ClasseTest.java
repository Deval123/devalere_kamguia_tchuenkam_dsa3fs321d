package com.devalere.security.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClasseTest {

    @Test
    public void testClasseCreation() {
        // Create test data
        Integer id = 1;
        String name = "Math";
        List<Student> students = new ArrayList<>();
        Teacher teacher = new Teacher();

        // Create Classe instance
        Classe classe = new Classe(id, name, students, teacher);

        // Assert values
        Assertions.assertEquals(id, classe.getId());
        Assertions.assertEquals(name, classe.getName());
        Assertions.assertEquals(students, classe.getStudent());
        Assertions.assertEquals(teacher, classe.getTeacher());
    }
}

