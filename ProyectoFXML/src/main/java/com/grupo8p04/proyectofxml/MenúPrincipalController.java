package com.grupo8p04.proyectofxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import modelo.clases.Concurso;
import modelo.clases.DueñoMascota;
import modelo.clases.Mascota;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class MenúPrincipalController {

    @FXML
    private Button adminConc;
    @FXML
    private Button adminDueños;
    @FXML
    private Button adminMascotas;
    
    private static ArrayList<Concurso> arrConcursos;
    private static ArrayList<DueñoMascota> arrDueños;
    private static ArrayList<Mascota> arrMascotas;
    
    @FXML
    private void initialize(){
        arrConcursos=Concurso.lecturaConcurso();
        arrDueños=DueñoMascota.lecturaDueños();
        arrMascotas=Mascota.lecturaMascotas();
    }
    
    
    @FXML
    private void cambiarAdminConcurso() throws IOException {
        App.setRoot("AdminConcurso");
    }
    
    @FXML
    private void cambiarAdminDueños() throws IOException {
        App.setRoot("AdminDueños");
    }
    
    @FXML
    private void cambiarAdminMascotas() throws IOException {
        App.setRoot("AdminMascotas");
    }

    public static ArrayList<Concurso> getArrConcursos() {
        return arrConcursos;
    }

    public static ArrayList<DueñoMascota> getArrDueños() {
        return arrDueños;
    }

    public static ArrayList<Mascota> getArrMascotas() {
        return arrMascotas;
    }
    
    
    
    
    
}
