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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vista.VistaPersonaController;

public class VistaListaControlador implements Initializable {

    private ObservableList<Persona> datos = null; // Colección vinculada a la vista.

    private ListView<Persona> vistadeListafxID;
    private TextField textFieldfxID;
    private TextField textFieldApellidofxID;
    @FXML
    private Button BAddfxID;
    @FXML
    private Button BBorrarfxID;
    @FXML
    private TableView<Persona> tablaPersonas;
    @FXML
    private TableColumn<Persona, String> nomCol;
    @FXML
    private TableColumn<Persona, String> apeCol;

    @FXML
    void addAccion(ActionEvent event) throws IOException {
        /* anadir aqui el codigo para mostrar la nueva ventana*/
        /*--------------------------------------------------------------------*/
        FXMLLoader miLoader = new FXMLLoader(getClass().getResource("/vista/vistaPersona.fxml"));
        Parent root = miLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Demo vista de persona");
        ((VistaPersonaController) miLoader.getController()).setDatos(datos);
        stage.show();
        
        /*--------------------------------------------------------------------*/
        /*comentar el codigo hasta final del metodo al añadir la nueva ventana*/
        
        // añade a la colección si los campos no son vacíos y no contienen únicamente blancos
//        if ((!textFieldfxID.getText().isEmpty())
//                && (textFieldfxID.getText().trim().length() != 0)
//                && (!textFieldApellidofxID.getText().isEmpty())
//                && (textFieldApellidofxID.getText().trim().length() != 0)) {
//            datos.add(new Persona(textFieldfxID.getText(), textFieldApellidofxID.getText()));
//            textFieldfxID.clear();
//            textFieldApellidofxID.clear();
//            textFieldfxID.requestFocus();  //cambio del foco al textfield.
//
//        }
    }

    @FXML
    void borrarAccion(ActionEvent event) {
        int i = tablaPersonas.getSelectionModel().getSelectedIndex();
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
        tablaPersonas.setItems(datos); // vinculaci�n entre la vista y el modelo
        nomCol.setCellValueFactory(celda -> celda.getValue().NombreProperty());
        apeCol.setCellValueFactory(celda -> celda.getValue().ApellidosProperty());
        
        /* asignar aqui el nuevo estilo de la celda*/
        /*-------------------------------------------------------*/
        
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
        tablaPersonas.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                    Boolean newValue) {
                if (tablaPersonas.isFocused()) {
                    BBorrarfxID.setDisable(false);
                    //BAddfxID.setDisable(true);
                }

            }

        });

    }
	


        
        
}

/* crear aqui la nueva clase que extiende a ListCell*/
/*-------------------------------------------------------*/



/*-------------------------------------------------------*/