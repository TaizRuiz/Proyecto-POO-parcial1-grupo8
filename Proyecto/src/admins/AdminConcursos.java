
package admins;

import java.time.*;
import java.util.*;
import modelo.*;
import main.*;
import enums.*;

public class AdminConcursos {

    static ArrayList<Concurso> arrConcursos= new ArrayList<Concurso>();
    
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

             int indiceciudad=sc.nextInt();
             sc.nextLine();
             Ciudad ciudad=NewMain.arrCiudades.get(indiceciudad);

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
             
             Premio[] arrPremios= new Premio[3];
             
             for(int i=0;i<3;i++){

                Puesto puesto=Puesto.values()[i];
                
                System.out.print("Ingrese la descripción del premio para el "+(i+1)+"º lugar: ");
                String descripcion= sc.nextLine();

                System.out.println("Seleccione los auspiciantes de la siguiente lista para el "+(i+1)+"º lugar");

                for (Auspiciante a: NewMain.arrAuspiciantes){
                    System.out.println("-"+a.nombre);
                 }
                System.out.print("Nombre del auspiciante elegido: ");

                int indiceAuspiciante=sc.nextInt();
                sc.nextLine();
                Auspiciante auspiciante=NewMain.arrAuspiciantes.get(indiceAuspiciante);

                Premio premio=new Premio(puesto,descripcion,auspiciante);
                arrPremios[i]=premio;

             }

                System.out.println("De la siguente lista seleccione los auspiciantes para el concurso");

                ArrayList<Auspiciante> arrDeAuspiciantes= new ArrayList<Auspiciante>();

                for (Auspiciante a: NewMain.arrAuspiciantes){
                    System.out.println("-"+a.nombre);
                 }

                System.out.print("Elige una opción: ");
                int indiceAuspicianteC=sc.nextInt();
                sc.nextLine();
                Auspiciante auspicianteConcurso=NewMain.arrAuspiciantes.get(indiceAuspicianteC);
                arrDeAuspiciantes.add(auspicianteConcurso);


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
             arrConcursos.add(concurso);
             concurso.generarCodConcurso();
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
            String codigoUsuario= sc.nextLine();
            Concurso busqueda= new Concurso(codigoUsuario);
            Concurso concursoElegido=new Concurso("Vacio");

            if (arrConcursos.contains(busqueda)){
                int ind=arrConcursos.indexOf(busqueda);
                concursoElegido= arrConcursos.get(ind);
            }

            System.out.println("Ingrese el código del participante que será inscrito en el concurso: "+concursoElegido.nombre);

            String codigoUsuarioMascota = sc.nextLine();
            Mascota busquedaMascota = new Mascota(codigoUsuarioMascota);
            Mascota mascotaRegistrar = new Mascota("Vacio");

            if (AdminMascotas.arrMascotas.contains(busquedaMascota)){
                int ind=AdminMascotas.arrMascotas.indexOf(busquedaMascota);
                mascotaRegistrar= AdminMascotas.arrMascotas.get(ind);
            }

            concursoElegido.participantes.add(mascotaRegistrar);

            System.out.println("Se ha registrado a "+mascotaRegistrar.nombre+" en el concurso "+concursoElegido.nombre);

            case 3: NewMain.MenuPrincipal();

            default: System.out.println("Opción no existente");
            MenuConcursos();    

            sc.close();
        }

    }     
}
