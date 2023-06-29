package Facade;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TrafficLightPane extends Pane {
    private static final double RADIUS = 20;

    private boolean red = false;
    private final double pause = 0.5;
    private Circle circleRed, circleYellow, circleGreen;
    private Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN};
    private int onColor = 0;

    public TrafficLightPane() {
        circleRed = new Circle(300, 50, RADIUS);
        circleYellow = new Circle(300, 90, RADIUS);
        circleGreen = new Circle(300, 130, RADIUS);

        circleYellow.setStroke(Color.BLACK);
        circleRed.setStroke(Color.BLACK);
        circleGreen.setStroke(Color.BLACK);

        circleGreen.setFill(Color.WHITE);
        circleRed.setFill(Color.WHITE);
        circleYellow.setFill(Color.WHITE);

        getChildren().add(circleRed);
        getChildren().add(circleYellow);
        getChildren().add(circleGreen);
        update();
    }

    private void update() {

        PauseTransition pause = new PauseTransition(Duration.seconds(this.pause));
        pause.setOnFinished(event -> {
            if (onColor == 0) {
                circleRed.setFill(colors[onColor]);
                red = true;
            } else {
                circleRed.setFill(Color.WHITE);
                red = false;
            }

            if (onColor == 1) {
                circleYellow.setFill(colors[onColor]);
                red = true;
            } else {
                circleYellow.setFill(Color.WHITE);
            }

            if (onColor == 2) {
                circleGreen.setFill(colors[onColor]);
                red = false;
            } else {
                circleGreen.setFill(Color.WHITE);
            }

            if ((onColor + 1) >= colors.length) {
                red = false;
                onColor = 0;
            } else {
                onColor = onColor + 1;
            }

            pause.play();
        });

        pause.play();
    }

    public boolean isRed() {
        return red;
    }

    public double getPause() {
        return pause;
    }
}
