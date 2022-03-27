package it.be.codingRace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.*;

@Table(name = "TICKET")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_SEQ")
  @SequenceGenerator(name = "TICKET_SEQ", allocationSize = 1)
  private Long id;

  private String subject;

  private String content;
}
