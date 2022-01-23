package com.grupo8p04.proyectofxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Platform;
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
import modelo.clases.DueñoMascota;
import modelo.clases.Mascota;
import modelo.enums.TipoEspecie;
import modelo.enums.TiposAnimal;


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
    public TableView tablaConcursos;
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
    private Button enviarCorreo;
    @FXML
    private Label mensajeEnvio;
    
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
            
            ct.btnSi.setDisable(true);
            ct.btnNo.setDisable(true);
               
            ct.btnInscSi.setDisable(true);
            ct.btnInscNo.setDisable(true);
            
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
            
            if(e.isConcursoEnCurso()==true){
                ct.concCurso.selectToggle(ct.btnSi);
            }
            else{
                ct.concCurso.selectToggle(ct.btnNo);
            }
            
            ct.btnInscSi.setDisable(false);
            ct.btnInscNo.setDisable(false);
            
            if(e.isAbiertoInscripciones()==true){
                ct.concInsc.selectToggle(ct.btnInscSi);
            }
            else{
                ct.concInsc.selectToggle(ct.btnInscNo);
            }
            
            ct.aggConcurso.setOnAction(ev -> ct.editarConcurso(conc));
            
            ct.llenarInfo(e);
            App.changeRoot(root);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    public void eliminarConcurso(Concurso c){
        
        try {
            
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
    
    public void consultarInscritos(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ConsultaConcurso.fxml"));//no tiene el controlador especificado
            ConsultaConcursoController ct = new ConsultaConcursoController();
            
            fxmlLoader.setController(ct);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            Concurso c = (Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
            
            if(c.getParticipantes().size()==0){
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
    
    public void consultarGanadores(){
        try{
            Concurso c = (Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ConsultaConcurso.fxml"));
            ConsultaConcursoController ct = new ConsultaConcursoController();
            
            fxmlLoader.setController(ct);
            
            BorderPane root = (BorderPane) fxmlLoader.load();
            
            ct.textoTitulo.setText("Mascotas ganadoras del concurso: "+c.getNombre());
            ct.botonInscribir.setText("ElegirGanadores");
            
            ct.listMascotas.getItems().setAll(c.getArrGanadores());
            ct.botonInscribir.setVisible(false);
            App.changeRoot(root);
        }
        
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void inscribirMascota() {
        try {
            InscribirMascotaController.concurso=(Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
            App.setRoot("InscribirMascota");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    public void enviarCorreo(){
        
        Concurso con=(Concurso) tablaConcursos.getSelectionModel().getSelectedItem();
        
        new Thread( ()-> {
         
        Platform.runLater(()->mensajeEnvio.setText("Enviando las invitaciones..."));
        
        
        ArrayList<String> destinatarios=new ArrayList<String>();
        
        for(DueñoMascota d:MenúPrincipalController.getArrDueños()){
            
           destinatarios.add(d.email);
        }        
            
            
        for(String d:destinatarios){   
        String destinatario=d;
        String asunto="Inscripciones abiertas al concurso "+con.getNombre()+"!!!";
        String cuerpo="Se ha abierto un nuevo concurso!! \nFecha del concurso: "+String.valueOf(con.getFechaEvento())+" \nLugar: "+con.getLugar()+", "+con.getCiudad()+" \nHora: "+String.valueOf(con.getHoraEvento())+" \nFecha límite de inscripción: "+String.valueOf(con.getFechaFinInscripcion())+" \nEsperamos tu participación!!";
        modelo.clases.Correo.enviarCorreo(destinatario, asunto, cuerpo);
        
        if((destinatarios.size()-1)==destinatarios.indexOf(d)){
            Platform.runLater(()->mensajeEnvio.setText("Proceso finalizado"));
            Platform.runLater(()->CrearConcursoController.mostrarAlerta(AlertType.INFORMATION,"Invitaciones al concurso "+con.getNombre()+" enviadas"));
        }
        }
        }
        ).start();
        
    }
}
