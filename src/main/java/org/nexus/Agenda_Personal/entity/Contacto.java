package org.nexus.Agenda_Personal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;

@Entity (name = "Contactos" )

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_contactos;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;


    public Integer getCodigoContactos() { return codigo_contactos; }
    public void setCodigoContactos(Integer codigoContactos) { this.codigo_contactos = codigoContactos; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}

