/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acadèmia;

import accesoaBD.AccesoaBD;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Alumno;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class AlumnesFXMLController implements Initializable {
    ObservableList<Alumno> alumneObservable;
    AccesoaBD acceso = new AccesoaBD();
    @FXML
    private TableView<Alumno> taulaAlumnes;
    @FXML
    private TableColumn<Alumno, String> nomCol;
    @FXML
    private TableColumn<Alumno, String> dniCol;
    @FXML
    private TableColumn<Alumno, Number> edatCol;
    @FXML
    private TableColumn<Alumno, ?> dataAltaCol;
    @FXML
    private Button altaAlumne;
    @FXML
    private Button baixaAlumne;
    @FXML
    private TableColumn<Alumno, ?> direccióCol;
    @FXML
    private TableColumn<Alumno, ?> fotoCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       alumneObservable = FXCollections.observableList(acceso.getAlumnos());
       taulaAlumnes.setItems(alumneObservable);
       taulaAlumnes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        nomCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        dniCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDni()));
        edatCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()));
        direccióCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDireccion()));
        dataAltaCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFechadealta()));
        fotoCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFoto()));
            acceso.salvar();

   }    

    @FXML
    private void altaAlumne(ActionEvent event) throws IOException {
        FXMLLoader miLoader = new FXMLLoader(getClass().getResource("AltaALumnesFXML.fxml"));
        Parent root = miLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Alta alumnes");
        ((AltaALumnesFXMLController) miLoader.getController()).setDatos(alumneObservable);
        stage.show();
    }

    @FXML
    private void baixaAlumne(ActionEvent event) {
        int i = taulaAlumnes.getSelectionModel().getSelectedIndex();
        if(i >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Baixa alumne");
            alert.setHeaderText("Baixa curs amb alumnes matriculats");
            alert.setContentText("¿Segur que vols continuar?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                System.out.println("ACCEPTAR");
            } else {
                System.out.println("CANCELAR");
            }
            alumneObservable.remove(i);
            }
         acceso.salvar();
    }
    
    
}
