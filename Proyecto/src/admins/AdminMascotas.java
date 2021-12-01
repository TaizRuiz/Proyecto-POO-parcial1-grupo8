package admins;

import java.time.LocalDate;
import java.util.*;
import modelo.*;
import enums.*;
import main.NewMain;

public class AdminMascotas {

    public static ArrayList<Mascota> arrMascotas= new ArrayList<Mascota>();

    public static void menuMascotas(){
        System.out.println("\n-Mascotas existentes: ");
        
        if (arrMascotas.isEmpty()){
            
            System.out.println("\nNo hay mascotas registrados");
        }
        else{

            for (Mascota m: arrMascotas){
                System.out.println("-Nombre: "+m.getNombre()+" Código: "+m.getCodMascota());
        }
            
        }
        
        System.out.println("\n------Menú de opciones de mascotas------ \n 1. Crear mascota \n 2. Eliminar mascota \n 3. Regresar al menú principal");
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nEscoja opción: ");
        int op = sc.nextInt();
        sc.nextLine();
        
        switch(op){
            
            case 1:
                System.out.print("\nIngrese el nombre de la mascota: ");
                String nomMasc = sc.nextLine();
                
                System.out.print("\nEscoja el tipo de animal: \n 1. Perro \n 2. Gato \n Seleccione una opción: "); 
                
                int opEspecie = sc.nextInt();
                sc.nextLine();
                
                TipoEspecie DiriA = TipoEspecie.Vacio;
                
                if (opEspecie==1){
                    DiriA = TipoEspecie.Perro;
                }
                else if(opEspecie==2){
                    DiriA = TipoEspecie.Gato;
                }
                                
                System.out.print("\nIngrese la raza de la mascota: ");
                String raza = sc.nextLine();
                
                System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
                String fechaStr = sc.nextLine();
                LocalDate fechaNac = LocalDate.parse(fechaStr);
                
                boolean dueñoEncontrado=false;
                Persona dueñoM=null;
               
                while(dueñoEncontrado==false){

                    System.out.print("Ingrese el dueño de la mascota: ");
                    String dueñoNombre = sc.nextLine();
                    dueñoM = new DueñoMascota(dueñoNombre);
                for (DueñoMascota d: AdminDueños.arrDueño){
                    Persona du= (Persona) d;
                    if (dueñoM.equals(du)){
                        dueñoEncontrado=true;
                        dueñoM=du;
                    }
                }
                }

                
                Mascota m1 = new Mascota(nomMasc,DiriA,raza,fechaNac,dueñoM);
                
                System.out.println("\nGenerando código para "+nomMasc+" ... ");
                m1.generarCodMascota();
                
                // mascota añadida a la lista
                arrMascotas.add(m1);
                
                System.out.println("¡¡¡Mascota "+nomMasc+" creada exitosamente!!! ");
                
                
                System.out.println("\n1.Regresar al menú mascota \n2.Regresar al menú principal ");
                System.out.print("Elige una opción: ");
                int opcion= sc.nextInt();
                sc.nextLine();
                if (opcion==1){
                    AdminMascotas.menuMascotas();
                }
                else if (opcion==2){
                    NewMain.menuPrincipal();
                }
            
             break;
                
            case 2:
                System.out.print("\nIngrese id de la mascota a eliminar: ");
                String codigo = sc.nextLine();
                Mascota buscarMascota = new Mascota(codigo);
                for(int i=0;i<arrMascotas.size();i++){
                    if(arrMascotas.get(i).equals(buscarMascota)){
                        arrMascotas.remove(i);
                    }
                }
                System.out.println("\nMascota con id: "+codigo+" eliminada con éxito!");
                
                System.out.println("\n1.Regresar al menú mascota \n2.Regresar al menú principal ");
                System.out.print("Elige una opción: ");
                int opcion2= sc.nextInt();
                sc.nextLine();
                if (opcion2==1){
                    AdminMascotas.menuMascotas();
                }
                else if (opcion2==2){
                    NewMain.menuPrincipal();
                }
            
             break;
             
            case 3:
                System.out.println("\nRegresando al menú principal...");
                NewMain.menuPrincipal();
                
            default:
                System.out.println(">>> Opción no existente <<<");
                menuMascotas();
        }

        sc.close();
    }
    
}
