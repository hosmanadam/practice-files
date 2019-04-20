package com.adamhosman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class PlayList {

    private String title;
    private LinkedList<Single> songs;
    private ListIterator<Single> playHead;
    private Single nowPlaying;
    private UserInterface ui = new UserInterface();
    private boolean isPlaying = false;
    private int lastSkipDirection = 0;  // 1 for forward, -1 for back
    private ArrayList<String> menu = new ArrayList<>(){{
        add("Stop & quit");
        add("Play previous");
        add("Replay current song");
        add("Play next");
        add("Display playlist");
        add("Remove current from playlist");
    }};

    public PlayList(String title) {
        this(title, new LinkedList<Single>());
    }

    public PlayList(String title, LinkedList<Single> songs) {
        this.title = title;
        this.songs = songs;
    }

    public void handleMenu() {
        ui.printMenu(menu);
        int choice = ui.getMenuChoice(menu);
        switch (choice) {
            case 0:
                stop();
                break;
            case 1:
                playPrevious();
                break;
            case 2:
                playAgain();
                break;
            case 3:
                playNext();
                break;
            case 4:
                displayPlayList();
                break;
            case 5:
                removeCurrent();
                break;
        }
    }

    public boolean addSong(Album album, String songTitle) {
        return addSong(new Single(album.getSongByTitle(songTitle), album));
    }

    public boolean addSong(Single song) {
        songs.add(song);
        return true;
    }

    public void displayPlayList() {
        ui.printPlayList(title, getTotalDuration(), songs);
    }

    public int getTotalDuration() {
        int totalDuration = 0;
        for (Single song : songs) {
            totalDuration += song.getDuration();
        }
        return totalDuration;
    }

    public void start() {
        ui.printHello();
        displayPlayList();
        playHead = songs.listIterator();
        nowPlaying = playHead.next();
        isPlaying = true;
        ui.printNowPlaying(nowPlaying);
    }

    public void playPrevious() {
        if (lastSkipDirection == 0 || !playHead.hasPrevious()) {
            ui.printError("Can't skip back, already on first song!");
        } else {
            if (lastSkipDirection == 1) {
                playHead.previous();
            }
            nowPlaying = playHead.previous();
            ui.printMessage("\nSkipping back...");
            ui.printNowPlaying(nowPlaying);
            lastSkipDirection = -1;
        }
    }

    public void playAgain() {
        ui.printMessage("\nAnd again...");
        ui.printNowPlaying(nowPlaying);
    }

    public void removeCurrent() {
        ui.printMessage("\n'" + nowPlaying.getTitle() + "' removed from " + this.title);
        playHead.remove();
        nowPlaying = playHead.next();
        ui.printNowPlaying(nowPlaying);
    }

    public void playNext() {
        if (!playHead.hasNext()) {
            ui.printError("Can't skip forward, already on last song!");
        } else {
            if (lastSkipDirection == -1) {
                playHead.next();
            }
            nowPlaying = playHead.next();
            ui.printMessage("\nSkipping forward...");
            ui.printNowPlaying(nowPlaying);
            lastSkipDirection = 1;
        }
    }

    public void stop() {
        ui.printGoodbye();
        isPlaying = false;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

}
