package org.nexus.Agenda_Personal.service;

import org.nexus.Agenda_Personal.entity.Contacto;
import org.nexus.Agenda_Personal.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactoService implements IContactoService{
    @Autowired
    private ContactoRepository contactoRepository;


    @Override
    public List<Contacto> listraContactos() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto buscarContactoPorNombre(String nombre) {
        return contactoRepository.findByNombre(nombre);
    }

    @Override
    public Contacto buscarContactoPorId(Integer codigo) {
        return contactoRepository.findById(codigo).orElse(null);
    }

    @Override
    public Contacto guardarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    // Este método es una forma de eliminar por objeto
    @Override
    public void eliminarContacto(Contacto contacto) {
        contactoRepository.delete(contacto);
    }
}