package com.devalere.security.exception;

import com.devalere.security.utils.ErrorCodes;
import lombok.Getter;

public class InvalidOperationException extends RuntimeException{

    @Getter
    private ErrorCodes errorCodes;
    public InvalidOperationException(String msg){
        super(msg);
    }
    public InvalidOperationException(String msg, Throwable cause){
        super(msg, cause);
    }

    public InvalidOperationException(String msg, Throwable cause, ErrorCodes errorCodes){
        super(msg, cause);
        this.errorCodes = errorCodes;
    }

    public InvalidOperationException(String msg,ErrorCodes errorCodes){
        super(msg);
        this.errorCodes = errorCodes;
    }

}
