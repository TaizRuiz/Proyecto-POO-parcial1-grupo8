package admins;

import java.util.*;
import modelo.*;

public class AdminEstadoConcursos {

    public static void menuEstadoConcursos(){

        System.out.println("Menú de opciones del estado de concursos: \n 1.Cambiar estado de un concurso \n 2.Consultar ganadores de un concurso \n 3.Regresar al menú concurso");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion= sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1:
            System.out.print(" 1.Cerrar inscripciones de un concurso \n 2.Terminar un concurso \n Seleccione una opción:");

            int opcionMenu= sc.nextInt();
            sc.nextLine();
            
            if (opcionMenu==1){

                System.out.println("Lista de concursos con inscripciones abiertas: ");
                
                for (Concurso c: AdminConcursos.arrConcursos){
                    if(c.abiertoInscripciones==true){
                        System.out.println("- Nombre: "+c.nombre+" Código: "+c.CodConcurso);
                    }
                }

                System.out.print("Escribe el codigo del concurso al que se cerraran las inscripciones: ");
                String codigoConcurso= sc.nextLine();
                Concurso concursoCerrarInscripciones=Concurso.busquedaConcurso(codigoConcurso);
                concursoCerrarInscripciones.abiertoInscripciones=false;
                System.out.print("Se han cerrado inscripciones del concurso "+concursoCerrarInscripciones.nombre);

            }

            else if (opcionMenu==2){
                
                System.out.println("Lista de concursos en curso: ");
                
                for (Concurso c: AdminConcursos.arrConcursos){
                    if(c.concursoEnCurso==true){
                        System.out.println("- Nombre: "+c.nombre+" Código: "+c.CodConcurso);
                    }
                }

                System.out.print("Escribe el codigo del concurso que desea finalizar: ");
                String codigoConcurso= sc.nextLine();
                Concurso concursoFinalizar=Concurso.busquedaConcurso(codigoConcurso);
                concursoFinalizar.concursoEnCurso=false;
                System.out.println("Concurso "+concursoFinalizar.nombre+" finalizado");
                System.out.println("Generando lista de ganadores");

                //Generar lista ganadores


             System.out.println(" 1.Regresar al menú estado de concursos \n 2.Regresar al concurso ");
             System.out.print("Elige una opción: ");
             opcion= sc.nextInt();
             sc.nextLine();
                if (opcion==1){
                    AdminEstadoConcursos.menuEstadoConcursos();
                }
                else if (opcion==2){
                    AdminConcursos.menuConcursos();
                }
            }
            break;

            case 2:
            

            case 3:AdminConcursos.menuConcursos();
            break;

        }

        sc.close();   
    }
    
}
