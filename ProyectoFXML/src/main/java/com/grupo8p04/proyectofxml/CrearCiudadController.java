/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import com.grupo8p04.proyectofxml.App;
import com.grupo8p04.proyectofxml.MenúPrincipalController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.clases.Ciudad;
import modelo.clases.ConcursoException;
/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class CrearCiudadController  {


    @FXML
    Label lblCiudad;
    @FXML
    Button crearCiudad;
    @FXML
    Button cancelarC;
    @FXML
    TextField nombreCiudad;
    @FXML
    TextField provinciaCiudad;
    
    
   @FXML
    private void crearCiudad(){
        try{
        Ciudad ciudad= new Ciudad(nombreCiudad.getText(),provinciaCiudad.getText());;
        ciudad.generarCodCiudad();
        
        if(ciudad.getNombre().equals("")){
            throw new ConcursoException("Nombre de ciudad faltante");
        }
        
        if(ciudad.getProvincia().equals("")){
            throw new ConcursoException("Provincia faltante");
        }
        
        MenúPrincipalController.getArrCiudades().add(ciudad);
        ciudad.guardarCiudad();
        
        mostrarAlerta(Alert.AlertType.INFORMATION,"Ciudad creada/editada exitosamente");
        
        App.setRoot("AdminCiudades");
            
        } catch (ConcursoException ex) {
            mostrarAlerta(Alert.AlertType.ERROR,ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void cancelarC() throws IOException{
        App.setRoot("AdminCiudades");
    }
    
    public void mostrarAlerta(Alert.AlertType tipo, String msj){
        Alert alert= new Alert(tipo);
        alert.setTitle("Diálogo de información");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText(msj);
        alert.showAndWait();
        
    }
    
}
