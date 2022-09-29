package com.gmail.mekhanich.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Group implements Serializable, Cloneable {

	//private Student[] students = new Student[10];
	private List<Student> group = new ArrayList<>();

	public Group() {
		super();
	}

	public Group(List<Student> group) {
		super();
		this.group = group;
	}

	public List<Student> getGroup() {
		return group;
	}

	public void setGroup(List<Student> group) {
		this.group = group;
	}

	@Override
	public String toString() {
		this.sorter();
		String message = "Group [students= " + System.lineSeparator();
		for (int i = 0; i < group.size(); i++) {
			message += group.get(i);
			message += System.lineSeparator();
			}
		return message;
	}

	public void addStudents(Student student) throws ThisProgException {
		if (group.size()<10) {
			this.group.add(student);
			System.out.println("New student was successfully enrolled!");
		} else if (group.size()>9) {
			System.out.println("Error in process!");
			throw new ThisProgException();
		} 
	}

	public void delStudents(String lastName) {
		for (int i = 0; i < group.size(); i++) {
			if (lastName.equals(group.get(i).getLastName())) {
					group.remove(i);
					System.out.println("This " + lastName + " student was successfully delete from!");
					break;
			}
		}
	}

	public Student srchStudents(String lastName) {
		Student srch = new Student(null, null, null, 0);
		for (int i = 0; i < group.size(); i++) {
			if (lastName.equals(group.get(i).getLastName())) {
				System.out.println("We have some results!");
				srch = group.get(i);
				} else {
				System.out.println("Are you looking for " + lastName + "? There is no any students with this last name - "
						+ lastName + "!");
				}				
			}
		return srch;
	}

	public  List<Student> sorter() {
		Collections.sort(this.group, Comparator.nullsLast(new StudentLastNameComaprator()));
		return group;
	}

	public void writerCSV(Group student, File file) throws IOException {
		String add = "";
		for (int i = 0; i < group.size(); i++) {
			add += group.get(i).toCSVString() + System.lineSeparator();
			}
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.print(add);
			System.out.println("Have done!");
		} catch (IOException e) {
		}
	}

	public Group groupFromCSV(File file) throws IOException, ThisProgException {
		String text = "";
		Group newGr = new Group();
		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			for (; (text = br.readLine()) != null;) {
				String result = "";
				result += text;
				Student temp = new Student(null, null, null, 0, null);
				temp.fromCSVString(result);
				newGr.addStudents(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newGr;
	}

	public void saveToFile() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("groupForNextUse.txt"))) {
			oos.writeObject(this);
			System.out.println("The operation have done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Group loadFromFile() {
		Group copyGr = new Group();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("groupForNextUse.txt"))) {
			copyGr = (Group) ois.readObject();
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}
		return copyGr;
	}

	@Override
	public Group clone() throws CloneNotSupportedException {
		Group cloneGr = new Group();
		for (int i = 0; i < this.group.size(); i++) {
			try {
				cloneGr.addStudents(group.get(i));
			} catch (ThisProgException e) {
				e.printStackTrace();
			}
		}
		return (Group) cloneGr;
	}
}
