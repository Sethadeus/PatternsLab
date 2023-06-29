package State;

import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public interface IState {
    void change(ImageView imageView) throws FileNotFoundException;
}

