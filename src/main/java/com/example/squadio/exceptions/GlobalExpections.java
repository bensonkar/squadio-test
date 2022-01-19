package com.example.squadio.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bkariuki
 */
@RestControllerAdvice
@Slf4j
public class GlobalExpections {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleInternalServerErrors(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("message", "Sorry something went wrong.Please try again later.");
        map.put("data", null);
        map.put("timeStamp", new Date().getTime());
        log.info("internal server errors occurred " + e.getMessage());
        return new ResponseEntity(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
