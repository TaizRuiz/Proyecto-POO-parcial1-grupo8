
package modelo.clases;

import com.grupo8p04.proyectofxml.MenúPrincipalController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.enums.TipoEspecie;

public class Mascota implements Serializable {
    
    private String nombre;
    private TipoEspecie mascota;
    private String raza;
    private LocalDate fechaNacimiento;
    private String foto;
    private DueñoMascota dueño;
    private String CodMascota;
    private static final long serialVersionUID = 6666;

    
    // constructor
    
    public Mascota(){}

    public Mascota (String c){
        CodMascota=c;
    }

    public Mascota(String n, TipoEspecie m, String r, LocalDate fn, String pic, DueñoMascota d){
        nombre=n;
        mascota=m;
        raza=r;
        fechaNacimiento=fn;
        foto = pic;
        dueño=d;
    }

    public Mascota(String id,String n, TipoEspecie m, String r, LocalDate fn,DueñoMascota p){
        CodMascota=id;
        nombre=n;
        mascota=m;
        raza=r;
        fechaNacimiento=fn;
        dueño=p;
    }
    
    public Mascota(String n, TipoEspecie tesp, LocalDate fechaNac, String raza, DueñoMascota dueño){
        nombre = n;
        mascota = tesp;
        fechaNacimiento = fechaNac;
        this.raza = raza;
        this.dueño = dueño;
    }
    
    public Mascota(String n, TipoEspecie tesp, String raza, DueñoMascota dueño){
        nombre = n;
        mascota = tesp;
        this.raza = raza;
        this.dueño = dueño;
    }
    
    // getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoEspecie getMascota() {
        return mascota;
    }

    public void setMascota(TipoEspecie mascota) {
        this.mascota = mascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto(){
        return foto;
    }
    
    public void setFoto(String f){
        foto = f;
    }
    
    public Persona getDueño() {
        return dueño;
    }

    public void setDueño(DueñoMascota dueño) {
        this.dueño = dueño;
    }

    public String getCodMascota() {
        return CodMascota;
    }

    public void setCodMascota(String CodMascota) {
        this.CodMascota = CodMascota;
    }
    
        
    // metodos
    
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }

        if (obj !=null && obj instanceof Mascota){
            Mascota other= (Mascota) obj;
            return CodMascota.equals(other.CodMascota);
        }

        return false;
    }
    
    public static ArrayList<Mascota> lecturaMascotas(){
        
       ArrayList<Mascota> arrMascotas=new ArrayList<Mascota>();
        
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader ("archivos/mascotas.csv"))){
            String linea;
            
            while((linea=bufferedReader.readLine())!=null){
                String[] info=linea.split(",");
                
                TipoEspecie tipo=TipoEspecie.Vacio;
                if(info[2].equals("perro")){
                    tipo=TipoEspecie.Perro;
                }
                else{
                    tipo=TipoEspecie.Gato;
                }
                
                LocalDate fecha=LocalDate.parse(info[4]);
                
                DueñoMascota dueñom=null;
                for (DueñoMascota d: MenúPrincipalController.getArrDueños()){
                    if(info[6].equals(d.getCedulaIdentidad())){
                        dueñom=d;
                    }
                }
               
                Mascota mascota= new Mascota(info[0],info[1],tipo,info[3].toUpperCase(),fecha,dueñom);
                
                arrMascotas.add(mascota);
                
            }
   
        }
        

        catch (IOException e){
            System.out.println(e);
        }

        return arrMascotas;
    }
    
    public void saveFile() {
        //String mascotas="";
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/mascotas.csv", true))) {
            sb.append("\r\n");
            sb.append(this.CodMascota).append(","); 
            sb.append(this.nombre).append(","); 
            sb.append(this.mascota).append(",");
            sb.append(this.raza).append(",");
            sb.append(this.fechaNacimiento).append(",");
            sb.append(this.foto).append(",");
            sb.append(this.dueño.getCedulaIdentidad());
            bufferedW.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static void saveFileEliminar() {
        File archivo=new File("archivos/mascotas.csv");
        archivo.delete();
        for(Mascota m:MenúPrincipalController.getArrMascotas()){
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("archivos/mascotas.csv", true))) {
            sb.append(m.CodMascota).append(","); 
            sb.append(m.nombre).append(","); 
            sb.append(m.mascota).append(",");
            sb.append(m.raza).append(",");
            sb.append(m.fechaNacimiento).append(",");
            sb.append(m.foto).append(",");
            sb.append(m.dueño.getCedulaIdentidad());
            if(!(MenúPrincipalController.getArrMascotas().indexOf(m)==(MenúPrincipalController.getArrMascotas().size()-1))){
            sb.append("\r\n");}
            bufferedW.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
        }
    }
    
    public String toString(){
        return "Código: "+CodMascota+"- Nombre: "+nombre+"- Dueño: "+dueño+"- Raza: "+raza;
    }
}
