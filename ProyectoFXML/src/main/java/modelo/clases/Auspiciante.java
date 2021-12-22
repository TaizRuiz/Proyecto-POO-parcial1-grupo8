
package clases;

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

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public double getTelefono() {
        return telefono;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public void setCodAuspiciante(String codAuspiciante) {
        this.codAuspiciante = codAuspiciante;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
       
    
    // métodos 

    public static Auspiciante busquedaAuspiciante(String nombreAuspiciante){

        Auspiciante auspicianteBusqueda=new Auspiciante(nombreAuspiciante);
        Auspiciante auspicianteEncontrado= new Auspiciante();

        if (AdminAuspiciantes.arrAuspiciantes.contains(auspicianteBusqueda)){
            int indAuspiciante=AdminAuspiciantes.arrAuspiciantes.indexOf(auspicianteBusqueda);
            auspicianteEncontrado= AdminAuspiciantes.arrAuspiciantes.get(indAuspiciante);
        }

        return auspicianteEncontrado;
    }
    

    @Override
    public String toString(){
        return "nombre: "+nombre+" código: "+codAuspiciante;
    }
    
}
