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

@SpringBootApplication
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
		logger.info("+++++Bienvenido a la aplicacion de Registro de Cliente++++");
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
             3. Modificar contacto
             4. Eliminar contacto
             5. Salir
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
				String nombre = consola.nextLine();
				Contacto contacto = contactoService.buscarContactoPorNombre(nombre);
				if (contacto != null) {
					logger.info("Contacto encontrado: " + contacto.getNombre() + salto);
				} else {
					logger.info("Contacto no encontrado" + salto);
				}
			}


			case 3 -> {
				//Buscar por codigo
				logger.info("Agregue el codigo del contacto a modificar");
				var codigo = Integer.parseInt(consola.nextLine());
				Contacto cliente = contactoService.buscarContactoPorId(codigo);
				//Guardar si no es null
				if (cliente != null){
					logger.info("Ingrese el nombre del cliente a agregar: ");
					var nombre = consola.nextLine();
					logger.info("Ingrese el apellido del cliente a agregar: ");
					var apellido = consola.nextLine();
					logger.info("Ingrese el telefono del cliente a agregar: ");
					var telefono = consola.nextLine();
					logger.info("Ingrese el correo del cliente a agregar: ");
					var correo = consola.nextLine();
					logger.info("Ingrese el genero del cliente a agregar: ");
					var genero = consola.nextLine();
					logger.info("Ingrese la edad del cliente a agregar: ");
					var edad = Integer.parseInt(consola.nextLine());
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setTelefono(telefono);
					cliente.setCorreo(correo);
					cliente.setGenero(genero);
					cliente.setEdad(edad);
					clienteService.guardarCliente(cliente);
					logger.info("Cliente modificado con exito: " + cliente+salto);
				} else {
					logger.info("Cliente no encontrado");
				}
			}
			case 4 -> {
				logger.info(salto + "***Eliminar Cliente***"+salto);
				logger.info("Ingrese el codigo del cliente a eliminar");
				var codigo = Integer.parseInt(consola.nextLine());
				var cliente = clienteService.buscarClientePorId(codigo);
				if (cliente !=null){
					clienteService.eliminarCliente(cliente);
					logger.info("Cliente eliminado, adiosito");
				} else {
					logger.info("Cliente no encontrado " +cliente+salto);
				}
			}
			case 5 -> {
				logger.info("Hasta la vista, Beibi" + salto + salto);
				salir = true;
			}
			default -> logger.info("Opcion invalida");
		}
		return false;


	}

}