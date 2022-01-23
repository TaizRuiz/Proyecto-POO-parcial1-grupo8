package modelo.clases;

import java.io.Serializable;
import modelo.enums.Puesto;

public class Premio implements Serializable{
    private Puesto puesto;
    private String descripcion;
    private Auspiciante auspiciante;
    private static final long serialVersionUID = 9999;
    
    
    // constructor
    
    public Premio(Puesto p, String d,Auspiciante a){
        puesto=p;
        descripcion=d;
        auspiciante=a;
    }

    
    // getters and setters

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Auspiciante getAuspiciante() {
        return auspiciante;
    }

    public void setAuspiciante(Auspiciante auspiciante) {
        this.auspiciante = auspiciante;
    }
    
    
    // metodos
    
   
    @Override
    public String toString(){
        return descripcion;
    }

     
}
