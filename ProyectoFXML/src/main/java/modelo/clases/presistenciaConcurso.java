public class presistenciaConcurso {
    public static void serializarConcurso() throws IOException{
            
            FileOutputStream fout= new FileOutputStream("archivos/concursos.ser");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(MenúPrincipalController.getArrConcursos());
            out.flush();
            
        }
}
