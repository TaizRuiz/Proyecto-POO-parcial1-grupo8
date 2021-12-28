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
import modelo.clases.DueñoMascota;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AdminDueñosController {

    @FXML
    private Button botonAgregarDueño;
    @FXML
    private Button botonCancelar;
    @FXML
    private TableView tablaDueños;
    @FXML
    private TableColumn<DueñoMascota, String> codDueños;
    @FXML
    private TableColumn<DueñoMascota, String> nombreDueños;
    @FXML
    private TableColumn<DueñoMascota, String> apellidoDueños;
    @FXML
    private TableColumn<DueñoMascota, String> telefDueños;
    @FXML
    private TableColumn<DueñoMascota, String> ciudadDueños;
    
    public void initialize() {
        codDueños.setCellValueFactory(new PropertyValueFactory<>("cedulaIdentidad"));
        nombreDueños.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoDueños.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        telefDueños.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        ciudadDueños.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        
        tablaDueños.getItems().setAll(DueñoMascota.lecturaDueños());
    }

       
    @FXML
    private void regresarMenu() throws IOException {
        App.setRoot("AgregarDueño");
    }
    @FXML
    private void Cancelar() throws IOException {
        App.setRoot("MenúPrincipal");
}
}
