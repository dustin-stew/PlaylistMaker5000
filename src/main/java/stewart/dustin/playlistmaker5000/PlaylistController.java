package stewart.dustin.playlistmaker5000;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PlaylistController {
    private PlaylistModel model;
    public PlaylistController(PlaylistModel model) {
        this.model = model;
    }

    protected void update(String title, String artist, int duration) {
        model.addSong(title, artist, duration);
    }
}