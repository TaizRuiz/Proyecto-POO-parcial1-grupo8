package com.grupo8p04.proyectofxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ContentDisplay.CENTER;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.clases.Concurso;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import modelo.clases.ConcursoException;


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
    TableView tablaConcursos;
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
    
    @FXML
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
                            botonEditar.setOnAction(e ->editarConcurso(conc));

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
               
                            System.out.println(conc.getParticipantes().size());
                             
                            Button botonInscritos=new Button("Consultar inscritos");
                            botonInscritos.setOnAction(e -> consultarInscritos());
                           
                                                           
                            hbOpciones.getChildren().addAll(botonGanadores,botonInscritos);
                            setGraphic(hbOpciones);
                            
                            if (conc.getParticipantes().size()==0){
                                botonInscritos.setDisable(true);
                            }
                              
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
    private void editarConcurso(Concurso conc){
        try {
            Concurso e = (Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CrearConcurso.fxml"));//no tiene el controlador especificado
            CrearConcursoController ct = new CrearConcursoController();
            
            fxmlLoader.setController(ct);//se asigna el controlador
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            ct.cmbTipo.getItems().setAll(modelo.enums.TiposAnimal.values());
            ct.ciudadConc.getItems().setAll(MenúPrincipalController.getArrCiudades());
            ct.crearPremio.setDisable(true);
            ct.cancelarCreacionC.setDisable(true);
            
            ct.nombreAuspiciante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            ct.tablaAusp.getItems().setAll(MenúPrincipalController.getArrAuspiciantes());
            
            ct.lugarPrem.setCellValueFactory(new PropertyValueFactory<>("puesto"));
            ct.descPrem.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            ct.auspPrem.setCellValueFactory(new PropertyValueFactory<>("auspiciante"));
            
            ct.btnSi.setDisable(false);
            ct.btnNo.setDisable(false);
            
            ct.btnInscSi.setDisable(false);
            ct.btnInscNo.setDisable(false);
            
            ct.aggConcurso.setOnAction(ev -> ct.editarConcurso(conc));
            
            ct.llenarInfo(e);
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    @FXML
    public void eliminarConcurso(Concurso c){
        
        try {
            modelo.clases.Concurso.serializarConcurso();
            
            Alert alerta= new Alert(AlertType.CONFIRMATION);
            alerta.setTitle("Diálogo de información");
            alerta.setHeaderText("Se requiere confirmación");
            alerta.setContentText("Está seguro de eliminar el concurso "+c.getNombre()+"?");
            Optional<ButtonType> result=alerta.showAndWait();
            
            if(result.get()==ButtonType.OK){
                MenúPrincipalController.getArrConcursos().remove(c);
                modelo.clases.Concurso.serializarConcurso();
                App.setRoot("AdminConcurso");
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        
    }
    
    @FXML
    public void consultarInscritos(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ConsultaConcurso.fxml"));//no tiene el controlador especificado
            ConsultaConcursoController ct = new ConsultaConcursoController();
            
            fxmlLoader.setController(ct);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            Concurso c = (Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
            
            if(c.getParticipantes().size()==0){
                System.out.println("noo");
                root.getChildren().clear();
                Label mensaje=new Label("No hay mascotas inscritas");
                
                Button botonInscribir= new Button("Inscribir Mascota");
                botonInscribir.setOnAction(e -> inscribirMascota());
                
                root.setCenter(mensaje);
                root.setBottom(botonInscribir);
                
                root.setAlignment(botonInscribir,Pos.TOP_CENTER);
                
                
                
            }
            
            else{
            ct.textoTitulo.setText("Mascotas inscritas en el concurso: "+c.getNombre());
            ct.listMascotas.getItems().setAll(c.getParticipantes());}
            
                if(c.isAbiertoInscripciones()==true){
                    ct.botonInscribir.setOnAction(e -> inscribirMascota());
                }
                
                else if (c.isAbiertoInscripciones()==false | c.isConcursoEnCurso()==false){
                ct.botonInscribir.setVisible(false);
                }
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
            ct.botonInscribir.setVisible(false);
            App.changeRoot(root);
        }
        
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    public void inscribirMascota() {
        try {
            InscribirMascotaController.concurso=(Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
            App.setRoot("InscribirMascota");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
