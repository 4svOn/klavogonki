package hse.cs.se.klavogonki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KlavoGonkiApplication extends Application {

    static Stage mainStage;

    static FXMLLoader fxmlLoaderMainScene, fxmlLoaderRaceScene;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        fxmlLoaderMainScene = new FXMLLoader(KlavoGonkiApplication.class.getResource("main.fxml"));
        fxmlLoaderRaceScene = new FXMLLoader(KlavoGonkiApplication.class.getResource("race.fxml"));
        setMainScene();
        stage.show();
    }

    static void setRaceScene() {
        try {
            Scene scene = new Scene(fxmlLoaderRaceScene.load());
            mainStage.setTitle("Клавогонки - Гонки!");
            mainStage.setScene(scene);
        } catch (Exception e) {

        }
    }

    static void setMainScene() {
        try {
            Scene scene = new Scene(fxmlLoaderMainScene.load());
            mainStage.setTitle("Клавогонки - Гонки!");
            mainStage.setScene(scene);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        launch();
    }
}