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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import modelo.clases.Concurso;
import modelo.clases.DueñoMascota;
import modelo.clases.Mascota;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AdminMascotasController  {

    @FXML
    private Button btAgrMasc;
    @FXML
    private Button botonCancelarM;
    @FXML
    private TableView tablaMascotas;
    @FXML
    private TableColumn<Mascota, String> codMasc;
    @FXML
    private TableColumn<Mascota, String> nombMasc;
    @FXML
    private TableColumn<Mascota, String> tipoMasc;
    @FXML
    private TableColumn<Mascota, String> dueñoMasc;
    @FXML
    private TableColumn<Mascota, String> razaMasc;
    @FXML
    private TableColumn<Mascota, String> fechaMasc;
    @FXML
    private TableColumn<Mascota, Void> clmOpciones;

    @FXML
    private void initialize(){
        
        codMasc.setCellValueFactory(new PropertyValueFactory<>("CodMascota"));
        nombMasc.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipoMasc.setCellValueFactory(new PropertyValueFactory<>("mascota"));
        dueñoMasc.setCellValueFactory(new PropertyValueFactory<>("dueño"));
              
        tablaMascotas.getItems().setAll(MenúPrincipalController.getArrMascotas());
        agregarBotones();
        
    } 
        
    
    @FXML
    private void menuCrearM() throws IOException {
        App.setRoot("CrearMascota");
    }
    
    @FXML
    private void regresarMenuPrincipalM() throws IOException {
        App.setRoot("MenúPrincipal");
    }
    
    
    private void agregarBotones(){

        Callback<TableColumn<Mascota, Void>, TableCell<Mascota, Void>> cellFactory = new Callback<TableColumn<Mascota, Void>, TableCell<Mascota, Void>>() {
            @Override
            public TableCell<Mascota, Void> call(final TableColumn<Mascota, Void> param) {
                TableCell<Mascota, Void> cell = new TableCell<Mascota, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            
                            Mascota mascota = getTableView().getItems().get(getIndex());
                            HBox hbOpciones = new HBox(5);
                            
                            Button btnDetalle = new Button("Detalle");
                            btnDetalle.setOnAction(e ->detalleMascota(mascota));

                            Button btnEditar = new Button("Editar");
                            btnEditar.setOnAction(e -> editarMascota());
                            
                            Button btnEliminar =new Button("Eliminar");
                            //botonInscritos.setOnAction(e -> consultarInscritos());
                            
                            hbOpciones.getChildren().addAll(btnDetalle,btnEditar,btnEliminar);
                            setGraphic(hbOpciones);
                            }
     
                    }
                    
            };
            return cell;
            }
        };

        clmOpciones.setCellFactory(cellFactory);

    }
    
    
    private void detalleMascota(Mascota m){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("DetalleMascota.fxml"));//no tiene el controlador especificado
            DetalleMascotaController dmc = new DetalleMascotaController();
            
            fxmlLoader.setController(dmc);
            
            AnchorPane root = (AnchorPane) fxmlLoader.load();
            dmc.llenarInfo(m);
                        
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void editarMascota(){
        try {
            Mascota pet = (Mascota) tablaMascotas.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearMascota.fxml"));//no tiene el controlador especificado
            CrearMascotaController apet = new CrearMascotaController();
            
            fxmlLoader.setController(apet);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            apet.llenarEdit(pet);
            
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
