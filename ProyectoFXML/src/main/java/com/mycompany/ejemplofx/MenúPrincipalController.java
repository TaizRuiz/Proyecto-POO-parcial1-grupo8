/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplofx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class MenúPrincipalController{

    /**
     * Initializes the controller class.
     */
   
    
    @FXML
    private void cambiarAdminConcurso() throws IOException {
        App.setRoot("AdministrarConcursos");
    }
    
    @FXML
    private void cambiarAdminDueños() throws IOException {
        App.setRoot("AdministrarDueños");
    }
    
    @FXML
    private void cambiarAdminMascotas() throws IOException {
        App.setRoot("AdministrarMascotas");
    }
    
}
