package com.gmail.mekhanich.andrii;

import com.gmail.mekhanich.andrii.model.LPAStudent;
import com.gmail.mekhanich.andrii.model.Students;
import com.gmail.mekhanich.andrii.util.QueryItem;
import com.gmail.mekhanich.andrii.util.QueryList;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        int studentsGroup = 10;
        List<Students> students  = new ArrayList<>();
        for (int i = 0; i<studentsGroup; i++){
            students.add(new Students());
        }
        students.add(new LPAStudent());
//        printList(students);
        printMoreList(students);

        List<LPAStudent> lpaStudents  = new ArrayList<>();
        for (int i = 0; i<studentsGroup; i++){
            lpaStudents.add(new LPAStudent());
        }

//        printList(lpaStudents);
        printMoreList(lpaStudents);


        testList(new ArrayList<String>(List.of("Zac", "Tik","Tak")));
        testList(new ArrayList<Integer>(List.of(1, 2,3)));
        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("COURSE", "Java");

        printMoreList(matches);

        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreList(students2021);


//        QueryList<Employee> emplList = new QueryList<>();
    }


    public static  void printMoreList(List <? extends  Students> students){
//
//        Students last = students.get(students.size()-1);
//        students.set(0, last);


        for (var student: students){
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list){
        for(var element: list){
            if(element instanceof String s){
                System.out.println("String: " + s.toUpperCase());
            } else if(element instanceof Integer integer) {
                System.out.println("Integer: " + integer.floatValue());
            }
        }
    }

//    public static void testList(List<String> list){
//        for(var element: list){
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list){
//        for(var element: list){
//            System.out.println("Ineger: " + element.floatValue());
//        }
//    }

//    public static <T extends Students> void printList(List <T> students){
//        for (var student: students){
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }

}