package problems.hackerrank;

import java.util.Stack;

/**
 * Hackerrank.com
 * Queues: A Tale of Two Stacks
 * 
 * @author Kihyun
 * @created   2018-02-16
 */
public class TaleOfTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
           	stackNewestOnTop.push(value);
        }

        public T peek() {
        	if ( stackOldestOnTop.isEmpty() ) {
	        	while ( !stackNewestOnTop.isEmpty() ) {
	        		stackOldestOnTop.push(stackNewestOnTop.pop());
	        	}
        	}
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
        	if ( stackOldestOnTop.isEmpty() ) {
	        	while ( !stackNewestOnTop.isEmpty() ) {
	        		stackOldestOnTop.push(stackNewestOnTop.pop());
	        	}
        	}
        	return stackOldestOnTop.pop();
        }
    }
}
