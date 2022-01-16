package com.grupo8p04.proyectofxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.clases.Concurso;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class AdminConcursoController {

    @FXML
    private Button crearConc;
    @FXML
    private Button regresarAdminC;
    @FXML
    private TableView tablaConcursos;
    @FXML
    private TableColumn<Concurso,String> codConc;
    @FXML
    private TableColumn<Concurso,String> nombreConc;
    @FXML
    private TableColumn<Concurso,String> fechaConc;
    @FXML
    private TableColumn<Concurso, String> ciudadConc;
    @FXML
    private TableColumn<Concurso, Void> opcionesConc;
    
    
    public void initialize() {
        codConc.setCellValueFactory(new PropertyValueFactory<>("CodConcurso"));
        nombreConc.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        fechaConc.setCellValueFactory(new PropertyValueFactory<>("fechaEvento"));
        ciudadConc.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        
        tablaConcursos.getItems().setAll(MenúPrincipalController.getArrConcursos());
        
        agregarBotones();
    } 

    @FXML
    private void regresarMenuAdminConcurso() throws IOException {
        App.setRoot("MenúPrincipal");
    }
    
    @FXML
    public void crearConcurso() {
        //App.setRoot("CrearConcurso");
            try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearConcurso.fxml"));//no tiene el controlador especificado
            CrearConcursoController ct = new CrearConcursoController();
            
            fxmlLoader.setController(ct);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            ct.cmbTipo.getItems().setAll(modelo.enums.TiposAnimal.values());
            ct.ciudadConc.getItems().setAll(MenúPrincipalController.getArrCiudades());
            
            ct.nombreAuspiciante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            ct.tablaAusp.getItems().setAll(MenúPrincipalController.getArrAuspiciantes());
            
            ct.lugarPrem.setCellValueFactory(new PropertyValueFactory<>("puesto"));
            ct.descPrem.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            ct.auspPrem.setCellValueFactory(new PropertyValueFactory<>("auspiciante"));
            ct.tablaPremio.getItems().setAll(AgregarPremioController.getArrPremios());
            
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
     private void agregarBotones(){

        Callback<TableColumn<Concurso, Void>, TableCell<Concurso, Void>> cellFactory = new Callback<TableColumn<Concurso, Void>, TableCell<Concurso, Void>>() {
            @Override
            public TableCell<Concurso, Void> call(final TableColumn<Concurso, Void> param) {
                TableCell<Concurso, Void> cell = new TableCell<Concurso, Void>() {
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            
                            Concurso conc = getTableView().getItems().get(getIndex());
                            HBox hbOpciones = new HBox(5);
                            
                            if (conc.isConcursoEnCurso()==true){
                           
                            Button botonEditar = new Button("Editar");
                            botonEditar.setOnAction(e ->editarConcurso());

                            Button botonEliminar = new Button("Eliminar");
                            botonEliminar.setOnAction(e -> eliminarConcurso(conc));
                            
                            Button botonInscritos=new Button("Consultar inscritos");
                            botonInscritos.setOnAction(e -> consultarInscritos());
                            
                            hbOpciones.getChildren().addAll(botonEditar,botonEliminar,botonInscritos);
                            setGraphic(hbOpciones);
                            }
                            
                            else{
                            Button botonGanadores = new Button("Consultar ganadores");
                            botonGanadores.setOnAction(e ->consultarGanadores());
                            
                            Button botonInscritos=new Button("Consultar inscritos");
                            botonInscritos.setOnAction(e -> consultarInscritos());
                            
                            hbOpciones.getChildren().addAll(botonGanadores,botonInscritos);
                            setGraphic(hbOpciones);
                              
                            }
                        }
                    }
                };
                return cell;
            }
        };

        opcionesConc.setCellFactory(cellFactory);

    }
     
     
    @FXML
    private void editarConcurso(){
        try {
            Concurso e = (Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearConcurso.fxml"));//no tiene el controlador especificado
            CrearConcursoController ct = new CrearConcursoController();
            
            fxmlLoader.setController(ct);//se asigna el controlador
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            ct.cmbTipo.getItems().setAll(modelo.enums.TiposAnimal.values());
            ct.ciudadConc.getItems().setAll(MenúPrincipalController.getArrCiudades());
            ct.crearPremio.setDisable(true);
            
            ct.tablaAusp.getItems().setAll(MenúPrincipalController.getArrAuspiciantes());
            
            ct.lugarPrem.setCellValueFactory(new PropertyValueFactory<>("puesto"));
            ct.descPrem.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            ct.auspPrem.setCellValueFactory(new PropertyValueFactory<>("auspiciante"));
            ct.tablaPremio.getItems().setAll(AgregarPremioController.getArrPremios());
            
            ct.btnSi.setDisable(false);
            ct.btnNo.setDisable(false);
            
            ct.btnInscSi.setDisable(false);
            ct.btnInscNo.setDisable(false);
            
            ct.llenarInfo(e);
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    @FXML
    public void eliminarConcurso(Concurso c){
        MenúPrincipalController.getArrConcursos().remove(c);
        modelo.clases.Concurso.serializarConcurso();
        
    }
    
    @FXML
    public void consultarInscritos(){
        try{
            Concurso c = (Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ConsultaConcurso.fxml"));//no tiene el controlador especificado
            ConsultaConcursoController ct = new ConsultaConcursoController();
            
            fxmlLoader.setController(ct);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            ct.textoTitulo.setText("Mascotas inscritas en el concurso: "+c.getNombre());
            ct.listMascotas.getItems().setAll(c.getParticipantes());
            App.changeRoot(root);
        }
        
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    public void consultarGanadores(){
        try{
            Concurso c = (Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ConsultaConcurso.fxml"));//no tiene el controlador especificado
            ConsultaConcursoController ct = new ConsultaConcursoController();
            
            fxmlLoader.setController(ct);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            ct.textoTitulo.setText("Mascotas ganadoras del concurso: "+c.getNombre());
            ct.listMascotas.getItems().setAll(c.getArrGanadores());
            App.changeRoot(root);
        }
        
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
