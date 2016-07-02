package ua.com.transportations.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by d.fedorov on 05.06.16.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Log log = LogFactory.getLog(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Something goes wrong, please contact support group")
    @ExceptionHandler(Exception.class)
    public void handleIOException(Exception e) {
        log.error(e.getMessage(), e);
    }
}
