package com.grupo8p04.proyectofxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AdminConcursoController implements Initializable  {

    @FXML
    private Button crearConc;
    @FXML
    private Button regresarAdminC;
    @FXML
    private TableView tablaConcursos;
    @FXML
    private TableColumn<?, ?> codConc;
    @FXML
    private TableColumn<?, ?> nombreConc;
    @FXML
    private TableColumn<?, ?> fechaConc;
    @FXML
    private TableColumn<?, ?> ciudadConc;
    @FXML
    private TableColumn<?, ?> opcionesConc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void regresarMenuAdminConcurso() throws IOException {
        App.setRoot("MenúPrincipal");
    }
    
    @FXML
    private void crearConcurso() throws IOException {
        App.setRoot("CrearConcurso");
    }
    
}
