package stewart.dustin.playlistmaker5000;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PlaylistMaker5000 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        PlaylistModel model = new PlaylistModel(java.time.LocalDateTime.now());
        PlaylistController controller = new PlaylistController(model);
        PlaylistView view = new PlaylistView(controller, model);
        Scene scene = new Scene(view.asParent(), 740, 480);
        stage.setTitle("Playlist Maker 5000");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

