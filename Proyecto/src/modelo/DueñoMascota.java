
package modelo;


public class DueñoMascota extends Persona {
    
    public double cedulaIdentidad;
    public String apellido;

    public DueñoMascota(double cedulaIdentidad, String apellido, String nombre, String direccion, double telefono, Ciudad ciudad, String email) {
        super(nombre, direccion, telefono, ciudad, email);
        this.cedulaIdentidad = cedulaIdentidad;
        this.apellido = apellido;
    }
    

    
    

    
 

    
}
