
package modelo;

public class Auspiciante extends Persona{

    public String webpage;
    public String codAuspiciante;
    

    public Auspiciante(String n,String d,double t, String c,String e,String w){
        super(n,d,t,c,e);
        webpage=w;
        
    }

    

    

    public String toString(){
        return "nombre: "+nombre+" código: "+codAuspiciante;
    }
    
}
