public class persistenciaAuspiciante {
    public static void serializarAuspiciante(){
          
        try{
            FileOutputStream fout= new FileOutputStream("archivos/auspiciantes.ser");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(MenúPrincipalController.getArrAuspiciantes());
            out.flush();
            
        }
        
        catch (IOException e){
            System.out.println(e);
        }

    
    }
    
}
