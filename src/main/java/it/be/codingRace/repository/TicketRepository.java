package it.be.codingRace.repository;


import org.springframework.stereotype.Repository;

import it.be.codingRace.entity.TicketEntity;

@Repository
public interface TicketRepository extends GenericRepository<TicketEntity, Long> {}
