package LinkedLists;

public class KthElement {
	
	
	public static  Node findKthElement(Node head,int k){
		
		Node fast=head,slow=head;
		int count =0;
		if(head==null || head.next==null){
			return head;
		}
		while(fast!=null){
			count++;
			fast = fast.next;
		}
		if(k>count){
			k= k%count;
		}
		fast = head;
		for(int i=0; i < k;i++){
			fast =fast.next;
		}
		while(fast!=null && slow !=null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.display(head);
		System.out.println(findKthElement(head,8).data);
		

	}

}
