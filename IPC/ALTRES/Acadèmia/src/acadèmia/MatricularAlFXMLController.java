/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acadèmia;

import accesoaBD.AccesoaBD;
import java.net.URL;
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
import modelo.Alumno;
import modelo.Curso;
import modelo.Matricula;

/**
 * FXML Controller class
 *
 * @author Maria
 */
public class MatricularAlFXMLController implements Initializable {
    ObservableList<Curso> cursoObservable;
    ObservableList<Alumno> alumneObservable;
    AccesoaBD acceso = new AccesoaBD();
    
    @FXML
    private TableView<Curso> tablaCursos;
    @FXML
    private TableView<Alumno> tablaAlumnes;
    @FXML
    private TableColumn<Curso, String> titolCol;
    @FXML
    private TableColumn<Curso, ?> diesCol;
    @FXML
    private TableColumn<Curso, ?> horaCol;
    @FXML
    private TableColumn<Curso, ?> aulaCol;
    @FXML
    private TableColumn<Curso, ?> nMaxCol;
    @FXML
    private TableColumn<Curso, ?> profCol;
    @FXML
    private TableColumn<Curso, ?> iniciCol;
    @FXML
    private TableColumn<Curso, ?> fiCol;
    @FXML
    private TableColumn<Alumno, ?> nomCol;
    @FXML
    private TableColumn<Alumno, ?> dniCol;
    @FXML
    private TableColumn<Alumno, ?> edatCol;
    @FXML
    private TableColumn<Alumno, ?> direccióCol;
    @FXML
    private TableColumn<Alumno, ?> dataAltaCol;
    @FXML
    private TableColumn<Alumno, ?> fotoCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        // TODO
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
    private void matricularAl(ActionEvent event) {
        Curso cursSel = tablaCursos.getSelectionModel().getSelectedItem();
        Alumno alumneSel = tablaAlumnes.getSelectionModel().getSelectedItem();
        System.out.println(cursSel);
        System.out.println(alumneSel);
    }

    
}
