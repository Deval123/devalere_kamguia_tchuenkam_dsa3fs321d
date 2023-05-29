package com.devalere.security.validator;

import com.devalere.security.dto.StudentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentValidator {
    public static List<String> validate(StudentDto studentDto){
        List<String> errors = new ArrayList<>();
        if (studentDto == null){
            errors.add("Please enter the student first name");
            errors.add("Please enter the student last name");
            return errors;
        }
        if (!StringUtils.hasLength(studentDto.getFirstName())){
            errors.add("Please enter the student first name");
        }
        if (!StringUtils.hasLength(studentDto.getLastName())){
            errors.add("Please enter the student last name");
        }
        return errors;
    }

}
