package com.yetgim.ecommerce.exceptions.handler;


import com.yetgim.ecommerce.exceptions.httpProblemDetails.BusinessProblemDetails;
import com.yetgim.ecommerce.exceptions.httpProblemDetails.NotFoundProblemDetails;
import com.yetgim.ecommerce.exceptions.httpProblemDetails.ValidationProblemDetails;
import com.yetgim.ecommerce.exceptions.types.BusinessException;
import com.yetgim.ecommerce.exceptions.types.NotFoundException;
import com.yetgim.ecommerce.exceptions.types.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URISyntaxException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundProblemDetails> handleNotFoundException(NotFoundException exception) throws URISyntaxException {

        NotFoundProblemDetails details = new NotFoundProblemDetails(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BusinessProblemDetails> handleBusinessException(BusinessException exception) throws URISyntaxException {

        BusinessProblemDetails details = new BusinessProblemDetails(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
    }

    @ExceptionHandler(ValidationException.class)
    public  ResponseEntity<ValidationProblemDetails> handleValidation(ValidationException exception) throws URISyntaxException {

        ValidationProblemDetails details = new ValidationProblemDetails(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
    }
}
