package algorithms;

class TwoArrayStack{
	int a[];
	int top1;
	int top2;
	int n;
	TwoArrayStack(int n){
		this.n = n;
		a = new int[n];
		top1 =-1;
		top2=n;
	}
	
	void push1(int data){
		if(top2-top1 <= 1){
			System.out.println("stack overflow");
		}
		else
			
			a[++top1]= data;
		System.out.println(top1);
	}
	
	void push2(int data){
		if(top2-top1 <= 1){
			System.out.println("stack overflow");
		}
		else
			
			a[--top2]= data;
		System.out.println(top2);
	}
	
	int pop1(){
		if(top1 == -1)
		{
			System.out.println("stack empty");
			return -1;
		}
		int data = a[top1];
		top1--;
		return data;
	}
	
	int pop2(){
		if(top2 == n)
		{
			System.out.println("stack empty");
			return -1;
		}
		int data = a[top2];
		top2++;
		return data;
	}
	
}

public class ArrayTwoStacks {

	public static void main(String[] args) {
		
		TwoArrayStack ts = new TwoArrayStack(5);
		 ts.push1(5);
		    ts.push2(10);
		    ts.push2(15);
		    ts.push1(11);
		    ts.push2(7);
		    System.out.println("Popped element from stack1 is "+ts.pop1());
		    ts.push2(40);
		    System.out.println("Popped element from stack2 is " + ts.pop2());
		    ts.pop2();
		    ts.pop2();
		    ts.pop2();
		    ts.pop2();
		    ts.pop2();
		   
		}
	}


