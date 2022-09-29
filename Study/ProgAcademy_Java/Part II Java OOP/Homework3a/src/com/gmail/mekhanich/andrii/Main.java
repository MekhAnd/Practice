package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws ThisProgException {
		Group one = new Group();
		Group two = new Group();

		File group = new File(
				"G:\\Java_OOP_WorkSpace\\HomeWork\\ProgKyivUA\\Homework3a\\src\\com\\gmail\\mekhanich\\andrii\\group.csv");
		File groupOne = new File(
				"G:\\Java_OOP_WorkSpace\\HomeWork\\ProgKyivUA\\Homework3a\\src\\com\\gmail\\mekhanich\\andrii\\groupOne.csv");

		KeyboardReader kb = new KeyboardReader();
		// Initialize st0 with KeyboardReader
		/*
		 * Student st0 = kb.setNewStudent();
		 * 
		 * Student st1 = new Student("Ivan", "Ivanov", "male", 18, "ZUNU"); Student st2
		 * = new Student("Stepan", "Petrov", "male", 18, "ZUNU"); Student st3 = new
		 * Student("Semen", "Zlobin", "male", 18, "ZUNU"); Student st4 = new
		 * Student("Alex", "Sidorov", "male", 18, "ZUNU");
		 */
		Student st5 = new Student("Vasil", "Stepanoff", "male", 22, "ZUNU");
		Student st6 = new Student("Tatiana", "Shorr", "female", 18, "ZUNU");
		Student st7 = new Student("Svitlana", "Koff", "female", 25, "ZUNU");
		Student st8 = new Student("Katerina", "Knur", "female", 21, "ZUNU");
		Student st9 = new Student("Irina", "Tpr", "female", 18, "ZUNU");
		Student st10 = new Student("Galina", "Duck", "female", 18, "ZUNU");
		Student st11 = new Student("Nata", "Shlaki", "female", 18, "ZUNU");
		Student st12 = new Student("Tasha", "Mali", "female", 18, "ZUNU");
		Student st13 = new Student("Tasha", "Mal", "female", 18, "ZUNU");
		Student st14 = new Student("Nata", "Shlak", "female", 18, "ZUNU");
		Student st15 = new Student("Galina", "Suduck", "female", 18, "ZUNU");
		Student st16 = new Student("Irina", "Tpra", "female", 18, "ZUNU");
		Student st17 = new Student("Katerina", "Knursh", "female", 18, "ZUNU");

		System.out.println();

		try {
			one.addStudents(st5);
			one.addStudents(st6);
			one.addStudents(st7);
			one.addStudents(st8);
			one.addStudents(st9);
			one.addStudents(st10);

		} catch (ThisProgException e) {
			System.out.println(e);
		}

		try {
			two.addStudents(st11);
			two.addStudents(st12);
			two.addStudents(st13);
			two.addStudents(st14);
			two.addStudents(st15);

		} catch (ThisProgException e) {
			System.out.println(e);
		}

		try {
			one.writerCSV(one, groupOne);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		one.saveToFile();
		Group three = new Group();
		three.loadFromFile();
		System.out.println("Three " + three.toString());

		List<Student> sortedGrOne = (List<Student>) one.getGroup().stream().filter(a -> a.getAge() > 20)
				.sorted((a, b) -> a.getLastName().compareTo(b.getLastName())).collect(Collectors.toList());

		System.out.println("\n\n" + sortedGrOne + "\n");

		/*
		 * //Search and Delete student with setSrchDelQuery //Search
		 * one.srchStudents(kb.setSrchDelQuery()); System.out.println(); //Delete
		 * one.delStudents(kb.setSrchDelQuery()); System.out.println();
		 * 
		 * System.out.println(one.toString());
		 * 
		 * 
		 * String newStud = "Igor;FTR;male;18;ZUNU";
		 * 
		 * Student st13 = new Student(null, null, null, 0, null); st13 =
		 * st13.fromCSVString(newStud); System.out.println("s13 - " + st13);
		 * System.out.println(st13.toCSVString());
		 */

		try {
			two.groupFromCSV(group);
		} catch (IOException | ThisProgException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(two.toString());
		Human human = new Human();
		Student humanSt = new Student(null, null, null, 0);
		Faculty humanFaculty = new Faculty();

		BlackList bl = new BlackList();
		bl.addTo(kb);
		bl.addTo(human);
		bl.addTo(humanSt);
		bl.addTo(humanFaculty);

		Faculty fin = new Faculty(3, bl);
		fin.setFaculty(one);
		fin.setFaculty(two);
		fin.setFaculty(kb);
		Group four = (Group) fin.peekGroup();

//		System.out.println();
//		System.out.println("!!!!!!!!!!!!");
//		System.out.println("This is CLONE = group four" + four.toString());

		Group five = (Group) fin.popGroup();
		System.out.println();
//		System.out.println("!!!!!!!!!!!!");
//		System.out.println("This is POP = group five" + five.toString());
//		
//		System.out.println(fin.toString());
	}

}
