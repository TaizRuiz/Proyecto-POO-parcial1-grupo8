/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8p04.proyectofxml;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.clases.Auspiciante;
import modelo.clases.Ciudad;
import modelo.clases.Concurso;
import modelo.utils.ConcursoException;
import modelo.clases.Ganador;
import modelo.clases.Mascota;
import modelo.clases.Premio;
import modelo.enums.TiposAnimal;

/**
 * FXML Controller class
 *
 * @author Guillermo José
 */
public class CrearConcursoController {
    

    @FXML
    Button cancelarCreacionC;
    @FXML
    Label tituloConcurso;
    @FXML
    TextField nombreConc;
    @FXML
    TextField horaConc;
    @FXML
    DatePicker fechaConc;
    @FXML
    DatePicker inicioInsc;
    @FXML
    DatePicker finInsc;
    @FXML
    TextField lugarConc;
    @FXML
    TableView tablaPremio;
    @FXML
    ComboBox cmbTipo;
    @FXML
    ComboBox ciudadConc;
    @FXML
    TableView tablaAusp;
    @FXML
    TableColumn<Auspiciante, String> nombreAuspiciante;
    @FXML
    Button aggConcurso;
    @FXML
    VBox aggPremio;
    @FXML
    TableColumn<Premio, String> lugarPrem;
    @FXML
    TableColumn<Premio, String> descPrem;
    @FXML
    TableColumn<Premio, String> auspPrem;
    @FXML
    Button crearPremio;
    @FXML
    GridPane opcionesConc;
    @FXML
    ToggleGroup concCurso;
    @FXML
    RadioButton btnSi;
    @FXML
    RadioButton btnNo;
    @FXML
    ToggleGroup concInsc;
    @FXML
    RadioButton btnInscSi;
    @FXML
    RadioButton btnInscNo;
    
    
    
    static ArrayList<Object> arrInfo= new ArrayList<Object>();
   

    @FXML
    private void cancelarCrearC() throws IOException {
        App.setRoot("AdminConcurso");
    }
    
    @FXML
    private void crearPremio() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("AgregarPremio.fxml"));
        AgregarPremioController ct = new AgregarPremioController();
        fxmlLoader.setController(ct);
        
        BorderPane root = (BorderPane) fxmlLoader.load();
        
        ct.cmbLugar.getItems().setAll(modelo.enums.Puesto.values());
        ct.nombreAuspiciante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        ct.tablaAuspPremio.getItems().setAll(MenúPrincipalController.getArrAuspiciantes());
       
        arrInfo.add(cmbTipo.getValue()); arrInfo.add(nombreConc.getText());
        arrInfo.add(fechaConc.getValue()); arrInfo.add(horaConc.getText());
        arrInfo.add(inicioInsc.getValue()); arrInfo.add(finInsc.getValue());
        arrInfo.add(ciudadConc.getValue()); arrInfo.add(lugarConc.getText());
        
        App.changeRoot(root);
    }
    
    @FXML
    private void crearConcurso(){
        
        try{
        
        ArrayList<Auspiciante> arrAuspiciante=new ArrayList<>();  arrAuspiciante.add((Auspiciante) tablaAusp.getSelectionModel().getSelectedItem());
        ArrayList<Mascota> arrParticipantes=new ArrayList<Mascota>();
        Premio[] arrPremios= new Premio[]{AgregarPremioController.arrPremios[0],AgregarPremioController.arrPremios[1],AgregarPremioController.arrPremios[2]};
        
        Concurso conc= new Concurso(nombreConc.getText(),fechaConc.getValue(),LocalTime.parse(horaConc.getText()),inicioInsc.getValue(),finInsc.getValue(),(Ciudad) ciudadConc.getValue(),lugarConc.getText(),arrPremios,arrAuspiciante,(TiposAnimal) cmbTipo.getValue());
        conc.generarCodConcurso();
        conc.setArrParticipantes(arrParticipantes);
        conc.setAbiertoInscripciones(true);
        conc.setConcursoEnCurso(true);
        
        AgregarPremioController.arrPremios[0]=null;
        AgregarPremioController.arrPremios[1]=null;
        AgregarPremioController.arrPremios[2]=null;
        
        if(conc.getNombre().equals("") | conc.getLugar().equals("") ){
            throw new ConcursoException("Debe rellenar todos la información solicitada");
            }
        
        if(conc.getFechaEvento()==null | conc.getFechaFinInscripcion()==null | conc.getFechaInscripcion()==null){
            throw new ConcursoException("Indique todas las fechas requeridas");
        }
        
        if(conc.getDirigidoA()==null | conc.getCiudad()==null){
            throw new ConcursoException("Seleccione todas las opciones requeridas");
        }
        if(conc.getAuspiciantes().get(0)==null){
            throw new ConcursoException("Auspiciante no seleccionado");
        }
        if(conc.getPremio()[0]==null | conc.getPremio()[1]==null | conc.getPremio()[2]==null){
            throw new ConcursoException("Cree todos los premios requeridos");
        }
        MenúPrincipalController.getArrConcursos().add(conc);
        modelo.clases.Concurso.serializarConcurso();
        
        mostrarAlerta(AlertType.INFORMATION,"Concurso creado/editado exitosamente");
        
        
        App.setRoot("AdminConcurso");
        } 
        catch (RuntimeException ex) {
            System.out.println("hola");
           mostrarAlerta(AlertType.ERROR,"Ingrese el formato de hora correcto");
        }
        catch(ConcursoException ex){
           mostrarAlerta(AlertType.ERROR,ex.getMessage());
        }
        catch (IOException ex) {
           mostrarAlerta(AlertType.ERROR,ex.getMessage());
        }
        
   

    }
    
    @FXML
    public void editarConcurso(Concurso c){
        
        try{
        
        ArrayList<Auspiciante> arrAuspiciante=new ArrayList<>();  arrAuspiciante.add((Auspiciante) tablaAusp.getSelectionModel().getSelectedItem());
        Concurso conc= new Concurso(nombreConc.getText(),fechaConc.getValue(),LocalTime.parse(horaConc.getText()),inicioInsc.getValue(),finInsc.getValue(),(Ciudad) ciudadConc.getValue(),lugarConc.getText(),c.getPremio(),arrAuspiciante,(TiposAnimal) cmbTipo.getValue());
        conc.generarCodConcurso();
        conc.setArrParticipantes(c.getParticipantes());
        RadioButton rdConc=(RadioButton) concCurso.getSelectedToggle();
        String sel1=rdConc.getText();
        if(sel1.equals("Si")){
            conc.setConcursoEnCurso(true);
        }
        else if(sel1.equals("No")){
            conc.setConcursoEnCurso(false);
            
        }
        RadioButton rdInsc=(RadioButton) concInsc.getSelectedToggle();
        String sel2=rdInsc.getText();
        if(sel2.equals("Si")){
            conc.setAbiertoInscripciones(true);
        }
        else if(sel2.equals("No")){
            conc.setAbiertoInscripciones(false);
        }
        
        if(conc.isConcursoEnCurso()==false){
            ArrayList<Ganador> ganadores=new ArrayList<Ganador>();
            conc.setArrGanadores(ganadores);
            modelo.clases.Ganador.generarGanadores(conc);
        }
       
        if(conc.getNombre().equals("") | conc.getLugar().equals("") ){
            throw new ConcursoException("Debe rellenar todos la información solicitada");
            }
        
        if(conc.getFechaEvento()==null | conc.getFechaFinInscripcion()==null | conc.getFechaInscripcion()==null){
            throw new ConcursoException("Indique todas las fechas requeridas");
        }
        
        if(conc.getDirigidoA()==null | conc.getCiudad()==null){
            throw new ConcursoException("Seleccione todas las opciones requeridas");
        }
        if(conc.getAuspiciantes().get(0)==null){
            throw new ConcursoException("Auspiciante no seleccionado");
        }
        if(conc.getPremio()[0]==null | conc.getPremio()[1]==null | conc.getPremio()[2]==null){
            throw new ConcursoException("Cree todos los premios requeridos");
        }
        MenúPrincipalController.getArrConcursos().add(conc);
        modelo.clases.Concurso.serializarConcurso();
        
        
        mostrarAlerta(AlertType.INFORMATION,"Concurso editado exitosamente");
        
        App.setRoot("AdminConcurso");
        }
        
       
        catch (RuntimeException ex) {
            System.out.println("hola");
           mostrarAlerta(AlertType.ERROR,"Formato de hora incorrecto");
        }
        catch(ConcursoException ex){
           mostrarAlerta(AlertType.ERROR,ex.getMessage());
        }
        catch (IOException ex) {
           mostrarAlerta(AlertType.ERROR,ex.getMessage());
        }
        
   

    }
    
    public void llenarInfo(Concurso c){
        tituloConcurso.setText("Editar Concurso");
        cmbTipo.setValue(c.getDirigidoA());
        nombreConc.setText(c.getNombre());
        fechaConc.setValue(c.getFechaEvento());
        horaConc.setText((String) c.getHoraEvento().toString());
        inicioInsc.setValue(c.getFechaInscripcion());
        finInsc.setValue(c.getFechaFinInscripcion());
        ciudadConc.setValue(c.getCiudad());
        lugarConc.setText(c.getLugar());
        tablaPremio.getItems().setAll(c.getPremio());
        MenúPrincipalController.getArrConcursos().remove(c);
        
            
    }
    
    public static void mostrarAlerta(AlertType tipo, String msj){
        Alert alert= new Alert(tipo);
        alert.setTitle("Diálogo de información");
        alert.setHeaderText("Resultado de la operación");
        alert.setContentText(msj);
        alert.showAndWait();
        
    }
    
   
     
}
