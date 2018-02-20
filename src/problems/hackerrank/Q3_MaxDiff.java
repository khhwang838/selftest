package problems.hackerrank;

import java.util.Arrays;

public class Q3_MaxDiff {

    static int maxDifference(int[] a) {
    	
    	int maxDiff = Integer.MIN_VALUE;
    	int maxIdx = -1;
        int minIdx = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
    	for ( int i = 0; i < a.length ; i++ ) {
    		if ( a[i] > max ) {
                max = a[i];
                maxIdx = i;
            }
            if ( a[i] < min ) {
                min = a[i];
                minIdx = i;
            }
    	}
        if ( maxIdx > minIdx ) {
            return max - min;
        } else {
        	
            for ( int i = 0; i < maxIdx ; i++ ){
                if ( maxDiff < max - a[i]) {
                    maxDiff = max - a[i];
                }
            }
            // TODO : fail here.....
            for ( int i = maxIdx+1; i < minIdx ; i++ ) {
            	if ( maxDiff < min - a[i] ) {
            		maxDiff = min - a[i];
            	}
            }
            //-----------------------
            for ( int i = minIdx+1; i < a.length; i++ ) {
            	if ( maxDiff < a[i] - min ) {
            		maxDiff = a[i] - min;
            	}
            }
            int tmpDiff = maxDifference(Arrays.copyOfRange(a, maxIdx+1, minIdx-1));
            if ( maxDiff < tmpDiff ) return tmpDiff;
        }
        return maxDiff;
    }
}



/*
min . . . max
. . min . . max
. . min . . max . .

. . max . . min . . 	7  10 2  1  9
. . max . . min			9  10 4 8 1 ---> 1  (fail)
max . . min . . 		10 3 9 1 2
max . . . min
*/

