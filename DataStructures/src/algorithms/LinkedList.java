package algorithms;

class Node {

	int data;

	Node next;

	Node(int data) {
		this.data = data;
	}

	void printSLL(Node head) {
		while (head != null) {
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.print("null");
	}

	public Node ReverseSL(Node head) {

		Node current = head, temp = null, prev = null;

		while (current.next != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		current.next = prev;
		head = current;

		return head;

	}

	Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null)
			head.next = reverse(next, k);

		// prev is now head of input list
		return prev;
	}

	public Node Bubblesort(Node head) {

		Node p = head, q = head, m = head;

		while (m.next != null) {
			while (p.next != null) {

				if (p.data > p.next.data) {

					int temp = p.data;

					p.data = p.next.data;

					p.next.data = temp;
				}

				p = p.next;

			}
			p = head;
			m = m.next;

		}
		return head;

	}
	
	
	public static Node push(Node head, int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		return head;
	}
	
	public static int pop(Node head){
		
		int data = head.data;
		head = head.next;
		return data;
	}
	
	public static Node RemoveNthNodeEnd(Node head,int n){
		Node prev = head;
		if(head ==null)
			return null;
		Node first=head,second=head;
		for(int i=0;i< n;i++){
			first = first.next;
		}
		while(first!=null){
			prev = second;
			second = second.next;
			first = first.next;
		}
		if(second == head)
			head = head.next;
		else
			prev.next = second.next;
		return head;
	}
	
	public static Node RotateList (Node head,int n){
		Node prev = head;
		if(head ==null)
			return null;
		Node fast = head,first=head;
		int length =0;
		while(fast!=null){
			length++;
			fast = fast.next;
		}
		n = n%length;
		fast = head;
		for(int i=0;i< length-n-1;i++){
			prev = first;
			first = first.next;
			
		}
		
	
		 Node kthNode = first;
		 
	        while (first.next != null)
	        	first = first.next;
	 
	        first.next = head;
	 
	
	        kthNode.next = null;
	 
	    
		return head;
	
			
	}
	
	
}

public class LinkedList {

	public static void main(String args[]) {

		Node head = new Node(40);
		head.next = new Node(20);
		head.next.next = new Node(60);
		head.next.next.next = new Node(50);
		//head.next.next.next.next = nul;

		head.printSLL(head);
		System.out.println();
		Node head1 = head.RotateList(head, 2);
		head1.printSLL(head1);
	}
}
