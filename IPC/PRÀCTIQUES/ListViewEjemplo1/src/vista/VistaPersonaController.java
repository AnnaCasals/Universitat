/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author ansalca2
 */
public class VistaPersonaController implements Initializable {
    private ObservableList<Persona> datosLocales = null;
    @FXML
    private TextField textFieldfxID;
    @FXML
    private TextField textFieldApellidofxID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvar(ActionEvent event) {
        if ((!textFieldfxID.getText().isEmpty())
                && (textFieldfxID.getText().trim().length() != 0)
                && (!textFieldApellidofxID.getText().isEmpty())
                && (textFieldApellidofxID.getText().trim().length() != 0)) {
            datosLocales.add(new Persona(textFieldfxID.getText(), textFieldApellidofxID.getText()));
            textFieldfxID.clear();
            textFieldApellidofxID.clear();
            textFieldfxID.requestFocus();  //cambio del foco al textfield.

        }
        textFieldApellidofxID.getScene().getWindow().hide();
    }

    @FXML
    private void cancelar(ActionEvent event) {
        textFieldApellidofxID.getScene().getWindow().hide();
    }
    
    public void setDatos(ObservableList<Persona> d){
        datosLocales = d;
    }
    
}
