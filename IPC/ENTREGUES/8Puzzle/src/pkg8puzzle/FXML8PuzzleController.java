/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puzzle;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import utiles8puzzle.Utils;


/**
 *
 * @author Anna
 */
public class FXML8PuzzleController implements Initializable {
    
    private Label label;
    @FXML
    private GridPane graella;
    @FXML
    private Button boto1;
    @FXML
    private Button boto2;
    @FXML
    private Button boto3;
    @FXML
    private Button boto4;
    @FXML
    private Button boto5;
    @FXML
    private Button boto6;
    @FXML
    private Button boto7;
    @FXML
    private Button boto8;
    @FXML
    private Button començar;
    @FXML
    private Button reset;
    
    private int[] z;
    private double deltaX;
    private double deltaY;
    private int celdaY, celdaX;
    private DoubleProperty height_Grid = new SimpleDoubleProperty();
    private DoubleProperty width_Grid = new SimpleDoubleProperty();
    private static int sizeCol, sizeRow;
    private int cbl, rbl;
    
    public void calculaCelda(double x_ratoli, double y_ratoli){
        celdaX = (int)(x_ratoli / (width_Grid.getValue()/ sizeCol));
        celdaY = (int)(y_ratoli / (height_Grid.getValue()/ sizeRow));
    }
    public boolean esPotMenejar(Button a) {
        int b = GridPane.getColumnIndex(a);
        int c = GridPane.getRowIndex(a);
        if((cbl == b + 1 || cbl == b - 1) && c == rbl) {
            return true;
        } 
        else if((rbl == c + 1 || rbl == c - 1) && b == cbl) {
            return true;
        } else { return false;}
    }
    private boolean esPotSoltar(Button a) {
        if(celdaY == rbl && celdaX == cbl){
            rbl = GridPane.getRowIndex(a);
            cbl = GridPane.getColumnIndex(a);
            return true;
        } else {
            rbl = rbl; cbl = cbl;
            return false;
        }
    }
    private void comprobar() {
        int a = GridPane.getRowIndex(boto1);
        int c = GridPane.getRowIndex(boto2);
        int e = GridPane.getRowIndex(boto3);
        int b = GridPane.getColumnIndex(boto1);
        int h = GridPane.getColumnIndex(boto4);
        int n = GridPane.getColumnIndex(boto7);
        
        int d = GridPane.getColumnIndex(boto2);
        int g = GridPane.getRowIndex(boto4);
        int i = GridPane.getRowIndex(boto5);
        int j = GridPane.getColumnIndex(boto5);
        int k = GridPane.getRowIndex(boto6);
        int p = GridPane.getColumnIndex(boto8);
        
        int f = GridPane.getColumnIndex(boto3);
        int l = GridPane.getColumnIndex(boto6);
        int m = GridPane.getRowIndex(boto7);
        int o = GridPane.getRowIndex(boto8);
        boolean w = false;
        if(a == 0 && c == 0 && e== 0 && b== 0 && h== 0) {
            if (n==0 && d == 1 && g == 1 && i == 1 && j == 1 && k == 1) {
                if (p ==1 && f == 2 && l == 2 && m == 2 && o == 2) {
                    boto1.setDisable(true);
                    boto2.setDisable(true);
                    boto3.setDisable(true);
                    boto4.setDisable(true);
                    boto5.setDisable(true);
                    boto6.setDisable(true);
                    boto7.setDisable(true);
                    boto8.setDisable(true);
                    reset.setDisable(true); 
                }
            }
        } 
    }
    public void cambiarBotons(Button a, int b) {
        switch(b) {
                case 1:
                    GridPane.setRowIndex(a, 0);
                    GridPane.setColumnIndex(a, 0);
                    break;
                case 2:
                    GridPane.setRowIndex(a, 0);
                    GridPane.setColumnIndex(a, 1);
                    break;
                case 3:
                    GridPane.setRowIndex(a, 0);
                    GridPane.setColumnIndex(a, 2);
                    break;
                case 4:
                    GridPane.setRowIndex(a, 1);
                    GridPane.setColumnIndex(a, 0);
                    break;
                case 5:
                    GridPane.setRowIndex(a, 1);
                    GridPane.setColumnIndex(a, 1);
                    break;
                case 6:
                    GridPane.setRowIndex(a, 1);
                    GridPane.setColumnIndex(a, 2);
                    break;
                case 7:
                    GridPane.setRowIndex(a, 2);
                    GridPane.setColumnIndex(a, 0);
                    break;
                case 8:
                    GridPane.setRowIndex(a, 2);
                    GridPane.setColumnIndex(a, 1);
                    break;
            }
    }
    public void menejarBotons(int[] s) {
        cambiarBotons(boto1, s[0]);
        cambiarBotons(boto2, s[1]);
        cambiarBotons(boto3, s[2]);
        cambiarBotons(boto4, s[3]);
        cambiarBotons(boto5, s[4]);
        cambiarBotons(boto6, s[5]);
        cambiarBotons(boto7, s[6]);
        cambiarBotons(boto8, s[7]);

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbl = 2; cbl = 2;
        height_Grid.bind(graella.heightProperty());
        width_Grid.bind(graella.widthProperty());
        sizeCol = graella.getColumnConstraints().size();
        sizeRow = graella.getRowConstraints().size();
        boto1.setDisable(true);
        boto2.setDisable(true);
        boto3.setDisable(true);
        boto4.setDisable(true);
        boto5.setDisable(true);
        boto6.setDisable(true);
        boto7.setDisable(true);
        boto8.setDisable(true);
        reset.setDisable(true);   
    }
 
    @FXML
    private void començar(MouseEvent event) {
        z = Utils.generarVectorAleatorio(8);
        menejarBotons(z);
        System.out.println(Arrays.toString(z));  
        boto1.setDisable(false);
        boto2.setDisable(false);
        boto3.setDisable(false);
        boto4.setDisable(false);
        boto5.setDisable(false);
        boto6.setDisable(false);
        boto7.setDisable(false);
        boto8.setDisable(false);
        reset.setDisable(false);  
    }
         @FXML
    private void reiniciar(MouseEvent event) {
        menejarBotons(z);
        
    }
    
     @FXML
    private void dins1(MouseEvent event) {
        if(esPotMenejar(boto1)) {
            boto1.setCursor(Cursor.HAND);
        }
    }
    @FXML
    private void fora1(MouseEvent event) {
        boto1.setCursor(Cursor.DEFAULT);
    }
    @FXML
    private void polsat1(MouseEvent event) {
        if(esPotMenejar(boto1)) {
            deltaX = boto1.getLayoutX();
            deltaY = boto1.getLayoutY();
        }
    }
    @FXML
    private void arrastrat1(MouseEvent event) {
        if(esPotMenejar(boto1)) {
            boto1.setTranslateX(event.getSceneX()- deltaX);
            boto1.setTranslateY(event.getSceneY() - deltaY);
        }
    }
    @FXML
    private void soltat1(MouseEvent event) {
        if(esPotMenejar(boto1)) {
            boto1.setTranslateX(0);
            boto1.setTranslateY(0);
            calculaCelda(event.getSceneX(),event.getSceneY());
            if(esPotSoltar(boto1)){
                GridPane.setRowIndex(boto1, celdaY);
                GridPane.setColumnIndex(boto1, celdaX);
                comprobar();
            }
        }
    }

    
    @FXML
    private void dins2(MouseEvent event) {
        if(esPotMenejar(boto2)) {
            boto2.setCursor(Cursor.HAND);
        }
    }
    @FXML
    private void fora2(MouseEvent event) {
        boto2.setCursor(Cursor.DEFAULT);
    }
    @FXML
    private void polsat2(MouseEvent event) {
        if(esPotMenejar(boto2)) {
            deltaX = boto2.getLayoutX();
            deltaY = boto2.getLayoutY();
        }
    }
    @FXML
    private void arrastrat2(MouseEvent event) {
        if(esPotMenejar(boto2)) {
            boto2.setTranslateX(event.getSceneX()- deltaX);
            boto2.setTranslateY(event.getSceneY() - deltaY);
        }
    }
    @FXML
    private void soltat2(MouseEvent event) {
        if(esPotMenejar(boto2)) {
            boto2.setTranslateX(0);
            boto2.setTranslateY(0);
            calculaCelda(event.getSceneX(),event.getSceneY());
            if(esPotSoltar(boto2)) {
                GridPane.setRowIndex(boto2, celdaY);
                GridPane.setColumnIndex(boto2, celdaX);
                comprobar();
            } 
        }
    }
   

    @FXML
    private void dins3(MouseEvent event) {
        if(esPotMenejar(boto3)) {
            boto3.setCursor(Cursor.HAND);
        }
    }
    @FXML
    private void fora3(MouseEvent event) {
        boto3.setCursor(Cursor.DEFAULT);
    }
    @FXML
    private void polsat3(MouseEvent event) {
        if(esPotMenejar(boto3)) {
            deltaX = boto3.getLayoutX();
            deltaY = boto3.getLayoutY();
        }
    }
    @FXML
    private void arrastrat3(MouseEvent event) {
        if(esPotMenejar(boto3)) {
            boto3.setTranslateX(event.getSceneX()- deltaX);
            boto3.setTranslateY(event.getSceneY() - deltaY);
        }
    }
    @FXML
    private void soltat3(MouseEvent event) {
        if(esPotMenejar(boto3)) {
            boto3.setTranslateX(0);
            boto3.setTranslateY(0);
            calculaCelda(event.getSceneX(),event.getSceneY());
            if(esPotSoltar(boto3)) {
                GridPane.setRowIndex(boto3, celdaY);
                GridPane.setColumnIndex(boto3, celdaX);
                comprobar();
            }
        }
    }
    
    
    @FXML
    private void dins4(MouseEvent event) {
        if(esPotMenejar(boto4)) {
            boto4.setCursor(Cursor.HAND);
        }
    }
    @FXML
    private void fora4(MouseEvent event) {
        boto4.setCursor(Cursor.DEFAULT);
    }
    @FXML
    private void polsat4(MouseEvent event) {
        if(esPotMenejar(boto4)) {
            deltaX = boto4.getLayoutX();
            deltaY = boto4.getLayoutY();
        }
    }
    @FXML
    private void arrastrat4(MouseEvent event) {
        if(esPotMenejar(boto4)) {
            boto4.setTranslateX(event.getSceneX()- deltaX);
            boto4.setTranslateY(event.getSceneY() - deltaY);
        }
    }
    @FXML
    private void soltat4(MouseEvent event) {
        if(esPotMenejar(boto4)) {
            boto4.setTranslateX(0);
            boto4.setTranslateY(0);
            calculaCelda(event.getSceneX(),event.getSceneY());
            if(esPotSoltar(boto4)) {
                GridPane.setRowIndex(boto4, celdaY);
                GridPane.setColumnIndex(boto4, celdaX);
                comprobar();
            }
        }
    }

    
    @FXML
    private void dins5(MouseEvent event) {
        if(esPotMenejar(boto5)) { 
            boto5.setCursor(Cursor.HAND);
        }
    }
    @FXML
    private void fora5(MouseEvent event) {
        boto5.setCursor(Cursor.DEFAULT);
    }
    @FXML
    private void polsat5(MouseEvent event) {
        if(esPotMenejar(boto5)) { 
            deltaX = boto5.getLayoutX();
            deltaY = boto5.getLayoutY();
        }
    }
    @FXML
    private void arrastrat5(MouseEvent event) {
        if(esPotMenejar(boto5)) { 
            boto5.setTranslateX(event.getSceneX()- deltaX);
            boto5.setTranslateY(event.getSceneY() - deltaY);
        }
    }
    @FXML
    private void soltat5(MouseEvent event) {
        if(esPotMenejar(boto5)) { 
            boto5.setTranslateX(0);
            boto5.setTranslateY(0);
            calculaCelda(event.getSceneX(),event.getSceneY());
            if(esPotSoltar(boto5)) {
                GridPane.setRowIndex(boto5, celdaY);
                GridPane.setColumnIndex(boto5, celdaX);
                comprobar();
            }
        }
    }
    
    
    @FXML
    private void dins6(MouseEvent event) {
        if(esPotMenejar(boto6)) {
            boto6.setCursor(Cursor.HAND);
        }
    }
    @FXML
    private void fora6(MouseEvent event) {
        boto6.setCursor(Cursor.DEFAULT);
    }
    @FXML
    private void polsat6(MouseEvent event) {
        if(esPotMenejar(boto6)) {
            deltaX = boto6.getLayoutX();
            deltaY = boto6.getLayoutY();
        }
    }
    @FXML
    private void arrastrat6(MouseEvent event) {
        if(esPotMenejar(boto6)) {
            boto6.setTranslateX(event.getSceneX()- deltaX);
            boto6.setTranslateY(event.getSceneY() - deltaY);
        }
    }
    @FXML
    private void soltat6(MouseEvent event) {
        if(esPotMenejar(boto6)) {
            boto6.setTranslateX(0);
            boto6.setTranslateY(0);
            calculaCelda(event.getSceneX(),event.getSceneY());
            if(esPotSoltar(boto6)) {
                GridPane.setRowIndex(boto6, celdaY);
                GridPane.setColumnIndex(boto6, celdaX);
                comprobar();
            }
        }
    }

    
    @FXML
    private void dins7(MouseEvent event) {
        if(esPotMenejar(boto7)) {
            boto7.setCursor(Cursor.HAND);
        }
    }
    @FXML
    private void fora7(MouseEvent event) {
        boto7.setCursor(Cursor.DEFAULT);
    }
    @FXML
    private void polsat7(MouseEvent event) {
        if(esPotMenejar(boto7)) {
            deltaX = boto7.getLayoutX();
            deltaY = boto7.getLayoutY();
        }
    }
    @FXML
    private void arrastrat7(MouseEvent event) {
        if(esPotMenejar(boto7)) {
            boto7.setTranslateX(event.getSceneX()- deltaX);
            boto7.setTranslateY(event.getSceneY() - deltaY);
        }
    }
    @FXML
    private void soltat7(MouseEvent event) {
        if(esPotMenejar(boto7)) {
            boto7.setTranslateX(0);
            boto7.setTranslateY(0);
            calculaCelda(event.getSceneX(),event.getSceneY());
            if(esPotSoltar(boto7)) {
                GridPane.setRowIndex(boto7, celdaY);
                GridPane.setColumnIndex(boto7, celdaX);
                comprobar();
            }
        }
    }

    
    @FXML
    private void dins8(MouseEvent event) {
        if(esPotMenejar(boto8)) {
            boto8.setCursor(Cursor.HAND);
        }
    }
    @FXML
    private void fora8(MouseEvent event) {
        boto8.setCursor(Cursor.DEFAULT);
    }
    @FXML
    private void polsat8(MouseEvent event) {
        if(esPotMenejar(boto8)) {
            deltaX = boto8.getLayoutX();
            deltaY = boto8.getLayoutY();
        }
    }
    @FXML
    private void arrastrat8(MouseEvent event) {
        if(esPotMenejar(boto8)) {
            boto8.setTranslateX(event.getSceneX()- deltaX);
            boto8.setTranslateY(event.getSceneY() - deltaY);
        }
    }
    @FXML
    private void soltat8(MouseEvent event) {
        if(esPotMenejar(boto8)) {
            boto8.setTranslateX(0);
            boto8.setTranslateY(0);
            calculaCelda(event.getSceneX(),event.getSceneY());
            if(esPotSoltar(boto8)) {
                GridPane.setRowIndex(boto8, celdaY);
                GridPane.setColumnIndex(boto8, celdaX);
                comprobar();
            }
        }
    }
}

   