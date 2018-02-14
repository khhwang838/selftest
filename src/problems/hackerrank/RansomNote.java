package problems.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hackerrank.com
 * Hash Tables: Ransom Note
 * ------------------------
 * Sample Input 0
 * 
 * 6 4
 * give me one grand today night
 * give one grand today
 * 
 * Sample Output 0
 * 
 * Yes
 * 
 * Sample Input 1
 * 
 * 6 5
 * two times three is not four
 * two times two is four
 * 
 * Sample Output 1
 * 
 * No
 * ------------------------
 * 입력: 매거진의 단어 수, 랜섬노트에 사용할 단어 수, 매거진 내용, 랜섬노트 내용
 * 출력: 랜섬노트의 내용을 매거진의 내용에 있는 단어로 만들 수 있으면 Yes, 아니면 No
 * 제한: 매거진에 있는 단어는 한번씩만 사용가능, 단어를 자르거나 붙여서 다른 단어를 만들 수 없음
 * 
 * Took 15 minutes to solve
 * ------------------------
 * @author Kihyun
 * @created   2018-02-15
 */
public class RansomNote {

    Map<String, Integer> magazineMap = new HashMap<>();
    Map<String, Integer> noteMap = new HashMap<>();
    
    public RansomNote(String magazine, String note) {
        String[] arrM = magazine.split(" ");
        String[] arrN = note.split(" ");
        int cnt;
        String key;
        for ( int idx=0; idx<arrM.length ; idx++) {
        	cnt=0;
        	key = arrM[idx];
        	if ( magazineMap.containsKey(key)) {
        		cnt = magazineMap.get(key);
        	}
        	magazineMap.put(key, cnt + 1);
        }
        for ( int idx=0; idx<arrN.length ; idx++) {
        	cnt=0;
        	key = arrN[idx];
        	if ( noteMap.containsKey(key)) {
        		cnt = noteMap.get(key);
        	}
        	noteMap.put(key, cnt + 1);
        }
    }
    
    public boolean solve() {
        for ( String key : noteMap.keySet() ) {
        	if ( magazineMap.get(key) < noteMap.get(key) ) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
