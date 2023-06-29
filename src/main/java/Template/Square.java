package Template;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square implements IShape {
    @Override
    public Runnable start(Pane canvas, int cw, int ch, int speed, double dx, double dy) {
        Rectangle square = new Rectangle(20, 20, Color.color(Math.random(), Math.random(), Math.random()));
        square.relocate(cw - 5, ch - 5);

        canvas.getChildren().add(square);

        new Animate(square, cw, ch, speed, dx, dy);

        return null;
    }
}
