
package clases;

import admins.AdminCiudades;


public class Ciudad {

    private String nombre;
    private String provincia;
    private String codCiudad;

    
    // constructor
    
    public Ciudad(){}

    public Ciudad(String n){
        nombre=n;
    }

    public Ciudad (String n, String p){
        nombre=n;
        provincia=p;
    }

    
    // getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }
    
    
    // metodos
    
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }

        if (obj !=null && obj instanceof Ciudad){
            Ciudad other= (Ciudad) obj;
            return nombre.equals(other.nombre);
        }

        return false;
    }

    public static Ciudad busquedaCiudad(String nombreCiudad){


        Ciudad ciudadBusqueda=new Ciudad(nombreCiudad);
        Ciudad ciudadEncontrada= new Ciudad();

        if (AdminCiudades.arrCiudades.contains(ciudadBusqueda)){
            int indCiudad=AdminCiudades.arrCiudades.indexOf(ciudadBusqueda);
            ciudadEncontrada= AdminCiudades.arrCiudades.get(indCiudad);
        }

        return ciudadEncontrada;
    }

    public void generarCodCiudad(){
        
        String [] arrNombre= nombre.split("");
        int tamaño=arrNombre.length;
        for (int i=0;i<2;i++){
            double ind= Math.floor(Math.random()*tamaño);
            String letraAleatoria=arrNombre[(int)ind];
            codCiudad=codCiudad+letraAleatoria;
        }

        for (int i=0;i<2;i++){
            String numero= String.valueOf((int) (Math.random()*10));
            codCiudad=codCiudad+numero;
        }

        codCiudad=codCiudad.toUpperCase();;
    }
    
}
