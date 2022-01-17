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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import modelo.clases.Concurso;
import modelo.clases.ConcursoException;
import modelo.clases.Mascota;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class InscribirMascotaController {

    @FXML
    private Button btnInscribir;
    @FXML
    private ListView listMascotas;
    
    public static Concurso concurso;
    
    public void initialize() {
        listMascotas.getItems().setAll(MenúPrincipalController.getArrMascotas());
    }

    public void inscribirMascota(){
        Mascota m= (Mascota) listMascotas.getSelectionModel().getSelectedItem();
        
        try{
        if(m==null){
            throw new ConcursoException("Seleccionar una mascota");
        }
        concurso.getParticipantes().add(m);
        modelo.clases.Concurso.serializarConcurso();
        
        Alert alert= new Alert(AlertType.INFORMATION);
        alert.setTitle("Diálogo de información");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText("Mascota inscrita");
        alert.showAndWait();
       
        App.setRoot("AdminConcurso");
        
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ConcursoException ex) {
            Alert alert= new Alert(AlertType.ERROR);
            alert.setTitle("Diálogo de información");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Seleccionar una mascota");
            alert.showAndWait();
            
        }
    }
    
}
