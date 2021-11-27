
package modelo;

import main.*;


public class Ciudad {

    public String nombre;
    public String provincia;
    public String CodCiudad;

    public Ciudad(){}

    public Ciudad(String n){
        nombre=n;
    }

    public Ciudad (String n, String p){
        nombre=n;
        provincia=p;
    }

    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }

        if (obj !=null && obj instanceof Ciudad){
            Ciudad other= (Ciudad) obj;
            return nombre.equals(other.nombre);
        }

        return false;
    }

    public static Ciudad busquedaCiudad(String nombreCiudad){


        Ciudad ciudadBusqueda=new Ciudad(nombreCiudad);
        Ciudad ciudadEncontrada= new Ciudad();

        if (NewMain.arrCiudades.contains(ciudadBusqueda)){
            int indCiudad=NewMain.arrCiudades.indexOf(ciudadBusqueda);
            ciudadEncontrada= NewMain.arrCiudades.get(indCiudad);
        }

        return ciudadEncontrada;
    }
    
}
