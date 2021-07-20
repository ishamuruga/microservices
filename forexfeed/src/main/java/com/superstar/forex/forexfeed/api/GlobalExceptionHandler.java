package com.superstar.forex.forexfeed.api;

import java.util.Date;

import com.superstar.forex.forexfeed.exception.NoForexFeedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler   {
    
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ NoForexFeedException.class})
    public ResponseEntity<ApiError> handlNoForexFeedException(Throwable cause) {

        ApiError apiErr = new ApiError();
        apiErr.setTs(new Date());
        apiErr.setDesc(cause.toString());
        apiErr.setApp("FX");

        logger.error(apiErr.toString(),cause);


        return new ResponseEntity<>(apiErr,HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler({ Exception.class})
    public ResponseEntity<ApiError> handleException(Throwable cause) {

        ApiError apiErr = new ApiError();
        apiErr.setTs(new Date());
        apiErr.setDesc(cause.toString());
        apiErr.setApp("FX");

        logger.error(apiErr.toString(),cause);


        return new ResponseEntity<>(apiErr,HttpStatus.BAD_GATEWAY);
    }

}
