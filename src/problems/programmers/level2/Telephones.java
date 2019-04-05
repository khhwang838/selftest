/**
 * Created on Mar 23, 2019 by Keichee
 */
package problems.programmers.level2;

import static org.hamcrest.CoreMatchers.startsWith;

public class Telephones {

	public static void main(String[] args) {
		String[] a = {"113", "12340", "123440", "12345", "98346"};
		solution(a);
	}
	public static boolean solution(String[] phone_book) {
        for (int i = 0; i< phone_book.length - 1; i++) {
            for ( int j = i+1; j < phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])) {
                	System.out.println(phone_book[i]);
                	System.out.println(phone_book[j]);
                    return false;
                }
            }
        }        
        return true;
    }
}
