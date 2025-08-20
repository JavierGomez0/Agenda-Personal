package org.nexus.Agenda_Personal.repository;

import org.nexus.Agenda_Personal.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Integer>{
    Contacto findByNombre(String nombre);
}
