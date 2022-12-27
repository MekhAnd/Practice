package com.example;


import java.sql.Array;

public class Series {

    public static int nSum(int n){
        return (n*(n+1))/2; // Tim solution

//        int sum = 0;
//        for(int i=0; i <=n; i++){
//            sum += i;
//            System.out.print(sum + " ");
//        }
//        return sum;
    }

    public static long factorial(int n){
        long result = 1;
        for(int i=1; i <=n; i++){
            result *= i;
            System.out.print(result + " ");
        }
        return result;
    }

    public static long fibonacci(int n){
        long fibResult = 0;
        long [] array = new long [n];
        array[0] = 0;
        array[1] = 1;
        for ( int i = 2; i<array.length; i++){
            System.out.print(fibResult + " ");
            fibResult = array[i-2] + array[i-1];
            array[i] = fibResult;
        }
        return fibResult;
    }
}
