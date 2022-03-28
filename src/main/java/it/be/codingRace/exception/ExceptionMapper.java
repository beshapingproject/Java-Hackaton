package it.be.codingRace.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.be.codingRace.dto.TicketResponseDTO;
import it.be.codingRace.dto.UploadAttachmentResponseDTO;
import it.be.codingRace.utils.JsonResponseBody;

@ControllerAdvice
public class ExceptionMapper extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TicketException.class)
  public final ResponseEntity<JsonResponseBody> handleTicketException(TicketException ex) {
    TicketException.Type type = ex.getType();

    ErrorMessageDTO errorMessage = new ErrorMessageDTO(type.toString(), ex.getMessage());

    return ResponseEntity.status(type.getStatus())
        .body(
            new JsonResponseBody(
                type.getStatus().value(), new TicketResponseDTO(errorMessage)));
  }

  @ExceptionHandler(AttachmentException.class)
  public final ResponseEntity<JsonResponseBody> handleAttachmentException(AttachmentException ex) {
    AttachmentException.Type type = ex.getType();

    ErrorMessageDTO errorMessage = new ErrorMessageDTO(type.toString(), ex.getMessage());

    return ResponseEntity.status(type.getStatus())
        .body(
            new JsonResponseBody(
                type.getStatus().value(), new UploadAttachmentResponseDTO(errorMessage)));
  }
}
