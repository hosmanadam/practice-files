package com.adamhosman;

import java.util.ArrayList;

public class Album {

    private String artist;
    private String title;
    private ArrayList<Song> songs;

    public Album(String artist, String title, ArrayList<Song> songs) {
        this.artist = artist;
        this.title = title;
        this.songs = songs;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public Single getSongByTitle(String songTitle) {
        for (Song song : songs) {
            if (song.getTitle().equals(songTitle)) {
                return new Single(song, this);
            }
        }
        return null;
    }

}
