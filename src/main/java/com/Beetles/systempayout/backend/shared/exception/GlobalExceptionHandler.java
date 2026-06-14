package com.Beetles.systempayout.backend.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail handleAccessDenied(AccessDeniedException ex) {
        ProblemDetail problemDetail =  ProblemDetail.forStatusAndDetail(
                HttpStatus.FORBIDDEN,
                "Acesso negado."
        );
        problemDetail.setInstance(null);
        problemDetail.setType(java.net.URI.create("about:blank"));
        return problemDetail;
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ProblemDetail IdNotFoundHandler(IdNotFoundException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                e.getMessage()
        );

        problemDetail.setInstance(null);
        problemDetail.setInstance(java.net.URI.create("about:blank"));
        return problemDetail;
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ProblemDetail EmailNotFoundHandler(EmailNotFoundException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                e.getMessage()
        );

        problemDetail.setInstance(null);
        problemDetail.setType(java.net.URI.create("about:blank"));
        return problemDetail;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ProblemDetail handleUsernameNotFound(UsernameNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNAUTHORIZED,
                "Email ou senha incorretos."
        );

        problemDetail.setInstance(null);
        problemDetail.setType(java.net.URI.create("about:blank"));
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGeneric(Exception ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected internal server error occurred."
        );

        problemDetail.setInstance(null);
        problemDetail.setType(java.net.URI.create("about:blank"));
        return problemDetail;
    }

    @ExceptionHandler(PaymentNotMadeException.class)
    public ProblemDetail handlePaymentNotMade(Exception ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );

        problemDetail.setInstance(null);
        problemDetail.setType(java.net.URI.create("about:blank"));
        return problemDetail;
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ProblemDetail handleBadCredentials(BadCredentialsException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNAUTHORIZED,
                "Email ou senha incorretos."
        );

        problemDetail.setInstance(null);
        problemDetail.setType(java.net.URI.create("about:blank"));
        return problemDetail;
    }

}
