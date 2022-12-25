package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs ;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        if (songs.findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        if(songs.findSong(trackNumber-1) != null){
            playList.add(songs.findSong(trackNumber-1));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        if (songs.findSong(title) != null) {
            playList.add(songs.findSong(title));
            return true;
        }
        return false;
    }

    public class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if(findSong(song.getTitle()) == null){
                this.songs.add(song);
                return true;
            }
             return false;
        }

        private Song findSong(String title) {
            Song song = null;
            for (Song currentSong : this.songs) {
                if (currentSong.getTitle() == title) {
                    song = currentSong;
                }
            }
            return song;
        }

        private Song findSong(int trackNumber) {
            Song song = null;
            if (this.songs != null && (trackNumber >= 0 && trackNumber < this.songs.size())) {
               song = this.songs.get(trackNumber);
            }
            return song;
        }
    }
}
