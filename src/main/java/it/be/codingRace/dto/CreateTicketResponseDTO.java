package it.be.codingRace.dto;

import it.be.codingRace.exception.ErrorMessageDTO;

public class CreateTicketResponseDTO {
  public static final String OK_STATUS = "OK";
  public static final String KO_STATUS = "KO";

  private String status;
  private Long ticketId;

  private ErrorMessageDTO errorMessage;

  public CreateTicketResponseDTO(Long ticketId) {
    super();
    this.status = OK_STATUS;
    this.ticketId = ticketId;
  }

  public CreateTicketResponseDTO(ErrorMessageDTO errorMessage) {
    super();
    this.status = KO_STATUS;
    this.errorMessage = errorMessage;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ErrorMessageDTO getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(ErrorMessageDTO errorMessage) {
    this.errorMessage = errorMessage;
  }
}
