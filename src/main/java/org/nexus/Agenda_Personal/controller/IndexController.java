package org.nexus.Agenda_Personal.controller;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.nexus.Agenda_Personal.entity.Contacto;
import org.nexus.Agenda_Personal.service.IContactoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;
//import jakarta.faces.view.ViewScoped;

import java.util.List;

//Componente generico
@Component
//alcance de tipo View
//@ViewScoped
//Gettter y Setter
@Data

public class IndexController {

    @Autowired
    IContactoService contactoService;
            private List<Contacto> contactos;
            private Contacto contactoSeleccionado;
            private static Logger logger = LoggerFactory.getLogger(IndexController.class);

            @PostConstruct
    public void init(){
                cargarDatos();
            }

            public void cargarDatos (){
                this.contactos = this.contactoService.listraContactos();
                this.contactos.forEach(contacto -> logger.info(contacto.toString()));
            }

            public void agregarContacto(){
                this.contactoSeleccionado = new Contacto();
            }

            public void guardarCliente(){
                logger.info("Contacto a guardar" + this.contactoSeleccionado);
                if (this.contactoSeleccionado.getCodigoContactos() ==null){
                    this.contactoService.guardarContacto(this.contactoSeleccionado);
                    this.contactos.add(this.contactoSeleccionado);
                    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("contacto agrgado"));
                }
                else{
                    this.contactoService.guardarContacto(this.contactoSeleccionado);
                    FacesContext.getCurrentInstance().addMesaage(null, new FacesMessage(cliente actualizado));
                }
                //ocultar la ventana modal
                PrimeFaces.current().executeScript("PF('ventanaModalContacto').show()");

                //Actualizar tabla utilizando tecnología incorporada - AJAX -
                PrimeFaces.current().ajax().update("formulario-contacto:mensaje-emergente", "formulario-contacto:tabla-contacto");

                //Limpiar el objeto cliente seleccionado
                this.clienteSeleccionado = null;
            }
                 public void eliminarCliente(){
                 logger.info("Cliente a eliminar: " + this.contactoSeleccionado);
                    this.contactoService.eliminarContacto(this.contactoSeleccionado);

                    //Eliminar el registro de la lista de clientes
                  this.contactos.remove(this.contactoSeleccionado);

                    //Reiniciar el objeto cliente seleccionado
                     this.contactoSeleccionado = null;

                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contacto eliminado"));
                     PrimeFaces.current().ajax().update("formulario-contacto:mensaje-emergente", "formulario-contacto:tabla-contacto");
    }
}
