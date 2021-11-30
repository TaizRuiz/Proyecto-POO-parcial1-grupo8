package admins;

import java.util.*;
import modelo.*;
import main.*;

public class AdminDueños { 
    
    public static ArrayList<DueñoMascota> arrDueño= new ArrayList<DueñoMascota>();
    
    public static void MenuDueños(){
        
        System.out.println("Dueños de Mascotas existentes: ");
        
        
        if (arrDueño.size()==0){
            
            System.out.println("No hay Dueños registrados");
        }
        else{

            for (int i=0;i<arrDueño.size();i++){
                System.out.println(arrDueño.get(i).nombre);
        }
        }
        
        
        System.out.println("Menú de opciones de concursos: ");
        System.out.println(" 1.Crear dueño ");
        System.out.println(" 2. Editar dueño ");
        System.out.println(" 3.Regresar al menú principal ");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        
        switch(opcion){

            case 1:
                System.out.println("Ingrese la cedula del Dueño: ");
                int cedula = sc.nextInt();
                
                System.out.println("Ingrese los nombres: ");
                String nombre = sc.nextLine();
                System.out.println("Ingrese los apellidos:  ");
                String apellido= sc.nextLine();
                System.out.println("Ingrese la direccion:  ");
                String direccion= sc.nextLine();
                System.out.println("Ingrese un numero de telefono:  ");
                double telefono= sc.nextDouble();
                System.out.println("Ingrese la ciudad:  ");
                String ciudad= sc.nextLine();
               
                System.out.println("Ingrese un E-mail:  ");
                String correo= sc.nextLine();
                
                DueñoMascota dueño = new DueñoMascota(cedula,apellido,nombre,direccion, telefono,ciudad, correo);
                arrDueño.add(dueño);
                System.out.println("Dueño "+ dueño.nombre+ " registrado exitosamente");
                
                System.out.println(" 1.Regresar al menú Dueño");
                System.out.println("2.Regresar al menú principal");
                System.out.print("Elige una opción: ");
                opcion= sc.nextInt();
                sc.nextLine();
                if (opcion==1){
                    AdminDueños.MenuDueños();
                }
                else if (opcion==2){
                    NewMain.menuPrincipal();
                }
            
             break;


            case 2: 
                System.out.println("Ingrese el id del dueño que quiere modificar: ");
                double id = sc.nextDouble();
                DueñoMascota modificable = null;
                for(DueñoMascota d: arrDueño){
                    if (d.getCedulaIdentidad() == id){
                        modificable = d;
                    }
                }
                
                System.out.println("1. Modificar nombre");
                System.out.println("2. Modificar apellido");
                System.out.println("3. Modificar direccion");
                System.out.println("4. Modificar telefono");
                System.out.println("5. Modificar ciudad");
                System.out.println("6. Modificar correo");
                System.out.println("7. Terminar modificacion");
//                se crea el menu para elegir las opciones de modificacion 
                int op = 0;
                while (op != 7){
                    System.out.print("Elige una opción: ");
                    op = sc.nextInt();
                    sc.nextLine();
                    if (modificable!=null){
                        switch(op){
                            case 1:
                                System.out.println("Ingrese los nombres: ");
                                String nombreM = sc.nextLine();
                                modificable.setNombre(nombreM);
                                break;
                            case 2:
                                System.out.println("Ingrese los apellidos:  ");
                                String apellidoM= sc.nextLine();
                                modificable.setApellido(apellidoM);
                                break;
                            case 3:
                                System.out.println("Ingrese la direccion:  ");
                                String direccionM= sc.nextLine();
                                modificable.setDireccion(direccionM);
                                break;
                            case 4:
                                System.out.println("Ingrese un numero de telefono:  ");
                                double telefonoM= sc.nextDouble();
                                modificable.setTelefono(telefonoM);
                                break;
                            case 5:
                                System.out.println("Ingrese la ciudad:  ");
                                String ciudadM= sc.nextLine();
                                modificable.setCiudad(ciudadM);
                                break;
                            case 6:
                                System.out.println("Ingrese un E-mail:  ");
                                String correoM= sc.nextLine();
                                modificable.setEmail(correoM);
                                break;
                        }
                    }else{
                        System.out.println("Este usuario no se encontró");
                        System.out.println("");
                    }
                }
//                aqui aparecen las opciones para elegir un menu de nuevo 
                System.out.println("Modificacion terminada.");
                System.out.println(" 1.Regresar al menú Dueño");
                System.out.println("2.Regresar al menú principal");
                System.out.print("Elige una opción: ");
                opcion= sc.nextInt();
                sc.nextLine();
                if (opcion==1){
                    AdminDueños.MenuDueños();
                }
                else if (opcion==2){
                    NewMain.menuPrincipal();
                }
             break;


            case 3: NewMain.menuPrincipal();

            default: System.out.println("Opción no existente");
                    MenuDueños();  
                    
                    

        
        } 
    }
    
        
}