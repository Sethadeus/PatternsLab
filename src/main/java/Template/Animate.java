package Template;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Animate {
    public Animate(Shape shape, int cw, int ch, int speed, double dxx, double dyy) {
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(speed),

                new EventHandler<ActionEvent>() {

                    double dx = dxx;
                    double dy = dyy;

                    @Override
                    public void handle(ActionEvent t) {
                        dy+=0.13;
                        shape.setLayoutX(shape.getLayoutX() + dx);
                        shape.setLayoutY(shape.getLayoutY() + dy);

                        if (shape.getLayoutX() <= 0 || shape.getLayoutX() >= cw) {
                            dx = -dx;
/*                            dx*=0.9;
                            dy*=0.9;*/
                        }

                        if (shape.getLayoutY() >= ch || shape.getLayoutY() <= 0) {
                            dy = -dy;
/*                            dx*=0.9;
                            dy*=0.9;*/
                        }
                    }
                }));

        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
    }
}
