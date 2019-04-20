package com.adamhosman;

import java.util.ArrayList;

public class Main {

    /**
     * https://www.udemy.com/java-the-complete-java-developer-course/learn/lecture/3654716
     *
     * Create a program that implements a playlist for songs
     * Create a Song class having Title and Duration for a song.  ✓
     * The program will have an Album class containing a list of songs.  ✓
     * The albums will be stored in an ArrayList  ✓
     * Songs from different albums can be added to the playlist and will appear in the list in the order they are added. ✓
     * Once the songs have been added to the playlist, create a menu of options to:
     * Quit,  ✓
     * Skip forward to the next song,   // TODO
     * skip backwards to a previous song,  // TODO
     * replay the current song,  // TODO
     * list the songs in the playlist.  ✓
     * A song must exist in an album before it can be added to the playlist (so you can only play songs that you own).  ✓
     * Hint:  To replay a song, consider what happened when we went back and forth from a city before we
     * started tracking the direction we were going.
     * As an optional extra, provide an option to remove the current song from the playlist  // TODO
     * (hint: listiterator.remove()
     */
    public static void main(String[] args) {
        AlbumCollection demoCollection = createDemoCollection();
        PlayList demoPlayList = createDemoPlayList(demoCollection);
        demoPlayList.play();
        while (demoPlayList.isPlaying()) {
            demoPlayList.handleMenu();
        }

        demoPlayList.display();

    }

    public static AlbumCollection createDemoCollection() {
        Album Metallica = new Album("Metallica", "Metallica", new ArrayList<>(){{
            add(new Song("Sad But True", 5, 24));
            add(new Song("Holier Than Thou", 3, 48));
            add(new Song("The Unforgiven", 6, 26));
            add(new Song("Wherever I May Roam", 6, 44));
            add(new Song("Don't Tread On Me", 4, 0));
            add(new Song("Through The Never", 4, 3));
            add(new Song("Nothing Else Matters", 6, 28));
            add(new Song("Of Wolf And Man", 4, 17));
            add(new Song("The God That Failed", 5, 9));
            add(new Song("My Friend Of Misery", 6, 48));
            add(new Song("The Struggle Within", 3, 54));
        }});

        Album Thriller = new Album("Michael Jackson", "Thriller", new ArrayList<>(){{
            add(new Song("Wanna Be Startin' Somethin'", 6, 3));
            add(new Song("Baby Be Mine", 4, 21));
            add(new Song("The Girl Is Mine", 3, 42));
            add(new Song("Thriller", 5, 58));
            add(new Song("Beat It", 4, 18));
            add(new Song("Billie Jean", 4, 54));
            add(new Song("Human Nature", 4, 6));
            add(new Song("P.Y.T. (Pretty Young Thing)", 3, 59));
            add(new Song("The Lady in My Life", 5, 0));
        }});

        AlbumCollection demoCollection = new AlbumCollection();
        demoCollection.addAlbum(Metallica);
        demoCollection.addAlbum(Thriller);

        return demoCollection;
    }

    public static PlayList createDemoPlayList(AlbumCollection albumCollection) {
        PlayList demoPlayList = new PlayList("All-time favorites");
        Album Metallica = albumCollection.getAlbumByTitle("Metallica");
        Album Thriller = albumCollection.getAlbumByTitle("Thriller");

        demoPlayList.addSong(Metallica, "Nothing Else Matters");
        demoPlayList.addSong(Metallica, "Sad But True");
        demoPlayList.addSong(Thriller, "Thriller");
        demoPlayList.addSong(Thriller, "Beat It");
        demoPlayList.addSong(Thriller, "Billie Jean");

        return demoPlayList;
    }

}
