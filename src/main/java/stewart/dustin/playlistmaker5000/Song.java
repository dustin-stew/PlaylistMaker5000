package stewart.dustin.playlistmaker5000;
/**
 * Class: Song.java
 * Purpose: Class object for creating a song object and interacting with it via Playlist.java
 */

public class Song {
    private final int duration;
    private final String title;
    private final String artist;

    /** Creates an object that represents a song, title, and duration*/
    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    /** Returns duration parameter*/
    public int getDuration() {
        return duration;
    }
    /** Returns title parameter*/
    public String getTitle() {
        return title;
    }

    /** Returns artist parameter*/
    public String getArtist() {
        return artist;
    }

    /** Converts parameters of object to a single string with a specific format*/
    public String toString() {
        return "%s by %s (%d sec)".formatted(title, artist, duration);
    }

}
