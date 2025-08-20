package org.nexus.Agenda_Personal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Entity (name = "Contactos" )
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoContactos;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private Integer edad;

    public Contacto(Integer codigoContactos) {
        this.codigoContactos = codigoContactos;
    }

    public Contacto(Integer codigoContactos, String correo, String telefono, String nombre, String apellido, Integer edad) {
        this.codigoContactos = codigoContactos;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getCodigoContactos() {
        return codigoContactos;
    }

    public void setCodigoContactos(Integer codigoContactos) {
        this.codigoContactos = codigoContactos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "codigoContactos=" + codigoContactos +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                '}';
    }
}
