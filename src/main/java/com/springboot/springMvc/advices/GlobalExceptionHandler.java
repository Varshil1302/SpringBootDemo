package com.springboot.springMvc.advices;

import com.springboot.springMvc.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiError> handleResourece(ResourceNotFoundException ex)
  {
     ApiError apiError=ApiError.builder().httpStatus(HttpStatus.NOT_FOUND)
             .message(ex.getMessage()).build();
     return ResponseEntity.ok(apiError);
  }

}
