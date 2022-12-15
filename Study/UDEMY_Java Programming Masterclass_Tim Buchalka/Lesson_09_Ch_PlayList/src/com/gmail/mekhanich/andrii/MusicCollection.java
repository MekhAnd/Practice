package com.gmail.mekhanich.andrii;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class MusicCollection {

    private ArrayList<Album> collection;

    public MusicCollection() {
        this.collection = new ArrayList<Album>();
    }

    public ArrayList<Album> getCollection() {
        return collection;
    }

    public boolean addAlbumToCollection(Album nameAlbum) {
        if (collection.indexOf(nameAlbum) < 0) {
            collection.add(nameAlbum);
            System.out.println("Album was successfully added!");
            return true;
        } else return false;
    }
}
