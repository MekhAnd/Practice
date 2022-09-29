package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class RockBands {
	private String name;
	private String song;
	private String [] album;
	
	public RockBands(String name, String[] album) {
		super();
		this.name = name;
		this.album = album;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String[] getAlbum() {
		return album;
	}

	public void setAlbum(String[] album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "RockBands [name=" + name + ", song=" + song + ", album=" + Arrays.toString(album) + "]";
	}
	
	
	
	
	
}
