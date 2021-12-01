package main;

import java.time.*;
import java.util.*;
import admins.*;
import enums.*;
import modelo.*;

public class CargarObjetos {

    public static void cargarObjetos(){

     //Creación de dueños de mascotas
     DueñoMascota dueño1= new DueñoMascota("1208021989","Arévalo","Guillermo","Centro",999111888,"Guayaquil","guillermo@gmail.com");
     DueñoMascota dueño2= new DueñoMascota("1234567890","Crespo","Nathaly","Norte",999666888,"Guayaquil","nathaly@gmail.com");
     DueñoMascota dueño3= new DueñoMascota("1204571989","Rodriguez","Santiago","Sur",999111999,"Guayaquil","santiago@gmail.com");
     DueñoMascota dueño4= new DueñoMascota("1208234689","Saltos","José","Centro",99913588,"Guayaquil","jose@gmail.com");
     DueñoMascota dueño5= new DueñoMascota("1203457889","Villacres","Pamela","Norte",945671888,"Guayaquil","pamela@gmail.com");
     DueñoMascota dueño6= new DueñoMascota("1202357989","Zambrano","Josué","Sur",999395598,"Guayaquil","josue@gmail.com");
     DueñoMascota dueño7= new DueñoMascota("1446521989","Delgado","Rosa","Centro",946511888,"Guayaquil","rosa@gmail.com");
     DueñoMascota dueño8= new DueñoMascota("1208056489","Altamirano","Martha","Centro",934545388,"Guayaquil","martha@gmail.com");
     DueñoMascota dueño9= new DueñoMascota("1245421989","Villavicencio","Martín","Norte",99910008,"Guayaquil","martin@gmail.com");
     DueñoMascota dueño10= new DueñoMascota("1208065589","Orozco","Olivia","Sur",90294588,"Guayaquil","olivia@gmail.com");
     
     AdminDueños.arrDueño.add(dueño1);
     AdminDueños.arrDueño.add(dueño2);
     AdminDueños.arrDueño.add(dueño3);
     AdminDueños.arrDueño.add(dueño4);
     AdminDueños.arrDueño.add(dueño5);
     AdminDueños.arrDueño.add(dueño6);
     AdminDueños.arrDueño.add(dueño7);
     AdminDueños.arrDueño.add(dueño8);
     AdminDueños.arrDueño.add(dueño9);
     AdminDueños.arrDueño.add(dueño10);

     
     //Creación de mascotas
     LocalDate fechaNacimiento1=LocalDate.parse("2020-02-15");
     Mascota mascota1= new Mascota("Minnie",TipoEspecie.Perro,"Chihuahua",fechaNacimiento1,"",dueño1);
     mascota1.generarCodMascota();
     LocalDate fechaNacimiento2=LocalDate.parse("2020-05-03");
     Mascota mascota2= new Mascota("Chester",TipoEspecie.Perro,"Pastor Alemán",fechaNacimiento2,"",dueño2);
     mascota2.generarCodMascota();
     LocalDate fechaNacimiento3=LocalDate.parse("2010-02-27");
     Mascota mascota3= new Mascota("Manchas",TipoEspecie.Perro,"Dálmata",fechaNacimiento3,"",dueño3);
     mascota3.generarCodMascota();
     LocalDate fechaNacimiento4=LocalDate.parse("2015-08-13");
     Mascota mascota4= new Mascota("Bigotes",TipoEspecie.Perro,"Poodle",fechaNacimiento4,"",dueño4);
     mascota4.generarCodMascota();
     LocalDate fechaNacimiento5=LocalDate.parse("2015-10-20");
     Mascota mascota5= new Mascota("Bobby",TipoEspecie.Perro,"Labrador",fechaNacimiento5,"",dueño5);
     mascota5.generarCodMascota();
     LocalDate fechaNacimiento6=LocalDate.parse("2010-12-24");
     Mascota mascota6= new Mascota("Manchas",TipoEspecie.Gato,"Persa",fechaNacimiento6,"",dueño6);
     mascota6.generarCodMascota();
     LocalDate fechaNacimiento7=LocalDate.parse("2010-02-10");
     Mascota mascota7= new Mascota("Coco",TipoEspecie.Gato,"Siamés",fechaNacimiento7,"",dueño7);
     mascota7.generarCodMascota();
     LocalDate fechaNacimiento8=LocalDate.parse("2010-07-13");
     Mascota mascota8= new Mascota("Felix",TipoEspecie.Gato,"Esfinge",fechaNacimiento8,"",dueño8);
     mascota8.generarCodMascota();
     LocalDate fechaNacimiento9=LocalDate.parse("2010-09-14");
     Mascota mascota9= new Mascota("Leo",TipoEspecie.Gato,"Bengala",fechaNacimiento9,"",dueño9);
     mascota9.generarCodMascota();
     LocalDate fechaNacimiento10=LocalDate.parse("2010-05-31");
     Mascota mascota10= new Mascota("Daisy",TipoEspecie.Gato,"Siberiano",fechaNacimiento10,"",dueño10);
     mascota10.generarCodMascota();
     
     AdminMascotas.arrMascotas.add(mascota1);
     AdminMascotas.arrMascotas.add(mascota2);
     AdminMascotas.arrMascotas.add(mascota3);
     AdminMascotas.arrMascotas.add(mascota4);
     AdminMascotas.arrMascotas.add(mascota5);
     AdminMascotas.arrMascotas.add(mascota6);
     AdminMascotas.arrMascotas.add(mascota7);
     AdminMascotas.arrMascotas.add(mascota8);
     AdminMascotas.arrMascotas.add(mascota9);
     AdminMascotas.arrMascotas.add(mascota10);

     
     //Creación de ciudades
     Ciudad ciudad1= new Ciudad("Guayaquil","Guayas");
     Ciudad ciudad2= new Ciudad("Quito","Pichincha");
     Ciudad ciudad3= new Ciudad("Cuenca","Azuay");
     
     AdminCiudades.arrCiudades.add(ciudad1);
     AdminCiudades.arrCiudades.add(ciudad2);
     AdminCiudades.arrCiudades.add(ciudad3);

     //Creación de auspiciantes
     Auspiciante auspiciante1= new Auspiciante("José Morales","Centro",993904665,"Guayaquil","josemor123@hotmail.com","www.josemorales.com");
     Auspiciante auspiciante2= new Auspiciante("Martha Gutierrez","Norte",991128065,"Guayaquil","marthgurrez@hotmail.com","www.marthagutierrez.com");
     Auspiciante auspiciante3= new Auspiciante("Héctor Pazmiño","Sur",918534665,"Quito","hectpazmño@hotmail.com","www.hectorpazmiño.com");
     AdminAuspiciantes.arrAuspiciantes.add(auspiciante1);
     AdminAuspiciantes.arrAuspiciantes.add(auspiciante2);
     AdminAuspiciantes.arrAuspiciantes.add(auspiciante3);

     //Creación del concurso terminado
     LocalDate fechaConcurso= LocalDate.parse("2021-08-01");
     LocalTime horaConcurso= LocalTime.parse("13:00:00");
     LocalDate fechaInscripciones= LocalDate.parse("2021-09-01");
     LocalDate fechaFinInscripciones= LocalDate.parse("2021-10-30");


     //Premios para el concurso terminado
     Premio premio1=new Premio(Puesto.Primer,"300 dólares",auspiciante1);
     Premio premio2=new Premio(Puesto.Segundo,"200 dólares",auspiciante2);
     Premio premio3=new Premio(Puesto.Tercer,"100 dólares",auspiciante3);
     Premio[] arrPremiosC1={premio1,premio2,premio3};
     
     ArrayList<Auspiciante> arrAuspiciantesC1= new ArrayList<Auspiciante>(Arrays.asList(auspiciante1,auspiciante2,auspiciante3));
    
     //Creación con constructor
     Concurso concursoTerminado= new Concurso("Concurso de perros",fechaConcurso,horaConcurso,fechaInscripciones,fechaFinInscripciones,ciudad1,"Estadio Central",arrPremiosC1,arrAuspiciantesC1,TiposAnimal.SoloPerros);
     
     //Llamada de métodos para asignar datos a los demás atributos del concurso no incluidos en el constructor
     concursoTerminado.generarCodConcurso();
     concursoTerminado.setAbiertoInscripciones(false);
     concursoTerminado.setConcursoEnCurso(false);

     //Inscripción de mascotas al concurso
     ArrayList<Mascota> arrMascotas= new ArrayList<Mascota>();
     arrMascotas.add(mascota1); 
     arrMascotas.add(mascota2); 
     arrMascotas.add(mascota3); 
     arrMascotas.add(mascota4); 
     arrMascotas.add(mascota5); 

     concursoTerminado.setArrParticipantes(arrMascotas);

     //Creación de la lista de ganadores

     ArrayList<Ganador> ganadores= new ArrayList<Ganador>();

     Ganador ganador1= new Ganador(mascota1.getNombre(),premio1,Puesto.Primer);
     Ganador ganador2= new Ganador(mascota2.getNombre(),premio2,Puesto.Segundo);
     Ganador ganador3= new Ganador(mascota4.getNombre(),premio3,Puesto.Tercer);

     ganadores.add(ganador1);
     ganadores.add(ganador2);
     ganadores.add(ganador3);

     concursoTerminado.setArrGanadores(ganadores);


     AdminConcursos.arrConcursos.add(concursoTerminado);

     //Creación del concurso vigente

     LocalDate fechaConcurso2= LocalDate.parse("2021-12-05");
     LocalTime horaConcurso2= LocalTime.parse("12:00:00");
     LocalDate fechaInscripciones2= LocalDate.parse("2021-11-01");
     LocalDate fechaFinInscripciones2= LocalDate.parse("2021-12-04");


     //Premios para el concurso terminado
     Premio premio1C2=new Premio(Puesto.Primer,"500 dólares",auspiciante1);
     Premio premio2C2=new Premio(Puesto.Segundo,"250 dólares",auspiciante2);
     Premio premio3C2=new Premio(Puesto.Tercer,"100 dólares",auspiciante3);
     Premio[] arrPremiosC2={premio1C2,premio2C2,premio3C2};
     
     ArrayList<Auspiciante> arrAuspiciantesC2= new ArrayList<Auspiciante>(Arrays.asList(auspiciante1,auspiciante2,auspiciante3));
    
     //Creación con constructor
     Concurso concursoVigente= new Concurso("Concurso de gatos",fechaConcurso2,horaConcurso2,fechaInscripciones2,fechaFinInscripciones2,ciudad2,"Centro",arrPremiosC2,arrAuspiciantesC2,TiposAnimal.SoloGatos);
     
     //Llamada de métodos para asignar datos a los demás atributos del concurso no incluidos en el constructor
     concursoVigente.generarCodConcurso();
     concursoVigente.setAbiertoInscripciones(true);
     concursoVigente.setConcursoEnCurso(true);

     ArrayList<Mascota> arrMascotas2= new ArrayList<Mascota>();
     concursoVigente.setArrParticipantes(arrMascotas2);

     ArrayList<Ganador> ganadores2= new ArrayList<Ganador>();
     concursoVigente.setArrGanadores(ganadores2);

     AdminConcursos.arrConcursos.add(concursoVigente);
    }

    
}
