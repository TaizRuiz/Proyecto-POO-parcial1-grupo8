
package modelo.clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import modelo.admins.AdminDueños;


public class DueñoMascota extends Persona implements Serializable{
    
    private String cedulaIdentidad;
    private String apellido;
    private static final long serialVersionUID = 4444;
    
    
    // constructor
    
    public DueñoMascota(){}
    
    public DueñoMascota(String n){
        super(n);
    }
    
    public DueñoMascota(String id, String ap){
        cedulaIdentidad = id;
        apellido = ap;
    }
        
    public DueñoMascota(String cedulaIdentidad, String apellido, String nombre, String direccion, String telefono, String ciudad, String email) {
        super(nombre, direccion, telefono, ciudad, email);
        this.cedulaIdentidad = cedulaIdentidad;
        this.apellido = apellido;
    }

    // getters and setters

    public String getCedulaIdentidad() {
        return cedulaIdentidad;
    }

    public void setCedulaIdentidad(String cedulaIdentidad) {
        this.cedulaIdentidad = cedulaIdentidad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    // metodos
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DueñoMascota other = (DueñoMascota) obj;
        if (!Objects.equals(this.cedulaIdentidad, other.cedulaIdentidad)) {
            return false;
        }
        return true;
    }   
    
    public boolean equalsDos(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DueñoMascota other = (DueñoMascota) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }   
    
    
    public static DueñoMascota busquedaDueño(String nombreDueño){

        DueñoMascota dueñoBusqueda = new DueñoMascota(nombreDueño);
        DueñoMascota dueñoEncontrado = new DueñoMascota();

        if (AdminDueños.arrDueño.contains(dueñoBusqueda)){
            int indDueño = AdminDueños.arrDueño.indexOf(dueñoBusqueda);
            dueñoEncontrado = (DueñoMascota) AdminDueños.arrDueño.get(indDueño);
        }else{
            System.out.println("Dueño no registrado");
        }

        return dueñoEncontrado;
    }
    
    public void saveFile(String nomfile) {
        String dueños="";
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/dueños.csv", true))) {
            sb.append(this.cedulaIdentidad).append(","); //cedula|
            sb.append(this.nombre).append(","); //cedula|nombres
            sb.append(this.apellido).append(",");
            sb.append(this.direccion).append(",");
            sb.append(this.telefono).append(",");
            sb.append(this.ciudad).append(",");
            sb.append(this.email);
            bufferedW.write(sb.toString());//Transformamos el StringBuilder a String
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    
    public static ArrayList<DueñoMascota> lecturaDueños(){
        
       ArrayList<DueñoMascota> arrDueños=new ArrayList<DueñoMascota>();
        
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader ("archivos/dueños.csv"))){
            String linea;
            bufferedReader.readLine();
            
            while((linea=bufferedReader.readLine())!=null){
                String[] info=linea.split(",");
                DueñoMascota dueño= new DueñoMascota(info[0],info[1],info[2],info[3],info[4],info[5],info[6]);
                //System.out.println(dueño);
                arrDueños.add(dueño);
            }
   
        }

        catch (IOException e){
            System.out.println(e);
        }

        return arrDueños;
    }
    
    public String toString(){
        return nombre+" "+apellido;
    }

    
}
    

    

