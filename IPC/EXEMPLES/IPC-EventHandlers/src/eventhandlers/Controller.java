package eventhandlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Controller {

    private static final int KEYBOARD_MOVEMENT_DELTA = 5;
    private static final int CIRCLE_SIZE_DELTA = 5;
    private static final DropShadow SHADOW = new DropShadow();
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    @FXML
    private Circle circle;
    @FXML
    private TextArea logger;
    @FXML
    private Label coordinates;

    // Keyboard event handlers

    @FXML
    private void keyTyped(KeyEvent event) {
        // Event fired when visible character pressed
        // Space is considered visible, arrow keys, shift, ctrl, etc. are not
        logKeyEvent(event);
        switch (event.getCode()) {
            case ADD:
                grow(null);
                break;
            case SUBTRACT:
                shrink(null);
                break;
            default:
                break;
        }
    }

    @FXML
    private void keyPressed(KeyEvent event) {
        // Event fired when non visible character pressed
        // That includes arrow keys, arrow keys, shift, ctrl, alt, function keys, etc
        logKeyEvent(event);
        switch (event.getCode()) {
            case UP:
                moveUp();
                break;
            case RIGHT:
                moveRight();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
        }
    }

    @FXML
    private void keyReleased(KeyEvent event) {
        logKeyEvent(event);
    }

    // Action event handlers
    
    @FXML
    private void grow(ActionEvent event) {
        logActionEvent(event);
        circle.setRadius(circle.getRadius() + CIRCLE_SIZE_DELTA);
        updateCircleInfo();
    }

    @FXML
    private void shrink(ActionEvent event) {
        logActionEvent(event);
        circle.setRadius(circle.getRadius() - CIRCLE_SIZE_DELTA);
        updateCircleInfo();
    }

    @FXML
    private void moveAction(ActionEvent event) {
        logActionEvent(event);
        String id = ((Node) event.getSource()).getId();
        switch (id) {
            case "up":
                moveUp();
                break;
            case "down":
                moveDown();
                break;
            case "left":
                moveLeft();
                break;
            case "right":
                moveRight();
                break;
        }
    }
    
    // Mouse event handlers

    @FXML
    void mouseEntered(MouseEvent event) {
        logMouseEvent(event);
        ((Node) event.getSource()).setEffect(SHADOW);
        circle.setCursor(Cursor.HAND);
    }

    @FXML
    void mouseExited(MouseEvent event) {
        logMouseEvent(event);
        ((Node) event.getSource()).setEffect(null);
        circle.setCursor(Cursor.DEFAULT);
    }
    
    @FXML
    private void mousePressed(MouseEvent event) {
        logMouseEvent(event);
        circle.setCursor(Cursor.MOVE);
        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();
        orgTranslateX = circle.getTranslateX();
        orgTranslateY = circle.getTranslateY();
    }

    @FXML
    private void mouseDragged(MouseEvent event) {
        logMouseEvent(event);
        double offsetX = event.getSceneX() - orgSceneX;
        double offsetY = event.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;
        circle.setTranslateX(newTranslateX);  //transform the object
        circle.setTranslateY(newTranslateY);
        updateCircleInfo();
    }

    @FXML
    private void mousedReleased(MouseEvent event) {
        logMouseEvent(event);
        circle.setCursor(Cursor.DEFAULT);
    }

    private void moveUp() {
        circle.setLayoutY(circle.getLayoutY() - KEYBOARD_MOVEMENT_DELTA);
        updateCircleInfo();
    }

    private void moveLeft() {
        circle.setLayoutX(circle.getLayoutX() - KEYBOARD_MOVEMENT_DELTA);
        updateCircleInfo();
    }

    private void moveRight() {
        circle.setLayoutX(circle.getLayoutX() + KEYBOARD_MOVEMENT_DELTA);
        updateCircleInfo();
    }

    private void moveDown() {
        circle.setLayoutY(circle.getLayoutY() + KEYBOARD_MOVEMENT_DELTA);
        updateCircleInfo();
    }

    private void updateCircleInfo() {
        coordinates.setText(String.format("x = %.0f, y = %.0f, r = %.0f", circle.getLayoutX(), circle.getLayoutY(), circle.getRadius()));
    }

    private void logMouseEvent(MouseEvent event) {
        logger.appendText("MouseEvent " + event.getEventType() + " (" + event.getX() + ", " + event.getY() + ")\n");
    }

    private void logKeyEvent(KeyEvent event) {
        logger.appendText("KeyEvent " + event.getEventType() + " (" + event.getCharacter() + ")\n");
    }

    private void logActionEvent(ActionEvent event) {
        String id = ((Node) event.getSource()).getId();
        logger.appendText("ActionEvent " + event.getEventType() + " (" + id + ")\n");
    }

}
