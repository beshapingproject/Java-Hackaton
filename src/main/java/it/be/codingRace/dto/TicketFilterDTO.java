package it.be.codingRace.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TicketFilterDTO {

    private Date creationDateFrom;
    private Date creationDateTo;

}
