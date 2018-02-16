package problems.hackerrank;

import java.util.Stack;

/**
 * Hackerrank.com
 * Stacks: Balanced Brackets
 * 
 * @author Kihyun
 * @created   2018-02-15
 */
public class BalancedBrackets {

	public static void main(String[] args) {
		String expression = "({()}]";
		System.out.println(isBalanced(expression));
	}
//	public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int a0 = 0; a0 < t; a0++) {
//            String expression = in.next();
//            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
//        }
//    }
	public static boolean isBalanced(String expression) {
		
		if ( expression.length() % 2 > 0 ) return false;
		
		Stack<Character> s = new Stack<>();
        
		for (int idx = 0; idx < expression.length() ; idx++ ) {
        	Character c = expression.charAt(idx);
        	if ( c == '(' || c == '{' || c == '[') {
        		s.push(c);
        	} else {
        		if (s.isEmpty() ) {
        			return false;
        		} else {
	        		Character p = s.pop();
	        		if ( (c == ')' && p != '(') || (c == '}' && p != '{') || (c == ']' && p != '[') ){
		        		return false;
		        	}
        		}
        	}
        }
        return s.isEmpty();		//  <-- return true; 가 아니라 스택이 비었는지를 확인해야 함
    }
}
