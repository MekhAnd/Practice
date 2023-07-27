package com.gmail.mekhanich.andrii;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Set<Task> tasks = TaskData.getTasks("all");
//        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Comparator<Task> sortByPriorityAndName =  Comparator.comparing(Task::getPriority).thenComparing(Task::getAssignee);
        Set<Task> annTasks = TaskData.getTasks("ann");
        sortAndPrint("Ann Tasks", annTasks, sortByPriority);

//        ******************************************************

        Set<Task> bobTasks = TaskData.getTasks("bob");
        sortAndPrint("Bob Tasks", bobTasks, sortByPriority);
        Set<Task> carolTasks = TaskData.getTasks("carol");
        sortAndPrint("Carol Tasks", carolTasks, sortByPriority);


        List<Set<Task>> union = new ArrayList<>(List.of(annTasks, bobTasks, carolTasks));

        Set<Task> unionSet = getUnion(union);
        sortAndPrint("Ann \u222a Bob \u222a", unionSet, sortByPriorityAndName);

        Set<Task> intersect = getIntersect(annTasks, bobTasks);
        sortAndPrint("Ann \u2229 Bob", intersect, sortByPriority);

        Set<Task> difference = getDifferenceUn(annTasks, carolTasks);
        sortAndPrint("Symmetric Difference Ann VS Carol", difference, sortByPriority);

        Set<Task> difference01 = getDifference(annTasks, carolTasks);
        sortAndPrint("Symmetric Difference Ann - Carol", difference01, sortByPriority);
    }


    public static Set<Task> getUnion (List<Set<Task>> listOfSet){
        Set<Task> unionSet = new HashSet<>();
        listOfSet.forEach(s->unionSet.addAll(s));

        return unionSet;
    }

    public static Set<Task> getIntersect (Set<Task> set1, Set<Task> set2){
        Set<Task> resultIntersect = new HashSet<>(set1);
        resultIntersect.retainAll(set2);
        return resultIntersect;
    }

    public static Set<Task> getDifferenceUn (Set<Task> set1, Set<Task> set2){
        Set<Task> difference12 = new HashSet<>(set1);
        difference12.removeAll(set2);

        Set<Task> difference21 = new HashSet<>(set2);
        difference21.removeAll(set1);

        difference12.addAll(difference21);

        return difference12;
    }

    public static Set<Task> getDifference (Set<Task> set1, Set<Task> set2){
        Set<Task> difference12 = new HashSet<>(set1);
        difference12.removeAll(set2);

        return difference12;
    }


    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter){
        String lineSeparator = "-".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);
        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }
}