
package admins;

import java.time.*;
import java.util.*;
import modelo.*;
import main.*;
import admins.*;

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
            
             System.out.print("Escoga una ciudad de la lista: ");

             int indiceciudad=sc.nextInt();
             sc.nextLine();
             Ciudad ciudad=NewMain.arrCiudades.get(indiceciudad);

             System.out.println("Ingrese la fecha del evento (YYYY-MM-DD)");
                String fechaString=sc.nextLine();
                LocalDate fechaevento=LocalDate.parse(fechaString);

             System.out.println("Ingrese la hora del evento (HH:MM:SS)");
                String horaString=sc.nextLine();
                LocalTime horaevento=LocalTime.parse(horaString);

             System.out.println("Ingrese la fecha de inicio de inscripciones (YYYY-MM-DD)");
                String fechaInicioString=sc.nextLine();
                LocalDate fechaInicio=LocalDate.parse(fechaInicioString);

             System.out.println("Ingrese la fecha de fin de inscripciones (YYYY-MM-DD)");
                String fechaFinString=sc.nextLine();
                LocalDate fechaFin=LocalDate.parse(fechaFinString);

             System.out.println("Creación de la lista de premios \n Ingrese la descripción y auspiciantes correspondientes para cada premio del concurso, del Primer al Tercer lugar");
             
             //System.out.print(AdminAuspiciantes.auspiciante1);

             Concurso concurso=new Concurso(nombre,fechaevento,horaevento,fechaInicio,fechaFin,ciudad,lugar);
             arrConcursos.add(concurso);
             System.out.print(concurso);
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

            default: System.out.println("Opción no existente");
            MenuConcursos();    
        }

    }
}
