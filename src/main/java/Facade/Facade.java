package Facade;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Facade {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 125;
    private CarPane carPane;
    private TrafficLightPane trafficLightPane;

    private static final int DURATION_MILLIS = 7;


    public VBox drawTask() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        VBox vBox = new VBox(hBox);

        Timeline timeline;

        carPane = new CarPane(WIDTH, HEIGHT);
        trafficLightPane = new TrafficLightPane();

        timeline = new Timeline(new KeyFrame(Duration.millis(DURATION_MILLIS), e -> {
            if (trafficLightPane.isRed() && carPane.getBase().getX() > 200 && carPane.getBase().getX() < 250) {
                //do nothing, wait until red light turns off
            } else {
                carPane.moveCar(2);
            }
        }));
        timeline.setCycleCount((int) (WIDTH + trafficLightPane.getPause()*2 * DURATION_MILLIS));
        timeline.play();

        carPane.setStyle("-fx-border-color: black;" + "-fx-border-insets: 5px");
        vBox.getChildren().add(carPane);
        vBox.getChildren().add(trafficLightPane);

        Timeline finalTimeline = timeline;
        timeline.setOnFinished(e -> {
            carPane.reset();
            finalTimeline.play();
        });

        return vBox;
    }
}
