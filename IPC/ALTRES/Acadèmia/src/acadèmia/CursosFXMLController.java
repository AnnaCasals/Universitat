/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acadèmia;

import accesoaBD.AccesoaBD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Alumno;
import modelo.Curso;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class CursosFXMLController implements Initializable {
    ObservableList<Curso> cursoObservable;
    AccesoaBD acceso = new AccesoaBD();
    
    @FXML
    private TableView<Curso> taulaCursos;
    @FXML
    private TableColumn<Curso, String> titolCol;
    @FXML
    private TableColumn<Curso,? > diesCol;
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
    private Button mostrarAlumnes;
    public static List<Alumno> alumnesDeCurs;
    @FXML
    private Button altaCurs;
    @FXML
    private Button baixaCurs;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        cursoObservable = FXCollections.observableList(acceso.getCursos());
        taulaCursos.setItems(cursoObservable);
        taulaCursos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        titolCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulodelcurso()));
        diesCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDiasimparte()));
        horaCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getHora()));
        aulaCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAula()));
        nMaxCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNumeroMaximodeAlumnos()));
        profCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getProfesorAsignado()));
        iniciCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFechainicio()));
        fiCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFechafin()));
            acceso.salvar();
    }    

    @FXML
    private void mostrarAlumnes(ActionEvent event) throws IOException {
        //alumnesDeCurs = acceso.getAlumnosDeCurso(taulaCursos.getSelectionModel().getSelectedItem().getTitulodelcurso());
        FXMLLoader miLoader = new FXMLLoader(getClass().getResource("MostrarAlumnesFXML.fxml"));
        Parent root = miLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Alumnes Curs");
        stage.show();
    }

    @FXML
    private void altaCurs(ActionEvent event) throws IOException {
        FXMLLoader miLoader = new FXMLLoader(getClass().getResource("AltaCursFXML.fxml"));
        Parent root = miLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Alta");
        ((AltaCursFXMLController) miLoader.getController()).setDatos(cursoObservable);
        stage.show();
        
    }


    @FXML
    private void baixaCurs(ActionEvent event) {
        int i = taulaCursos.getSelectionModel().getSelectedIndex();
        if(i >= 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Baixa curs");
            alert.setHeaderText("Baixa curs amb alumnes matriculats");
            alert.setContentText("¿Segur que vols continuar?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                System.out.println("ACCEPTAR");
            } else {
                System.out.println("CANCELAR");
            }
            cursoObservable.remove(i);
            }
         acceso.salvar();
    }
    
}
