/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrames;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;

/**
 *
 * @author Anna
 */
public class FXMLDiagramesController implements Initializable {
    
    private Label label;
    @FXML
    private LineChart<String, Number> chart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    
    final int NBRACKETS = 10;
    public void aleatoris() {
        int hist[] = new int[NBRACKETS];
        for (int i = 0; i< hist.length; i++) {
            hist[i] = 0;
        }
        for(int j = 0; j < 1000; j++){
            double value = Math.random() * NBRACKETS;
            hist[(int) value]++;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        xAxis.setLabel("Ranges");
        yAxis.setLabel("Frequencies");
        XYChart.Series<String, Number> series = new XYChart.Series();
        for(int i = 0; i < hist.length; i++)
            series.getData().add(new XYChart.Data<>(i + "-" + (i+1), hist[i]);
            series.setName("Histogram");
            chart.getData().add(series);
        }
        // TODO
    }    
    
}
