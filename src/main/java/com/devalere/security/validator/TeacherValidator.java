package com.devalere.security.validator;

import com.devalere.security.dto.TeacherDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TeacherValidator {
    public static List<String> validate(TeacherDto teacherDto){
        List<String> errors = new ArrayList<>();
        if (teacherDto == null){
            errors.add("Please enter the teacher first name");
            errors.add("Please enter the teacher last name");
            return errors;
        }
        if (!StringUtils.hasLength(teacherDto.getFirstName())){
            errors.add("Please enter the teacher first name");
        }
        if (!StringUtils.hasLength(teacherDto.getLastName())){
            errors.add("Please enter the teacher last name");
        }
        return errors;
    }

}
