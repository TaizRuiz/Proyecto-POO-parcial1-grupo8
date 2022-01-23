/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;


import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import modelo.clases.Ciudad;
/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AdminCiudadesController  {


    @FXML
    private Label tituloAdminCiudad;
    @FXML
    private Button aggCiudad;
    @FXML
    private Button regresarCiudad;
    @FXML
    private TableView tablaCiudades;
    @FXML
    private TableColumn<Ciudad, String> codCiudad;
    @FXML
    private TableColumn<Ciudad, String> nombreCiudad;
    @FXML
    private TableColumn<Ciudad, String> provinciaCiudad;
    @FXML
    private TableColumn<Ciudad, Void> opcionesCiudad;
   
    
    public void initialize() {
        codCiudad.setCellValueFactory(new PropertyValueFactory<>("codCiudad"));
        nombreCiudad.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        provinciaCiudad.setCellValueFactory(new PropertyValueFactory<>("provincia"));
        tablaCiudades.getItems().setAll(MenúPrincipalController.getArrCiudades());
        
        agregarBotones();
    }  
    
    @FXML
    private void regresarMenu() throws IOException{
        App.setRoot("MenúPrincipal");
    }
    
    private void agregarBotones(){

        Callback<TableColumn<Ciudad, Void>, TableCell<Ciudad, Void>> cellFactory = new Callback<TableColumn<Ciudad, Void>, TableCell<Ciudad, Void>>() {
            @Override
            public TableCell<Ciudad, Void> call(final TableColumn<Ciudad, Void> param) {
                TableCell<Ciudad, Void> cell = new TableCell<Ciudad, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            
                            Ciudad ciudad = getTableView().getItems().get(getIndex());
                            HBox hbOpciones = new HBox(5);
                            

                            Button btnEditar = new Button("Editar");
                            btnEditar.setOnAction(e -> editarCiudad(ciudad));
                            
                            Button btnEliminar =new Button("Eliminar");
                            btnEliminar.setOnAction(e -> eliminarCiudad(ciudad));
                            
                            hbOpciones.getChildren().addAll(btnEditar,btnEliminar);
                            setGraphic(hbOpciones);
                            }
     
                    }
                    
            };
            return cell;
            }
        };

        opcionesCiudad.setCellFactory(cellFactory);

    }
    
    @FXML
    private void crearCiudad(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearCiudad.fxml"));
            CrearCiudadController cc = new CrearCiudadController();
            
            fxmlLoader.setController(cc);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    private void editarCiudad(Ciudad c){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearCiudad.fxml"));
            CrearCiudadController cc = new CrearCiudadController();
            
            fxmlLoader.setController(cc);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            cc.lblCiudad.setText("Editar Ciudad");
            cc.nombreCiudad.setText(c.getNombre());
            cc.provinciaCiudad.setText(c.getProvincia());
           
            MenúPrincipalController.getArrCiudades().remove(c);
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarCiudad(Ciudad c){
        
        try {
            
            Alert alerta= new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Diálogo de información");
            alerta.setHeaderText("Se requiere confirmación");
            alerta.setContentText("Está seguro de eliminar la ciudad "+c.getNombre()+"?");
            Optional<ButtonType> result=alerta.showAndWait();
                
            if(result.get()==ButtonType.OK){
                MenúPrincipalController.getArrCiudades().remove(c);
                c.guardarCiudadEliminar();
                App.setRoot("AdminCiudad");
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        
    }
}
