package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int [][] newArray = new int [4][4];
        int [] arrayNew [] = new int [8][8];

        System.out.println(Arrays.toString(newArray));
        System.out.println(Arrays.toString(arrayNew));

        System.out.println("length = " + newArray.length);
        System.out.println("length = " + arrayNew.length);

         for (int[] outer: arrayNew){
             System.out.println(Arrays.toString(outer));
         }

//         for(int i=0; i<newArray.length; i++){
//             var innerArray = newArray[i];
//             for(int k=0; k<innerArray.length; k++){
//                 System.out.print(newArray[i][k] + " ");
//             }
//             System.out.println();
//         }

//        for (var outer :arrayNew){
//            for(var element :outer){
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }

        System.out.println(Arrays.deepToString(arrayNew));

         newArray[1] = new int[]{10,20,30,40};
        newArray[0] = new int[]{11,21};
        System.out.println(Arrays.deepToString(newArray));

        Object [] objArray = new Object[3];
        System.out.println(Arrays.toString(objArray));
        objArray [0] = arrayNew;
        objArray [1] = newArray;
        objArray [2] = new String[] {"new", "String", "Array"};
        System.out.println(Arrays.toString(objArray));
        System.out.println(Arrays.deepToString(objArray));

        for (Object element: objArray) {
            System.out.println("Element types = " + element.getClass().getSimpleName());
            System.out.println("Element toString - " + element.toString());
            System.out.println(Arrays.deepToString((Object[])element));
        }

    }
}