package com.devalere.security.dto;

import com.devalere.security.entities.Student;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class StudentDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private ClasseDto classe;

    public StudentDto() {
    }

    public StudentDto(Integer id, String firstName, String lastName, ClasseDto classe) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classe = classe;
    }

    public static StudentDto fromEntity(Student student){
        if(student == null){
            return null;
        }
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .classe(ClasseDto.fromEntity(student.getClasse()))
                .build();
    }

    public static Student toEntity(StudentDto studentDto){
        if(studentDto == null){
            return  null;
        }
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setClasse(ClasseDto.toEntity(studentDto.getClasse()));
        return student;
    }

}
