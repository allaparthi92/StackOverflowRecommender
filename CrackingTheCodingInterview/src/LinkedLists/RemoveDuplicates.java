package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(4);
		head.display(head);
		//Node head2 = removeDuplicatesII(head);
		//head2.display(head2);
	}

	public static Node removeDuplicates(Node head) {

		if (head == null) {
			return head;
		}
		Set<Integer> set = new HashSet<>();
		Node curr = head;
		Node prev = head;
		while (curr != null) {
			if (set.contains(curr.data)) {
				prev.next = curr.next;
			} else {
				prev = curr;
			}
			set.add(curr.data);
			curr = curr.next;
		}

		return head;

	}
	
	

}
