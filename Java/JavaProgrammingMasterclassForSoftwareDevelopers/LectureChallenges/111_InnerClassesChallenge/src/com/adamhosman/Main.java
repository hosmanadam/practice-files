package com.adamhosman;

import java.util.ArrayList;

public class Main {

    /**
     * https://www.udemy.com/java-the-complete-java-developer-course/learn/lecture/3779664
     *
     * Modify the playlist challenge so that the Album class uses an inner class.
     * Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList  ✓
     * The inner SongList class will use an ArrayList  ✓
     * and will provide a method to add a song.  ✓
     * It will also provide findSong() methods which will be used by the containing Album class
     * to add songs to the playlist.  ✓
     * Neither the Song class or the Main class should be changed.
     */
    public static void main(String[] args) {
        AlbumCollection demoCollection = createDemoCollection();
        PlayList demoPlayList = createDemoPlayList(demoCollection);
        demoPlayList.start();
        while (demoPlayList.isPlaying()) {
            demoPlayList.handleMenu();
        }
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
        Album Metallica = albumCollection.getAlbumByTitle("Metallica");
        Album Thriller = albumCollection.getAlbumByTitle("Thriller");

        PlayList demoPlayList = new PlayList("All-time favorites");
        demoPlayList.addSong(Metallica, "Nothing Else Matters");
        demoPlayList.addSong(Metallica, "Sad But True");
        demoPlayList.addSong(Thriller, "Thriller");
        demoPlayList.addSong(Thriller, "Beat It");
        demoPlayList.addSong(Thriller, "Billie Jean");

        return demoPlayList;
    }

}
