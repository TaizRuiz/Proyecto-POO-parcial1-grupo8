package admins;

import java.util.*;
import modelo.*;
import main.*;

public class AdminDueños { 
    
    static ArrayList<DueñoMascota> arrDueño= new ArrayList<DueñoMascota>();
    
    public static void menuDueños(){
        
        System.out.println("Dueños de Mascotas existentes: ");
        
        
        if (arrDueño.size()==0){
            
            System.out.println("No hay Dueños registrados");
        }
        else{

            for (int i=0;i<arrDueño.size();i++){
                System.out.println(arrDueño.get(i).nombre);
        }
        }
        
        
        System.out.println("Menú de opciones de concursos: ");
        System.out.println(" 1.Crear dueño ");
        System.out.println(" 2. Editar dueño ");
        System.out.println(" 3.Regresar al menú principal ");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        
        switch(opcion){

            case 1:
                System.out.println("Ingrese la cedula del Dueño: ");
                double cedula = sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingrese los nombres: ");
                String nombre = sc.nextLine();
                System.out.println("Ingrese los apellidos:  ");
                String apellido= sc.nextLine();
                System.out.println("Ingrese la direccion:  ");
                String direccion= sc.nextLine();
                System.out.println("Ingrese un numero de telefono:  ");
                double telefono= sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingrese la ciudad:  ");
                String ciudad= sc.nextLine();
               
                System.out.println("Ingrese un E-mail:  ");
                String correo= sc.nextLine();
                
                DueñoMascota dueño = new DueñoMascota(cedula,apellido,nombre,direccion, telefono,ciudad, correo);
                arrDueño.add(dueño);
                System.out.println("Dueño "+ dueño.nombre+ " registrado exitosamente");
                
                System.out.println(" 1.Regresar al menú Dueño");
                System.out.println("2.Regresar al menú principal");
                System.out.print("Elige una opción: ");
                opcion= sc.nextInt();
                sc.nextLine();
                if (opcion==1){
                    AdminDueños.menuDueños();
                }
                else if (opcion==2){
                    NewMain.menuPrincipal();
                }
            
             break;


            case 2: System.out.print("Fin del menú");

            case 3: NewMain.menuPrincipal();

            default: System.out.println("Opción no existente");
                    menuDueños();  
                    
                    

        
        } 

        sc.close();
    }
    
        
}

