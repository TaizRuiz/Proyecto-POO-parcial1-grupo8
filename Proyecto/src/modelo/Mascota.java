
package modelo;

import enums.TiposAnimal;
import java.time.LocalDate;

public class Mascota {
    
    public String nombre;
    public TiposAnimal mascota;
    public String raza;
    public LocalDate fechaNacimiento;
    public DueñoMascota dueño;
    public String CodMascota;

    public Mascota(String n, TiposAnimal m, String r, LocalDate fn, DueñoMascota d, String cod){
        nombre=n;
        mascota=m;
        raza=r;
        fechaNacimiento=fn;
        dueño=d;
        CodMascota=cod;
    }
    
}
