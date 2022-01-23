/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import modelo.clases.DueñoMascota;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AdminDueñosController {

    @FXML
    private Button botonAgregarDueño;
    @FXML
    private Button botonCancelar;
    @FXML
    private TableView tablaDueños;
    @FXML
    private TableColumn<DueñoMascota, String> codDueños;
    @FXML
    private TableColumn<DueñoMascota, String> nombreDueños;
    @FXML
    private TableColumn<DueñoMascota, String> apellidoDueños;
    @FXML
    private TableColumn<DueñoMascota, String> telefDueños;
    @FXML
    private TableColumn<DueñoMascota, String> ciudadDueños;
    @FXML
    private TableColumn<DueñoMascota, Void> opcionesDueños;
    
    @FXML
    public void initialize() {
        codDueños.setCellValueFactory(new PropertyValueFactory<>("cedulaIdentidad"));
        nombreDueños.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoDueños.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        telefDueños.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        ciudadDueños.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        
        tablaDueños.getItems().setAll(MenúPrincipalController.getArrDueños());
        agregarBotonesDueños();
    }

       
    @FXML
    private void AgregarDueño() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("AgregarDueño.fxml"));//no tiene el controlador especificado
            AgregarDueñoController ad = new AgregarDueñoController();
            
            fxmlLoader.setController(ad);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            
            
            
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    @FXML
    private void Cancelar() throws IOException {
        App.setRoot("MenúPrincipal");
}
    
    private void agregarBotonesDueños(){

        Callback<TableColumn<DueñoMascota, Void>, TableCell<DueñoMascota, Void>> cellFactory = new Callback<TableColumn<DueñoMascota, Void>, TableCell<DueñoMascota, Void>>() {
            @Override
            public TableCell<DueñoMascota, Void> call(final TableColumn<DueñoMascota, Void> param) {
                TableCell<DueñoMascota, Void> cell = new TableCell<DueñoMascota, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            
                            DueñoMascota dueM = getTableView().getItems().get(getIndex());
                            HBox hbxOpciones = new HBox(5);
                            
                            
                           
                            Button bEditar = new Button("Editar");
                            bEditar.setOnAction(e ->editarDueñoMascota(dueM));

                            Button bEliminar = new Button("Eliminar");
                            bEliminar.setOnAction(e -> eliminarDueñoMascota(dueM));
                            
                           
                            
                            hbxOpciones.getChildren().addAll(bEditar,bEliminar);
                            setGraphic(hbxOpciones);
                            
                            
                           
                              
                            }
                        }

//                   

                    
                };
                return cell;
            }
        };

        opcionesDueños.setCellFactory(cellFactory);

        
    }
        
       private void editarDueñoMascota(DueñoMascota d){
           try {
            DueñoMascota de = (DueñoMascota) tablaDueños.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("AgregarDueño.fxml"));//no tiene el controlador especificado
            AgregarDueñoController ad = new AgregarDueñoController();
            
            fxmlLoader.setController(ad);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            MenúPrincipalController.getArrDueños().remove(d);
            d.saveFileEliminar();
            ad.llenarInfo(de);
            
            
            
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
   
    }
    
    @FXML
    public void eliminarDueñoMascota(DueñoMascota c){
        
        try {
           
            
            Alert alerta= new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Diálogo de información");
            alerta.setHeaderText("Se requiere confirmación");
            alerta.setContentText("Está seguro de eliminar el dueño "+c.getNombre()+"?");
            Optional<ButtonType> result=alerta.showAndWait();
            
            if(result.get()==ButtonType.OK){
                MenúPrincipalController.getArrDueños().remove(c);
                c.saveFileEliminar();
                App.setRoot("AdminDueños");
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        
    }
        
    

}