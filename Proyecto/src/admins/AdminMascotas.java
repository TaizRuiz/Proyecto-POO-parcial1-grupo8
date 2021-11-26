package admins;

import java.time.LocalDate;
import java.util.*;
import modelo.*;
import enums.*;

public class AdminMascotas {

    public static ArrayList<Mascota> arrMascotas= new ArrayList<Mascota>();

    public static void MenuMascotas(){
        System.out.println("Mascotas existentes: ");
        
        if (arrMascotas.isEmpty()){
            
            System.out.println("No hay mascotas registrados");
        }
        else{

            for (Mascota m: arrMascotas){
                System.out.println("-Nombre: "+m.nombre+" Código: "+m.CodMascota);
        }
            
        }
        
        System.out.println("Menú de opciones de mascotas: \n 1. Crear mascota: \n 2. Eliminar mascota: \n 3. Regresar al menú principal.");
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Escoja opción: ");
        int op = sc.nextInt();
        sc.nextLine();
        
        switch(op){
            
            case 1:
                System.out.print("Ingrese el nombre de la mascota: ");
                String nomMasc = sc.nextLine();
                
                System.out.print("Escoja el tipo de animal: \n 1. Perro \n 2. Gato \n"); 
                int opEspecie = sc.nextInt();
                sc.nextLine();
                
                TipoEspecie DiriA = TipoEspecie.Vacio;
                
                if (opEspecie==1){
                    DiriA = TipoEspecie.Perro;
                }
                else if(opEspecie==2){
                    DiriA = TipoEspecie.Gato;
                }
                                
                System.out.print("Ingrese la raza de la mascota: ");
                String raza = sc.nextLine();
                
                System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
                String fechaStr = sc.nextLine();
                LocalDate fechaNac = LocalDate.parse(fechaStr);
                
                System.out.print("Ingrese el dueño de la mascota: ");
                String dueño = sc.nextLine();
                
                // Mascota m1 = new Mascota(nomMa)
        }
    }
    
}
