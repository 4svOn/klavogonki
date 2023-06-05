package hse.cs.se.klavogonki;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class RaceController implements Initializable {
    @FXML
    private TextArea resultArea;

    @FXML
    private Label timerLabel;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    private String currentText;

    private String[] currentTextTokenized;

    private int currentToken;

    private boolean isError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timer timer = new Timer();

        TimerTask countdown = new TimerTask() {
            int seconds = 5;
            @Override
            public void run() {
                Platform.runLater(
                    () -> {
                        timerLabel.setText(seconds + " seconds left!");
                        seconds--;
                        if (seconds < 0) {
                            timerLabel.setText("Start printing!");
                            timer.cancel();
                            textField.setEditable(true);
                        }
                    }
                );
            }
        };
        timer.scheduleAtFixedRate(countdown, 0L, 1000L);

        InputStream file = KlavoGonkiApplication.class.getResourceAsStream("texts/text1.txt");
        Scanner s = new Scanner(file).useDelimiter("\\A");
        currentText = s.hasNext() ? s.next() : "";
        currentToken = 0;
        currentTextTokenized = currentText.split(" ");
        isError = false;
        textArea.setText(currentText);
    }

    @FXML
    protected void keyTypedInTextField(KeyEvent keyEvent) {
//        String letter = keyEvent.getText();
//        if (letter.charAt(0) != currentText.charAt(currentLetter) || isError) {
//            isError = true;
//            textField.setStyle("-fx-text-fill: red;");
//        } else if (letter.charAt(0) == currentText.charAt(currentLetter)){
//
//        }
        if (!textField.isEditable())
            return;
        if (keyEvent.getCharacter().equals(" ") && !isError) {
            ++currentToken;
            Platform.runLater(
                    () -> textField.setText("")
            );
            return;
        }
        String currentText = textField.getText();
        if (!currentTextTokenized[currentToken].startsWith(currentText)) {
            isError = true;
            Platform.runLater(
                    () -> textField.setStyle("-fx-text-inner-color: red;")
            );
        } else {
            isError = false;
            Platform.runLater(
                    () -> textField.setStyle("-fx-text-inner-color: black;")
            );
        }

        Text text = new Text("абоба");
        text.setUnderline(true);
        textArea.setText(String.valueOf(text));
//        textArea.selectRange(5, 9);
    }
}