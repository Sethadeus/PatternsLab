package Template;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball implements IShape {
    private static int RADIUS = 10;

    @Override
    public Runnable start(Pane canvas, int cw, int ch, int speed, double dx, double dy) {
        Circle ball = new Circle(RADIUS, Color.color(Math.random(), Math.random(), Math.random()));
        ball.relocate(cw - RADIUS * 2, ch - RADIUS * 2);

        canvas.getChildren().add(ball);

        new Animate(ball, cw, ch, speed, dx, dy);

        return null;
    }
}
