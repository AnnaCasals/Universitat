/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciologin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField text_usuari;
    @FXML
    private Text missatge_usuari;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PolsatIniciar(ActionEvent event) {
        missatge_usuari.setText("Benvingut " + text_usuari.getText());
    }
    
}
