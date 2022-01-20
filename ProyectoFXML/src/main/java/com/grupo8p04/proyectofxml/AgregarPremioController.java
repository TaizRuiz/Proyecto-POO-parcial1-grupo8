/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;


import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import modelo.clases.Auspiciante;
import modelo.clases.Ciudad;
import modelo.clases.Premio;
import modelo.enums.Puesto;
import modelo.enums.TiposAnimal;
/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AgregarPremioController {


    @FXML
    private Button guardarPremio;
    @FXML
    private Button cancelarPremio;
    @FXML
    private TextField descPrem;
    @FXML
    TableView tablaAuspPremio;
    @FXML
    TableColumn<Auspiciante, String> nombreAuspiciante;
    @FXML
    ComboBox cmbLugar;
    public static Premio[] arrPremios=new Premio[3];
    
    
    @FXML
    private void cancelarCrearPremio() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearConcurso.fxml"));//no tiene el controlador especificado
        CrearConcursoController ct = new CrearConcursoController();
            
        fxmlLoader.setController(ct);
            
        BorderPane root = (BorderPane) fxmlLoader.load();
        App.changeRoot(root);
    }
    
    @FXML
    private void crearPremio() throws IOException{
        
        Premio premio= new Premio((Puesto) cmbLugar.getValue(),descPrem.getText(),(Auspiciante) tablaAuspPremio.getSelectionModel().getSelectedItem());
        
        if (cmbLugar.getValue().equals(Puesto.Primer)){
            arrPremios[0]=premio;
        }
        
        else if(cmbLugar.getValue().equals(Puesto.Segundo)){
            arrPremios[1]=premio;
        }
        
        else{
            arrPremios[2]=premio;
        }
        
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Diálogo de información");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Premio creado exitosamente");
        alert.showAndWait();
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearConcurso.fxml"));//no tiene el controlador especificado
        CrearConcursoController ct = new CrearConcursoController();
            
        fxmlLoader.setController(ct);
            
        BorderPane root = (BorderPane) fxmlLoader.load();
        ct.cmbTipo.setValue((TiposAnimal) CrearConcursoController.arrInfo.get(0));
        ct.nombreConc.setText((String) CrearConcursoController.arrInfo.get(1));
        ct.fechaConc.setValue((LocalDate) CrearConcursoController.arrInfo.get(2));
        ct.horaConc.setText((String) CrearConcursoController.arrInfo.get(3));
        ct.inicioInsc.setValue((LocalDate)CrearConcursoController.arrInfo.get(4));
        ct.finInsc.setValue((LocalDate)CrearConcursoController.arrInfo.get(5));
        ct.ciudadConc.setValue((Ciudad)CrearConcursoController.arrInfo.get(6));
        ct.lugarConc.setText((String)CrearConcursoController.arrInfo.get(7));
        
        CrearConcursoController.arrInfo.clear();
        
        ct.cmbTipo.getItems().setAll(modelo.enums.TiposAnimal.values());
        ct.ciudadConc.getItems().setAll(MenúPrincipalController.getArrCiudades());
        
        ct.nombreAuspiciante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        ct.tablaAusp.getItems().setAll(MenúPrincipalController.getArrAuspiciantes());
        
        ct.lugarPrem.setCellValueFactory(new PropertyValueFactory<>("puesto"));
        ct.descPrem.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        ct.auspPrem.setCellValueFactory(new PropertyValueFactory<>("auspiciante"));
        ct.tablaPremio.getItems().setAll(AgregarPremioController.getArrPremios());
        ct.tablaPremio.getItems().setAll(AgregarPremioController.getArrPremios());
        
        
        
        App.changeRoot(root);
    }

    public static Premio[] getArrPremios() {
        return arrPremios;
    }
    
    
  

}
