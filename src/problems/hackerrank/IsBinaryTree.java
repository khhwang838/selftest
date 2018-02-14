package problems.hackerrank;

import java.util.ArrayList;
import java.util.List;

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
