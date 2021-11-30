package admins;


import java.util.*;
import main.NewMain;
import modelo.Ciudad;

public class AdminCiudades {

    public static ArrayList<Ciudad> arrCiudades= new ArrayList<Ciudad>();
    
    public static void menuCiudades(){

        Scanner sc=new Scanner(System.in);

        System.out.println("\nLista de ciudades registradas: ");

        for (Ciudad ciudad: arrCiudades){
            System.out.println(ciudad.getNombre());
        }

        System.out.print("\nDesea registrar una nueva ciudad? S/N: ");

        String respuesta=sc.nextLine();

        switch (respuesta){

           case "S": System.out.print("\nIngrese el nombre de la ciudad: ");
              String nombre=sc.nextLine();

              System.out.print("Ingrese el nombre de la provincia de la ciudad?: ");
              String provincia=sc.nextLine();

              Ciudad ciudad= new Ciudad(nombre,provincia);
              ciudad.generarCodCiudad();
              arrCiudades.add(ciudad);

              System.out.print("\n¡¡¡Ciudad registrada!!!");

              System.out.print("\n1.Regresar al menú principal \n2.Crear nueva ciudad ");
              System.out.print("Elige una opción: ");
              int opcion= sc.nextInt();
              sc.nextLine();
                if (opcion==1){
                    NewMain.menuPrincipal();
                }
                else if (opcion==2){
                    AdminCiudades.menuCiudades();
                }
            
            break;

        

            case "N":
             System.out.println("Regresando al menú principal...");
             NewMain.menuPrincipal();
             break;
        }


        sc.close();
    }
}
