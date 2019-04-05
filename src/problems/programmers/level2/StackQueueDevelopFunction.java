/**
 * Created on Dec 29, 2018 by Keichee
 */
package problems.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// 스택큐 > 기능개발
public class StackQueueDevelopFunction {
	public static void main(String[] args) {
		int[] progresses = new int[]{90, 50};
		int[] speeds = new int[]{1, 1};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
		
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> functionCountPerDeploy = new ArrayList<>();
        int max = 0;
        int numOfFunctions = 0;
        
        if(progresses.length == 1) {
        		return new int[]{1};
        }
        for ( int idx = 0; idx < progresses.length ; idx++) {
        		int progress = progresses[idx];
        		int speed = speeds[idx];
        		
        		int restProgress = 100 - progress;
        		int deployDay = restProgress / speed;
        		if( restProgress % speed > 0) {
        			deployDay += 1;
        		}
        		// 7, 3, 2, 9, 5
        		if(deployDay > max) {
        			max = deployDay;
        			if (idx > 0) {
        				functionCountPerDeploy.add(numOfFunctions);
        			}        			
        			numOfFunctions = 1;
        		}else {
        			numOfFunctions++;
        		}
        }
        functionCountPerDeploy.add(numOfFunctions);
        
        answer = new int[functionCountPerDeploy.size()];
        int i = 0;
        Iterator<Integer> iter = functionCountPerDeploy.iterator();
        while(iter.hasNext()) {
        		Integer value = iter.next();
        		answer[i++] = value;
        }
        
        return answer;
    }
}
