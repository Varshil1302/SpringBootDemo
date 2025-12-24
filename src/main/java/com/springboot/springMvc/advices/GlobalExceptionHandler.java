package com.springboot.springMvc.advices;

import com.springboot.springMvc.exception.ResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler
{

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiResponse<?>> handleResourece(ResourceNotFoundException ex)
  {
     ApiError apiError=ApiError.builder().httpStatus(HttpStatus.NOT_FOUND)
             .message(ex.getMessage()).build();
     return buildErrorResponse(apiError);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){

      List<String> subError=ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
      ApiError apiError=ApiError.builder().httpStatus(HttpStatus.BAD_REQUEST).message("Input is not valid").subErrors(subError).build();
      return buildErrorResponse(apiError);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<?>> handleException(Exception ex)
  {
      ApiError apiError=ApiError.builder().httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).message(ex.getMessage()).build();

      return buildErrorResponse(apiError);
  }

  private ResponseEntity<ApiResponse<?>> buildErrorResponse(ApiError apiError)
  {
       return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getHttpStatus());
  }

}
