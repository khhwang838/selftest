/**
 * Created on Dec 29, 2018 by Keichee
 */
package problems.programmers;

import java.util.Arrays;

// 해시 > 완주하지 못한 선수
public class NotCompletedParticipant {

	public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for ( int index = 0; index < completion.length; index++){
        		if(!participant[index].equals(completion[index])){
        			return participant[index];
        		}
        }
        return participant[participant.length-1];
    }
}
