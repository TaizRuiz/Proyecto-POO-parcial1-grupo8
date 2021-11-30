package modelo;

import java.util.*;

import admins.AdminAuspiciantes;
import enums.Puesto;

public class Premio {
    private Puesto puesto;
    private String descripcion;
    private Auspiciante auspiciante;
    
    
    // constructor
    
    public Premio(Puesto p, String d,Auspiciante a){
        puesto=p;
        descripcion=d;
        auspiciante=a;
    }

    
    // getters and setters

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Auspiciante getAuspiciante() {
        return auspiciante;
    }

    public void setAuspiciante(Auspiciante auspiciante) {
        this.auspiciante = auspiciante;
    }
    
    
    // metodos
    
    public static Premio[] generarListaPremios(Premio[] arrPremios){

        Scanner sc=new Scanner(System.in);

        for(int i=0;i<3;i++){
            Puesto puesto=Puesto.values()[i];
            
            System.out.print("\nIngrese la descripción del premio para el "+(i+1)+"º lugar: \n");
            String descripcion= sc.nextLine();

            System.out.println("Seleccione los auspiciantes de la siguiente lista para el "+(i+1)+"º lugar");

            for (Auspiciante a: AdminAuspiciantes.arrAuspiciantes){
                System.out.println("-"+a.nombre);
            }
            
            System.out.print("Ingrese el nombre del auspiciante que desea elegir: ");

            String nombreAuspiciante=sc.nextLine();
            Auspiciante auspiciante=Auspiciante.busquedaAuspiciante(nombreAuspiciante);
            

            Premio premio=new Premio(puesto,descripcion,auspiciante);
            arrPremios[i]=premio;
         }
         
        return arrPremios;
        
    }

    public String toString(){
        return descripcion;
    }

     
}
