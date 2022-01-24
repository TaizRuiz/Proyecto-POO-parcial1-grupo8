/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.clases.Mascota;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class DetalleMascotaController {


    @FXML
    Label lblNombreMascota;
    @FXML
    Label lblNacimiento;
    @FXML
    Label lblRaza;
    @FXML
    Label lblDueño;
    @FXML
    ImageView imgMascota;
    @FXML
    Button btnRegresar;
      
    
    public void llenarInfo(Mascota m){
        lblNombreMascota.setText(m.getNombre());
        lblNacimiento.setText(m.getFechaNacimiento().toString());
        lblRaza.setText(m.getRaza());
        lblDueño.setText(m.getDueño().getNombre());
        
        InputStream input = null;
        try {
            String fileName = "ImagenesMascotas/"+ m.getNombre()+ ".png";
           
            input = App.class.getResource(fileName).openStream();

            //crear la imagen 
            Image image = new Image(input, 80, 80, false, false);
            imgMascota.setImage(image);

        } catch (Exception ex) {
            System.out.println("no se encuentra archivo de imagen");
          
        }
        
    }
    
    public void regresarAccion() throws IOException{
         App.setRoot("AdminMascotas");
    }
}
