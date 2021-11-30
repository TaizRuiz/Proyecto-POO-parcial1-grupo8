package admins;

import java.util.*;
import modelo.*;


public class AdminEstadoConcursos {

    public static void menuEstadoConcursos(){

        System.out.println("\n---Menú de opciones del estado de los concursos--- \n1.Cambiar estado de un concurso \n2.Consultar ganadores de un concurso \n3.Regresar al menú concurso");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion= sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1:
            System.out.print("\n¿Qué desea hacer? \n1.Cerrar inscripciones de un concurso \n2.Terminar un concurso \nSeleccione una opción: ");

            int opcionMenu= sc.nextInt();
            sc.nextLine();
            
            if (opcionMenu==1){

                System.out.println("\nLista de concursos con inscripciones abiertas: ");
                
                for (Concurso c: AdminConcursos.arrConcursos){
                    if(c.isAbiertoInscripciones()==true){
                        System.out.println("- Nombre: "+c.getNombre()+" Código: "+c.getCodConcurso());

                    }
                }


                System.out.print("\nEscribe el código del concurso al que se cerraran las inscripciones: ");
                String codigoConcurso= sc.nextLine();
                Concurso concursoCerrarInscripciones=Concurso.busquedaConcurso(codigoConcurso);
                concursoCerrarInscripciones.setAbiertoInscripciones(false);
                System.out.println("\nSe han cerrado inscripciones del concurso "+concursoCerrarInscripciones.getNombre());

                System.out.println("\n1.Regresar al menú estado de concursos \n2.Regresar al menú concurso ");
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

            else if (opcionMenu==2){
                
                System.out.println("\nLista de concursos en curso: ");
                
                for (Concurso c: AdminConcursos.arrConcursos){
                    if(c.isConcursoEnCurso()==true){
                        System.out.println("- Nombre: "+c.getNombre()+" Código: "+c.getCodConcurso());
                    }
                }

                System.out.print("\nEscribe el codigo del concurso que desea finalizar: ");
                String codigoConcurso= sc.nextLine();
                Concurso concursoFinalizar=Concurso.busquedaConcurso(codigoConcurso);
                concursoFinalizar.setAbiertoInscripciones(false);
                concursoFinalizar.setConcursoEnCurso(false);
                System.out.println("\nConcurso "+concursoFinalizar.getNombre()+" finalizado");
                System.out.println("Generando lista de ganadores....");

                //Para este caso los ganadores serán elegidos de forma aleatoria
                Ganador.generarGanadores(concursoFinalizar);


             System.out.println("\n1.Regresar al menú estado de concursos \n2.Regresar al menú concurso ");
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
            System.out.println("\nLista de concursos finalizados: ");

            for (Concurso conc: AdminConcursos.arrConcursos){
                if(conc.isConcursoEnCurso()==false){
                    System.out.println("- Nombre: "+conc.getNombre()+" Código: "+conc.getCodConcurso());
                }
            }

            System.out.print("\nIngrese el código del concurso al que desea consultar los ganadores: \n");

            String codConcurso= sc.nextLine();
            Concurso concursoConsultar=Concurso.busquedaConcurso(codConcurso);

            for (Ganador ganador: concursoConsultar.getArrGanadores()){
                System.out.println(ganador);
            }

            System.out.println("\n1.Regresar al menú estado de concursos \n2.Regresar al menú concurso ");
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
