package algorithms;

public class UserStack {

	int a[] ;
	int max =1;
	int top =-1;

	public  UserStack(){

		this.a = new int[max];
	}

	void push(int ele,UserStack s){

		if(top == max-1 ){
			System.out.println("Stack Overflow");
		}
		else{
			top = top +1;
			s.a[top] = ele;


		}
	}

	int pop(UserStack s){
		int x = 0;
		if(s.top == -1 ){

			System.out.println("Stack underflow");
			return -1;
		}

		else{
			x = s.a[top--];
			return x;
		}
	}

	int top(UserStack s){

		return s.a[top];

	}

	void printStack(UserStack s){
		for(int i=0; i<=s.top;i++)
			System.out.print(s.a[i]+"   ");
	}

	public static void main(String args[]){
		UserStack s = new UserStack();

		s.push(1, s);

		s.push(2, s);

		s.push(3, s);

		s.printStack(s);

		System.out.println("");

		s.pop(s);
		s.pop(s);


		System.out.println("");
		s.printStack(s);
	}

}
