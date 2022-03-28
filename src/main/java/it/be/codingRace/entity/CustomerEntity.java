package it.be.codingRace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne private TicketEntity ticketEntity;

}
