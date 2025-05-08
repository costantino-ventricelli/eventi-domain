package it.links.eventi_domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "eventi")
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(name = "ora_inizio")
    private LocalTime oraInizio;

    @Column(name = "ora_fine")
    private LocalTime oraFine;

    @Column(name = "id_stanza")
    private Long idStanza;

    private String descrizione;
}
