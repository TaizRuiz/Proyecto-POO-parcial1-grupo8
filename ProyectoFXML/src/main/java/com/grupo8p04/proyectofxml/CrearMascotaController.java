/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import modelo.clases.MascotaException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.clases.*;
import modelo.enums.*;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class CrearMascotaController {

    @FXML
    private Button botonCancelarM;
    @FXML
    private Button btGuardar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtRaza;
    @FXML
    private DatePicker dateNacimiento;
    @FXML
    ComboBox cmbDueño;
    @FXML
    ComboBox selecEspecies;
    @FXML
    private Label lblTituloMascota;
    @FXML
    private Button btnFoto;

    
    @FXML
    private void cancelarCrearM() throws IOException {
        App.setRoot("AdminMascotas");
    }
    
    private void initialize(){
        cmbDueño.getItems().setAll(MenúPrincipalController.getArrDueños());
        selecEspecies.getItems().setAll(modelo.enums.TipoEspecie.values());
    }
    
     @FXML
    private void guardarMascota() throws IOException{
        try{
        Mascota msc= new Mascota(txtNombre.getText(),(TipoEspecie) selecEspecies.getValue(),dateNacimiento.getValue(), txtRaza.getText(),(DueñoMascota) cmbDueño.getValue());

        if(msc.getNombre().equals("") | msc.getMascota()==null | msc.getFechaNacimiento()==null | msc.getRaza().equals("") | msc.getDueño()==null){
            throw new MascotaException("Debe rellenar todos los campos");
        }

        MenúPrincipalController.getArrMascotas().add(msc);
        msc.setCodMascota(String.valueOf(MenúPrincipalController.getArrMascotas().indexOf(msc)+1));
        msc.saveFile();

        mostrarAlerta(Alert.AlertType.INFORMATION,"Mascota creada/editada exitosamente");
        App.setRoot("AdminMascotas");
        }catch(MascotaException em){
            mostrarAlerta(Alert.AlertType.ERROR,em.getMessage());
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    
    public void llenarEdit(Mascota m){
        lblTituloMascota.setText("Editar Mascota");
        txtNombre.setText(m.getNombre());
        selecEspecies.getItems().setAll(modelo.enums.TipoEspecie.values());
        selecEspecies.setValue(m.getMascota());
        dateNacimiento.setValue(m.getFechaNacimiento());
        txtRaza.setText(m.getRaza());
        cmbDueño.getItems().setAll(MenúPrincipalController.getArrDueños());
        cmbDueño.setValue(m.getDueño());
        //txtFoto.setText(m.getFoto());
    }
    
    public void mostrarAlerta(Alert.AlertType tipo, String msj){
        Alert alert= new Alert(tipo);
        alert.setTitle("Diálogo de información");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText(msj);
        alert.showAndWait();

    }
}
