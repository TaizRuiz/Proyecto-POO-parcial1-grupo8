
package modelo.admins;

import java.time.*;
import java.util.*;
import modelo.clases.*;
import modelo.enums.TiposAnimal;
import modelo.main.NewMain;

public class AdminConcursos {
    

    public static ArrayList<Concurso> arrConcursos= new ArrayList<Concurso>();
    
    public static void menuConcursos(){

        //Mostrar concursos
        System.out.println("\n------------Menú concursos------------ \n \n Concursos existentes: ");
        
        if (arrConcursos.size()==0){
            
            System.out.println("No hay concursos registrados");
        }
        else{

            for (int i=0;i<arrConcursos.size();i++){
                System.out.println("-Nombre: "+arrConcursos.get(i).getNombre()+" Código: "+arrConcursos.get(i).getCodConcurso());
        }
        }
        
        System.out.println("\n-----Menú de opciones de concursos---- \n 1.Crear concurso \n 2.Estado de concursos \n 3.Inscribir participante \n 4.Regresar al menú principal \n");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion= sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1: 
             System.out.print("\nIngrese el nombre del concurso: ");
                String nombre= sc.nextLine();
             
             System.out.print("Ingrese el lugar del concurso: ");
                String lugar= sc.nextLine();

             System.out.println("\nLista de ciudades inscritas: ");
                for (Ciudad c: AdminCiudades.arrCiudades){
                    System.out.println("-"+c.getNombre());
                }


             Ciudad ciudadInscribir = null;
             String codC=null;
                int w=0;
                do{
                    if(w>0){
                        System.out.println("---Ciudad no encontrada ---");
                    }
                    System.out.print("\nIngrese el nombre de la ciudad que desea inscribir: ");
                    codC= sc.nextLine();
                    ciudadInscribir = new Ciudad(codC);
                    w++;
                }while(!(AdminCiudades.arrCiudades.contains(ciudadInscribir)));

                ciudadInscribir=Ciudad.busquedaCiudad(codC);

             System.out.print("\nIngrese la fecha del evento (YYYY-MM-DD): ");
                String fechaString=sc.nextLine();
                LocalDate fechaEvento=LocalDate.parse(fechaString);

             System.out.print("Ingrese la hora del evento (HH:MM:SS): ");
                String horaString=sc.nextLine();
                LocalTime horaEvento=LocalTime.parse(horaString);

             System.out.print("Ingrese la fecha de inicio de inscripciones (YYYY-MM-DD): ");
                String fechaInicioString=sc.nextLine();
                LocalDate fechaInicio=LocalDate.parse(fechaInicioString);

             System.out.print("Ingrese la fecha de fin de inscripciones (YYYY-MM-DD): ");
                String fechaFinString=sc.nextLine();
                LocalDate fechaFin=LocalDate.parse(fechaFinString);

             System.out.println("\n-Creación de la lista de premio \n(Ingrese la descripción y auspiciantes correspondientes para cada premio del concurso, del Primer al Tercer lugar)");
             
             //Se genera la lista con el método de la clase Premio
             Premio[] arrPremios=new Premio[3];
             arrPremios=Premio.generarListaPremios(arrPremios);
             

             System.out.print("\n¿Cuántos auspiciantes desea inscribir para el concurso "+nombre+"?: ");
             int cantAuspiciantes=sc.nextInt();
             sc.nextLine();

             ArrayList<Auspiciante> arrDeAuspiciantes= new ArrayList<Auspiciante>();

             System.out.println("\nDe la siguente lista seleccione los auspiciantes para el concurso");

                for (Auspiciante a: AdminAuspiciantes.arrAuspiciantes){
                    System.out.println("-"+a.nombre);
                 }

             int x=0;
             while (x<cantAuspiciantes){

             System.out.print("Ingrese el nombre del "+(x+1)+"º auspiciante que desea elegir para el concurso: ");
                
             String nombreAuspiciante=sc.nextLine();
             //Se utiliza el método de Auspiciante para encontrar el auspiciante requerido
                Auspiciante auspicianteConcurso=Auspiciante.busquedaAuspiciante(nombreAuspiciante);
                arrDeAuspiciantes.add(auspicianteConcurso);
                x++;

             }

             System.out.println("\nA quién está dirigido el concurso? \n 1.Para todos \n 2.Solo perros \n 3.Solo gatos");

             System.out.print("Elige una opción: ");
             int opcionTipo=sc.nextInt();
             sc.nextLine();

             TiposAnimal dirigidoA=TiposAnimal.Vacio;
        
             if (opcionTipo==1){
                dirigidoA=TiposAnimal.Todos;
             }

             else if (opcionTipo==2){
                dirigidoA=TiposAnimal.SoloPerros;
             }

             else if (opcionTipo==3){
                dirigidoA=TiposAnimal.SoloGatos;
             }
                
             else{
                System.out.println("Opción no válida");
             }

             //Creación de concurso junto con sus atributos
             Concurso concurso=new Concurso(nombre,fechaEvento,horaEvento,fechaInicio,fechaFin,ciudadInscribir,lugar,arrPremios,arrDeAuspiciantes,dirigidoA);
             concurso.generarCodConcurso();
             concurso.setAbiertoInscripciones(true);
             concurso.setConcursoEnCurso(true);
             
             arrConcursos.add(concurso);
             
             ArrayList<Mascota> arrMascotas= new ArrayList<Mascota>();
             concurso.setArrParticipantes(arrMascotas);

             System.out.println("\n¡¡¡Concurso "+nombre+" creado exitosamente!!!");

             System.out.println("\n1.Regresar al menú concurso \n2.Regresar al menú principal ");
             System.out.print("Elige una opción: ");
             opcion= sc.nextInt();
             sc.nextLine();
                if (opcion==1){
                    AdminConcursos.menuConcursos();
                }
                else if (opcion==2){
                    NewMain.menuPrincipal();
                }
            
            break;

            case 2: AdminEstadoConcursos.menuEstadoConcursos();
            break;

            case 3: 

            //Se muestran los concursos abiertos a inscripciones
             if (arrConcursos.size()==0){
            
                System.out.println("\nNo hay concursos registrados");
             }
             else{
               
                System.out.println("\nLista de concursos abiertos a inscripciones: ");
                
                for (Concurso c: arrConcursos){
                   if (c.isAbiertoInscripciones()==true){
                    System.out.println("-Nombre: "+c.getNombre()+" Código: "+c.getCodConcurso());
                   }
             }
             }

             Concurso concursoInscribir = null;
             String cod=null;
                int y=0;
                do{
                    if(y>0){
                        System.out.println("---Concurso no encontrado ---");
                    }
                    System.out.print("\nIngrese el código del concurso al que quiere inscribir un participante: ");
                    cod= sc.nextLine();
                    concursoInscribir = new Concurso(cod);
                    y++;
                }while(!(arrConcursos.contains(concursoInscribir)));

                concursoInscribir=Concurso.busquedaConcurso(cod);

             System.out.println("\nLista de mascotas inscritas: ");

             if (AdminMascotas.arrMascotas.size()==0){
                 System.out.println("No hay mascotas registradas");
             }

             else{
             for (Mascota m: AdminMascotas.arrMascotas){
                 System.out.println("- Nombre de la mascota: "+m.getNombre()+" Código: "+m.getCodMascota());
             }
            }

             Mascota mascotaInscribir = null;
             String codM=null;
                int z=0;
                do{
                    if(z>0){
                        System.out.println("---Mascota no encontrada ---");
                    }
                    System.out.print("\nIngrese el código de la mascota que quiere inscribir: ");
                    codM= sc.nextLine();
                    mascotaInscribir = new Mascota(codM);
                    z++;
                }while(!(AdminMascotas.arrMascotas.contains(mascotaInscribir)));

                mascotaInscribir=Mascota.busquedMascota(codM);

             concursoInscribir.getParticipantes().add(mascotaInscribir);

             System.out.println("\n¡¡¡Se ha registrado a "+mascotaInscribir.getNombre()+" en el concurso "+concursoInscribir.getNombre()+"!!!");
             
             System.out.println("\n1.Regresar al menú concurso \n2.Regresar al menú principal ");
             System.out.print("Elige una opción: ");
             opcion= sc.nextInt();
             sc.nextLine();
                if (opcion==1){
                    AdminConcursos.menuConcursos();
                }
                else if (opcion==2){
                    NewMain.menuPrincipal();
                }

            break;


            case 4: NewMain.menuPrincipal();
            break;

            default: System.out.println("\nOpción no existente");
             menuConcursos();    
            

             sc.close();
        }

    }     
}
