package com.yetgim.ecommerce.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.net.URISyntaxException;

public class BusinessProblemDetails extends ProblemDetail {

    public BusinessProblemDetails(String message) throws URISyntaxException {
        setDetail(message);
        setTitle("Business Exception");
        setStatus(HttpStatus.BAD_REQUEST);
        setInstance(new URI("http://localhost:8080/ecommerce.org/business"));
    }
}
