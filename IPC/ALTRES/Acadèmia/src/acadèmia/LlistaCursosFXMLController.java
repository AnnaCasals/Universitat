/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acadèmia;

import static acadèmia.CursosFXMLController.alumnesDeCurs;
import accesoaBD.AccesoaBD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Button;
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
 * @author Maria
 */
public class LlistaCursosFXMLController implements Initializable {
    ObservableList<Curso> cursoObservable;
    public static List<Alumno> alumnesDeCurs;
    AccesoaBD acceso = new AccesoaBD();
    
    @FXML
    private Button mostrarAlumnes;
    @FXML
    private TableView<Curso> taulaCursos;
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
        // TODO
    }    

    @FXML
    private void mostrarAlumnes(ActionEvent event) throws IOException {
        alumnesDeCurs = acceso.getAlumnosDeCurso(taulaCursos.getSelectionModel().getSelectedItem().getTitulodelcurso());
        FXMLLoader miLoader = new FXMLLoader(getClass().getResource("MostrarAlumnesFXML.fxml"));
        Parent root = miLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Alumnes Curs");
        stage.show();
    }
    
}
