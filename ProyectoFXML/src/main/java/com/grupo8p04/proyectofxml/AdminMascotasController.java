/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

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
public class AdminMascotasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void menuCrearM() throws IOException {
        App.setRoot("CrearMascota");
    }
    
    @FXML
    private void regresarMenuPrincipalM() throws IOException {
        App.setRoot("MenúPrincipal");
    }
    
}
