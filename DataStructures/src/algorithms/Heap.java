package algorithms;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> al ;
	public int size =0;
	int max = 10;
	public int heapptr =0;
	public Heap(int i) {
		 al = new ArrayList<Integer>();
	}
	public static void main(String[] args) {	
		Heap h1 = new Heap(10);		
		h1.insert(12);
		h1.insert(7);
		h1.insert(9);
		h1.insert(10);
		h1.insert(8);
		h1.insert(6);
		h1.insert(3);
		h1.insert(15);
		h1.delete();
		h1.delete();
		for(int i : h1.al){
			System.out.println(i);
		}
	}
	private void delete() {
		
		if(al.size()<= 0){
			System.out.println("Empty");
		}else{
			al.set(0,al.get(al.size()-1));
			al.remove(al.size()-1);
			size--;
			heapdown();
		}
	}
	private void heapdown() {
		int root =0;
		
		int lc = 2*root +1;
		while(lc < al.size()){
			
			int max = lc;
			int rc = lc +1;
			if(rc < al.size()){
				if(al.get(lc) > al.get(rc)){
					max = lc;
				}else{
					max = rc;
				}				
			}
			
			if(al.get(root) < al.get(max)){
				int temp = al.get(root);
				al.set(root, al.get(max));
				al.set(max, temp);
				root = max;
				lc = 2*root + 1;
			}else{
				break;
			}
		}
	}
	private void insert(int value) {
		if(isFull()){
			System.out.println("It is fuking full");
		}else{
			al.add(value);
			size+=1;
			heapup(size-1);
		}
		
	}
	private void heapup(int i) {
		int temp = al.get(i);
		while(i>0 && temp > al.get(parent(i))){
			al.set(i, al.get(parent(i)));
			al.set(parent(i), temp);
			i = parent(i);
		}
		
		
	}
	private int parent(int i) {
		
		return (i-1)/2;
	}
	private boolean isFull() {
		
		return (al.size()>= max);
	}
}

