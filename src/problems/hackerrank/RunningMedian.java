package problems.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * hackerrank.com
 * Heaps: Find the Running Median
 * 
 * @author Kihyun
 * @created   2018-02-16
 */
public class RunningMedian {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            if ( a_i == 0 ) System.out.println(a[0]/1.0);
            if ( a_i == 1 ) System.out.println((a[0] + a[1])/2.0);
            
        }
    }
	
	/*
	 * Timeout
	 */
//	public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] a = new int[n];
//        List<Integer> data = new ArrayList<>();
//        for(int a_i=0; a_i < n; a_i++){
//            a[a_i] = in.nextInt();
//            data.add(a[a_i]);
//            Collections.sort(data);
//            if ( data.size() == 1) {
//                System.out.println(data.get(0)/1.0);
//            }
//            else if ( data.size() % 2 > 0 ) {
//            	System.out.println(data.get(data.size()/2)/1.0);
//            } else {
//            	double result = (data.get(data.size()/2 - 1) + data.get(data.size()/2))/2.0;
//            	System.out.println(result);
//            }
//        }
//    }
}
