package it.links.eventi_domain.repository;

import it.links.eventi_domain.entity.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {

    List<Evento> findAll();

    List<Evento> findByDataEvento(LocalDate dataEvento);

}
