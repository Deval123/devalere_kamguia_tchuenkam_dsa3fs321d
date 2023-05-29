package com.devalere.security.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void testStudentCreation() {
        // Create test data
        Integer id = 1;
        String firstName = "John";
        String lastName = "Doe";
        Classe classe = new Classe();

        // Create Student instance
        Student student = new Student(id, firstName, lastName, classe);

        // Assert values
        Assertions.assertEquals(id, student.getId());
        Assertions.assertEquals(firstName, student.getFirstName());
        Assertions.assertEquals(lastName, student.getLastName());
        Assertions.assertEquals(classe, student.getClasse());
    }
}

