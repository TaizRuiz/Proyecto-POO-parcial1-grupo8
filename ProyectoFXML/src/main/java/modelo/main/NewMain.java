package main;

import clases.Auspiciante;
import clases.Ciudad;
import java.util.*;
import admins.*;

public class NewMain {

    public static ArrayList<Ciudad> arrCiudades= new ArrayList<Ciudad>();
    public static ArrayList<Auspiciante> arrAuspiciantes= new ArrayList<Auspiciante>();

    public static void menuPrincipal(){
        System.out.println("\n------------Menú principal------------ \n 1.Administrar Concursos \n 2.Administrar Dueños \n 3.Administrar Mascotas \n 4.Administrar Auspiciantes \n 5.Administrar Ciudades \n");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion= sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1: AdminConcursos.menuConcursos();
                    break;

            case 2: AdminDueños.MenuDueños();
                    break;
            
            case 3: AdminMascotas.menuMascotas();
                    break;

            case 4: AdminAuspiciantes.menuAuspiciantes();
                    break;

            case 5: AdminCiudades.menuCiudades();
            
            default: System.out.println("Opción no existente");
                    menuPrincipal();

            sc.close();
        }
    }

    
    public static void main(String[] args) {

        CargarObjetos.cargarObjetos();
        menuPrincipal();
        
          
    
}
}
