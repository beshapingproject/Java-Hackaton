package it.be.codingRace.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AttachmentException extends Exception {

  /** */
  private static final long serialVersionUID = -3128719698316124298L;

  private Throwable cause;
  private String message;
  private Type type;

  public AttachmentException(String message, Type type) {
    super();
    this.message = message;
    this.type = type;
  }

  @AllArgsConstructor
  public static enum Type {
    INVALID_REQUEST(HttpStatus.BAD_REQUEST),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND),
    NULL_ATTACHMENT_ID(HttpStatus.BAD_REQUEST);

    @Getter @Setter private HttpStatus status;
  }
}
