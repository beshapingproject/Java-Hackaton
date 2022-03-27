package it.be.codingRace.exception;

import org.springframework.http.HttpStatus;

public class TicketException extends Exception {

  /** */
  private static final long serialVersionUID = -3128719698316124298L;

  private Throwable cause;
  private String message;
  private Type type;

  public TicketException(Throwable cause, String message, Type type) {
    super();
    this.cause = cause;
    this.message = message;
    this.type = type;
  }

  public TicketException(String message, Type type) {
    super();
    this.message = message;
    this.type = type;
  }

  public Throwable getCause() {
    return cause;
  }

  public String getMessage() {
    return message;
  }

  public Type getType() {
    return type;
  }

  public static enum Type {
    INVALID_REQUEST(HttpStatus.BAD_REQUEST);

    private HttpStatus status;

    private Type(HttpStatus status) {
      this.status = status;
    }

    public HttpStatus getStatus() {
      return status;
    }

    public void setStatus(HttpStatus status) {
      this.status = status;
    }
  }
}
