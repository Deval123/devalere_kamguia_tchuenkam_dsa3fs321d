package com.devalere.security.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrorCodesTest {

    @Test
    public void testErrorCodes() {
        Assertions.assertEquals(1000, ErrorCodes.STUDENT_NOT_FOUND.getCode());
        Assertions.assertEquals(1001, ErrorCodes.STUDENT_NOT_VALID.getCode());
        Assertions.assertEquals(1002, ErrorCodes.STUDENT_ALREADY_EXIST.getCode());
        Assertions.assertEquals(2000, ErrorCodes.TEACHER_NOT_FOUND.getCode());
        Assertions.assertEquals(2001, ErrorCodes.TEACHER_NOT_VALID.getCode());
        Assertions.assertEquals(2002, ErrorCodes.TEACHER_ALREADY_EXIST.getCode());
        Assertions.assertEquals(3000, ErrorCodes.USER_NOT_FOUND.getCode());
        Assertions.assertEquals(3001, ErrorCodes.USER_NOT_VALID.getCode());
        Assertions.assertEquals(3002, ErrorCodes.USER_ALREADY_EXIT.getCode());
        Assertions.assertEquals(4000, ErrorCodes.CLASS_NOT_VALID.getCode());
        Assertions.assertEquals(4001, ErrorCodes.CLASS_NOT_FOUND.getCode());
    }
}
