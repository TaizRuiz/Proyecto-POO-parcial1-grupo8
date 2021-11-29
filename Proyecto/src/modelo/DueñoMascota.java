
package modelo;




public class DueñoMascota extends Persona {
    
    public double cedulaIdentidad;
    public String apellido;

    public DueñoMascota(double cedulaIdentidad, String apellido, String nombre, String direccion, double telefono, String ciudad, String email) {
        super(nombre, direccion, telefono, ciudad, email);
        this.cedulaIdentidad = cedulaIdentidad;
        this.apellido = apellido;
    }

    public DueñoMascota(String n,String d,double t, String c,String e){
        super(n, d, t, c, e);
    }

    public double getCedulaIdentidad() {
        return cedulaIdentidad;
    }

    public void setCedulaIdentidad(double cedulaIdentidad) {
        this.cedulaIdentidad = cedulaIdentidad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
    

    

