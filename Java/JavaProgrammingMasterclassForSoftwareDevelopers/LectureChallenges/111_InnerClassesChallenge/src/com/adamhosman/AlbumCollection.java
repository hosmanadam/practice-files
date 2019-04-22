package com.adamhosman;

import java.util.ArrayList;

public class AlbumCollection {

    private ArrayList<Album> albums;

    public AlbumCollection() {
        this(new ArrayList<Album>());
    }

    public AlbumCollection(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public Album getAlbumByTitle(String albumTitle) {
        for (Album album : albums) {
            if (album.getTitle().equals(albumTitle)) {
                return album;
            }
        }
        return null;
    }

    public boolean addAlbum(Album album) {
        albums.add(album);
        return true;
    }

}
