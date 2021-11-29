package modelo;

public abstract class Persona {

    public String nombre;
    public String direccion;
    public double telefono;
    public String ciudad;
    public String email;

    public Persona(){}

    public Persona(String n){
        nombre=n;
    }

    public Persona(String nombre, String direccion, double telefono, String ciudad, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.email = email;
    }
    
    
    
    
}
