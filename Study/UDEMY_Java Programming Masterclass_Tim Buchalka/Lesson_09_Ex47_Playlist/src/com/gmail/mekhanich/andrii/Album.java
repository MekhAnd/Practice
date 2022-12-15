package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        if((index >= 0) && (index < songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        if(findSong(title)!= null){
            playList.add(findSong(title));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        Song song = null;
        for (Song currentSong : songs) {
            if(currentSong.getTitle() == title){
                song = currentSong;
            }
        }
        return song;
    }
}
