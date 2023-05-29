package com.devalere.security.handlers;

import com.devalere.security.utils.ErrorCodes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ErrorDtoTest {

    @Test
    public void testErrorDto() {
        Integer httpCode = 400;
        ErrorCodes code = ErrorCodes.STUDENT_NOT_FOUND;
        String message = "Student not found";
        List<String> errors = new ArrayList<>();
        errors.add("Error 1");
        errors.add("Error 2");

        ErrorDto errorDto = new ErrorDto(httpCode, code, message, errors);

        Assertions.assertEquals(httpCode, errorDto.getHttpCode());
        Assertions.assertEquals(code, errorDto.getCode());
        Assertions.assertEquals(message, errorDto.getMessage());
        Assertions.assertEquals(errors, errorDto.getErrors());
    }
}
