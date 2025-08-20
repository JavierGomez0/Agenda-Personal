package org.nexus.Agenda_Personal.service;

import org.nexus.Agenda_Personal.entity.Contacto;
import org.nexus.Agenda_Personal.repository.ContactoRepository;

//Inyectar dependencia

//Componente de SpringBoot para crear aplicaciones
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactoService implements IContactoService {
    @Autowired
    private ContactoRepository contactoRepository;


    public List<Contacto> listarContacto() {
        List<Contacto> cliente = contactoRepository.findAll();
        return cliente;
    }

    public List<Contacto> buscarContactoPorNombre(String nombre) {
        return contactoRepository.findByNombre(String nombre);
    }

    public void guardarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    public void eliminarContacto(Contacto contacto) {
        contactoRepository.delete(contacto);

    }
}
