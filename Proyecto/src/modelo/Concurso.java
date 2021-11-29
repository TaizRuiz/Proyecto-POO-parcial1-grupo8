
package modelo;

import enums.TiposAnimal;
import java.time.*;
import java.util.ArrayList;

import admins.AdminConcursos;


public class Concurso {
    public String nombre;
    public LocalDate fechaEvento;
    public LocalTime horaEvento;
    public LocalDate fechaInscripcion;
    public LocalDate fechaFinInscripcion;
    public Ciudad ciudad;
    public String lugar;
    public String CodConcurso;
    public Premio[] premio;
    public ArrayList<Auspiciante> auspiciantes;
    public TiposAnimal dirigidoA;
    public ArrayList<Mascota> participantes;
    public boolean abiertoInscripciones;
    public boolean concursoEnCurso;
    public Ganador[] arrGanadores;

    public Concurso(){};
    
    public Concurso(String c){
        CodConcurso=c;
    }

    public Concurso(String n, LocalDate fe, LocalTime he, LocalDate fi, LocalDate ff, Ciudad ci, String lu, Premio[] pr, ArrayList<Auspiciante> arr,TiposAnimal ta){
        nombre= n;
        fechaEvento=fe;
        horaEvento=he;
        fechaInscripcion=fi;
        fechaFinInscripcion=ff;
        ciudad=ci;
        lugar=lu;
        premio=pr;
        auspiciantes=arr;
        dirigidoA=ta;

        
    }

    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }

        if (obj !=null && obj instanceof Concurso){
            Concurso other= (Concurso) obj;
            return CodConcurso.equals(other.CodConcurso);
        }

        return false;
    }

    public void generarCodConcurso(){

        String codConcurso="";
        String nombreSinEspacios=nombre.replace(" ", "");
        
        String [] arrNombre= nombreSinEspacios.split("");
        int tamaño=arrNombre.length;
        for (int i=0;i<2;i++){
            double ind= Math.floor(Math.random()*tamaño);
            String letraAleatoria=arrNombre[(int)ind];
            codConcurso=codConcurso+letraAleatoria;
        }

        for (int i=0;i<2;i++){
            String numero= String.valueOf((int) (Math.random()*10));
            codConcurso=codConcurso+numero;
        }

        CodConcurso=codConcurso.toUpperCase();;
    }

    public static Concurso busquedaConcurso(String codigoConcurso){

        Concurso concursoBusqueda=new Concurso(codigoConcurso);
        Concurso concursoEncontrado= new Concurso();

        if (AdminConcursos.arrConcursos.contains(concursoBusqueda)){
            int indConcurso=AdminConcursos.arrConcursos.indexOf(concursoBusqueda);
            concursoEncontrado= AdminConcursos.arrConcursos.get(indConcurso);
        }

        return concursoEncontrado;
    }
    

    public String toString(){
        return "nombre: "+nombre+" lugar: "+lugar+" "+fechaEvento+" "+horaEvento;
    }
}
