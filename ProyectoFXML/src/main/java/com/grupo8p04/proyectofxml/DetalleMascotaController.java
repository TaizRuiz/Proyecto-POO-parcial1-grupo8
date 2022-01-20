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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import modelo.clases.Mascota;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class DetalleMascotaController implements Initializable {


    @FXML
    Label lblNombreMascota;
    @FXML
    Label lblNacimiento;
    @FXML
    Label lblRaza;
    @FXML
    Label lblDueño;
    @FXML
    ImageView imgMascota;
    @FXML
    Button btnRegresar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void llenarInfo(Mascota m){
        lblNombreMascota.setText(m.getNombre());
        lblNacimiento.setText(m.getFechaNacimiento().toString());
        lblRaza.setText(m.getRaza());
        lblDueño.setText(m.getDueño().getNombre());
    }
    
    public void regresarAccion() throws IOException{
         App.setRoot("AdminMascotas");
    }
}
