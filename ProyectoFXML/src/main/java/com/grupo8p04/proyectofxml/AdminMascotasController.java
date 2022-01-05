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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.clases.Mascota;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AdminMascotasController  {

    @FXML
    private Button btAgrMasc;
    @FXML
    private Button botonCancelarM;
    @FXML
    private TableView tablaMascotas;
    @FXML
    private TableColumn<Mascota, String> codMasc;
    @FXML
    private TableColumn<Mascota, String> nombMasc;
    @FXML
    private TableColumn<Mascota, String> tipoMasc;
    @FXML
    private TableColumn<Mascota, String> dueñoMasc;
    @FXML
    private TableColumn<Mascota, String> razaMasc;
    @FXML
    private TableColumn<Mascota, String> fechaMasc;

    @FXML
    private void initialize(){
        
        codMasc.setCellValueFactory(new PropertyValueFactory<>("CodMascota"));
        nombMasc.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipoMasc.setCellValueFactory(new PropertyValueFactory<>("mascota"));
        dueñoMasc.setCellValueFactory(new PropertyValueFactory<>("dueño"));
        razaMasc.setCellValueFactory(new PropertyValueFactory<>("raza"));
        fechaMasc.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        
        tablaMascotas.getItems().setAll(MenúPrincipalController.getArrMascotas());
        
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
