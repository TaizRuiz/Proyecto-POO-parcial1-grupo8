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
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CrearMascotaController {

    @FXML
    private Button botonCancelarM;

    
    @FXML
    private void cancelarCrearM() throws IOException {
        App.setRoot("AdminMascotas");
    }
    
}
