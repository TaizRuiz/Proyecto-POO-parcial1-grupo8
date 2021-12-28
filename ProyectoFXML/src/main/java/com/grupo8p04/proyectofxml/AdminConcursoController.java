package com.grupo8p04.proyectofxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.clases.Concurso;


/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AdminConcursoController {

    @FXML
    private Button crearConc;
    @FXML
    private Button regresarAdminC;
    @FXML
    private TableView tablaConcursos;
    @FXML
    private TableColumn<Concurso,String> codConc;
    @FXML
    private TableColumn<Concurso,String> nombreConc;
    @FXML
    private TableColumn<Concurso,String> fechaConc;
    @FXML
    private TableColumn<Concurso, String> ciudadConc;
    
    
    public void initialize() {
        codConc.setCellValueFactory(new PropertyValueFactory<>("CodConcurso"));
        nombreConc.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        fechaConc.setCellValueFactory(new PropertyValueFactory<>("fechaEvento"));
        ciudadConc.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        
        tablaConcursos.getItems().setAll(Concurso.lecturaConcurso());
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
