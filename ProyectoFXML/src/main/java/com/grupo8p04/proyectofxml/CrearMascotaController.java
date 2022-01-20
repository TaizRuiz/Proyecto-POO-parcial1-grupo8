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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    private TextField txtFoto;
    @FXML
    private ComboBox cmbDueño;
    @FXML
    private ComboBox selecEspecies;
    @FXML
    private Label lblTituloMascota;

    
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
        Mascota msc= new Mascota(txtNombre.getText(),(TipoEspecie) selecEspecies.getValue(),dateNacimiento.getValue(), txtRaza.getText(),(DueñoMascota) cmbDueño.getValue());
        msc.generarCodMascota();
        MenúPrincipalController.getArrMascotas().add(msc);
        msc.saveFile();
        //modelo.clases.DueñoMascota.serializar();
        App.setRoot("AdminMascotas");
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
        txtFoto.setText(m.getFoto());
        MenúPrincipalController.getArrMascotas().remove(m);
    }
}
