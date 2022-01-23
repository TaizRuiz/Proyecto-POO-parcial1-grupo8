
package modelo.clases;

import com.grupo8p04.proyectofxml.MenúPrincipalController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


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


   
    public String toString(){
        return nombre;
    }
    
    public void guardarCiudad(){
        
        String ciudad="";
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/ciudades.csv", true))) {
            sb.append("\r\n");
            sb.append(this.codCiudad).append(","); 
            sb.append(this.nombre).append(","); 
            sb.append(this.provincia);
            bufferedW.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
    
    public  void guardarCiudadEliminar() {
        File archivo=new File("archivos/ciudades.csv");
        archivo.delete();
        for(Ciudad c:MenúPrincipalController.getArrCiudades()){
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/ciudades.csv",true))) {
            
            sb.append(c.codCiudad).append(","); 
            sb.append(c.nombre).append(","); 
            sb.append(c.provincia);
            if(!(MenúPrincipalController.getArrCiudades().indexOf(c)==(MenúPrincipalController.getArrCiudades().size()-1))){
                sb.append("\r\n");}
            bufferedW.write(sb.toString());//Transformamos el StringBuilder a String
        } catch (IOException e) {
            System.out.println(e);
        }
        }
    }
    public static ArrayList<Ciudad> lecturaCiudades(){
        
       ArrayList<Ciudad> arrCiudades=new ArrayList<Ciudad>();
        
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader ("archivos/ciudades.csv"))){
            String linea;
            
            while((linea=bufferedReader.readLine())!=null){
                String[] info=linea.split(",");
                Ciudad ciudad= new Ciudad(info[0],info[1],info[2]);
                arrCiudades.add(ciudad);
            }
   
        }

        catch (IOException e){
            System.out.println(e);
        }

        return arrCiudades;
    }
    
}
