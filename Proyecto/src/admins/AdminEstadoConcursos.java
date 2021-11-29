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
                    if(c.isAbiertoInscripciones()==true){
                        System.out.println("- Nombre: "+c.getNombre()+" Código: "+c.getCodConcurso());
                    }
                }

                System.out.print("Escribe el codigo del concurso al que se cerraran las inscripciones: ");
                String codigoConcurso= sc.nextLine();
                Concurso concursoCerrarInscripciones=Concurso.busquedaConcurso(codigoConcurso);
                concursoCerrarInscripciones.setAbiertoInscripciones(false);
                System.out.print("Se han cerrado inscripciones del concurso "+concursoCerrarInscripciones.getNombre());

            }

            else if (opcionMenu==2){
                
                System.out.println("Lista de concursos en curso: ");
                
                for (Concurso c: AdminConcursos.arrConcursos){
                    if(c.isConcursoEnCurso()==true){
                        System.out.println("- Nombre: "+c.getNombre()+" Código: "+c.getCodConcurso());
                    }
                }

                System.out.print("Escribe el codigo del concurso que desea finalizar: ");
                String codigoConcurso= sc.nextLine();
                Concurso concursoFinalizar=Concurso.busquedaConcurso(codigoConcurso);
                concursoFinalizar.setConcursoEnCurso(false);
                System.out.println("Concurso "+concursoFinalizar.getNombre()+" finalizado");
                System.out.println("Generando lista de ganadores");

                //Para este caso los ganadores serán elegidos de forma aleatoria
                Ganador.generarGanadores(concursoFinalizar);


             System.out.println(" 1.Regresar al menú estado de concursos \n 2.Regresar al menú concurso ");
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
            System.out.println("Lista de concursos finalizados: ");

            for (Concurso conc: AdminConcursos.arrConcursos){
                if(conc.isConcursoEnCurso()==false){
                    System.out.print("- Nombre: "+conc.getNombre()+" Código: "+conc.getCodConcurso());
                }
            }

            System.out.print("Ingrese el código del concurso al que desea consultar los ganadores: ");

            String codConcurso= sc.nextLine();
            Concurso concursoConsultar=Concurso.busquedaConcurso(codConcurso);

            for (Ganador ganador: concursoConsultar.getArrGanadores()){
                System.out.println(ganador);
            }

            System.out.println(" 1.Regresar al menú estado de concursos \n 2.Regresar al menú concurso ");
             System.out.print("Elige una opción: ");
             opcion= sc.nextInt();
             sc.nextLine();
                if (opcion==1){
                    AdminEstadoConcursos.menuEstadoConcursos();
                }
                else if (opcion==2){
                    AdminConcursos.menuConcursos();
                }
            
            break;

            case 3:AdminConcursos.menuConcursos();
            break;

        }

        sc.close();   
    }
    
}
