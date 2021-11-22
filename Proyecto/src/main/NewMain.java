package main;

import java.util.*;
import admins.*;
import modelo.*;

public class NewMain {

    public static ArrayList<Ciudad> arrCiudades= new ArrayList<Ciudad>();
    static Ciudad ciudad1= new Ciudad("Guayaquil","Guayas");
    public static ArrayList<Auspiciante> arrAuspiciantes= new ArrayList<Auspiciante>();
    static Auspiciante auspiciante1= new Auspiciante("José","Centro",991114665,"Guayaquil","jose123@hotmail.com","www.jose123.com");
    
    
    

    public static void MenuPrincipal(){
        System.out.println("Menú principal: \n 1.Administrar Concursos \n 2.Administrar Dueños \n 3.Administrar Mascotas \n 4.Administrar Auspiciantes");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion= sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1: AdminConcursos.MenuConcursos();
                    break;

            case 2: AdminDueños.MenuDueños();
                    break;
            
            case 3: AdminMascotas.MenuMascotas();
                    break;

            case 4: AdminAuspiciantes.MenuAuspiciantes();
                    break;
            
            default: System.out.println("Opción no existente");
                    MenuPrincipal();

            sc.close();
        }
    }

    
    public static void main(String[] args) {

        arrCiudades.add(ciudad1);
        arrAuspiciantes.add(auspiciante1);
        MenuPrincipal();
        
          
    
}
}
