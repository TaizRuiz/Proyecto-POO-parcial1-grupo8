package modelo;

import java.util.*;
import enums.Puesto;
import main.*;

public class Premio {
    private Puesto puesto;
    private String descripcion;
    private Auspiciante auspiciante;

    public Premio(Puesto p, String d,Auspiciante a){
        puesto=p;
        descripcion=d;
        auspiciante=a;
    }

    public static Premio[] generarListaPremios(Premio[] arrPremios){

        Scanner sc=new Scanner(System.in);

        for(int i=0;i<3;i++){
            Puesto puesto=Puesto.values()[i];
            
            System.out.print("Ingrese la descripción del premio para el "+(i+1)+"º lugar: ");
            String descripcion= sc.nextLine();

            System.out.println("Seleccione los auspiciantes de la siguiente lista para el "+(i+1)+"º lugar");

            for (Auspiciante a: NewMain.arrAuspiciantes){
                System.out.println("-"+a.nombre);
            }
            
            System.out.print("Ingrese el nombre del auspiciante que desea elegir: ");

            String nombreAuspiciante=sc.nextLine();
            Auspiciante auspiciante=Auspiciante.busquedaAuspiciante(nombreAuspiciante);
            

            Premio premio=new Premio(puesto,descripcion,auspiciante);
            arrPremios[i]=premio;

         }

         sc.close();

        return arrPremios;

        
    }

    public String toString(){
        return puesto+" Lugar: "+descripcion+" , "+auspiciante;
    }
    

    
}
