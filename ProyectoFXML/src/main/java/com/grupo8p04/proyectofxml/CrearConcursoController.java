/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.clases.Auspiciante;
import modelo.clases.Ciudad;
import modelo.clases.Concurso;
import modelo.clases.Premio;
import modelo.enums.TiposAnimal;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class CrearConcursoController {
    

    @FXML
    private Button cancelarCreacionC;
    @FXML
    Label tituloConcurso;
    @FXML
    private TextField nombreConc;
    @FXML
    private TextField horaConc;
    @FXML
    private DatePicker fechaConc;
    @FXML
    private DatePicker inicioInsc;
    @FXML
    private DatePicker finInsc;
    @FXML
    private TextField lugarConc;
    @FXML
    private TableView tablaPremio;
    @FXML
    private ComboBox cmbTipo;
    @FXML
    private ComboBox ciudadConc;
    @FXML
    private TableView tablaAusp;
    @FXML
    private TableColumn<Auspiciante, String> nombreAuspiciante;
    @FXML
    private Button aggConcurso;
    @FXML
    private VBox aggPremio;
    @FXML
    private TableColumn<Premio, String> lugarPrem;
    @FXML
    private TableColumn<Premio, String> descPrem;
    @FXML
    private TableColumn<Premio, String> auspPrem;
    @FXML
    private Button crearPremio;
    
    
    @FXML
    private void initialize(){
        cmbTipo.getItems().setAll(modelo.enums.TiposAnimal.values());
        ciudadConc.getItems().setAll(MenúPrincipalController.getArrCiudades());
        
        nombreAuspiciante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablaAusp.getItems().setAll(MenúPrincipalController.getArrAuspiciantes());
        
        lugarPrem.setCellValueFactory(new PropertyValueFactory<>("puesto"));
        descPrem.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        auspPrem.setCellValueFactory(new PropertyValueFactory<>("auspiciante"));
        tablaPremio.getItems().setAll(AgregarPremioController.getArrPremios());
        
    }

    @FXML
    private void cancelarCrearC() throws IOException {
        App.setRoot("AdminConcurso");
    }
    
    @FXML
    private void crearPremio() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("AgregarPremio.fxml"));
        AgregarPremioController ct = new AgregarPremioController();
        fxmlLoader.setController(ct);
        
        BorderPane root = (BorderPane) fxmlLoader.load();
        
        ct.cmbLugar.getItems().setAll(modelo.enums.Puesto.values());
        ct.nombreAuspiciante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        ct.tablaAuspPremio.getItems().setAll(MenúPrincipalController.getArrAuspiciantes());
        App.changeRoot(root);
    }
    
    @FXML
    private void crearConcurso() throws IOException{
        
        ArrayList<Auspiciante> arrAuspiciante=new ArrayList<>();
        arrAuspiciante.add((Auspiciante) tablaAusp.getSelectionModel().getSelectedItem());
        Concurso conc= new Concurso(nombreConc.getText(),fechaConc.getValue(),LocalTime.parse(horaConc.getText()),inicioInsc.getValue(),finInsc.getValue(),(Ciudad) ciudadConc.getValue(),lugarConc.getText(),AgregarPremioController.getArrPremios(),arrAuspiciante,(TiposAnimal) cmbTipo.getValue());
        conc.generarCodConcurso();
        MenúPrincipalController.getArrConcursos().add(conc);
        modelo.clases.Concurso.serializarConcurso();
        App.setRoot("AdminConcurso");
    


    }
    
    
    
}
