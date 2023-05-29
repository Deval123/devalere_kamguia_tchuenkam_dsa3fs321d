package com.devalere.security.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    @Test
    public void testTeacherCreation() {
        // Create test data
        Integer id = 1;
        String firstName = "John";
        String lastName = "Doe";
        Classe classe = new Classe();

        // Create Teacher instance
        Teacher teacher = new Teacher(id, firstName, lastName, classe);

        // Assert values
        Assertions.assertEquals(id, teacher.getId());
        Assertions.assertEquals(firstName, teacher.getFirstName());
        Assertions.assertEquals(lastName, teacher.getLastName());
        Assertions.assertEquals(classe, teacher.getClasse());
    }
}
