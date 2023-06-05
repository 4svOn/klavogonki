package hse.cs.se.klavogonki;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainController {

    @FXML
    private Button goRaceButton;

    @FXML
    protected void onGoRaceButtonClick() throws IOException {
        KlavoGonkiApplication.setRaceScene();
    }
}
