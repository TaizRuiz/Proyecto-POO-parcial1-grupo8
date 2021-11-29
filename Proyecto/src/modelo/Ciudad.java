
package modelo;

import main.*;


public class Ciudad {

    public String nombre;
    public String provincia;
    public String codCiudad;

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

    public void generarCodCiudad(){
        
        String [] arrNombre= nombre.split("");
        int tamaño=arrNombre.length;
        for (int i=0;i<2;i++){
            double ind= Math.floor(Math.random()*tamaño);
            String letraAleatoria=arrNombre[(int)ind];
            codCiudad=codCiudad+letraAleatoria;
        }

        for (int i=0;i<2;i++){
            String numero= String.valueOf((int) (Math.random()*10));
            codCiudad=codCiudad+numero;
        }

        codCiudad=codCiudad.toUpperCase();;
    }
    
}
