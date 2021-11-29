package admins;


import java.util.*;
import main.NewMain;
import modelo.Ciudad;

public class AdminCiudades {

    public static ArrayList<Ciudad> arrCiudades= new ArrayList<Ciudad>();
    
    public static void menuCiudades(){

        Scanner sc=new Scanner(System.in);

        System.out.println("Lista de ciudades registradas: ");

        for (Ciudad ciudad: arrCiudades){
            System.out.println(ciudad.getNombre());
        }

        System.out.println("Desea registrar una nueva ciudad? S/N");

        String respuesta=sc.nextLine();

        if(respuesta=="S"){

            System.out.println("Ingrese el nombre de la ciudad: ");
            String nombre=sc.nextLine();

            System.out.println("Ingrese el nombre de la provincia de la ciudad?: ");
            String provincia=sc.nextLine();

            Ciudad ciudad= new Ciudad(nombre,provincia);
            ciudad.generarCodCiudad();

        }

        else if(respuesta=="N"){
            System.out.println("Regresando al menú principal...");
            NewMain.menuPrincipal();
        }


        sc.close();
    }
}
