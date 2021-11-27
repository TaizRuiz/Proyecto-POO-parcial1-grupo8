
package admins;

import java.time.*;
import java.util.*;
import modelo.*;
import main.*;
import enums.*;

public class AdminConcursos {
    

    public static ArrayList<Concurso> arrConcursos= new ArrayList<Concurso>();
    
    public static void MenuConcursos(){

        
        System.out.println("Concursos existentes: ");
        
        if (arrConcursos.size()==0){
            
            System.out.println("No hay concursos registrados");
        }
        else{

            for (int i=0;i<arrConcursos.size();i++){
                System.out.println("-Nombre: "+arrConcursos.get(i).nombre+" Código: "+arrConcursos.get(i).CodConcurso);
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
                    System.out.println("-"+c.nombre);
                }

             System.out.print("Escoga una ciudad de la lista: ");
                String nombreCiudad=sc.nextLine();
                Ciudad ciudad=Ciudad.busquedaCiudad(nombreCiudad);

             System.out.print("Ingrese la fecha del evento (YYYY-MM-DD): ");
                String fechaString=sc.nextLine();
                LocalDate fechaevento=LocalDate.parse(fechaString);

             System.out.print("Ingrese la hora del evento (HH:MM:SS): ");
                String horaString=sc.nextLine();
                LocalTime horaevento=LocalTime.parse(horaString);

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

                for (Auspiciante a: NewMain.arrAuspiciantes){
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
             int opciontipo=sc.nextInt();
             sc.nextLine();

             TiposAnimal dirigidoA=TiposAnimal.Vacio;
        
             if (opciontipo==1){
                dirigidoA=TiposAnimal.Todos;
             }

             else if (opciontipo==2){
                dirigidoA=TiposAnimal.SoloPerros;
             }

             else if (opciontipo==3){
                dirigidoA=TiposAnimal.SoloGatos;
             }
                
             else{
                System.out.println("Opción no válida");
             }

             Concurso concurso=new Concurso(nombre,fechaevento,horaevento,fechaInicio,fechaFin,ciudad,lugar,arrPremios,arrDeAuspiciantes,dirigidoA);
             concurso.generarCodConcurso();
             
             arrConcursos.add(concurso);
             
             ArrayList<Mascota> arrMascotas= new ArrayList<Mascota>();
             concurso.participantes=arrMascotas;

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

            case 2: 

             if (arrConcursos.size()==0){
            
                System.out.println("No hay concursos registrados");
             }
             else{
    
                for (int i=0;i<arrConcursos.size();i++){
                    System.out.println("-Nombre: "+arrConcursos.get(i).nombre+" Código: "+arrConcursos.get(i).CodConcurso);
             }
             }

             System.out.println("Ingrese el código del concurso al que quiere inscribir un participante: ");
             String codigoConcurso= sc.nextLine();
             Concurso concursoInscribir=Concurso.busquedaConcurso(codigoConcurso);

             System.out.println("Lista de mascotas inscritas en el concurso "+concursoInscribir.nombre);

             if (concursoInscribir.participantes.size()==0){
                 System.out.println("No hay mascotas registradas");
             }

             else{
             for (Mascota m: concursoInscribir.participantes){
                 System.out.println("- Nombre de la mascota: "+m.nombre+" Código: "+m.CodMascota);
             }
            }

             System.out.println("Ingrese el código del participante que será inscrito en el concurso: "+concursoInscribir.nombre);
             String codMascota= sc.nextLine();
             Mascota mascotaRegistrar=Mascota.busquedMascota(codMascota);

             concursoInscribir.participantes.add(mascotaRegistrar);

             System.out.println("Se ha registrado a "+mascotaRegistrar.nombre+" en el concurso "+concursoInscribir.nombre);
             
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


            case 3: NewMain.MenuPrincipal();
            break;

            default: System.out.println("Opción no existente");
             MenuConcursos();    
            

             sc.close();
        }

    }     
}
