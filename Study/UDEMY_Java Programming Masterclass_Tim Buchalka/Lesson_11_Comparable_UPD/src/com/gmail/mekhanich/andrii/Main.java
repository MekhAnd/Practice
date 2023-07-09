package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Integer five = 5;
        Integer [] array = {0,5,12,25, 50,-50};

        for(Integer i : array){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo= %d%n", five,
                    (val == 0 ? "==" : ((val < 0 )? "<" : ">")), i, val);
        }
//        ******************************************

        String banana = "banana";
        String [] fruits = {"apple", "banana", "BANANA", "orange"};
        for(String i : fruits){
            int val = banana.compareTo(i);
            System.out.printf("%s %s %s: compareTo= %d%n", banana,
                    (val == 0 ? "==" : ((val < 0 )? "<" : ">")), i, val);
        }

        Arrays.sort(fruits);
        System.out.println(Arrays.toString(fruits));

        //        ******************************************

        Student andr = new Student("Andriy");
        Student [] group = {new Student("Tim"),new Student("Kate"),new Student("Zak"), new Student("Pol")};
        for(Student i : group){
            int val = andr.compareTo(i);
            System.out.printf("%s %s %s: compareTo= %d%n", andr,
                    (val == 0 ? "==" : ((val < 0 )? "<" : ">")), i, val);
        }

        Arrays.sort(group);
        System.out.println(Arrays.toString(group ));
//        ******************************************
        System.out.println("result = " + andr.compareTo(new Student("Mary")));

        Comparator<Student> gpaSorter = new StudetGPAComparator();
        Arrays.sort(group, gpaSorter);
        System.out.println(Arrays.toString(group));

        Arrays.sort(group, gpaSorter.reversed());
        System.out.println(Arrays.toString(group));
    }
}

class StudetGPAComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2){
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {
    String name;
    private static int LAST_ID = 1000;
    private static Random random = new Random();

    private int id;
    protected double gpa;
    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return  "%d - %s (%.2f)".formatted(id,name,gpa);
    }


    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }



    //    @Override
//    public int compareTo(Object o) {
//        Student other = (Student)o ;
//        return name.compareTo(other.name);
//    }

}