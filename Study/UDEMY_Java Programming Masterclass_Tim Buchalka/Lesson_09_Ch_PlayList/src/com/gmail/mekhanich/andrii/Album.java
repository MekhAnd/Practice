package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> album;

    public Album(String name) {
        this.name = name;
        this.album = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getAlbum() {
        return album;
    }

    public void addSongToAlbum(String name, String duration){
        if(findSong(name)== null){
            album.add(new Song(name, duration));
            System.out.println("This song was successfully added!");
        } else System.out.println("This song already exists in album!");
    }

    public void addSongToAlbum(Song song){
        if(findSong(song.getTitle())== null){
            album.add(song);
            System.out.println("This song was successfully added!");
        } else System.out.println("This song already exists in album!");
    }

    private Song findSong(String name){
        Song song = null;
        for (int i = 0; i < album.size(); i++){
            if(album.get(i).getTitle() == name){
                song = album.get(i);
            }
        }
        return song;
    }
}
