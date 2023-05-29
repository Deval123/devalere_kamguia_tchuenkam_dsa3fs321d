package com.devalere.security.validator;

import com.devalere.security.dto.ClasseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClasseValidator {

    public static List<String> validate(ClasseDto classeDto){
        List<String> errors = new ArrayList<>();
        if (classeDto == null){
            errors.add("Please enter the class name");
            return errors;
        }

        if (!StringUtils.hasLength(classeDto.getName())){
            errors.add("Please enter the class name");
        }
        return errors;
    }

}
