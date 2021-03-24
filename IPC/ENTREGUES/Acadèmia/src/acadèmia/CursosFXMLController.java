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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Alumno;
import modelo.Curso;
import modelo.Matricula;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class CursosFXMLController implements Initializable {
    ObservableList<Curso> cursoObservable;
    ObservableList<Alumno> alumneObservable;
    AccesoaBD acceso = new AccesoaBD();
    
    @FXML private TableView<Curso> taulaCursos;
    @FXML private TableColumn<Curso, String> titolCol;
    @FXML private TableColumn<Curso,? > diesCol;
    @FXML private TableColumn<Curso, ?> horaCol;
    @FXML private TableColumn<Curso, ?> aulaCol;
    @FXML private TableColumn<Curso, ?> nMaxCol;
    @FXML private TableColumn<Curso, ?> profCol;
    @FXML private TableColumn<Curso, ?> iniciCol;
    @FXML private TableColumn<Curso, ?> fiCol;
    @FXML private Button mostrarAlumnes;
    @FXML private Button altaCurs;
    @FXML private Button baixaCurs;
    public static List<Alumno> alumnesDeCurs;
    @FXML private HBox hbox;
    @FXML private Pane pane;
    @FXML private HBox botons;
    @FXML private VBox vbox;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hbox.prefHeightProperty().bind(vbox.heightProperty());
        taulaCursos.prefWidthProperty().bind(hbox.widthProperty());
        taulaCursos.prefHeightProperty().bind(hbox.heightProperty());
        hbox.prefHeightProperty().bind(vbox.heightProperty());
        botons.prefWidthProperty().bind(pane.widthProperty());
        
        
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
            baixaCurs.setDisable(true);
            taulaCursos.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue <? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if(taulaCursos.isFocused()) {
                        baixaCurs.setDisable(false);
                    }
                }
                });
            acceso.salvar();
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
        ((MostrarAlumnesFXMLController) miLoader.getController()).setDatos(alumneObservable);
        stage.show();
        acceso.salvar();
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
        stage.setResizable(false);
        ((AltaCursFXMLController) miLoader.getController()).setDatos(cursoObservable);
        stage.show();
        
    }


    @FXML
    private void baixaCurs(ActionEvent event) {
        List<Matricula> a = acceso.getMatriculasDeCurso(taulaCursos.getSelectionModel().getSelectedItem());
        int i = taulaCursos.getSelectionModel().getSelectedIndex();
            if(i >= 0) {
                if(!a.isEmpty()) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Baixa curs");
                    alert.setHeaderText("Baixa curs amb alumnes matriculats");
                    alert.setContentText("BORRAR CURS SELECCIONAT I ALUMNES MATRICULATS EN AQUEST?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        a.remove(i);
                        cursoObservable.remove(i);
                    System.out.println("ACCEPTAR");
                    } else {
                        System.out.println("CANCELAR");
                    }
                } else { cursoObservable.remove(i); }
            }
        acceso.salvar();
    }
    
}
