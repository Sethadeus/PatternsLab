package Template;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private static int WIDTH = 600;
    private static int HEIGHT = 400;
    private static int SPEED = 15;
    private static int DX = 7;
    private static int DY = 10;

    @Override
    public void start(Stage stage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, WIDTH, HEIGHT, Color.WHITE);


        RadioButton SquareRBTN = new RadioButton("Квадрат");
        RadioButton StarRBTN = new RadioButton("Звезда");
        RadioButton BallRBTN = new RadioButton("Мяч");
        ToggleGroup group = new ToggleGroup();
        SquareRBTN.setToggleGroup(group);
        StarRBTN.setToggleGroup(group);
        BallRBTN.setToggleGroup(group);
        BallRBTN.fire();

        Button pusk = new Button();
        pusk.setText("Пуск");
        pusk.setOnAction(e -> {
            Platform.runLater(() -> {
                RadioButton selected = (RadioButton) group.getSelectedToggle();
                String sel = selected.getText();
                System.out.println(sel);

                switch(sel){
                    case "Квадрат":
                        IShape square = new Square();
                        Thread threadSquare = new Thread(square.start(canvas, WIDTH, HEIGHT, SPEED, DX, DY));
                        threadSquare.start();
                        break;
                    case "Звезда":
                        IShape star = new Star();
                        Thread threadStar = new Thread(star.start(canvas, WIDTH, HEIGHT, SPEED, DX, DY));
                        threadStar.start();
                        break;
                    case "Мяч":
                        IShape ball = new Ball();
                        Thread threadBall = new Thread(ball.start(canvas, WIDTH, HEIGHT, SPEED, DX, DY));
                        threadBall.start();
                        break;
                }

            });
        });

        Button close = new Button();
        close.setText("Закрыть");
        close.setOnAction(e -> {
            Stage stage2 = (Stage) close.getScene().getWindow();
            stage2.close();
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(close, pusk, SquareRBTN, StarRBTN, BallRBTN );

        canvas.getChildren().add(hBox);

        stage.setTitle("Template");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}