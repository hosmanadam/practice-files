package com.adamhosman;

public class Song {

    private String title;
    private int duration;

    public Song(String title, int minutes, int seconds) {
        this(title, minutes * 60 + seconds);
    }

    public Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

}

/**
 * Song with reference to the album it came from
 */
class Single extends Song {

    private Album album;

    public Single(Song song, Album album) {
        super(song.getTitle(), song.getDuration());
        this.album = album;
    }

    public String getAlbumTitle() {
        return album.getTitle();
    }

    public String getArtist() {
        return album.getArtist();
    }

}
