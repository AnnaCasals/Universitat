/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx1r;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author ansalca2
 */
public class FXML1rController implements Initializable {
    
    @FXML
    private Rectangle rectangle;
    @FXML
    private Slider hSlider;
    @FXML
    private Slider vSlider;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //vSlider.valueProperty().addListener((a, b, c) -> {
          //  rectangle.setHeight((double) c);
        //});
        //hSlider.valueProperty().addListener((a, b, c) -> {
          //  rectangle.setWidth((double) c);
        //});
        rectangle.widthProperty().bind(hSlider.valueProperty());
        rectangle.heightProperty().bind(vSlider.valueProperty());
    }    
    
}
