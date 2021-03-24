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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Persona;


/**
 * FXML Controller class
 *
 * @author ansalca2
 */
public class FXMLaController implements Initializable {

    @FXML
    private TextField textFieldfxID;
    @FXML
    private TextField textFieldApellidofxID;

    private ObservableList <Persona> datosLocales;
    
    public void inicializaDatos(ObservableList<Persona> dat) {
        datosLocales = dat;
    }
    private void aceptarPersona(ActionEvent event()) {
        if ((!textFieldfxID.getText().isEmpty())
                && (textFieldfxID.getText().trim().length() != 0)
                && (!textFieldApellidofxID.getText().isEmpty())
                && (textFieldApellidofxID.getText().trim().length() != 0)) {
            datosLocales.add(new Persona(textFieldfxID.getText(), textFieldApellidofxID.getText()));
            textFieldfxID.clear();
            textFieldApellidofxID.clear();
            textFieldfxID.requestFocus();  //cambio del foco al textfield.
        }
        ((Stage)nombre)
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        // TODO
    }    

    
}
