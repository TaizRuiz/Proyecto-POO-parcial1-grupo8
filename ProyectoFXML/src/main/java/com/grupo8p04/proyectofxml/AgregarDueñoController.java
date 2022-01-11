/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.clases.DueñoMascota;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */

public class AgregarDueñoController  {

    @FXML
    private Button cancelar;
    @FXML
    private TextField nombreDueño;
    @FXML
    private TextField apellidoDueño;
    @FXML
    private TextField direccionDueño;
    @FXML
    private TextField telefonoDueño;
    @FXML
    private TextField correoDueño;
    @FXML
    private Button guardarDueño;
    @FXML
    private TextField ciudadDueño;
    @FXML
    private TextField cedulaDueño;
    
    
//    @FXML
//    private void initialize(){
//        
//        selecCiudad.getItems().setAll(MenúPrincipalController.getArrCiudades());
//
//    }
   
    @FXML
    private void Cancelar2() throws IOException {
        App.setRoot("AdminDueños");
}

@FXML
    private void guardarDueno() throws IOException{
        
        DueñoMascota due= new DueñoMascota(cedulaDueño.getText(),apellidoDueño.getText(), nombreDueño.getText(), direccionDueño.getText(), telefonoDueño.getText(), ciudadDueño.getText(), correoDueño.getText());
        MenúPrincipalController.getArrDueños().add(due);
        //modelo.clases.DueñoMascota.serializar();
        App.setRoot("AdminDueños");
    

    
    }
    
}
    
  