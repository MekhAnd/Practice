package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList currentAlbum;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.currentAlbum = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.currentAlbum.addSong(title, duration);
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        ArrayList <Song> currentSongAlbum = this.currentAlbum.getSongs();
        if((index >= 0) && (index < currentSongAlbum.size())){
            playList.add(currentSongAlbum.get(index));
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
        return this.currentAlbum.findSong(title);
    }

    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList();
        }

        public boolean addSong(String title, double duration) {
            if(findSong(title) == null){
                songs.add(new Song(title, duration));
                return true;
            }
            return false;
        }

        public ArrayList<Song> getSongs() {
            return songs;
        }

        private Song findSong(String title) {
            Song song = null;
            for (Song currentSong : songs) {
                    if (currentSong.getTitle() == title) {
                        song = currentSong;
                    }
                }
            return song;
        }





    }
}
