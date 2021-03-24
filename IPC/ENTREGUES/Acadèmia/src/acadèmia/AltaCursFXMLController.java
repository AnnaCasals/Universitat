/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acadèmia;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import modelo.Curso;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class AltaCursFXMLController implements Initializable {
    private ObservableList<Curso> dadesLocals = null;
    @FXML
    private TextField nomProf;
    @FXML
    private TextField maxAlumnes;
    @FXML
    private DatePicker dataInici;
    @FXML
    private DatePicker dataFi;
    @FXML
    private ToggleButton dll;
    @FXML
    private ToggleButton dm;
    @FXML
    private ToggleButton dc;
    @FXML
    private ToggleButton dj;
    @FXML
    private ToggleButton dv;
    @FXML
    private ToggleButton ds;
    @FXML
    private TextField aula;
    @FXML
    private TextField titolCurs;
    @FXML
    private TextField hora;
    @FXML
    private TextField min;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    private void desar(ActionEvent event) {

        if((!titolCurs.getText().isEmpty()) && (titolCurs.getText().trim().length() != 0)
                && (!nomProf.getText().isEmpty()) && (nomProf.getText().trim().length() != 0)
                && (!maxAlumnes.getText().isEmpty()) && (maxAlumnes.getText().trim().length() != 0)
                && (!aula.getText().isEmpty()) && (aula.getText().trim().length() != 0)) {
                int mAlumnes = Integer.parseInt(maxAlumnes.getText());
                LocalDate inici = dataInici.getValue();
                LocalDate fi = dataFi.getValue();
                int hh = Integer.parseInt(hora.getText());
                int mm = Integer.parseInt(min.getText());
                LocalTime h = LocalTime.of(hh, mm);
                dadesLocals.add(new Curso(titolCurs.getText(), nomProf.getText(), mAlumnes, inici, fi, h, null, aula.getText()));
                titolCurs.clear(); nomProf.clear(); maxAlumnes.clear(); hora.clear(); min.clear(); aula.clear();
                titolCurs.requestFocus();
        }
         titolCurs.getScene().getWindow().hide();
    }
    
    @FXML
    private void cancelar(ActionEvent event) {
        titolCurs.getScene().getWindow().hide();
    }
    public void setDatos(ObservableList<Curso> d){
        dadesLocals = d;
    }
    
    
}
