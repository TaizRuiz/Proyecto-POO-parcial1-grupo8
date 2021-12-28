
package modelo.clases;

import java.time.LocalDate;
import modelo.admins.AdminMascotas;
import modelo.enums.TipoEspecie;

public class Mascota {
    
    private String nombre;
    private TipoEspecie mascota;
    private String raza;
    private LocalDate fechaNacimiento;
    private String foto;
    private Persona dueño;
    private String CodMascota;

    
    // constructor
    
    public Mascota(){}

    public Mascota (String c){
        CodMascota=c;
    }

    public Mascota(String n, TipoEspecie m, String r, LocalDate fn, String pic, DueñoMascota d){
        nombre=n;
        mascota=m;
        raza=r;
        fechaNacimiento=fn;
        foto = pic;
        dueño=d;
    }

    public Mascota(String n, TipoEspecie m, String r, LocalDate fn, Persona d){
        nombre=n;
        mascota=m;
        raza=r;
        fechaNacimiento=fn;
        dueño=d;
    }
    
    
    // getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoEspecie getMascota() {
        return mascota;
    }

    public void setMascota(TipoEspecie mascota) {
        this.mascota = mascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto(){
        return foto;
    }
    
    public void setFoto(String f){
        foto = f;
    }
    
    public Persona getDueño() {
        return dueño;
    }

    public void setDueño(DueñoMascota dueño) {
        this.dueño = dueño;
    }

    public String getCodMascota() {
        return CodMascota;
    }

    public void setCodMascota(String CodMascota) {
        this.CodMascota = CodMascota;
    }
    
        
    // metodos
    
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

    @Override
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
            mascotaRegistrar= (Mascota) AdminMascotas.arrMascotas.get(ind);
        }

        return mascotaRegistrar;
    }
    
}
