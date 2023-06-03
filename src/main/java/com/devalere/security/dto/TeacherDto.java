package com.devalere.security.dto;

import com.devalere.security.entities.Classe;
import com.devalere.security.entities.Teacher;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class TeacherDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private Classe classe;
    public static TeacherDto fromEntity(Teacher teacher){
        if(teacher == null){
            return null;
        }
        return TeacherDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .classe(teacher.getClasse())
                .build();
    }

    public static Teacher toEntity(TeacherDto teacherDto){
        if(teacherDto == null){
            return  null;
        }
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setClasse(teacherDto.getClasse());
        return teacher;
    }
}
