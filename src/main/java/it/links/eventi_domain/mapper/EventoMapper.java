package it.links.eventi_domain.mapper;

import it.links.eventi_domain.dto.EventoDTO;
import it.links.eventi_domain.entity.Evento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    EventoDTO toDTO(Evento evento);

    Evento toEntity(EventoDTO eventoDTO);

    List<EventoDTO> convertToDTOList(List<Evento> eventi);
}
