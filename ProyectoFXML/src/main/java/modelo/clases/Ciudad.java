
package modelo.clases;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import modelo.admins.AdminCiudades;


public class Ciudad implements Serializable{

    private String nombre;
    private String provincia;
    private String codCiudad;
    private static final long serialVersionUID = 2222;

    
    // constructor
    
    public Ciudad(){}

    public Ciudad(String n){
        nombre=n;
    }

    public Ciudad (String n, String p){
        nombre=n;
        provincia=p;
    }
    
    public Ciudad (String id,String n, String p){
        codCiudad=id;
        nombre=n;
        provincia=p;
    }

    
    // getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }
    
    
    // metodos
    
    @Override
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

        if (AdminCiudades.arrCiudades.contains(ciudadBusqueda)){
            int indCiudad=AdminCiudades.arrCiudades.indexOf(ciudadBusqueda);
            ciudadEncontrada= (Ciudad) AdminCiudades.arrCiudades.get(indCiudad);
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
    
    public String toString(){
        return nombre;
    }
    
    public static void serializarCiudad(){
          
        try{
            FileOutputStream fout= new FileOutputStream("archivos/ciudades.ser");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(AdminCiudades.arrCiudades);
            out.flush();
            
        }
        
        catch (IOException e){
            System.out.println(e);
        }

    
    }
    
    public static ArrayList<Ciudad> lecturaCiudades(){
        
       ArrayList<Ciudad> arrCiudades=new ArrayList<Ciudad>();
        
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader ("archivos/ciudades.csv"))){
            String linea;
            
            while((linea=bufferedReader.readLine())!=null){
                String[] info=linea.split(",");
                Ciudad ciudad= new Ciudad(info[0],info[1],info[2]);
                //System.out.println(dueño);
                arrCiudades.add(ciudad);
            }
   
        }

        catch (IOException e){
            System.out.println(e);
        }

        return arrCiudades;
    }
    
}
