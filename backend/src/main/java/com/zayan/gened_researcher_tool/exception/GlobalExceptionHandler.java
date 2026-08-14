package com.zayan.gened_researcher_tool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

     @ExceptionHandler(InvalidTeacherNameException.class)
     public ResponseEntity<Map<String, String>> handleInvalidTeacherName(
             InvalidTeacherNameException ex) {

          return ResponseEntity
                  .status(HttpStatus.BAD_REQUEST)
                  .body(Map.of(
                          "error", "Bad Request",
                          "message", ex.getMessage()
                  ));
     }

     @ExceptionHandler(CourseNotFoundException.class)
     public ResponseEntity<Map<String, String>> handleCourseNotFound(
             CourseNotFoundException ex) {

          return ResponseEntity
                  .status(HttpStatus.NOT_FOUND)
                  .body(Map.of(
                          "error", "Not Found",
                          "message", ex.getMessage()
                  ));
     }
}