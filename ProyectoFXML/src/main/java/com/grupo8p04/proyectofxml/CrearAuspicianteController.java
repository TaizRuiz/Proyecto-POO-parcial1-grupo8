/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.clases.Auspiciante;
import modelo.utils.ConcursoException;
/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class CrearAuspicianteController {

    @FXML
    Label tituloAusp;
    @FXML
    Button guardarAusp;
    @FXML
    Button cancelarA;
    @FXML
    TextField nombreAusp;
    @FXML
    TextField dircAusp;
    @FXML
    TextField telAusp;
    @FXML
    TextField ciudadAusp;
    @FXML
    TextField emailAusp;
    @FXML
    TextField pageAusp;
    

    @FXML
    private void crearAusp(){
        try{
        Auspiciante ausp= new Auspiciante(nombreAusp.getText(),dircAusp.getText(),telAusp.getText(),ciudadAusp.getText(),emailAusp.getText(),pageAusp.getText());;
        
        
        if(ausp.nombre.equals("")){
            throw new ConcursoException("Nombre de auspiciante faltante");
        }
        
        if(ausp.direccion.equals("")){
            throw new ConcursoException("Dirección de auspiciante faltante");
        }
        
        if(ausp.telefono.equals("")){
            throw new ConcursoException("Teléfono de auspiciante faltante");
        }
        
        if(ausp.ciudad.equals("")){
            throw new ConcursoException("Ciudad de auspiciante faltante");
        }
        
        if(ausp.getWebpage().equals("")){
            throw new ConcursoException("Página web de auspiciante faltante");
        }
        
        MenúPrincipalController.getArrAuspiciantes().add(ausp);
        ausp.setCodAuspiciante(String.valueOf(MenúPrincipalController.getArrAuspiciantes().indexOf(ausp)+1));
        modelo.clases.Auspiciante.serializarAuspiciante();
        
        mostrarAlerta(Alert.AlertType.INFORMATION,"Auspiciante creado/editado exitosamente");
        
        App.setRoot("AdminAuspiciantes");
            
        } catch (ConcursoException ex) {
            mostrarAlerta(Alert.AlertType.ERROR,ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
     public void mostrarAlerta(Alert.AlertType tipo, String msj){
        Alert alert= new Alert(tipo);
        alert.setTitle("Diálogo de información");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText(msj);
        alert.showAndWait();
        
    }
     
    @FXML
    private void cancelarA() throws IOException{
        App.setRoot("AdminAuspiciantes");
    }
    
}
