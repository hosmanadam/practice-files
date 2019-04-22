package com.adamhosman;

import java.util.ArrayList;

public class Album {

    private String artist;
    private String title;
    private SongList songList;

    public Album(String artist, String title, ArrayList<Song> songs) {
        this.artist = artist;
        this.title = title;
        this.songList = new SongList(songs);
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public Single getSongByTitle(String songTitle) {
        Song song = songList.getSongByTitle(songTitle);
        if (song != null)
            return new Single(song, this);
        return null;
    }

    private class SongList {

        private ArrayList<Song> songs;

        public SongList(ArrayList<Song> songs) {
            this.songs = songs;
        }

        public Song getSongByTitle(String songTitle) {
            for (Song song : songs) {
                if (song.getTitle().equals(songTitle)) {
                    return song;
                }
            }
            return null;
        }

        public void addSong(String title, int minutes, int seconds) {
            songs.add(new Song(title, minutes, seconds));
        }

    }

}
