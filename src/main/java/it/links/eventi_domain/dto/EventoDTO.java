package it.links.eventi_domain.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventoDTO {
    private Long id;
    private LocalDate dataEvento;
    private LocalTime oraInizio;
    private LocalTime oraFine;
    private Long idStanza;
    private String descrizione;
}
