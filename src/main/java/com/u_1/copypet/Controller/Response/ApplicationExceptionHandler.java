package com.u_1.copypet.Controller.Response;

import jakarta.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {

    List<Map<String, String>> errors = new ArrayList<>();

    //クラス全体のValidationエラー
    e.getBindingResult().getGlobalErrors().forEach(globalError -> {
      Map<String, String> error = new HashMap<>();
      error.put("entity", globalError.getObjectName());
      error.put("message", globalError.getDefaultMessage());
      errors.add(error);
    });

    //フィールドのValidationエラー
    e.getBindingResult().getFieldErrors().forEach(fieldError -> {
      Map<String, String> error = new HashMap<>();
      error.put("field", fieldError.getField());
      error.put("message", fieldError.getDefaultMessage());
      errors.add(error);
    });

    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "validation error",
        errors);
    return ResponseEntity.badRequest().body(errorResponse);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleUserNotFoundException(
      UserNotFoundException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
        "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(PetAlreadyExistsException.class)
  public ResponseEntity<Map<String, String>> handlePetAlreadyExistsException(
      PetAlreadyExistsException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()),
        "error", HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI());

    return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(PetNotFoundException.class)
  public ResponseEntity<Map<String, String>> handlePetNotFoundException(
      PetNotFoundException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
        "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BreedingNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleBreedingNotFoundException(
      BreedingNotFoundException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
        "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BreedingAlreadyExistsException.class)
  public ResponseEntity<Map<String, String>> handleBreedingAlreadyExistsException(
      BreedingAlreadyExistsException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()),
        "error", HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI());

    return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  public static final class ErrorResponse {

    private final HttpStatus status;
    private final String message;
    private final List<Map<String, String>> errors;

    public ErrorResponse(HttpStatus status, String message, List<Map<String, String>> errors) {
      this.status = status;
      this.message = message;
      this.errors = errors;
    }

    public HttpStatus getStatus() {
      return status;
    }

    public String getMessage() {
      return message;
    }

    public List<Map<String, String>> getErrors() {
      return errors;
    }
  }

}
