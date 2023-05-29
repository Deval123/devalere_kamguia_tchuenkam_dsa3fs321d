package com.devalere.security.dto;

import com.devalere.security.entities.Classe;
import com.devalere.security.entities.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ClasseDto {
    private Integer id;

    private  String name;

    private Teacher teacher;

    @JsonIgnore
    private List<StudentDto> student;

    public ClasseDto(Integer id, String name, Teacher teacher, List<StudentDto> student) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.student = student;
    }

    public ClasseDto() {

    }

    public static ClasseDto fromEntity(Classe classe){
        if(classe == null){
            return null;
        }
        return ClasseDto.builder()
                .id(classe.getId())
                .name(classe.getName())
                .teacher(classe.getTeacher())
                .build();
    }

    public static Classe toEntity(ClasseDto classeDto){
        if(classeDto == null){
            return  null;
        }
        Classe classe = new Classe();
        classe.setId(classeDto.getId());
        classe.setName(classeDto.getName());
        classe.setTeacher(classeDto.getTeacher());
        return classe;
    }

}
