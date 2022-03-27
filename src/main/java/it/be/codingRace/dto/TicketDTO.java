package it.be.codingRace.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class TicketDTO implements Serializable {
  /** */
  private static final long serialVersionUID = 832598692666554292L;

  @NotEmpty(message = "subject must not be empty")
  private String subject;

  @NotEmpty(message = "content must not be empty")
  private String content;

  public TicketDTO(String subject, String content) {
    super();
    this.subject = subject;
    this.content = content;
  }

  public TicketDTO() {
    super();
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
