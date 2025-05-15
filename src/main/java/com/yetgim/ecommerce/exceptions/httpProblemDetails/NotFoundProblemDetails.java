package com.yetgim.ecommerce.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.net.URISyntaxException;

public class NotFoundProblemDetails extends ProblemDetail {

    public NotFoundProblemDetails(String message) throws URISyntaxException {
        setDetail(message);
        setTitle("Not Found Exception");
        setStatus(HttpStatus.NOT_FOUND);
        setInstance(new URI("http://localhost:8080/ecommerce.org/notfound"));
    }
}
