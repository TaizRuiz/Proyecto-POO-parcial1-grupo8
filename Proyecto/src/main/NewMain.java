
package main;

import java.util.*;
import admins.*;
import modelo.*;

public class NewMain {

    public static ArrayList<Ciudad> arrCiudades= new ArrayList<Ciudad>();
    static Ciudad ciudad1= new Ciudad("Guayaquil","Guayas");
    
    

    public static void MenuPrincipal(){
        System.out.println("Menú principal: \n 1.Administrar Concursos \n 2.Administrar Dueños \n 3.Administrar Mascotas");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion= sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1: AdminConcursos.MenuConcursos();
                    break;

            case 2: System.out.println("Fin del menú");
        }
    }

    
    public static void main(String[] args) {

        arrCiudades.add(ciudad1);
        MenuPrincipal();
        
        
        

       

        
    
}
}
