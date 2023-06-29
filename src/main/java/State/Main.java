package State;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {
    public ImageView imageView;
    public Button happyBtn, sadBtn, sleepBtn;

    private IState state;

    private Happy happy = new Happy();
    private Sad sad = new Sad();
    private Sleep sleep = new Sleep();

    public void setState(IState state) {
        this.state = state;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PickachuState");

        Parent root = FXMLLoader.load(getClass().getResource("/state/state.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onHappyButtonClick() throws FileNotFoundException {
        setState(happy);
        state.change(imageView);
    }

    public void onSadButtonClick() throws FileNotFoundException {
        setState(sad);
        state.change(imageView);
    }

    public void onSleepButtonClick() throws FileNotFoundException {
        setState(sleep);
        state.change(imageView);
    }
}
