package modelo;

import enums.Puesto;

public class Ganador {
    
    public String nombreGanador;
    public Premio premioGanador;
    public Puesto puestoGanador;

    public Ganador(String n,Premio p,Puesto pu){
        nombreGanador=n;
        premioGanador=p;
        puestoGanador=pu;
    }

    public String toString(){
        return puestoGanador+" lugar.- Nombre del ganador: "+nombreGanador+" Premio: "+premioGanador;
    }
}
