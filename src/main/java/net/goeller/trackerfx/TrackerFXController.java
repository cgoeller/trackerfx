package net.goeller.trackerfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class TrackerFXController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btPause;

    @FXML
    private Button btReport;

    @FXML
    private VBox vbox;


    @FXML
    void pausePressed(ActionEvent event) {

        vbox.getChildren().add(new Button("Test"));

    }

    @FXML
    void reportPressed(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert btPause != null : "fx:id=\"btPause\" was not injected: check your FXML file 'TrackerFXUI.fxml'.";
        assert btReport != null : "fx:id=\"btReport\" was not injected: check your FXML file 'TrackerFXUI.fxml'.";
        assert vbox != null : "fx:id=\"vbox\" was not injected: check your FXML file 'TrackerFXUI.fxml'.";


    }

}
