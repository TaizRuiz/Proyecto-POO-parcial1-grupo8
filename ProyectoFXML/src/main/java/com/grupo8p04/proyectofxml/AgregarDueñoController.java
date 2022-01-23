/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.clases.DueñoMascota;
import modelo.utils.DueñoMascotaException;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */

public class AgregarDueñoController  {

    @FXML
    private Button cancelar;
    @FXML
    private TextField nombreDueño;
    @FXML
    private TextField apellidoDueño;
    @FXML
    private TextField direccionDueño;
    @FXML
    private TextField telefonoDueño;
    @FXML
    private TextField correoDueño;
    @FXML
    private Button guardarDueño;
    @FXML
    private TextField ciudadDueño;
    @FXML
    private TextField cedulaDueño;
    @FXML
     Label labelDueño;
    
   
    @FXML
    private void Cancelar2() throws IOException {
        App.setRoot("AdminDueños");
}

    @FXML
    private void guardarDueno() throws IOException{
        try{
        
        DueñoMascota due= new DueñoMascota(cedulaDueño.getText(),apellidoDueño.getText(), nombreDueño.getText(), direccionDueño.getText(), telefonoDueño.getText(), ciudadDueño.getText(), correoDueño.getText());
        
        if(due.getCedulaIdentidad().equals("") | due.getApellido().equals("") ){
            throw new DueñoMascotaException("Debe rellenar todos los campos solicitados");
            }
        
        if(due.getNombre().equals("") | due.getDireccion().equals("") ){
            throw new DueñoMascotaException("Debe rellenar todos los campos solicitados");
            }
        if(due.getTelefono().equals("") | due.getCiudad().equals("") ){
            throw new DueñoMascotaException("Debe rellenar todos los campos solicitados");
            }
        if(due.getEmail().equals("") ){
            throw new DueñoMascotaException("Debe rellenar todos los campos solicitados");
            }
        
        MenúPrincipalController.getArrDueños().add(due);
        due.setCedulaIdentidad(String.valueOf(MenúPrincipalController.getArrDueños().indexOf(due)+1));
        due.saveFile(); 
        
        mostrarAlerta(AlertType.INFORMATION,"Dueño creado/editado exitosamente");
        App.setRoot("AdminDueños");
        } catch(DueñoMascotaException d){
            mostrarAlerta(AlertType.ERROR,d.getMessage());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }   
          

    
    }
    public void llenarInfo(DueñoMascota du){
        labelDueño.setText("EDITAR DUEÑO");
        cedulaDueño.setText(du.getCedulaIdentidad());
        apellidoDueño.setText(du.getApellido());
        nombreDueño.setText(du.getNombre());
        direccionDueño.setText(du.getDireccion());
        telefonoDueño.setText(du.getTelefono());
        ciudadDueño.setText(du.getCiudad());
        correoDueño.setText(du.getEmail());
    MenúPrincipalController.getArrDueños().remove(du);
    }
    
    public void mostrarAlerta(AlertType tipo, String msj){
        Alert alert= new Alert(tipo);
        alert.setTitle("Diálogo de información");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText(msj);
        alert.showAndWait();
        
    }
}
    
  