/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acadèmia;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import modelo.Alumno;

/**
 * FXML Controller class
 *
 * @author Anna
 */
public class AltaALumnesFXMLController implements Initializable {
    private ObservableList<Alumno> dadesLocals = null;
    @FXML
    private TextField nomAlumne;
    @FXML
    private TextField dniAlumne;
    @FXML
    private TextField edatAlumne;
    @FXML
    private TextField direccioAlumne;
    @FXML
    private DatePicker dataAltaAlumne;
    @FXML
    private ImageView foto;
    
    private Image imatge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void desarAlumne(ActionEvent event) {
        if((!nomAlumne.getText().isEmpty()) && (nomAlumne.getText().trim().length() != 0)
                && (!dniAlumne.getText().isEmpty()) && (dniAlumne.getText().trim().length() != 0)
                && (!edatAlumne.getText().isEmpty()) && (edatAlumne.getText().trim().length() != 0)
                && (!direccioAlumne.getText().isEmpty()) && (direccioAlumne.getText().trim().length() != 0)) {
            int edat = Integer.parseInt(edatAlumne.getText());
            LocalDate dataAlta = dataAltaAlumne.getValue();
            imatge = foto.getImage();
            dadesLocals.add(new Alumno(dniAlumne.getText(), nomAlumne.getText(), edat, direccioAlumne.getText(),  dataAlta, imatge));
            nomAlumne.clear(); dniAlumne.clear(); edatAlumne.clear(); direccioAlumne.clear();
            nomAlumne.requestFocus();
        }
        nomAlumne.getScene().getWindow().hide();

    }

    @FXML
    private void cancelarAlumne(ActionEvent event) {
         nomAlumne.getScene().getWindow().hide();
    }
    public void setDatos(ObservableList<Alumno> d){
        dadesLocals = d;
    }

    @FXML
    private void afegirFoto(ActionEvent event) {
        FileChooser afegirFoto = new FileChooser();
        afegirFoto.setTitle("Obrir foto");
        Window window = null;
        File fotoSeleccionada = afegirFoto.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
        if (fotoSeleccionada != null) {
            String item = fotoSeleccionada.getAbsolutePath();
            File imageFile = new File(item);
            String fileLocation = imageFile.toURI().toString();
            imatge = new Image(fileLocation);
            foto.setImage(imatge);
        }
    }
    
}
