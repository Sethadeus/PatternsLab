package Observer;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {

    @FXML
    public ImageView leftEye, rightEye, mouth, nose;

    private boolean lE, rE, m, n;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("PickachuObserver");

        Parent root = FXMLLoader.load(getClass().getResource("/observer/observer.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onLeftEyeClicked() throws FileNotFoundException {
        if (lE) {
            lE = false;
            leftEye.setImage(new Image(new FileInputStream("src/main/resources/observer/eye_left_default.png")));
        } else {
            lE = true;
            leftEye.setImage(new Image(new FileInputStream("src/main/resources/observer/eye_left_closed.png")));
        }
    }

    public void onRightEyeClicked() throws FileNotFoundException {
        if (rE) {
            rE = false;
            rightEye.setImage(new Image(new FileInputStream("src/main/resources/observer/eye_right_default.png")));
        } else {
            rE = true;
            rightEye.setImage(new Image(new FileInputStream("src/main/resources/observer/eye_right_closed.png")));
        }
    }

    public void onMouthClicked() throws FileNotFoundException {
        if (m) {
            m = false;
            mouth.setImage(new Image(new FileInputStream("src/main/resources/observer/rot_default.png")));
        } else {
            m = true;
            mouth.setImage(new Image(new FileInputStream("src/main/resources/observer/rot_open.png")));
        }
    }

    public void onNoseClicked() throws FileNotFoundException {
        if (n) {
            n = false;
            nose.setImage(new Image(new FileInputStream("src/main/resources/observer/nose_default.png")));
        } else {
            n = true;
            nose.setImage(new Image(new FileInputStream("src/main/resources/observer/nose_red.png")));
        }
    }
}