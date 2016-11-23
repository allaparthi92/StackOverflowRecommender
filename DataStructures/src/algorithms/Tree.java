package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Height{
	 int height;
	
	Height(int height){
		this.height = height;
	}
}
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	void InorderIterative(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode temp = root;

		while (temp != null || (!s.isEmpty())) {

			if (temp != null) {

				s.push(temp);

				temp = temp.left;
			} else {
				temp = s.pop();
				System.out.print(temp.data);
				temp = temp.right;

			}
		}

	}

	void preOrderIterative(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while ((!s.isEmpty())) {

			root = s.pop();

			System.out.print(root.data);

			if (root.right != null) {
				TreeNode temp = root.right;
				s.push(temp);
			}
			if (root.left != null) {
				TreeNode temp = root.left;
				s.push(temp);
			}
		}

	}

	void postOrderIterative(TreeNode root) {

		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		s.push(root);
		while ((!s.isEmpty())) {
			root = s.pop();
			s1.push(root);
			if (root.left != null) {
				TreeNode temp = root.left;
				s.push(temp);
			}
			if (root.right != null) {
				TreeNode temp = root.right;
				s.push(temp);
			}

		}
		while (!s1.isEmpty())
			System.out.print(s1.pop().data);

	}

	void LevelOrderIterative(TreeNode root) {

		Queue<TreeNode> q = (Queue<TreeNode>) new LinkedList<TreeNode>();

		q.add(root);

		while ((!q.isEmpty())) {
			root = q.poll();
			System.out.print(root.data);
			if (root.left != null) {
				TreeNode temp = root.left;
				q.add(temp);
			}
			if (root.right != null) {
				TreeNode temp = root.right;
				q.add(temp);
			}

		}
	}

	void LevelOrderIterativewithLevel(TreeNode root) {

		Queue<TreeNode> q = (Queue<TreeNode>) new LinkedList<TreeNode>();

		q.add(root);
		q.add(null);
		int count = 0;
		while ((!q.isEmpty())) {
			root = q.poll();
			if (root == null && !q.isEmpty() ) {
				count = count + 1;
					q.add(null);
			} else {
				if(q.isEmpty())
					return;
				System.out.print(root.data + "-->" + count + ",");
				if (root.left != null) {
					TreeNode temp = root.left;
					q.add(temp);
				}
				if (root.right != null) {
					TreeNode temp = root.right;
					q.add(temp);
				}
			}
		}
	}
	
	
	void LevelOrderPrintEachLevel(TreeNode root) {

		Queue<TreeNode> q = (Queue<TreeNode>) new LinkedList<TreeNode>();

		q.add(root);
		q.add(null);
		while ((!q.isEmpty())) {
			root = q.poll();
			if (root == null && !q.isEmpty() ) {
					q.add(null);
					System.out.println();
			} else {
				if(q.isEmpty())
					return;
				System.out.print(root.data);
				if (root.left != null) {
					TreeNode temp = root.left;
					q.add(temp);
				}
				if (root.right != null) {
					TreeNode temp = root.right;
					q.add(temp);
				}
			}
		}
	}
	
	
	boolean	TreesIdentical(TreeNode root1 , TreeNode root2){
		if(root1==null && root2==null)
			return true;
		
		if(((root1==null) && (root2!=null))||((root1!=null)&&(root2==null))){
			return false;
		}

		if(root1.data!=root2.data)
			return false;
		else
			
		return ((TreesIdentical(root1.left,root2.left)&& TreesIdentical(root1.right,root2.right)));
		
	}
	
	
	void  Printpathsfromroottoleaves(TreeNode root,int pathlen,int path[]){
		
		if(root!=null){
			path[pathlen] = root.data;
			pathlen++;
		}
		else
			return;
			
		if(root.left==null&&root.right==null){
			printArraypaths(path,pathlen);
		}
		
		else{
			 Printpathsfromroottoleaves(root.left,pathlen,path);
			 
			 Printpathsfromroottoleaves(root.right,pathlen,path);
		}
			
	}

	private void printArraypaths(int[] path, int pathlen) {
	
		for(int i=0;i<pathlen;i++){
			System.out.print(path[i]);
		}
		
		System.out.println();
		
	}
	
	void SpiralLevelOrderPrintEachLevel(TreeNode root) {
		
		Queue<TreeNode> q = (Queue<TreeNode>) new LinkedList<TreeNode>();
		
		Queue<TreeNode> q1 = (Queue<TreeNode>) new LinkedList<TreeNode>();
		
		Stack<TreeNode> s =  new Stack<TreeNode>();

		q.add(root);
	
		boolean var = false;
		while(!q1.isEmpty()|| !q.isEmpty()){
			
			if(var){
				
				while(!q1.isEmpty()){
					root = q1.poll();
			
					System.out.print(root.data);
					if (root.right != null) {
						TreeNode temp = root.right;
						q.add(temp);
					}
					if (root.left != null) {
						TreeNode temp = root.left;
							q.add(temp);
					}
					
			}
				
				var= !var;
				
			}
			
			else{
				
				while(!q.isEmpty()){
					root = q.poll();
					s.push(root);
					
					if (root.right != null) {
						TreeNode temp = root.right;
						q1.add(temp);
					}
					if (root.left != null) {
						TreeNode temp = root.left;
							q1.add(temp);
					}
					
			}
				while(!s.isEmpty()){
					System.out.print(s.pop().data);
				}
				
				var= !var;
			
			}
		}
	}
			
		boolean SumChildrenTree(TreeNode root){
			
			
			
			if(root == null||(root.left==null && root.right==null) )
				
				return true;
			else{
				int sum =0;
				if(root.left==null)
					sum = sum + root.right.data;
				else
					sum = sum +root.left.data;
				if(root.right==null)
					sum = sum +root.left.data;
				else
					sum = sum +root.right.data;
				
				return(root.data==(sum) && SumChildrenTree(root.left)&&SumChildrenTree(root.right) );
				
			}		
		}
		
		public int DaiameterOfTree(TreeNode root,int height){
			
			Height lh = new Height(height);
			Height rh = new Height(height);
			
			if(root == null){
				height =0;
				return 0;
			}
			lh.height++ ;
			rh.height++ ;
			
		
			int leftdia = DaiameterOfTree(root.left,lh.height);
			int rightdia = DaiameterOfTree(root.right,rh.height);
			
		height = Math.max(lh.height, rh.height)+1;
			return Math.max((lh.height+ rh.height)-1,Math.max(leftdia, rightdia));
			
		}
		
		
		TreeNode InsertBinarySearchTree(TreeNode root,int data){
			
			 if(root==null){
				 root = new TreeNode(data);
				 return root;
			 }				
			 else{
				
				 if(root.data > data){
					 root.left = InsertBinarySearchTree(root.left,data);
				 }
				 else {
					root.right =  InsertBinarySearchTree(root.right,data);
				 }
			
				 
			 }
				
		
			 return root;
		}
		
		public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
			
			    
			 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
				
				ArrayList<Integer> sub = new ArrayList<Integer>();
				
				if(a==null)
					return result;
				Queue<TreeNode> q = new LinkedList<TreeNode>();
				q.add(a);
				q.add(null);
				boolean flag = true;
				while(!q.isEmpty()){
					a = q.poll();
					//System.out.println(q);
					if(a!=null)
						sub.add(a.data);
					if(a==null){
						if(!q.isEmpty())
							q.add(null);
	                    if(!flag)
	                        Collections.reverse(sub);
	                    flag = !flag;
	                   
						result.add(sub);
						
						sub = new ArrayList<Integer>();
						
						continue;
						
					}
				
				
						if(a.left!=null){
						
							q.add(a.left);
						}
						if(a.right!=null){
						
							q.add(a.right);
						}
					
				}
				return result;
						
			}
	
}

public class Tree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		
		
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		
		System.out.println(root.zigzagLevelOrder(root));
		
	}

}
