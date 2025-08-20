package org.nexus.Agenda_Personal.service;

import org.nexus.Agenda_Personal.entity.Contacto;
import java.util.List;

public interface IContactoService {
    public List<Contacto> listraContactos();
    public Contacto buscarContactoPorId (Integer codigo);
    public Contacto buscarContactoPorNombre (String nombre);
    public void guardarContacto (Contacto contacto);
    public void eliminarContacto (Contacto contacto);
}
