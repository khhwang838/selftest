package problems.hackerrank;

import java.util.Scanner;

public class Contacts {
	
	final static Node root = new Node();
	
	static class Node {
		private int count = 1;
		final Node[] nodes = new Node[26];
		public void addCount() {
			count++;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if ("add".equals(op)) {
				add(contact, root, 0);
			} else if ("find".equals(op)) {
				System.out.println(countNames(root, contact, 0));
			}
		}
	}
	public static void add(String name, Node node, int idx) {
		if ( name != null && name.length() > idx) {
			char c = name.charAt(idx);
			Node n = node.nodes[c-97];
			if ( n == null ) {
				n = new Node();
				node.nodes[c-97] = n;
				add(name, n, idx+1);
			} else {
				n.addCount();
				add(name, n, idx+1);
			}
		}else return;
	}
	public static int countNames(Node node, String name, int idx) {
		char c = name.charAt(idx);
		Node n = node.nodes[c-97];
		if ( n == null) {
			return 0;
		} else if ( name.length() - 1 == idx ) {
			return n.count;
		} else {
			return countNames(n, name, idx+1);
		}
	}
}
