package it.links.eventi_domain.controller;

import it.links.eventi_domain.dto.EventoDTO;
import it.links.eventi_domain.service.impl.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/eventi")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/tutto")
    public ResponseEntity<List<EventoDTO>> getAll(){
        return eventoService.getAll();
    }

    @PostMapping("/crea-evento")
    public ResponseEntity<EventoDTO> creaEvento(@RequestBody EventoDTO eventoDTO){
        return eventoService.creaEvento(eventoDTO);
    }

    @PatchMapping("/modifica-evento/{id}")
    public ResponseEntity<EventoDTO> modificaEvento(@PathVariable Long id, @RequestBody EventoDTO eventoDTO){
        return eventoService.modificaEvento(id, eventoDTO);
    }

    @GetMapping("/cerca-evento/{dataEvento}")
    public ResponseEntity<List<EventoDTO>> cercaPerData(@PathVariable LocalDate dataEvento){
        return eventoService.cercaPerData(dataEvento);
    }

    @DeleteMapping("/elimina-evento/{id}")
    public ResponseEntity<Void> eliminaEvento(@PathVariable Long id){
        return eventoService.eliminaEvento(id);
    }

}
