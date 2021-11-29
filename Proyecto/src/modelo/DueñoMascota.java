
package modelo;


public class DueñoMascota extends Persona {
    
    private double cedulaIdentidad;
    private String apellido;
    
    
    // constructor
    
    public DueñoMascota(String n){
        super(n);
    }
        
    public DueñoMascota(double cedulaIdentidad, String apellido, String nombre, String direccion, double telefono, String ciudad, String email) {
        super(nombre, direccion, telefono, ciudad, email);
        this.cedulaIdentidad = cedulaIdentidad;
        this.apellido = apellido;
    }

    public DueñoMascota(String n,String d,double t, String c,String e){
        super(n, d, t, c, e);
    }
    
    
    // getters and setters

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

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
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
