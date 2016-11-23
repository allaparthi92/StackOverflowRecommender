package LinkedLists;

public class Node {

	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

	public void display(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("null");
	}
}