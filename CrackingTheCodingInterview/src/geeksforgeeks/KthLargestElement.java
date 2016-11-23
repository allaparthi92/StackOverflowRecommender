package geeksforgeeks;

import java.util.PriorityQueue;

public class KthLargestElement {
	
	public static void KthLargest(int a[],int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(Integer x : a){
			queue.offer(x);
			if(queue.size() > k){
				queue.poll();
			
			}
		}
		  System.out.println( queue.peek());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] =  {3,2,1,5,6,4};
		KthLargest(a,2);
	}

}
