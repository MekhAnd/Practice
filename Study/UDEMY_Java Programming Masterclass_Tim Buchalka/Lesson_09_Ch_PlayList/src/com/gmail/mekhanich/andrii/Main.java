package com.gmail.mekhanich.andrii;

import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Song song01 = new Song("001", "1:35");
        Song song02 = new Song("002", "2:35");
        Song song03 = new Song("003", "1:45");
        Song song04 = new Song("004", "2:25");
        Song song05 = new Song("005", "1:15");
        Song song06 = new Song("006", "3:35");
        Song song07 = new Song("007", "5:35");

        Album first = new Album("First");

        first.addSongToAlbum(song01);
        first.addSongToAlbum(song02);
        first.addSongToAlbum(song03);
        first.addSongToAlbum(song04);
        first.addSongToAlbum(song05);
        first.addSongToAlbum(song06);
        first.addSongToAlbum(song07);

        first.addSongToAlbum("008", "3:50");
        first.addSongToAlbum("008", "3:50");

        Song song08 = new Song("008", "1:35");
        Song song09 = new Song("009", "2:35");
        Song song10 = new Song("010", "1:45");
        Song song11 = new Song("011", "2:25");
        Song song12 = new Song("012", "1:15");
        Song song13 = new Song("013", "3:35");
        Song song14 = new Song("014", "5:35");

        Album second = new Album("Second");

        second.addSongToAlbum(song08);
        second.addSongToAlbum(song09);
        second.addSongToAlbum(song10);
        second.addSongToAlbum(song11);
        second.addSongToAlbum(song12);
        second.addSongToAlbum(song13);
        second.addSongToAlbum(song14);

        MusicCollection myCollection = new MusicCollection();

        myCollection.addAlbumToCollection(first);
        myCollection.addAlbumToCollection(second);

        PlayList currentList = new PlayList();
        currentList.addSongToPlayList("008", myCollection);
        currentList.addSongToPlayList("010", myCollection);
        currentList.addSongToPlayList("012", myCollection);
        currentList.addSongToPlayList("001", myCollection);
        currentList.addSongToPlayList("009", myCollection);
        currentList.addSongToPlayList("001", myCollection);


        currentList.addSongToPlayList("015", myCollection);

        currentList.printPlayList();

        System.out.println();
        System.out.println("PLAYER");
        player(currentList);
    }

    private static boolean player(PlayList playList){
        Scanner sc = new Scanner(System.in);
        ListIterator<Song> li = playList.getPlayList().listIterator();
        printPlayerMenu();

        boolean quit = false;
        boolean direction = true;

        while(li.hasNext()){
            int actions = sc.nextInt();
            sc.nextLine();
            switch (actions){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println(direction);
                    if(!direction){
                        if(li.hasNext()){
                            li.next();
                        }
                        direction = true;
                    }
                    if(li.hasNext()){
                        System.out.println("Now playing " + li.next().toString());
                    } else {
                        System.out.println("This is the last song in play list");
                        direction = false;
                    }
                    break;
                case 2:
                    System.out.println(direction);
                    if(direction){
                        if(li.hasPrevious()){
                            li.previous();
                        }
                        direction = false;
                    }
                    if(li.hasPrevious()){
                        System.out.println("Now playing " + li.previous().toString());
                    } else {
                        System.out.println("This is the last song in play list");
                        direction = true;
                    }
                    break;
                case 3:
                    li.remove();
                    break;
                case 4:
                    playList.printPlayList();
                break;
                case 5:
                    printPlayerMenu();
            }
        }
        return true;
    }

    private static void printPlayerMenu(){
        System.out.println("Available actions:\n press ");
        System.out.println("0 - quit\n" + "1 - go to next point\n" + "2 - go to previous point\n"
                + "3 - remove current song\n" + "4 - print song list\n" + "5 - read menu\n");
    }


}