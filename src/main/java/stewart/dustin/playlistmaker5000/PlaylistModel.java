package stewart.dustin.playlistmaker5000;

import javafx.beans.property.SimpleIntegerProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PlaylistModel {
    private LocalDateTime date;
    ArrayList<Song> playlist;
    private SimpleIntegerProperty playlistSize;

    public PlaylistModel(LocalDateTime date) {
        this.date = date;
        this.playlist = new ArrayList<Song>();
    }
    public void addSong(String name, String artist, int duration) {
        playlist.add(new Song(name, artist, duration));
    }
    public SimpleIntegerProperty getPlaylistLength(){
        this.playlistSize = new SimpleIntegerProperty(playlist.size());
        return this.playlistSize;
    }
    public ArrayList<Song> getList(){
        return playlist;
    }
    public String getListAsString() {
        String playlistString = "";
        for (int i = 0; i < getPlaylistLength().getValue(); i++) {
            playlistString += String.format("%d. %s\n", i+1, getList().get(i).toString());
        }

        return playlistString;
    }
}
