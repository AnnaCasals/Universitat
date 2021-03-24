package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import modelo.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

public class VistaListaControlador implements Initializable {

    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.

    @FXML
    private ListView<Persona> vistadeListafxID;
    private TextField textFieldfxID;
    private TextField textFieldApellidofxID;
    @FXML
    private Button BAddfxID;
    @FXML
    private Button BBorrarfxID;

    @FXML
    void addAccion(ActionEvent event) throws IOException {
        /* anadir aqui el codigo para mostrar la nueva ventana*/
        /*--------------------------------------------------------------------*/
        //Parent root = FXMLLoader.load(getClass().getResource("/vista/FXMLa.fxml"));
        FXMLLoader miLoader = new FMXLLoader(getClass().getResource("/vista/FXMLa.fxml");
        Parent root = miLoader.load();
        ((VistaFXMLaController)miLoader.getContoller()).inizializaDatos(datos);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Vista Persona");
        stage.show();
    
        
        /*--------------------------------------------------------------------*/
        /*comentar el codigo hasta final del metodo al añadir la nueva ventana*/
        
        // añade a la colección si los campos no son vacíos y no contienen únicamente blancos
        if ((!textFieldfxID.getText().isEmpty())
                && (textFieldfxID.getText().trim().length() != 0)
                && (!textFieldApellidofxID.getText().isEmpty())
                && (textFieldApellidofxID.getText().trim().length() != 0)) {
            datos.add(new Persona(textFieldfxID.getText(), textFieldApellidofxID.getText()));
            textFieldfxID.clear();
            textFieldApellidofxID.clear();
            textFieldfxID.requestFocus();  //cambio del foco al textfield.

        }
    }

    @FXML
    void borrarAccion(ActionEvent event) {
        int i = vistadeListafxID.getSelectionModel().getSelectedIndex();
        if (i >= 0) {
            datos.remove(i);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        ArrayList<Persona> misdatos = new ArrayList<Persona>();
        misdatos.add(new Persona("Pepe", "García"));
        misdatos.add(new Persona("María", "Pérez"));
        datos = FXCollections.observableArrayList(misdatos);
        vistadeListafxID.setItems(datos); // vinculaci�n entre la vista y el modelo
        
        /* asignar aqui el nuevo estilo de la celda*/
        /*-------------------------------------------------------*/
        vistadeListafxID.setCellFactory(c -> new PersonListCell());
        /*-------------------------------------------------------*/
        
        
        // inhabilitar botones al arrancar.
        //BAddfxID.setDisable(true);
        BBorrarfxID.setDisable(true);
        // oyente de foco para el textfield.
//        textFieldfxID.focusedProperty().addListener((obj, antiguo, nuevo) -> {
//            // TODO Auto-generated method stub
////                    if (textFieldfxID.isFocused()) {
//            if (nuevo == true) {
//                BAddfxID.setDisable(false);
//                BBorrarfxID.setDisable(true);
//            }
//        });

        // oyente de foco para el listView
        vistadeListafxID.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                    Boolean newValue) {
                if (vistadeListafxID.isFocused()) {
                    BBorrarfxID.setDisable(false);
                    //BAddfxID.setDisable(true);
                }

            }

        });

    }
	


        
        
}

/* crear aqui la nueva clase que extiende a ListCell*/
/*-------------------------------------------------------*/
class PersonListCell extends ListCell<Persona>
{
@Override
protected void updateItem(Persona item, boolean empty)
{ super.updateItem(item, empty); // Obligatoria esta llamada
if (item==null || empty) setText(null);
else setText(item.getNombre()+ " ," + item.getApellidos());
}
}


/*-------------------------------------------------------*/