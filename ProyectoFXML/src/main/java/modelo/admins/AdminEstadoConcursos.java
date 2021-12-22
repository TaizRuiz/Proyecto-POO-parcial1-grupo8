package admins;

import clases.Concurso;
import clases.Ganador;
import java.util.*;


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

                Concurso concursoCerrar = null;
                String cod=null;
                int x=0;
                do{
                    if(x>0){
                        System.out.println("---Concurso no encontrado ---");
                    }
                    System.out.print("\nIngrese el código del concurso al que quiere cerrar inscripciones: ");
                    cod= sc.nextLine();
                    concursoCerrar = new Concurso(cod);
                    x++;
                }while(!(AdminConcursos.arrConcursos.contains(concursoCerrar)));

                concursoCerrar=Concurso.busquedaConcurso(cod);
                concursoCerrar.setAbiertoInscripciones(false);
                System.out.println("\nSe han cerrado inscripciones del concurso "+concursoCerrar.getNombre());

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

                Concurso concursoFinalizar = null;
                String cod=null;
                int x=0;
                do{
                    if(x>0){
                        System.out.println("---Concurso no encontrado ---");
                    }
                    System.out.print("\nIngrese el código del concurso que quiere finalizar : ");
                    cod= sc.nextLine();
                    concursoFinalizar = new Concurso(cod);
                    x++;
                }while(!(AdminConcursos.arrConcursos.contains(concursoFinalizar)));

                concursoFinalizar=Concurso.busquedaConcurso(cod);
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
