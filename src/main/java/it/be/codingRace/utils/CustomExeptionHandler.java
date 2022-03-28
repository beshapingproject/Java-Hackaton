package it.be.codingRace.utils;

import it.be.codingRace.exception.TicketException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExeptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException exception,
             HttpHeaders httpHeaders,
             HttpStatus httpStatus,
             WebRequest webRequest){

        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errors.add("'" + fieldError.getField() + "' field " + fieldError.getDefaultMessage());
        }

        TicketException ticketException = new TicketException("Validation failed: " + errors,
                TicketException.Type.INVALID_REQUEST);
        return new ResponseEntity(ticketException.getMessage(),  HttpStatus.BAD_REQUEST);
    }
}
