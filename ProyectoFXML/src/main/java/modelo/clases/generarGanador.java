public class generarGanador {
    public static void generarGanadores(Concurso concursoFinalizar){
        
        
        int i=0;
        while(i<3){
            Random r=new Random();
            int ind=r.nextInt(concursoFinalizar.getParticipantes().size());
            Mascota mascotaGanadora=concursoFinalizar.getParticipantes().get(ind);
            
            Premio[] premio=concursoFinalizar.getPremio();

            Ganador ganador= new Ganador(mascotaGanadora.getNombre(),premio[i],premio[i].getPuesto());

            if (concursoFinalizar.getArrGanadores().contains(ganador)){}
            
            else{
            concursoFinalizar.getArrGanadores().add(ganador);
            i++;
        
        }     
        }
    }
    
}
