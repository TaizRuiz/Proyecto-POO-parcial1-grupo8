package com.grupo8p04.proyectofxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class MenúPrincipalController {

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
