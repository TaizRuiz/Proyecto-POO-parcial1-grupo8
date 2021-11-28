package admins;

import modelo.*;
import java.util.*;
import main.*;

public class AdminAuspiciantes {
      
        
    
    public static void menuAuspiciantes(){
        
        
        System.out.println("Auspiciantes registrados: ");
    
        
        if (NewMain.arrAuspiciantes.size()==0){
            
            System.out.println("No hay auspiciantes registrados");
        }
        else{

            for (int i=0;i<NewMain.arrAuspiciantes.size();i++){
                System.out.println(NewMain.arrAuspiciantes.get(i).nombre);
        }
        }

        System.out.println("Menú de opciones de auspiciantes: \n 1.Crear auspiciante \n 2.Regresar al menú principal");

        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion= sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1:
            System.out.print("Ingrese el nombre del auspiciante: ");
            String nombre= sc.nextLine();

            System.out.print("Ingrese la dirección del auspiciante: ");
            String direccion= sc.nextLine();

            
            System.out.print("Ingrese el teléfono del auspiciante: ");
            double telefono= sc.nextDouble();
            sc.nextLine();

            System.out.print("Ingrese la ciudad del auspiciante: ");
            String ciudad= sc.nextLine();

            System.out.print("Ingrese el e-mail del auspiciante: ");
            String email= sc.nextLine();

            System.out.print("Ingrese la webpage del auspiciante: ");
            String webpage= sc.nextLine();



            Auspiciante auspiciante= new Auspiciante(nombre,direccion,telefono,ciudad,email,webpage);
            NewMain.arrAuspiciantes.add(auspiciante);

            System.out.println("Auspiciante registrado");

            System.out.println(" 1.Regresar al menú auspiciantes \n 2.Regresar al menú principal ");
             System.out.print("Elige una opción: ");
             opcion= sc.nextInt();
             sc.nextLine();
                if (opcion==1){
                    AdminAuspiciantes.menuAuspiciantes();
                }
                else if (opcion==2){
                    NewMain.menuPrincipal();
                }

            break;

            case 2: NewMain.menuPrincipal();
                    break;

            default: System.out.println("Opción no existente");
            menuAuspiciantes();   

            sc.close();

        }

    }
}
