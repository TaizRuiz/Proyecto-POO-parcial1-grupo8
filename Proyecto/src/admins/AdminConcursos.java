
package admins;

import java.time.*;
import java.util.*;
import modelo.*;
import main.*;
import enums.*;

public class AdminConcursos {
    

    public static ArrayList<Concurso> arrConcursos= new ArrayList<Concurso>();
    
    public static void menuConcursos(){

        
        System.out.println("Concursos existentes: ");
        
        if (arrConcursos.size()==0){
            
            System.out.println("No hay concursos registrados");
        }
        else{

            for (int i=0;i<arrConcursos.size();i++){
                System.out.println("-Nombre: "+arrConcursos.get(i).getNombre()+" Código: "+arrConcursos.get(i).getCodConcurso());
        }
        }
        
        System.out.println("Menú de opciones de concursos: \n 1.Crear concurso \n 2.Estado de concursos \n 3.Inscribir participante \n 4.Regresar al menú principal");
        
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
                for (Ciudad c: AdminCiudades.arrCiudades){
                    System.out.println("-"+c.getNombre());
                }

             System.out.print("Escoga una ciudad de la lista: ");
                String nombreCiudad=sc.nextLine();
                Ciudad ciudad=Ciudad.busquedaCiudad(nombreCiudad);

             System.out.print("Ingrese la fecha del evento (YYYY-MM-DD): ");
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

             System.out.println("Creación de la lista de premios \nIngrese la descripción y auspiciantes correspondientes para cada premio del concurso, del Primer al Tercer lugar");
             
             Premio[] arrPremios=new Premio[3];
             arrPremios=Premio.generarListaPremios(arrPremios);
             

             System.out.println("¿Cuántos auspiciantes desea inscribir para el concurso "+nombre+"?");
             int cantAuspiciantes=sc.nextInt();
             sc.nextLine();

             ArrayList<Auspiciante> arrDeAuspiciantes= new ArrayList<Auspiciante>();

             System.out.println("De la siguente lista seleccione los auspiciantes para el concurso");

                for (Auspiciante a: AdminAuspiciantes.arrAuspiciantes){
                    System.out.println("-"+a.nombre);
                 }

             int x=0;
             while (x<cantAuspiciantes){

             System.out.print("Ingrese el nombre del "+(x+1)+"º auspiciante que desea elegir para el concurso: ");
                
             String nombreAuspiciante=sc.nextLine();
                Auspiciante auspicianteConcurso=Auspiciante.busquedaAuspiciante(nombreAuspiciante);
                arrDeAuspiciantes.add(auspicianteConcurso);
                x++;

             }

             System.out.println("A quién está dirigido el concurso? \n 1.Para todos \n 2.Solo perros \n 3.Solo gatos");

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

             Concurso concurso=new Concurso(nombre,fechaEvento,horaEvento,fechaInicio,fechaFin,ciudad,lugar,arrPremios,arrDeAuspiciantes,dirigidoA);
             concurso.generarCodConcurso();
             concurso.setAbiertoInscripciones(true);
             concurso.setConcursoEnCurso(true);
             
             arrConcursos.add(concurso);
             
             ArrayList<Mascota> arrMascotas= new ArrayList<Mascota>();
             concurso.setParticipantes(arrMascotas);

             System.out.println("Concurso "+nombre+" creado exitosamente");

             System.out.println(" 1.Regresar al menú concurso \n 2.Regresar al menú principal ");
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

             if (arrConcursos.size()==0){
            
                System.out.println("No hay concursos registrados");
             }
             else{
    
                for (int i=0;i<arrConcursos.size();i++){
                    System.out.println("-Nombre: "+arrConcursos.get(i).getNombre()+" Código: "+arrConcursos.get(i).getCodConcurso());
             }
             }

             System.out.println("Ingrese el código del concurso al que quiere inscribir un participante: ");
             String codigoConcurso= sc.nextLine();
             Concurso concursoInscribir=Concurso.busquedaConcurso(codigoConcurso);

             System.out.println("Lista de mascotas inscritas en el concurso "+concursoInscribir.getNombre());

             if (concursoInscribir.getParticipantes().size()==0){
                 System.out.println("No hay mascotas registradas");
             }

             else{
             for (Mascota m: concursoInscribir.getParticipantes()){
                 System.out.println("- Nombre de la mascota: "+m.getNombre()+" Código: "+m.getCodMascota());
             }
            }

             System.out.println("Ingrese el código del participante que será inscrito en el concurso: "+concursoInscribir.getNombre());
             String codMascota= sc.nextLine();
             Mascota mascotaRegistrar=Mascota.busquedMascota(codMascota);

             concursoInscribir.getParticipantes().add(mascotaRegistrar);

             System.out.println("Se ha registrado a "+mascotaRegistrar.getNombre()+" en el concurso "+concursoInscribir.getNombre());
             
             System.out.println(" 1.Regresar al menú concurso \n 2.Regresar al menú principal ");
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

            default: System.out.println("Opción no existente");
             menuConcursos();    
            

             sc.close();
        }

    }     
}
