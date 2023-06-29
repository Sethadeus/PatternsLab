package Facade;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Facade facade = new Facade();
        primaryStage.setScene(new Scene(facade.drawTask()));
        primaryStage.setTitle("Moving Car");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
