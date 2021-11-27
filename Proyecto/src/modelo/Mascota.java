
package modelo;

import enums.TipoEspecie;
import java.time.LocalDate;
import admins.*;

public class Mascota {
    
    public String nombre;
    public TipoEspecie mascota;
    public String raza;
    public LocalDate fechaNacimiento;
    public DueñoMascota dueño;
    public String CodMascota;

    public Mascota(){}

    public Mascota(String n,String r){
        nombre=n;
        raza=r;
    }

    public Mascota (String c){
        CodMascota=c;
    }

    public Mascota(String n, TipoEspecie m, String r, LocalDate fn, DueñoMascota d){
        nombre=n;
        mascota=m;
        raza=r;
        fechaNacimiento=fn;
        dueño=d;
    }

    public void generarCodMascota(){

        String codMascota="";
        String nombreSinEspacios=nombre.replace(" ", "");
        
        String [] arrNombre= nombreSinEspacios.split("");
        int tamaño=arrNombre.length;
        for (int i=0;i<2;i++){
            double ind= Math.floor(Math.random()*tamaño);
            String letraAleatoria=arrNombre[(int)ind];
            codMascota=codMascota+letraAleatoria;
        }

        for (int i=0;i<2;i++){
            String numero= String.valueOf((int) (Math.random()*10));
            codMascota=codMascota+numero;
        }
        
        CodMascota=codMascota.toUpperCase();;
    }

    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }

        if (obj !=null && obj instanceof Mascota){
            Mascota other= (Mascota) obj;
            return CodMascota.equals(other.CodMascota);
        }

        return false;
    }

    public static Mascota busquedMascota(String codMascota){
        Mascota busquedaMascota = new Mascota(codMascota);
        Mascota mascotaRegistrar = new Mascota();

        if (AdminMascotas.arrMascotas.contains(busquedaMascota)){
            int ind=AdminMascotas.arrMascotas.indexOf(busquedaMascota);
            mascotaRegistrar= AdminMascotas.arrMascotas.get(ind);
        }

        return mascotaRegistrar;
    }
    
}
