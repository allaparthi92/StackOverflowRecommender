package algorithms;

public class UserQueue {

	int array[];
	
	int front = -1;
	
	int rear =-1;
	
	int size= 10 ;
	
	public   UserQueue(){
	
		
		this.array = new int[size];
		
	}
	
	void Enqueue(UserQueue q,int data) throws IllegalAccessException{
		
		if((q.rear+1)%q.size == q.front){
			
			throw new IllegalAccessException("queue is full");
		}
		
		else if( q.front == -1 && q.rear == -1){
			q.front++;
			q.rear++;
			q.array[q.rear]= data;
		}
		else{
			q.rear = (q.rear+1)%q.size ;
			
			q.array[q.rear] = data;
			
		}
	}
	
	int Dequeue(UserQueue q) throws IllegalAccessException{
		int x =0;
		if(q.front == -1 && q.rear == -1){
			
			throw new IllegalAccessException("queue is empty");
		}
		
		else if( q.front == q.rear){
			
			x = q.array[q.front];
			
			q.front =-1;
			q.rear =-1;
		}
		else{
			x = q.array[q.front];
			
			q.front = (q.front+1)%q.size ;
			
		}
		return x;
	}
	
	
	public void printQueue(UserQueue q){
		for(int i=q.front ; i<=q.rear;i++){
			System.out.print(q.array[i]+"  ");
		}
		System.out.println("");
	}
	
	public static void main(String args[]) throws IllegalAccessException{
		UserQueue q = new UserQueue();
		q.Enqueue(q, 10);
		
		q.Enqueue(q, 20);
		
		q.printQueue(q);
		
		q.Dequeue(q);
		q.Dequeue(q);
		q.Dequeue(q);
		
	}
}