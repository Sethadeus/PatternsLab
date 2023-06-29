package Template;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Star implements IShape {
    @Override
    public Runnable start(Pane canvas, int cw, int ch, int speed, double dx, double dy) {
        Path star = new Path();

        MoveTo moveTo = new MoveTo(16, 30);
        LineTo line1 = new LineTo(12, 20);
        LineTo line2 = new LineTo(0, 19);
        LineTo line3 = new LineTo(9, 12);
        LineTo line4 = new LineTo(6, 0);
        LineTo line5 = new LineTo(16, 6);
        LineTo line6 = new LineTo(26, 0);
        LineTo line7 = new LineTo(23, 12);
        LineTo line8 = new LineTo(32, 19);
        LineTo line9 = new LineTo(20, 19);
        LineTo line10 = new LineTo(16, 30);

        star.getElements().add(moveTo);
        star.getElements().addAll(line1, line2, line3, line4, line5, line6, line7, line8, line9, line10);
        star.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        star.setStroke(Color.WHITE);

        star.relocate(cw - 5, ch - 5);

        canvas.getChildren().add(star);

        new Animate(star, cw, ch, speed, dx, dy);
        return null;
    }

}
