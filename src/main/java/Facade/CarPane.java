package Facade;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

class CarPane extends Pane {
    private double w; // pane width
    private double h; // pane height

    // left Tire x,y and radius
    private double leftTireX; // left tire is the car's drawing start point
    private double leftTireY;
    private double tireRadius;

    private Circle[] tires = new Circle[2]; // Index 0, 1 = left and right tire
    private Polyline cover = new Polyline();
    private ObservableList<Double> points;
    private Rectangle base;

    CarPane(double width, double height) {
        // Get width height and measurements for the left tire (starting point)
        w = width;
        h = height;
        leftTireX = w * 0.2;
        leftTireY = h * 0.9;
        tireRadius = h * 0.1;

        // set MIN and MAX width
        setMinWidth(w);
        setMinHeight(h);

        setMaxWidth(w);
        setMaxHeight(h);

        reset(); // draws and adjusts car to starting position
    }

    public void reset() {
        if (points != null) {
            points.clear();
        }
        getChildren().clear();
        drawCar();
        moveCar(tireRadius * 13 * -1);
    }

    public void drawCar() {
        for (int i = 0; i < tires.length; i++) {
            tires[i] = new Circle(leftTireX + (i * 4 * tireRadius), leftTireY, tireRadius);
            tires[i].setStroke(Color.BLACK);
            tires[i].setFill(Color.TRANSPARENT);
        }

        double baseX = tires[0].getCenterX() - tires[0].getRadius() * 3;
        double baseY = tires[0].getCenterY() - tires[0].getRadius() * 3;
        base = new Rectangle(baseX, baseY, tireRadius * 10, tireRadius * 2);
        base.setFill(Color.TRANSPARENT);
        base.setStroke(Color.BLACK);

        // draw the car's top cover
        double startX = base.getX() + tireRadius * 2;
        double startY = base.getY();
        double currentX = startX;
        double currentY = startY;

        points = cover.getPoints();

        double distance = tireRadius * 2;
        points.addAll(currentX, currentY); // start point

        currentX += distance;
        currentY -= distance;
        points.addAll(currentX, currentY); // up right

        currentX += distance;
        points.addAll(currentX, currentY); // right

        currentX += distance;
        currentY += distance;
        points.addAll(currentX, currentY); // down right

/*        points.addAll(startX, startY); // connect to starting point
        cover.setFill(Color.BLUE);*/

        getChildren().addAll(tires);
        getChildren().add(base);
        getChildren().add(cover);
    }

    void moveCar(double distance) {
        for (Circle c : tires) {
            c.setCenterX(c.getCenterX() + distance);
        }
        base.setX(base.getX() + distance);

        for (int i = 0; i < points.size(); i += 2) {
            points.set(i, points.get(i) + distance);
        }
    }

    public int getOneCycleDuration() {
        return (int) w;
    }

    public Rectangle getBase() {
        return base;
    }
}
