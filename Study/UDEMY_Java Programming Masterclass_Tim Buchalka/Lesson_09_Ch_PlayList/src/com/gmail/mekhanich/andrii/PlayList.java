package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class PlayList {

    private LinkedList<Song> playList;

    public PlayList() {
        this.playList = new LinkedList<Song>();
    }

    public LinkedList<Song> getPlayList() {
        return playList;
    }

    public LinkedList<Song> addSongToPlayList(String title, MusicCollection myCollection) {
        Song addedSong = null;
        addedSong = findSongInCollection(title, myCollection);
        if (findSongInCollection(title, myCollection) != null) {
            System.out.println("Successfully added");
            addedSong = findSongInCollection(title, myCollection);
            playList.add(addedSong);
        } else {
            System.out.println("This song is not belongs to your collection!");
        }


        return playList;
    }

    private Song findSongInCollection(String name, MusicCollection myCollection) {
        Song song = null;
        if (myCollection.getCollection().size() >= 0) {
            ArrayList<Album> collection = myCollection.getCollection();
            for (int i = 0; i < collection.size(); i++) {
                if (collection.get(i).getAlbum().size() >= 0) {
                    ArrayList<Song> album = collection.get(i).getAlbum();
                    for (int j = 0; j < album.size(); j++) {
                        if (album.get(j).getTitle() == name) {
                            song = album.get(j);
                        }
                    }
                }
            }
        }
        return song;
    }

    public void printPlayList() {
        ListIterator<Song> li = playList.listIterator();
        while (li.hasNext()) {
            System.out.println(li.next().toString());
        }
    }
}
