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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
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
    TextField nombreConc;
    @FXML
    TextField horaConc;
    @FXML
    DatePicker fechaConc;
    @FXML
    DatePicker inicioInsc;
    @FXML
    DatePicker finInsc;
    @FXML
    TextField lugarConc;
    @FXML
    TableView tablaPremio;
    @FXML
    ComboBox cmbTipo;
    @FXML
    ComboBox ciudadConc;
    @FXML
    TableView tablaAusp;
    @FXML
    TableColumn<Auspiciante, String> nombreAuspiciante;
    @FXML
    Button aggConcurso;
    @FXML
    VBox aggPremio;
    @FXML
    TableColumn<Premio, String> lugarPrem;
    @FXML
    TableColumn<Premio, String> descPrem;
    @FXML
    TableColumn<Premio, String> auspPrem;
    @FXML
    Button crearPremio;
    @FXML
    GridPane opcionesConc;
    @FXML
    ToggleGroup concCurso;
    @FXML
    RadioButton btnSi;
    @FXML
    RadioButton btnNo;
    @FXML
    ToggleGroup concInsc;
    @FXML
    RadioButton btnInscSi;
    @FXML
    RadioButton btnInscNo;
    
    
    
    
    
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
        
        concCurso.selectToggle(btnSi);
        btnSi.setDisable(true);
        btnNo.setDisable(true);
        
        concInsc.selectToggle(btnInscSi);
        btnInscSi.setDisable(true);
        btnInscNo.setDisable(true);
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
        
        RadioButton rdConc=(RadioButton) concCurso.getSelectedToggle();
        String sel1=rdConc.getText();
        if(sel1.equals("Si")){
            conc.setConcursoEnCurso(true);
        }
        else{
            conc.setConcursoEnCurso(false);
        }
        
        RadioButton rdInsc=(RadioButton) concInsc.getSelectedToggle();
        String sel2=rdInsc.getStyle();
        if(sel2.equals("Si")){
            conc.setAbiertoInscripciones(true);
        }
        else{
            conc.setAbiertoInscripciones(false);
        }
        
       
        MenúPrincipalController.getArrConcursos().add(conc);
        modelo.clases.Concurso.serializarConcurso();
        App.setRoot("AdminConcurso");
   

    }
    
    public void llenarInfo(Concurso c){
        tituloConcurso.setText("Editar Concurso");
        cmbTipo.setValue(c.getDirigidoA());
        nombreConc.setText(c.getNombre());
        fechaConc.setValue(c.getFechaEvento());
        horaConc.setText((String) c.getHoraEvento().toString());
        inicioInsc.setValue(c.getFechaInscripcion());
        finInsc.setValue(c.getFechaFinInscripcion());
        ciudadConc.setValue(c.getCiudad());
        lugarConc.setText(c.getLugar());
        MenúPrincipalController.getArrConcursos().remove(c);
        
            
    }
    
   
     
}
