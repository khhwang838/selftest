package problems.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Hackerrank.com
 * Trees: Is This a Binary Search Tree?
 * 
 * 기본으로 노드 트리를 구성해주고 root노드를 파라미터로 전달받음
 * checkBST(Node root) 함수를 구현하는 문제
 * 
 * @author Kihyun
 * @created   2018-02-15
 */
public class IsBinaryTree {

	class Node {
        int data;
        Node left;
        Node right;
    }
	
    List<Integer> data = new ArrayList<>();
    void traverseInorder(Node node ){
        Node left = node.left;
        if ( left != null) traverseInorder(left);
        
        data.add(node.data);
        
        Node right = node.right;
        if ( right != null ) traverseInorder(right);
        
    }
    boolean checkBST(Node root) {
        traverseInorder(root);
        //System.out.println(data);
        for(int idx = 0; idx < data.size()-1 ; idx++){
            if ( data.get(idx) >= data.get(idx+1) ){
                return false;
            }
        }
        return true;
    }
}
