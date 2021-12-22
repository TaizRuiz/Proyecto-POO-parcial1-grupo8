package admins;

import clases.Mascota;
import clases.DueñoMascota;
import java.time.LocalDate;
import java.util.*;
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
                
                            
                DueñoMascota dueñoEncontrado = null;
                boolean found = false;
                int x=0;
                do{
                    if(x>0){
                        System.out.println("--- Dueño no encontrado ---");
                    }
                    System.out.print("\nIngrese dueño de mascota: ");
                    String nomDueño = sc.nextLine();
                    dueñoEncontrado = new DueñoMascota(nomDueño);
                    for(int i=0;i<AdminDueños.arrDueño.size();i++){
                        if(AdminDueños.arrDueño.get(i).equalsDos(dueñoEncontrado)){
                            dueñoEncontrado = AdminDueños.arrDueño.get(i);
                            i=AdminDueños.arrDueño.size();
                            found = true;
                        }
                    }
                    x++;
                }while(found == false);
                                
                Mascota m1 = new Mascota(nomMasc,DiriA,raza,fechaNac,"", dueñoEncontrado);
                
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
                
                boolean foundDos = false;
                int y=0;
                do{
                    if(y>0){
                        System.out.println("--- Mascota no encontrada ---");
                    }
                    System.out.print("\nIngrese id de la mascota a eliminar: ");
                    String codigo = sc.nextLine();
                    Mascota buscarMascota = new Mascota(codigo);
                    for(int i=0;i<arrMascotas.size();i++){
                        if(arrMascotas.get(i).equals(buscarMascota)){
                            arrMascotas.remove(i);
                            foundDos = true;
                            i = arrMascotas.size();
                        }
                    }
                    y++;
                }while(foundDos == false);
            
                
                System.out.println("\nMascota eliminada con éxito!");
                
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
