package State;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sleep implements IState{
    @Override
    public void change(ImageView imageView) throws FileNotFoundException {
        imageView.setImage(new Image(new FileInputStream("src/main/resources/state/sleep.png")));
    }
}
