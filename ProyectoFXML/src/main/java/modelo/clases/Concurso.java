
package modelo.clases;

import com.grupo8p04.proyectofxml.MenúPrincipalController;
import java.io.*;
import java.time.*;
import java.util.ArrayList;
import modelo.enums.TiposAnimal;


public class Concurso implements Serializable {
    private String nombre;
    private LocalDate fechaEvento;
    private LocalTime horaEvento;
    private LocalDate fechaInscripcion;
    private LocalDate fechaFinInscripcion;
    private Ciudad ciudad;
    private String lugar;
    private String CodConcurso;
    private Premio[] premio;
    private ArrayList<Auspiciante> auspiciantes;
    private TiposAnimal dirigidoA;
    private ArrayList<Mascota> participantes;
    private boolean abiertoInscripciones;
    private boolean concursoEnCurso;
    private ArrayList<Ganador> arrGanadores;
    private static final long serialVersionUID = 1111;
    
    
    
    // constructores
    
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
    
    
    // getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public LocalTime getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(LocalTime horaEvento) {
        this.horaEvento = horaEvento;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public LocalDate getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    public void setFechaFinInscripcion(LocalDate fechaFinInscripcion) {
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getCodConcurso() {
        return CodConcurso;
    }

    public void setCodConcurso(String CodConcurso) {
        this.CodConcurso = CodConcurso;
    }

    public Premio[] getPremio() {
        return premio;
    }

    public void setPremio(Premio[] premio) {
        this.premio = premio;
    }

    public ArrayList<Auspiciante> getAuspiciantes() {
        return auspiciantes;
    }

    public void setAuspiciantes(ArrayList<Auspiciante> auspiciantes) {
        this.auspiciantes = auspiciantes;
    }

    public TiposAnimal getDirigidoA() {
        return dirigidoA;
    }

    public void setDirigidoA(TiposAnimal dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    public ArrayList<Mascota> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Mascota Mascotas) {
        this.participantes.add(Mascotas);
    }

    public void setArrParticipantes(ArrayList<Mascota> arrMascotas){
        this.participantes=arrMascotas;
    }


    public boolean isAbiertoInscripciones() {
        return abiertoInscripciones;
    }

    public void setAbiertoInscripciones(boolean abiertoInscripciones) {
        this.abiertoInscripciones = abiertoInscripciones;
    }

    public boolean isConcursoEnCurso() {
        return concursoEnCurso;
    }

    public void setConcursoEnCurso(boolean concursoEnCurso) {
        this.concursoEnCurso = concursoEnCurso;
    }

    public ArrayList<Ganador> getArrGanadores() {
        return arrGanadores;
    }

    public void setGanadores(Ganador ganador) {
        this.arrGanadores.add(ganador);
    }

    public void setArrGanadores(ArrayList<Ganador> arrGanador) {
        this.arrGanadores=arrGanador;
    }
        
    
    // métodos
    
    @Override
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

    
    @Override
    public String toString(){
        return "nombre: "+nombre+" lugar: "+lugar+" "+fechaEvento+" "+horaEvento;
    }
    
    
    
        
  
    
    public static ArrayList<Concurso> lecturaConcurso(){
        
       ArrayList<Concurso> arrConcursos=null;
        
        try{
            ObjectInputStream in= new ObjectInputStream(new FileInputStream("archivos/concursos.ser"));
            arrConcursos=(ArrayList<Concurso>) in.readObject();
            in.close();
            
        }
        
	catch (FileNotFoundException e){
            System.out.println(e);
        }

        catch (IOException | ClassNotFoundException e){
            System.out.println(e);
        }

        return arrConcursos;
    }
    
}
