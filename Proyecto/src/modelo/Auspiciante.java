
package modelo;

import main.*;

public class Auspiciante extends Persona{

    public String webpage;
    public String codAuspiciante;

    public Auspiciante(){
        super();
    }

    public Auspiciante(String n){
        super(n);
    }
    

    public Auspiciante(String n,String d,double t, String c,String e,String w){
        super(n,d,t,c,e);
        webpage=w;
        
    }

    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }

        if (obj !=null && obj instanceof Auspiciante){
            Auspiciante other= (Auspiciante) obj;
            return nombre.equals(other.nombre);
        }

        return false;
    }

    public static Auspiciante busquedaAuspiciante(String nombreAuspiciante){

        Auspiciante auspicianteBusqueda=new Auspiciante(nombreAuspiciante);
        Auspiciante auspicianteEncontrado= new Auspiciante();

        if (NewMain.arrAuspiciantes.contains(auspicianteBusqueda)){
            int indAuspiciante=NewMain.arrAuspiciantes.indexOf(auspicianteBusqueda);
            auspicianteEncontrado= NewMain.arrAuspiciantes.get(indAuspiciante);
        }

        return auspicianteEncontrado;
    }
    

    public String toString(){
        return "nombre: "+nombre+" código: "+codAuspiciante;
    }
    
}
