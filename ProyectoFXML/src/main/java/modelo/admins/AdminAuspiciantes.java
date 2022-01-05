package modelo.admins;

import java.util.*;
import modelo.clases.Auspiciante;
import modelo.main.NewMain;

public class AdminAuspiciantes {
      
    public static ArrayList<Auspiciante> arrAuspiciantes= new ArrayList<Auspiciante>();
    
    public static void menuAuspiciantes(){
        
        
        System.out.println("\nAuspiciantes registrados: ");
    
        
        if (arrAuspiciantes.size()==0){
            
            System.out.println("No hay auspiciantes registrados");
        }
        else{

            for (int i=0;i<arrAuspiciantes.size();i++){
                System.out.println("-"+arrAuspiciantes.get(i).nombre);
        }
        }

        System.out.println("\n-----Menú de opciones de auspiciantes----- \n 1.Crear auspiciante \n 2.Regresar al menú principal");

        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion= sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1:
            System.out.print("\nIngrese el nombre del auspiciante: ");
            String nombre= sc.nextLine();

            System.out.print("Ingrese la dirección del auspiciante: ");
            String direccion= sc.nextLine();

            
            System.out.print("Ingrese el teléfono del auspiciante: ");
            String telefono= sc.nextLine();

            System.out.print("Ingrese la ciudad del auspiciante: ");
            String ciudad= sc.nextLine();

            System.out.print("Ingrese el e-mail del auspiciante: ");
            String email= sc.nextLine();

            System.out.print("Ingrese la webpage del auspiciante: ");
            String webpage= sc.nextLine();



            Auspiciante auspiciante= new Auspiciante(nombre,direccion,telefono,ciudad,email,webpage);
            arrAuspiciantes.add(auspiciante);

            System.out.println("\n¡¡¡Auspiciante registrado!!!");

            System.out.println("\n1.Regresar al menú auspiciantes \n2.Regresar al menú principal ");
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
