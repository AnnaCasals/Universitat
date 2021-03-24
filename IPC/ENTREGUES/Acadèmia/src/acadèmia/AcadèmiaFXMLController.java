/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acadèmia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Anna
 */
public class AcadèmiaFXMLController implements Initializable {
    
    private Label label;
    @FXML
    private HBox hboxBotons;
    @FXML
    private VBox vbox;
    @FXML
    private Label text;
    @FXML
    private HBox hboxText;
    @FXML
    private StackPane stackText;
    @FXML
    private StackPane stackBotons;
    
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void cursos(ActionEvent event) throws IOException {
        FXMLLoader miLoader = new FXMLLoader(getClass().getResource("CursosFXML.fxml"));
        Parent root = miLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Cursos");
        stage.show();
    }

    @FXML
    private void alumnes(ActionEvent event) throws IOException {
        FXMLLoader meuLoader = new FXMLLoader(getClass().getResource("AlumnesFXML.fxml"));
        Parent root = meuLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Alumnes");
        stage.show();
    }


    @FXML
    private void matricula(ActionEvent event) throws IOException {
        FXMLLoader miLoader = new FXMLLoader(getClass().getResource("MatriculaFXML.fxml"));
        Parent root = miLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Matrícula");
        stage.show();
    }

    
}
