package it.be.codingRace.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.be.codingRace.dto.CreateTicketResponseDTO;
import it.be.codingRace.exception.TicketException.Type;

@ControllerAdvice
public class TicketExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TicketException.class)
  public final ResponseEntity<CreateTicketResponseDTO> handleTicketException(TicketException ex) {
    Type type = ex.getType();

    ErrorMessageDTO errorMessage = new ErrorMessageDTO(type.toString(), ex.getMessage());

    return ResponseEntity.status(type.getStatus()).body(new CreateTicketResponseDTO(errorMessage));
  }
}
