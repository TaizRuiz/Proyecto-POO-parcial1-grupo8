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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import modelo.clases.Auspiciante;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AdminAuspiciantesController {

    @FXML
    private Button aggAusp;
    @FXML
    private Button regresarA;
    @FXML
    private TableView tablaAuspiciantes;
    @FXML
    private TableColumn<Auspiciante, String> codAusp;
    @FXML
    private TableColumn<Auspiciante, String> nombreAusp;
    @FXML
    private TableColumn<Auspiciante, String> telAusp;
    @FXML
    private TableColumn<Auspiciante, String> ciudadAusp;
    @FXML
    private TableColumn<Auspiciante, Void> opcionesAusp;

    
    public void initialize() {
        codAusp.setCellValueFactory(new PropertyValueFactory<>("codAuspiciante"));
        nombreAusp.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        telAusp.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        ciudadAusp.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        
        tablaAuspiciantes.getItems().setAll(MenúPrincipalController.getArrAuspiciantes());
        
        agregarBotones();
    }  
    
    @FXML
    private void regresarMenu() throws IOException{
        App.setRoot("MenúPrincipal");
    }
    
    private void agregarBotones(){

        Callback<TableColumn<Auspiciante, Void>, TableCell<Auspiciante, Void>> cellFactory = new Callback<TableColumn<Auspiciante, Void>, TableCell<Auspiciante, Void>>() {
            @Override
            public TableCell<Auspiciante, Void> call(final TableColumn<Auspiciante, Void> param) {
                TableCell<Auspiciante, Void> cell = new TableCell<Auspiciante, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            
                            Auspiciante ausp = getTableView().getItems().get(getIndex());
                            HBox hbOpciones = new HBox(5);
                            

                            Button btnEditar = new Button("Editar");
                            btnEditar.setOnAction(e -> editarAuspiciante(ausp));
                            
                            Button btnEliminar =new Button("Eliminar");
                            btnEliminar.setOnAction(e -> eliminarAusp(ausp));
                            
                            hbOpciones.getChildren().addAll(btnEditar,btnEliminar);
                            setGraphic(hbOpciones);
                            }
     
                    }
                    
            };
            return cell;
            }
        };

        opcionesAusp.setCellFactory(cellFactory);

    }
    
    @FXML
    private void crearAuspiciante(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearAuspiciante.fxml"));
            CrearAuspicianteController ca = new CrearAuspicianteController();
            
            fxmlLoader.setController(ca);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    private void editarAuspiciante(Auspiciante a){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearAuspiciante.fxml"));
            CrearAuspicianteController ca = new CrearAuspicianteController();
            
            fxmlLoader.setController(ca);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            ca.nombreAusp.setText(a.nombre);
            ca.dircAusp.setText(a.direccion);
            ca.telAusp.setText(a.telefono);
            ca.ciudadAusp.setText(a.ciudad);
            ca.emailAusp.setText(a.email);
            ca.pageAusp.setText(a.getWebpage());
           
            MenúPrincipalController.getArrAuspiciantes().remove(a);
            modelo.clases.Auspiciante.serializarAuspiciante();
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarAusp(Auspiciante a){
        
        try {
            
            Alert alerta= new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Diálogo de información");
            alerta.setHeaderText("Se requiere confirmación");
            alerta.setContentText("Está seguro de eliminar el auspiciante "+a.getNombre()+"?");
            Optional<ButtonType> result=alerta.showAndWait();
                
            if(result.get()==ButtonType.OK){
                MenúPrincipalController.getArrAuspiciantes().remove(a);
                modelo.clases.Auspiciante.serializarAuspiciante();
                App.setRoot("AdminAuspiciantes");
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        
    }
    
}
