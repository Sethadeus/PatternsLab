package Template;

import javafx.scene.layout.Pane;

public interface IShape {
    Runnable start(Pane canvas, int canvasWidth, int canvasHeight, int speed, double deltaX, double deltaY);

}
