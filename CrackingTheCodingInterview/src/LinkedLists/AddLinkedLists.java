package LinkedLists;

public class AddLinkedLists {

	public static Node AddTwoNumbers(Node head1, Node head2, boolean carry) {
		if (head1 == null && head2 == null) {
			if (carry) {
				return new Node(1);
			}
			return null;
		}
		int sum = 0;
		if (head1 != null) {
			sum = sum + head1.data;
			head1 = head1.next;
		}
		if (head2 != null) {
			sum = sum + head2.data;
			head2 = head2.next;
		}
		if (carry) {
			sum = sum + 1;
		}
		Node result = new Node(sum % 10);
		carry = (sum / 10 == 1);
		result.next = AddTwoNumbers(head1, head2, carry);
		return result;
	}

	public static Node addTwoNumbers(Node l1, Node l2) {
		return AddTwoNumbers(l1, l2, false);
	}

	public static void main(String[] args) {

		Node head1 = new Node(7);
		head1.next = new Node(1);
		head1.next.next = new Node(6);

		Node head2 = new Node(5);
		head2.next = new Node(9);
		head2.next.next = new Node(2);

		Node node = addTwoNumbers(head1, head2);
		node.display(node);

	}

}
