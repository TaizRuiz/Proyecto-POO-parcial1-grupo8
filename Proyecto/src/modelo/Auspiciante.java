
package modelo;

import admins.AdminAuspiciantes;

public class Auspiciante extends Persona{

    private String webpage;
    private String codAuspiciante;
    
    
    // constructores
    
    public Auspiciante(){
        super();
    }

    public Auspiciante(String n){
        super(n);
    }
    

    public Auspiciante(String n,String d,double t, String c,String e,String w){
        super(n,d,t,c,e);
        webpage=w;
        
    }
    
    // getters y setters

    public String getWebpage() {
        return webpage;
    }

    public String getCodAuspiciante() {
        return codAuspiciante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public void setCodAuspiciante(String codAuspiciante) {
        this.codAuspiciante = codAuspiciante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEmail(String email) {
        this.email = email;
    }
       
    
    // métodos

    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }

        if (obj !=null && obj instanceof Auspiciante){
            Auspiciante other= (Auspiciante) obj;
            return nombre.equals(other.nombre);
        }

        return false;
    }

    public static Auspiciante busquedaAuspiciante(String nombreAuspiciante){

        Auspiciante auspicianteBusqueda=new Auspiciante(nombreAuspiciante);
        Auspiciante auspicianteEncontrado= new Auspiciante();

        if (AdminAuspiciantes.arrAuspiciantes.contains(auspicianteBusqueda)){
            int indAuspiciante=AdminAuspiciantes.arrAuspiciantes.indexOf(auspicianteBusqueda);
            auspicianteEncontrado= AdminAuspiciantes.arrAuspiciantes.get(indAuspiciante);
        }

        return auspicianteEncontrado;
    }
    

    public String toString(){
        return "nombre: "+nombre+" código: "+codAuspiciante;
    }
    
}
