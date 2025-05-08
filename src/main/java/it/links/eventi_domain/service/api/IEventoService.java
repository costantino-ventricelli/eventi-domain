package it.links.eventi_domain.service.api;

import it.links.eventi_domain.dto.EventoDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IEventoService {
    ResponseEntity<EventoDTO> creaEvento(EventoDTO eventoDTO);

    ResponseEntity<EventoDTO> modificaEvento(Long id, EventoDTO eventoDTO);

    ResponseEntity<List<EventoDTO>> getAll();

    ResponseEntity<List<EventoDTO>> cercaPerData(LocalDate dataEvento);

    ResponseEntity<Void> eliminaEvento(Long id);
}
