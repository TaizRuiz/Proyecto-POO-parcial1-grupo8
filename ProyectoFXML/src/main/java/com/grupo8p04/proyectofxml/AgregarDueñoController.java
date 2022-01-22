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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import modelo.clases.DueñoMascota;
import modelo.clases.DueñoMascotaException;

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
    @FXML
     Label labelDueño;
    
    
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
        try{
        
        DueñoMascota due= new DueñoMascota(cedulaDueño.getText(),apellidoDueño.getText(), nombreDueño.getText(), direccionDueño.getText(), telefonoDueño.getText(), ciudadDueño.getText(), correoDueño.getText());
        MenúPrincipalController.getArrDueños().add(due);
        due.saveFile(); //guarda el objeto en el txt
        //modelo.clases.DueñoMascota.serializar();
        
        if(due.getCedulaIdentidad().equals("") | due.getApellido().equals("") ){
            throw new DueñoMascotaException("Debe rellenar todos los campos solicitados");
            }
        
        if(due.getNombre().equals("") | due.getDireccion().equals("") ){
            throw new DueñoMascotaException("Debe rellenar todos los campos solicitados");
            }
        if(due.getTelefono().equals("") | due.getCiudad().equals("") ){
            throw new DueñoMascotaException("Debe rellenar todos todos los campos solicitados");
            }
        if(due.getEmail().equals("") ){
            throw new DueñoMascotaException("Debe rellenar todos todos los campos solicitados");
            }
        App.setRoot("AdminDueños");
        } catch(Exception e){
            Alert a = new Alert(AlertType.ERROR,"Se encontro una indeterminacion.");
            a.show();
        
        }

    
    }
    public void llenarInfo(DueñoMascota du){
        labelDueño.setText("EDITAR DUEÑO");
        cedulaDueño.setText(du.getCedulaIdentidad());
        apellidoDueño.setText(du.getApellido());
        nombreDueño.setText(du.getNombre());
        direccionDueño.setText(du.getDireccion());
        telefonoDueño.setText(du.getTelefono());
        ciudadDueño.setText(du.getCiudad());
        correoDueño.setText(du.getEmail());
    MenúPrincipalController.getArrDueños().remove(du);
    }
}
    
  