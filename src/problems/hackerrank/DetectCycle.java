package problems.hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * Linked List : Detect a cycle
 * 
 * @author Kihyun
 * @created   2018-02-15
 */
public class DetectCycle {

	class Node {
		int data;
		Node next;
	}
	/*
	 * 내가 푼 해답
	 */
	Set<Node> dup = new HashSet<>();
	boolean hasCycle(Node head) {
	    if (head == null ) {
            dup = new HashSet<>();
	    	return false;
	    }
	    if ( dup.contains(head) ) {
            dup = new HashSet<>();
            return true;
        }
	    dup.add(head);
	    return hasCycle(head.next);
	}

/*	더 좋은 해답
	boolean hasCycle(Node head) {
		if (head == null)
			return false;
		else {
			Node slow = head;
			Node fast = head.next;
			while (fast != null && fast.next != null && fast != slow) {
				slow = slow.next;
				fast = fast.next.next;
			}
			if (fast != null && fast == slow)
				return true;
			return false;
		}
	}*/
}
