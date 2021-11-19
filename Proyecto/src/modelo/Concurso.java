
package modelo;

import java.time.*;
import java.util.ArrayList;


public class Concurso {
    public String nombre;
    public LocalDate fechaEvento;
    public LocalDateTime horaEvento;
    public LocalDate fechaInscripcion;
    public LocalDate fechaFinIncripcion;
    public Ciudad ciudad;
    public String lugar;
    public String CodConcurso;
    public Premio premio;
    public ArrayList<Auspiciante> auspiciantes;
    public TiposAnimal dirigidoA;
    
}
