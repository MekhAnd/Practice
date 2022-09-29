package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Расстояние Хємминга между двумя целыми числами

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your numbers:");
		int n = sc.nextInt();
		int m = sc.nextInt();

		System.out.println(Arrays.toString(binar(n)));
		System.out.println(Arrays.toString(binar(m)));
		System.out.println(distance(binar(n), binar(m)));

		//System.out.println("Другой метод " + binary(n) + " " +binary(m));
		System.out.println ("Другой метод " + compare(n,m));
		System.out.println(calculateHemingsLength (n,m));

	}

	public static int [] binar(int a) {			//method for converting binary int to int array with 32 digits
		String z = Integer.toString(a, 2);
		char[] ch = z.toCharArray();
		int [] ar = new int [32];
		
		for (int i=0; i<=31; i++ ) {
			
			if (i<ch.length) {
				ar[i] = ch[ch.length-1-i]-48; 
			} else {
				ar[i] = 0;
			}
		}
		
		return ar;
	}

	public static int distance(int[] n, int[] m) {	//method which calculating distance 
		int distance = 0;
			for (int i = 0; i <= 31; i++) {
				if ((n[i] != m[i])) {
					distance += 1;
					} 
			}
		
		return distance;
	}
	
	/* public static int binary (int a) {						//method which take decimal numbers and return binary numbers 
	 	int c = Integer.parseInt(Integer.toString(a,2));
	 	return c;
 	}*/
	 
	 public static int compare (int a, int b) {				//	
		 int compare = 0;
	 	 	for (int i = 0; i<=31; i++) {
	 	 		if ((a&1)!=(b&1)) {
	 	 			compare ++;
	 	 		} else {
	 	 		}
	 	 		a = a>>1;
	 	 		b = b>>1;
	 	 	}
	 	 return compare;
	 }
	 
	 static int calculateHemingsLength(int a, int b) {
			int n = 0;
			int c = a ^ b;
			for (; c > 0;) {
				n +=(c & 1);
				c >>= 1;
			}
			return n;
		}

}

/*static int calculateHemingsLength(int a, int b) {
	int n = 0;
	int c = a ^ b;
	for (; c > 0;) {
		n +=(c & 1);
		c >>= 1;
	}
	return n;
}
*/

