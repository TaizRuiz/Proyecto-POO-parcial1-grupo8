
package admins;

import java.util.*;
import modelo.*;
import main.*;

public class AdminConcursos {

    static ArrayList<Concurso> arrConcursos= new ArrayList<Concurso>();
    
    public static void MenuConcursos(){
        
        System.out.println("Concursos existentes: ");
        
        if (arrConcursos.size()==0){
            
            System.out.println("No hay concursos registrados");
        }
        else{

            for (int i=0;i<arrConcursos.size();i++){
                System.out.println(arrConcursos.get(i).nombre);
        }
        }
        
        
        System.out.println("Menú de opciones de concursos: \n 1.Crear concurso \n 2.Inscribir participante \n 3.Regresar al menú principal");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion= sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1: 
             System.out.print("Ingrese el nombre del concurso: ");
                String nombre= sc.nextLine();
             System.out.print("Ingrese el lugar del concurso: ");
                String lugar= sc.nextLine();

             System.out.println("Lista de ciudades inscritas: ");
             for (Ciudad c: NewMain.arrCiudades){
                System.out.println(c.nombre);
             }

            
             System.out.print("Elige una ciudad de la lista: ");

             int indiceciudad=sc.nextInt();
             sc.nextLine();
             Ciudad ciudad=NewMain.arrCiudades.get(indiceciudad);
            

             
           
            
            

             Concurso concurso=new Concurso(nombre,lugar,ciudad);
             arrConcursos.add(concurso);
             System.out.println("Concurso "+ concurso.nombre+" creado exitosamente");

             System.out.println(" 1.Regresar al menú concurso \n 2.Regresar al menú principal ");
             System.out.print("Elige una opción: ");
             opcion= sc.nextInt();
             sc.nextLine();
                if (opcion==1){
                    AdminConcursos.MenuConcursos();
                }
                else if (opcion==2){
                    NewMain.MenuPrincipal();
                }
            
             break;


            case 2: System.out.print("Fin del menú");

            case 3: NewMain.MenuPrincipal();
        }

    }
}
