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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.Alumno;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class MostrarAlumnesFXMLController implements Initializable {
    ObservableList<Alumno> alumneObservable;
     private ObservableList<Alumno> dadesLocals = null;
    
    AccesoaBD acceso = new AccesoaBD();
    @FXML   private Button borrar;
    @FXML   private Button cancelar;
   
    @FXML   private HBox hboxLlista;
    @FXML   private VBox vbox;
    @FXML   private Pane pane;
    @FXML   private HBox botons;
    @FXML   private TableView<Alumno> taulaAlumnes;
    @FXML   private TableColumn<Alumno, ?> nomCol;
    @FXML   private TableColumn<Alumno, ?> dniCol;
    @FXML   private TableColumn<Alumno, ?> edatCol;
    @FXML   private TableColumn<Alumno, ?> direccioCol;
    @FXML   private TableColumn<Alumno, ?> dataAltaCol;

    /**
     * Initializes the controller class.
     */
    private ObservableList<Alumno> dada = FXCollections.observableList(
            CursosFXMLController.alumnesDeCurs
    );
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hboxLlista.prefHeightProperty().bind(vbox.heightProperty());
        taulaAlumnes.prefWidthProperty().bind(hboxLlista.widthProperty());
        taulaAlumnes.prefHeightProperty().bind(hboxLlista.heightProperty());
        hboxLlista.prefHeightProperty().bind(vbox.heightProperty());
        botons.prefWidthProperty().bind(pane.widthProperty());
        
        
        taulaAlumnes.setItems(dada);
        taulaAlumnes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        nomCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNombre()));
        dniCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDni()));
        edatCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEdad()));
        direccioCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDireccion()));
        dataAltaCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFechadealta()));
    }    

    @FXML
    private void borrarAlumneCurs(ActionEvent event) {
         dada.removeAll(taulaAlumnes.getSelectionModel().getSelectedItems());
         //acceso.salvar();
    }

    @FXML
    private void cancelar(ActionEvent event) {
        taulaAlumnes.getScene().getWindow().hide();
    }
    public void setDatos(ObservableList<Alumno> d){
        dadesLocals = d;
    }
}
