/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acadèmia;

import accesoaBD.AccesoaBD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Alumno;
import modelo.Curso;
import modelo.Matricula;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class MatricularAlFXMLController implements Initializable {
    ObservableList<Curso> cursoObservable;
    ObservableList<Alumno> alumneObservable;
    AccesoaBD acceso = new AccesoaBD();
    
    @FXML   private TableColumn<Curso, String> titolCol;
    @FXML   private TableColumn<Curso, ?> diesCol;
    @FXML   private TableColumn<Curso, ?> horaCol;
    @FXML   private TableColumn<Curso, ?> aulaCol;
    @FXML   private TableColumn<Curso, ?> nMaxCol;
    @FXML   private TableColumn<Curso, ?> profCol;
    @FXML   private TableColumn<Curso, ?> iniciCol;
    @FXML   private TableColumn<Curso, ?> fiCol;
    @FXML   private TableColumn<Alumno, ?> nomCol;
    @FXML   private TableColumn<Alumno, ?> dniCol;
    @FXML   private TableColumn<Alumno, ?> edatCol;
    @FXML   private TableColumn<Alumno, ?> direccióCol;
    @FXML   private TableColumn<Alumno, ?> dataAltaCol;
    @FXML   private TableColumn<Alumno, ?> fotoCol;
    @FXML   private VBox vbox;
    @FXML   private HBox botons;
    @FXML   private TableView<Curso> tablaCursos;
    @FXML   private TableView<Alumno> tablaAlumnes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaCursos.prefWidthProperty().bind(vbox.heightProperty());
        tablaCursos.prefHeightProperty().bind(vbox.widthProperty());
        tablaAlumnes.prefWidthProperty().bind(vbox.heightProperty());
        tablaAlumnes.prefHeightProperty().bind(vbox.widthProperty());
        
        cursoObservable = FXCollections.observableList(acceso.getCursos());
        tablaCursos.setItems(cursoObservable);
        tablaCursos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        titolCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulodelcurso()));
        diesCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDiasimparte()));
        horaCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getHora()));
        aulaCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAula()));
        nMaxCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNumeroMaximodeAlumnos()));
        profCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getProfesorAsignado()));
        iniciCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFechainicio()));
        fiCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFechafin()));
        
        
        alumneObservable = FXCollections.observableList(acceso.getAlumnos());
        tablaAlumnes.setItems(alumneObservable);
        tablaAlumnes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        nomCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNombre()));
        dniCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDni()));
        edatCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEdad()));
        direccióCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDireccion()));
        dataAltaCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFechadealta()));
        fotoCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFoto()));
        acceso.salvar();
    }    

    @FXML
    private void matricular(ActionEvent event) {
        Curso curs = tablaCursos.getSelectionModel().getSelectedItem();
        Alumno alumne = tablaAlumnes.getSelectionModel().getSelectedItem();
        if(curs.getNumeroMaximodeAlumnos() + 1 <= curs.getNumeroMaximodeAlumnos()) {
            List<Matricula> a = acceso.getMatriculasDeCurso(curs);
            a.add(new Matricula(null, curs, alumne));
        }
        acceso.salvar();
    }
}
        