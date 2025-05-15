package com.yetgim.ecommerce.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.net.URISyntaxException;

public class ValidationProblemDetails extends ProblemDetail {

    public ValidationProblemDetails(String message) throws URISyntaxException {
        setDetail(message);
        setTitle("Validation Exception");
        setStatus(HttpStatus.BAD_REQUEST);
        setInstance(new URI("http://localhost:8080/ecommerce.org/validation"));

    }
}
