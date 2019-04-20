package com.adamhosman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class PlayList {

    private String title;
    private LinkedList<Single> songs;
    private ListIterator playHead;
    private UserInterface ui = new UserInterface();
    private boolean isPlaying = false;
    private ArrayList<String> menu = new ArrayList<>(){{
        add("Stop & quit");
        add("Previous song");
        add("Replay current song");
        add("Next song");
        add("List all songs");
        add("Remove current song from playlist");
    }};

    public PlayList(String title) {
        this(title, new LinkedList<Single>());
    }

    public PlayList(String title, LinkedList<Single> songs) {
        this.title = title;
        this.songs = songs;
        this.playHead = songs.listIterator();  // TODO: Access 'songs' only through this
    }

    public void handleMenu() {
        ui.printMenu(menu);
        int choice = ui.getMenuChoice(menu);
        switch (choice) {
            case 0:
                stop();
                break;
            case 1:
                // TODO
                break;
            case 2:
                // TODO
                break;
            case 3:
                // TODO
                break;
            case 4:
                display();
                break;
            case 5:
                // TODO
                break;
        }
    }

    public String getTitle() {
        return title;
    }

    public LinkedList<Single> getSongs() {
        return songs;
    }

    public boolean addSong(Album album, String songTitle) {
        return addSong(new Single(album.getSongByTitle(songTitle), album));
    }

    public boolean addSong(Single song) {
        songs.add(song);
        return true;
    }

    public void display() {
        ui.printPlayList(title, getTotalDuration(), songs);
    }

    public int getTotalDuration() {
        int totalDuration = 0;
        for (Single song : songs) {
            totalDuration += song.getDuration();
        }
        return totalDuration;
    }

    public void play() {
        isPlaying = true;
        ui.printHello();
    }

    public void stop() {
        ui.printGoodbye();
        isPlaying = false;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

}
