package com.grupo8p04.proyectofxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    
    @FXML
    private void initialize(){
        modelo.main.CargarObjetos.cargarObjetos();
        
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
    
}
