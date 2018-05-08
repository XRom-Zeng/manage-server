package com.xrom.server.config;

import com.xrom.server.code.ResponseCode;
import com.xrom.server.response.WebResponse;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import static com.xrom.server.response.WebResponse.error;

/**
 * configuration global exception handler
 * @author XRom
 * @date 2018-02-07 19-41
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(UnknownAccountException.class)
    public WebResponse unknownAccountException(UnknownAccountException e) {
        logger.error(e.getMessage());
        return error(ResponseCode.UNKNOWN_ACCOUNT);
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public WebResponse incorrectCredentialsException(IncorrectCredentialsException e) {
        logger.error(e.getMessage());
        return error(ResponseCode.INCORRECT_CREDENTIALS);
    }

    @ExceptionHandler(Exception.class)
    public WebResponse exceptionHandler(Exception e) {
        logger.error(e.getMessage());
        return error();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public WebResponse noHandlerFoundException(NoHandlerFoundException e) {
        logger.error("The requested resource is not available:\t method: " + e.getHttpMethod() + "\turl: " + e.getRequestURL());
        return error(ResponseCode.NO_HANDLER_FOUND);
    }
}
