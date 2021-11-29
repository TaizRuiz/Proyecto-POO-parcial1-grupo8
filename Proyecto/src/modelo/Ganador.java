package modelo;

import enums.Puesto;
import java.util.*;

public class Ganador {
    
    public String nombreGanador;
    public Premio premioGanador;
    public Puesto puestoGanador;

    public Ganador(String n,Premio p,Puesto pu){
        nombreGanador=n;
        premioGanador=p;
        puestoGanador=pu;
    }

    public static void generarGanadores(Concurso concursoFinalizar){
        for(int i=0;i<3;i++){

            Random rand=new Random();

            int indAleatorio= rand.nextInt(concursoFinalizar.participantes.size()-1);
            Mascota mascotaGanadora=concursoFinalizar.participantes.get(indAleatorio);
            Premio premio=concursoFinalizar.premio[i];
            Puesto puesto=Puesto.values()[i];

            Ganador ganador= new Ganador(mascotaGanadora.nombre,premio,puesto);
            concursoFinalizar.arrGanadores[i]=ganador;
        }
    }
    public String toString(){
        return puestoGanador+" lugar.- Nombre del ganador: "+nombreGanador+" Premio: "+premioGanador;
    }
}
