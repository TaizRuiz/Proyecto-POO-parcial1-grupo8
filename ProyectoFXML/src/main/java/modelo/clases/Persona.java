package modelo.clases;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable{

    public String nombre;
    public String direccion;
    public String telefono;
    public String ciudad;
    public String email;
    private static final long serialVersionUID = 7777;

    public Persona(){}

    public Persona(String n){
        nombre=n;
    }

    public Persona(String nombre, String direccion, String telefono, String ciudad, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
}