package modelo.clases;

import java.io.Serializable;
import modelo.enums.Puesto;
import java.util.Random;

public class Ganador implements Serializable{
    
    private String nombreGanador;
    private Premio premioGanador;
    private Puesto puestoGanador;
    private static final long serialVersionUID = 5555;

    
    // constructor
    
    public Ganador(String n,Premio p,Puesto pu){
        nombreGanador=n;
        premioGanador=p;
        puestoGanador=pu;
    }

    
    // getters and setters

    public String getNombreGanador() {
        return nombreGanador;
    }

    public void setNombreGanador(String nombreGanador) {
        this.nombreGanador = nombreGanador;
    }

    public Premio getPremioGanador() {
        return premioGanador;
    }

    public void setPremioGanador(Premio premioGanador) {
        this.premioGanador = premioGanador;
    }

    public Puesto getPuestoGanador() {
        return puestoGanador;
    }

    public void setPuestoGanador(Puesto puestoGanador) {
        this.puestoGanador = puestoGanador;
    }
    
    
    // metodos

    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }

        if (obj !=null && obj instanceof Ganador){
            Ganador other= (Ganador) obj;
            return nombreGanador.equals(other.nombreGanador);
        }

        return false;
    }
    
    
    @Override
    public String toString(){
        return puestoGanador+" lugar.- Nombre del ganador: "+nombreGanador+" Premio: "+premioGanador;
    }
}
