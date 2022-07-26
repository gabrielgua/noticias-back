package com.gabriel.noticias.api.exception;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Problema.Campo> campos = new ArrayList<>();
        for (ObjectError error: ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            campos.add(new Problema.Campo(nome, message));
        }

        Problema erro = new Problema();
        erro.setStatus(status.value());
        erro.setDataHora(OffsetDateTime.now());
        erro.setTitulo("Validation Error");
        erro.setCampos(campos);

        return handleExceptionInternal(ex, erro, headers, status, request);
    }

    @ExceptionHandler(StandardError.class)
    public ResponseEntity<Object> handleDomainException(StandardError ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        Problema erro = new Problema();
        erro.setStatus(status.value());
        erro.setTitulo(ex.getMessage());
        erro.setDataHora(OffsetDateTime.now());

        return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);

    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Object> handleObjectNotFoundException(ObjectNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        Problema erro = new Problema();
        erro.setStatus(status.value());
        erro.setTitulo(ex.getMessage());
        erro.setDataHora(OffsetDateTime.now());

        return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        Problema erro = new Problema();
        erro.setStatus(status.value());
        erro.setTitulo(ex.getMessage());
        erro.setDataHora(OffsetDateTime.now());

        return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
    }













}
