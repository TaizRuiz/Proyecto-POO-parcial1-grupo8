
package modelo;

import enums.TiposAnimal;
import java.time.*;
import java.util.ArrayList;


public class Concurso {
    public String nombre;
    public LocalDate fechaEvento;
    public LocalTime horaEvento;
    public LocalDate fechaInscripcion;
    public LocalDate fechaFinInscripcion;
    public Ciudad ciudad;
    public String lugar;
    public String CodConcurso;
    public Premio premio;
    public ArrayList<Auspiciante> auspiciantes;
    public TiposAnimal dirigidoA;
    
    
    
    //public String crearCodConc(String fechaEvento, String ciudad, String lugar){
        //return 
    
    //}

    public Concurso(String n, LocalDate fe, LocalTime he, LocalDate fi, LocalDate ff, Ciudad ci, String lu, String cod, Premio pr,ArrayList<Auspiciante> arr, TiposAnimal ta){
        nombre= n;
        fechaEvento=fe;
        horaEvento=he;
        fechaInscripcion=fi;
        fechaFinInscripcion=ff;
        ciudad=ci;
        lugar=lu;
        CodConcurso=cod;
        premio=pr;
        auspiciantes=arr;
        dirigidoA=ta;

        
    }
}
