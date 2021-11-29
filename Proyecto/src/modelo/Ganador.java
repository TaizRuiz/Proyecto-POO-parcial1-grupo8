package modelo;

import enums.Puesto;
import java.util.*;

public class Ganador {
    
    private String nombreGanador;
    private Premio premioGanador;
    private Puesto puestoGanador;

    
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
    
    public static void generarGanadores(Concurso concursoFinalizar){
        for(int i=0;i<3;i++){

            Random rand=new Random();

            int indAleatorio= rand.nextInt(concursoFinalizar.getParticipantes().size()-1);
            Mascota mascotaGanadora=concursoFinalizar.getParticipantes().get(indAleatorio);
            Premio premio=concursoFinalizar.getPremio()[i];
            Puesto puesto=Puesto.values()[i];

            Ganador ganador= new Ganador(mascotaGanadora.getNombre(),premio,puesto);
            concursoFinalizar.getArrGanadores()[i]=ganador;
        }
    }
    
    public String toString(){
        return puestoGanador+" lugar.- Nombre del ganador: "+nombreGanador+" Premio: "+premioGanador;
    }
}
