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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import modelo.clases.Concurso;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class ConsultaConcursoController  {

    @FXML
    Label textoTitulo;
    @FXML
    Button btonR;
    @FXML
    ListView listMascotas;

    @FXML
    public void regresarConsulta() throws IOException{
      App.setRoot("AdminConcurso");
    }   
    
}
