package it.links.eventi_domain.service.impl;

import it.links.eventi_domain.dto.EventoDTO;
import it.links.eventi_domain.entity.Evento;
import it.links.eventi_domain.mapper.EventoMapper;
import it.links.eventi_domain.repository.EventoRepository;
import it.links.eventi_domain.service.api.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService implements IEventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoMapper eventoMapper;

    @Override
    public ResponseEntity<EventoDTO> creaEvento(EventoDTO eventoDTO){
        Evento evento = eventoMapper.toEntity(eventoDTO);
        Evento eventoDaSalvare = eventoRepository.save(evento);

        EventoDTO eventoDaConvertire = eventoMapper.toDTO(eventoDaSalvare);
        return ResponseEntity.ok(eventoDaConvertire);
    }

    @Override
    public ResponseEntity<EventoDTO> modificaEvento(Long id, EventoDTO eventoDTO){
        Optional<Evento> eventoDaCercare = eventoRepository.findById(id);
        if(eventoDaCercare.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Evento evento = eventoDaCercare.get();

        if (eventoDTO.getDataEvento() != null){
            evento.setDataEvento(eventoDTO.getDataEvento());
        }

        if (eventoDTO.getOraInizio() != null){
            evento.setOraInizio(eventoDTO.getOraInizio());
        }

        if (eventoDTO.getOraFine() != null){
            evento.setOraFine(eventoDTO.getOraFine());
        }

        if (eventoDTO.getIdStanza() != null){
            evento.setIdStanza(eventoDTO.getIdStanza());
        }

        if (eventoDTO.getDescrizione() != null){
            evento.setDescrizione(eventoDTO.getDescrizione());
        }

        Evento eventoAggiornato = eventoRepository.save(evento);
        EventoDTO eventoAggDTO = eventoMapper.toDTO(eventoAggiornato);
        return ResponseEntity.ok(eventoAggDTO);
    }

    @Override
    public ResponseEntity<List<EventoDTO>> getAll(){
        List<Evento> eventi = eventoRepository.findAll();
        List<EventoDTO> eventiDTO = eventoMapper.convertToDTOList(eventi);
        return ResponseEntity.ok(eventiDTO);
    }

    @Override
    public ResponseEntity<List<EventoDTO>> cercaPerData(LocalDate dataEvento){
        List<Evento> eventi = eventoRepository.findByDataEvento(dataEvento);

        if (eventi.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            List<EventoDTO> eventiDTO = eventoMapper.convertToDTOList(eventi);
            return ResponseEntity.ok(eventiDTO);
        }
    }

    @Override
    public ResponseEntity<Void> eliminaEvento(Long id){
        if (eventoRepository.existsById(id)){
            eventoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
