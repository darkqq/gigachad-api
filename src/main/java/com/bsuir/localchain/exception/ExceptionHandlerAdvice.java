package com.bsuir.localchain.exception;

import com.bsuir.localchain.to.common.ErrorCommon;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorCommon handleTransferBusinessException(Exception exception) {
        return new ErrorCommon()
                .setMessage(exception.getMessage());
    }
}