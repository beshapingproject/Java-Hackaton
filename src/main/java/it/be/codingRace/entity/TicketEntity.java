package it.be.codingRace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TICKET")
@Entity
public class TicketEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_SEQ")
  @SequenceGenerator(name = "TICKET_SEQ", allocationSize = 1)
  private Long id;

  private String subject;

  private String content;

  public TicketEntity(String subject, String content) {
    super();
    this.subject = subject;
    this.content = content;
  }

  public TicketEntity() {
    super();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
