package admins;

import modelo.*;
import java.util.*;
import main.*;

public class AdminAuspiciantes {
    static ArrayList<Auspiciante> arrAuspiciantes= new ArrayList<Auspiciante>();
    
        
    
    public static void MenuAuspiciantes(){
        Auspiciante auspiciante1= new Auspiciante("José","Centro",991114665,"Guayaquil","jose123@hotmail.com","www.jose123.com");
        
        arrAuspiciantes.add(auspiciante1);
        //auspiciante1.generarCodAuspiciante();
        
        System.out.println("Auspiciantes registrados: ");
    
        
        if (arrAuspiciantes.size()==0){
            
            System.out.println("No hay auspiciantes registrados");
        }
        else{

            for (int i=0;i<arrAuspiciantes.size();i++){
                System.out.println(arrAuspiciantes.get(i).nombre);
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
            arrAuspiciantes.add(auspiciante);

            System.out.println("Auspiciante registrado");

            break;

            case 2: NewMain.MenuPrincipal();
                    break;

            default: System.out.println("Opción no existente");
            MenuAuspiciantes();   



        }

    }
}
