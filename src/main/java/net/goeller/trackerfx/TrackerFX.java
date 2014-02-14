package net.goeller.trackerfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author Chris
 */
public class TrackerFX extends Application {

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the
     * application can not be launched through deployment artifacts, e.g., in IDEs with limited FX support.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TrackerFXUI.fxml"));

        Scene scene = new Scene(root, 300, 275);

        stage.getIcons().add(new Image(getClass().getResource("clock.png").toString()));
        stage.setTitle("TrackerFX");
        stage.setScene(scene);
        stage.show();
    }

}
