/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acadèmia;

import accesoaBD.AccesoaBD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Alumno;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class MostrarAlumnesFXMLController implements Initializable {
    ObservableList<Alumno> alumneObservable;
    AccesoaBD acceso = new AccesoaBD();
 
    @FXML
    private Button borrar;
    @FXML
    private Button cancelar;
    @FXML
    private TableView<Alumno> taulaAlumnes;
    @FXML
    private TableColumn<Alumno, String> nomCol;
    @FXML
    private TableColumn<Alumno, String> dniCol;
    @FXML
    private TableColumn<Alumno, Number> edatCol;
    @FXML
    private TableColumn<Alumno, String> direccióCol;
    @FXML
    private TableColumn<Alumno, ?> dataAltaCol;
    @FXML
    private TableColumn<Alumno, ?> fotoCol;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        alumneObservable = FXCollections.observableList(acceso.getAlumnos());
        taulaAlumnes.setItems(alumneObservable);
        dniCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDni()));
        nomCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        direccióCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        edatCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()));
        dataAltaCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFechadealta()));
        fotoCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFoto()));
    }    

    @FXML
    private void borrarAlumneCurs(ActionEvent event) {
         /*data.removeAll(alumnesCurs.getSelectionModel().getSelectedItems());
         acceso.salvar();
*/
    }

    @FXML
    private void cancelar(ActionEvent event) {
           // alumnesCurs.getScene().getWindow().hide();
    }
    
}
