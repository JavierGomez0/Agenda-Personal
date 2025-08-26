package org.nexus.Agenda_Personal;

import java.util.List;
import java.util.Scanner;

import org.nexus.Agenda_Personal.entity.Contacto;
import org.nexus.Agenda_Personal.service.ContactoService;
import org.nexus.Agenda_Personal.service.IContactoService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class AgendaPersonalApplication implements CommandLineRunner {

	@Autowired
	private IContactoService contactoService;

	private static final Logger logger = LoggerFactory.getLogger(AgendaPersonalApplication.class);

	String salto=System.lineSeparator();

	public static void main(String[] args){
		logger.info("iniciando la aplicacion");
		SpringApplication.run(AgendaPersonalApplication.class, args);
		logger.info("Aplicacion finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		AgendaPersonalApp();
	}

	private void AgendaPersonalApp(){
		logger.info("+++++Bienvenido a la aplicacion de Agensa de Contactos++++");
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola,opcion);
			logger.info(salto);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
             ***Aplicacion***
             1. Listar contacto
             2. Buscar contacto
             3.Crear contacto
             4. Modificar contacto
             5. Eliminar contacto
             6. Salir
             """);
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){
			case 1 -> {
				logger.info(salto+"***Lista de contacto***"+salto);
				List<Contacto> contactos = contactoService.listraContactos();
				contactos.forEach(contacto -> logger.info(contacto.toString()+salto));
			}

			case 2 -> {
				logger.info(salto + "***Buscar contacto por su nombre***" + salto);
                logger.info("Ingrese el nombre a buscar: ");
                String nombre = consola.nextLine();
                Contacto contacto = contactoService.buscarContactoPorNombre(nombre);
                if (contacto != null) {
                    logger.info("Contacto encontrado: " + contacto + salto);
                } else {
                    logger.info("Contacto no encontrado" + salto);
                }
            }

			case 3 -> {
                logger.info(salto + "*** Crear nuevo contacto ***" + salto);
                Contacto contacto = new Contacto( );
                logger.info("Ingrese el nombre: ");
                contacto.setNombre(consola.nextLine());
                logger.info("Ingrese el apellido: ");
                contacto.setApellido(consola.nextLine());
                logger.info("Ingrese el teléfono: ");
                contacto.setTelefono(consola.nextLine());
                logger.info("Ingrese el correo: ");
                contacto.setCorreo(consola.nextLine());
                contactoService.guardarContacto(contacto);
                logger.info("Contacto creado con éxito: " + contacto + salto);
            }

			case 4 -> {
                logger.info(salto + "*** Modificar contacto ***" + salto);
                logger.info("Ingrese el código del contacto a modificar: ");
                int codigo = Integer.parseInt(consola.nextLine());
                Contacto contacto = contactoService.buscarContactoPorId(codigo);
                if (contacto != null){
                    logger.info("Ingrese el nuevo nombre: ");
                    contacto.setNombre(consola.nextLine());
                    logger.info("Ingrese el nuevo apellido: ");
                    contacto.setApellido(consola.nextLine());
                    logger.info("Ingrese el nuevo teléfono: ");
                    contacto.setTelefono(consola.nextLine());
                    logger.info("Ingrese el nuevo correo: ");
                    contacto.setCorreo(consola.nextLine());
                    contactoService.guardarContacto(contacto);
                    logger.info("Contacto modificado con éxito: " + contacto + salto);
                } else {
                    logger.info("Contacto no encontrado" + salto);
                }
            }

            case 5 -> {
                logger.info(salto + "*** Eliminar contacto ***" + salto);
                logger.info("Ingrese el código del contacto a eliminar: ");
                int codigo = Integer.parseInt(consola.nextLine());
                Contacto contacto = contactoService.buscarContactoPorId(codigo);
                if (contacto != null){
                    contactoService.eliminarContacto(contacto);
                    logger.info("Contacto eliminado con éxito." + salto);
                } else {
                    logger.info("Contacto no encontrado" + salto);
                }
            }

			case 6 -> {
				logger.info("Hasta la vista, Beibi" + salto + salto);
				salir = true;
			}
			default -> logger.info("Opcion invalida");
		}
		return false;


	}

}