package it.be.codingRace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "CUSTOMER")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
  @SequenceGenerator(name = "CUSTOMER_SEQ", allocationSize = 1)
  private Long id;

  private String name;

  private String surname;

  private String email;
}
