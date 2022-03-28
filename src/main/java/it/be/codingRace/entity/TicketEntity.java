package it.be.codingRace.entity;

import javax.persistence.*;

import lombok.*;

import java.util.Date;
import java.util.List;

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

  private String subCategory;

  private String status;

  private Date created;

  private Date updated;

  @OneToMany private List<AttachmentEntity> attachmentEntityList;

}
