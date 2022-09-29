package com.gmail.mekhanich.andrii;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		RockBands acdc = new RockBands("AcDc",
				new String[] { "Shoot to Thrill", "Rock and Roll damnation", "Guns of Hire", "Cold Harted Man",
						"Back in Black", "Thunderstruck", "If You Want Blood You've Got It", "Evil Walks", "T.N.T.",
						"Highway to Hell" });
		RockBands pinkFloyd = new RockBands("Pink Floyd",
				new String[] { "In the Flesh?", "The Thin Ice", "Another Brick in the Wall",
						"The Happiest Days of Our Lives", "Another Brick in the Wall, Pt. 2", "Mother",
						"Goodbye Blue Sky", "Empty Spaces", "Young Lust", "One of My Turns" });
		RockBands manowar = new RockBands("Manowar",
				new String[] { "Kings of Metal", "Heart of Steel", "Sting of the Bumblebee",
						"The Crown and the Ring (Lament of the Kings)", "Kingdom Come", "Pleasure Slave",
						"Hail and Kill", "The Warrior's Prayer", "Blood of the Kings" });

		RockBands [] singers = new RockBands [] {acdc, pinkFloyd, manowar};
		List<String> playlist = Arrays.stream(singers)
				.flatMap(a-> Arrays.stream(a.getAlbum()))
				.sorted((a,b)->a.compareTo(b))
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println("First 3 songs by alphabet, from all playlist - " + playlist);
				
		Stream <String> acplay = Arrays.stream(acdc.getAlbum())
				.sorted((a,b)->a.compareTo(b))
				.limit(3);
		Stream<String> pfplay = Arrays.stream(pinkFloyd.getAlbum())
				.sorted((a,b)->a.compareTo(b))
				.limit(3);
		Stream<String> manplay = Arrays.stream(manowar.getAlbum())
				.sorted((a,b)->a.compareTo(b))
				.limit(3);
		
		Stream<String> pl = Stream.concat(acplay, pfplay);
		Stream<String> pl2 = Stream.concat(pl, manplay);		
				
		List<String> playlistv2 = pl2.collect(Collectors.toList());
		
		System.out.println("First 3 songs by alphabet, from every album - " + playlistv2);
	}

}
