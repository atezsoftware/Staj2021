package com.atez.inventory.manager.exception;



import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus httpStatus, WebRequest webRequest) {
        final String path = webRequest.getDescription(false);

        List<String> validationErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " : " + error.getDefaultMessage())
                .collect(Collectors.toList());

        var signError = new CustomError.SignErrorBuilder()
                .withTimestamp(LocalDateTime.now())
                .withStatus(httpStatus.value())
                .withMessage(httpStatus.name())
                .withPath(path)
                .withDetail(validationErrors.toString())
                .withType(exception.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(signError, httpStatus);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(WebRequest webRequest, Exception exception) {
        var responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);
        final HttpStatus httpStatus = responseStatus!=null ? responseStatus.value() : HttpStatus.INTERNAL_SERVER_ERROR;
        final String localizedMessage = exception.getLocalizedMessage();
        final String path = webRequest.getDescription(false);
        final String message = responseStatus!=null ? localizedMessage : httpStatus.getReasonPhrase();

        var signError = new CustomError.SignErrorBuilder()
                .withTimestamp(LocalDateTime.now())
                .withStatus(httpStatus.value())
                .withMessage(message)
                .withPath(path)
                .withType(exception.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(signError, httpStatus);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleSignException(WebRequest webRequest, CustomException signException) {
        final String path = webRequest.getDescription(false);
      
        CustomError signError = new CustomError.SignErrorBuilder()
                .withTimestamp(LocalDateTime.now())
                .withStatus(signException.getErrorCode().getCode())
                .withMessage(signException.getErrorMessage())
                .withDetail(signException.getErrorDetail())
                .withPath(path)
                .withType(signException.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(signError, signException.getErrorCode().getHttpStatus());
    }


}
