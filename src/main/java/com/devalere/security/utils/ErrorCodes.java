package com.devalere.security.utils;

public enum ErrorCodes {

    STUDENT_NOT_FOUND(1000),

    STUDENT_NOT_VALID(1001),

    STUDENT_ALREADY_EXIST(1002),

    TEACHER_NOT_FOUND(2000),

    TEACHER_NOT_VALID(2001),

    TEACHER_ALREADY_EXIST(2002),

    USER_NOT_FOUND(3000),
    USER_NOT_VALID(3001),
    USER_ALREADY_EXIT(3002),
    BAD_CREDENTIALS(3003),
    CLASS_NOT_VALID(4000),
    CLASS_NOT_FOUND(4001);


    private  int code;
    ErrorCodes(int code){
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
