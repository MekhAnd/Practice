package com.gmail.mekhanich.andrii;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		ProgrammingLanguage lang1 = new ProgrammingLanguage("Haskell", DifficultyLevel.HARD);
		ProgrammingLanguage lang2 = new ProgrammingLanguage("Python", DifficultyLevel.EASY);
		ProgrammingLanguage lang3 = new ProgrammingLanguage("Java", DifficultyLevel.MEDIUM);
		ProgrammingLanguage lang4 = new ProgrammingLanguage("C++", DifficultyLevel.HARD);
		ProgrammingLanguage lang5 = new ProgrammingLanguage("JS", DifficultyLevel.EASY);

		List<ProgrammingLanguage> languages = List.of(lang1, lang2, lang3, lang4, lang5);
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input difficulty level of language (0-easy, 1- medium, 2-hard)");
		int check = sc.nextInt();
		System.out.println("If you would like to choose language by length of name please input (0-for short name, 1 for long name), if you would not - press 2");	
		int check1 = 2; 
			check1 = sc.nextInt();
		
		Stream<ProgrammingLanguage> result = languages.stream()
				.filter(a-> (a.getComplexity()==DifficultyLevel.values()[check]));
				
		if (check1>1) {
			Optional <ProgrammingLanguage> answer = result.findAny();
			System.out.println(answer.get());
		} else if (check1==1){
			Optional <ProgrammingLanguage> answer = result.max((a,b)-> ((Integer)a.getName().length()).compareTo(b.getName().length()));

			System.out.println(answer.get());
		} else if (check1==0){
			Optional <ProgrammingLanguage> answer = result.min((a,b)-> ((Integer)a.getName().length()).compareTo(b.getName().length()));
			System.out.println(answer.get());
		}
		}

	public static int compareHard(ProgrammingLanguage a, ProgrammingLanguage b) {
		if (a.getComplexity().ordinal() > b.getComplexity().ordinal()) {
			return 1;
		}
		if (a.getComplexity().ordinal() < b.getComplexity().ordinal()) {
			return -1;
		}
		return Integer.compare(a.getName().length(), b.getName().length());
	}

}

enum DifficultyLevel {
	EASY, MEDIUM, HARD;
}

class ProgrammingLanguage {
	private String name;
	private DifficultyLevel complexity;

	public ProgrammingLanguage(String name, DifficultyLevel complexity) {
		super();
		this.name = name;
		this.complexity = complexity;
	}

	public String getName() {
		return name;
	}

	public DifficultyLevel getComplexity() {
		return complexity;
	}

	@Override
	public String toString() {
		return "ProgrammingLanguage [name=" + name + ", complexity=" + complexity + "]";
	}
}
