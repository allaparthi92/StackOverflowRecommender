package InterviewbitTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import algorithms.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Trees {
	boolean found = false;

	public TreeNode getSuccessor(TreeNode a, int b) {
		return Inorder(a, b);
	}

	public TreeNode Inorder(TreeNode a, int b) {
		if (a == null)
			return null;
		TreeNode L = Inorder(a.left, b);
		if (L != null)
			return L;
		if (a.val == b) {
			found = true;
		} else {
			if (found) {
				return a;
			}
		}
		TreeNode R = Inorder(a.right, b);
		if (R != null)
			return R;
		return null;
	}
	
	 	public int isBalanced(TreeNode a) {
	 		
	 		if(a==null)
	 			return 1;
	 		if(a.left==null || a.right==null)
	 			return 1;
	 		int left = depth(a.left);
	 		int right = depth(a.right);
	 		if(Math.abs(left - right)> 1)
	 			return 0;
	 		
	 		else
	 			
	 			if(isBalanced(a.left)==1 && isBalanced(a.right)==1){
	 				return 1;
	 			}
			return 1;
	}

	private int depth(TreeNode a) {
		
		if(a==null)
			
			return 0;
		if(a.left==null || a.right==null)
			return 0;
		return (1+ Math.max(depth(a.left), depth(a.right)));
	}
	
	public int isSameTree(TreeNode a, TreeNode b) {
		if(a==null && b== null)
			return 1;
		if( a== null || b==null)
			return 0;
		if(a.val == b.val){
			if(isSameTree(a.left,b.left) ==1 && isSameTree(a.right,b.right)==1){
				return 1;
			}
		}
		else
			return 0;
			
		
		return 0;
		
	}
	
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    Stack <TreeNode> s = new Stack();
	    
	    s.push(a);
	    while(a!=null || s.isEmpty()){
	        if(a.left!=null){
	            a= a.left;
	            s.push(a);
	        }
	         else{
	            result.add(s.pop().val);
	            if(s.pop().right!=null)
	                a= a.right;
	         } 
	    }
	     Collections.reverse(result);
	     return result;
	}
	
	 public int sumOfLeftLeaves(TreeNode root) {
	        if(root==null)
	            return 0;
	        
	       return sumOfLeftLeavesHelper(root,false);
	  
	 }  
	 
	 public int sumOfLeftLeavesHelper(TreeNode root,boolean add){
		 
		 if(root.left==null && root.right == null){
			 if(add){
				 return root.val;
			 }else{
				 return 0;
			 }
			 
			
		 }
		 return sumOfLeftLeavesHelper(root.left,true)+sumOfLeftLeavesHelper(root.right,false);
		 
		 
	 }
		    
	
	  
	  

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);

	}

}
