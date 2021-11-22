package modelo;

import enums.Puesto;

public class Premio {
    private Puesto puesto;
    private String descripcion;
    private Auspiciante auspiciante;

    public Premio(Puesto p, String d,Auspiciante a){
        puesto=p;
        descripcion=d;
        auspiciante=a;
    }

    public String toString(){
        return puesto+" Lugar: "+descripcion+" , "+auspiciante;
    }
    
    
}
