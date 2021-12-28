package modelo.clases;

import modelo.enums.Puesto;

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
    
    public static void generarGanadores(Concurso concursoFinalizar){
        
        
        int i=0;
        while(i<3){
            Mascota mascotaGanadora=concursoFinalizar.getParticipantes().get(i);
            Premio premio=concursoFinalizar.getPremio()[i];
            Puesto puesto=Puesto.values()[i];

            Ganador ganador= new Ganador(mascotaGanadora.getNombre(),premio,puesto);

            if (concursoFinalizar.getArrGanadores().contains(ganador)){}
            
            else{
            concursoFinalizar.getArrGanadores().add(ganador);
            i++;
        }
             
        }
    }
    
    @Override
    public String toString(){
        return puestoGanador+" lugar.- Nombre del ganador: "+nombreGanador+" Premio: "+premioGanador;
    }
}
