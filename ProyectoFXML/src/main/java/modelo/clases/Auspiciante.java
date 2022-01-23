
package modelo.clases;

import com.grupo8p04.proyectofxml.MenúPrincipalController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Auspiciante extends Persona implements Serializable{

    private String webpage;
    private String codAuspiciante;
    private static final long serialVersionUID = 3333;
    
    
    // constructores
    
    public Auspiciante(){
        super();
    }

    public Auspiciante(String n){
        super(n);
    }
    

    public Auspiciante(String n,String d,String t, String c,String e,String w){
        super(n,d,t,c,e);
        webpage=w;
        
    }
    
    // getters y setters

    public String getWebpage() {
        return webpage;
    }

    public String getCodAuspiciante() {
        return codAuspiciante;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public void setCodAuspiciante(String codAuspiciante) {
        this.codAuspiciante = codAuspiciante;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
       
    
    // métodos 

    @Override
    public String toString(){
        return nombre;
    }
    
    public static void serializarAuspiciante(){
          
        try{
            FileOutputStream fout= new FileOutputStream("archivos/auspiciantes.ser");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(MenúPrincipalController.getArrAuspiciantes());
            out.flush();
            
        }
        
        catch (IOException e){
            System.out.println(e);
        }

    
    }
    
    public static ArrayList<Auspiciante> lecturaAuspiciante(){
        
       ArrayList<Auspiciante> arrAuspiciantes=new ArrayList<Auspiciante>();
        
        try{
            ObjectInputStream in= new ObjectInputStream(new FileInputStream("archivos/auspiciantes.ser"));
            arrAuspiciantes=(ArrayList<Auspiciante>) in.readObject();
            in.close();
            
        }
        
	catch (FileNotFoundException e){
            System.out.println(e);
        }

        catch (IOException | ClassNotFoundException e){
            System.out.println(e);
        }

        return arrAuspiciantes;
    }
    
}
