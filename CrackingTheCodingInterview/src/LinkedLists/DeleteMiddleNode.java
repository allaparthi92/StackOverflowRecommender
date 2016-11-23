package LinkedLists;

public class DeleteMiddleNode {
	
	public static boolean deleteMiddleNode(Node node){
		
		if(node == null || node.next==null){
			return false;
		}
		Node nextNode = node.next;
		node.data = nextNode.data;
		node.next = nextNode.next;
		return true;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.display(head);
		deleteMiddleNode(head.next.next);
		head.display(head);
		
	}

}
