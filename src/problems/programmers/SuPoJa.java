/**
 * Created on Jan 19, 2019 by Keichee
 */
package problems.programmers;

import java.util.ArrayList;
import java.util.List;

public class SuPoJa {
	
	public static void main(String[] args) {
		int[] answers = new int[]{1,2,3,4,5,6,7,8,9,10};
//		System.out.println(solution(answers));
	}
	public static int[] solution(int[] answers) {
		int[] p1 = new int[]{1,2,3,4,5};
		int[] p2 = new int[]{2,1,2,3,2,4,2,5};	 
		int[] p3 = new int[]{3,3,1,1,2,2,4,4,5,5};
		int[] score = new int[]{};
		
		for(int i=0;i<answers.length;i++) {
			// check p1
			if(answers[i] == p1[i%p1.length]) score[0]++;
			// check p2
			if(answers[i] == p2[i%p2.length]) score[1]++;
			// check p3
			if(answers[i] == p3[i%p3.length]) score[2]++;
		}
		
		int maxScore = Math.max(score[0], score[1]);
		maxScore = Math.max(maxScore, score[2]);
        
		List<Integer> aa = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
        		if(maxScore == score[i]){
        			aa.add(i+1);
        		}
        }
        int[] result = new int[aa.size()];
        if(aa.size() == 0 ) return result;
        for(int i =0; i< aa.size() ; i++) {
        		result[i] = aa.get(i);
        }
        return result;
    }
}
