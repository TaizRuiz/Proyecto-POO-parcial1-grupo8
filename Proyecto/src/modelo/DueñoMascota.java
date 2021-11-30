
package modelo;

import admins.AdminDueños;


public class DueñoMascota extends Persona {
    
    private String cedulaIdentidad;
    private String apellido;
    
    
    // constructor
    
    public DueñoMascota(){}
    
    public DueñoMascota(String n){
        super(n);
    }
        
    public DueñoMascota(String cedulaIdentidad, String apellido, String nombre, String direccion, double telefono, String ciudad, String email) {
        super(nombre, direccion, telefono, ciudad, email);
        this.cedulaIdentidad = cedulaIdentidad;
        this.apellido = apellido;
    }

    // getters and setters

    public String getCedulaIdentidad() {
        return cedulaIdentidad;
    }

    public void setCedulaIdentidad(String cedulaIdentidad) {
        this.cedulaIdentidad = cedulaIdentidad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public double getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    // metodos
    
    
    
    public static DueñoMascota busquedaDueño(String nombreDueño){

        DueñoMascota dueñoBusqueda = new DueñoMascota(nombreDueño);
        DueñoMascota dueñoEncontrado = new DueñoMascota();

        if (AdminDueños.arrDueño.contains(dueñoBusqueda)){
            int indDueño = AdminDueños.arrDueño.indexOf(dueñoBusqueda);
            dueñoEncontrado = AdminDueños.arrDueño.get(indDueño);
        }else{
            System.out.println("Dueño no registrado");
        }

        return dueñoEncontrado;
    }

}
    

    

