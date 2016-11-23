package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node
{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
	}
	
	static void printSLL(Node head){
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.println("null");
	}
}
public class PalindromeLinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(3);
		head.next.next.next.next.next = new Node(1);

		Node head1 = new Node(5);
		head1.next = new Node(6);
		head1.next.next = new Node(7);
		head1.next.next.next = new Node(8);
		head.printSLL(head);
		System.out.println();
		//head1.printSLL(head1);
		Node head2 = MergeSort(head);
		head2.printSLL(head2);
		System.out.println();
		//PlaindromeList2(head);31
		

	}

	private static int PlaindromeList(Node head) {
		Node slow= head,fast = head;
		Node slow_prev = head;
		if(head==null){
			System.out.println(true);
			return 1;
		}
			
		while(fast!=null && fast.next!=null){
			slow_prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		int result = 0;
		if(fast==null){
			//even
			slow_prev.next = null;
			Node Secondhead = slow;
			Node reverseHead = ReverseList(Secondhead);
			// result = Comparelists(head,reverseHead);
			System.out.println(result);
			Secondhead  = ReverseList(reverseHead);
			slow_prev.next = Secondhead;
		}else{
			slow_prev.next = null;
			Node Secondhead = slow.next;
			Node reverseHead = ReverseList(Secondhead);
			// result = Comparelists(head,reverseHead);
			System.out.println("0dd"+result);
			Secondhead  = ReverseList(reverseHead);
			slow_prev.next = slow;
			slow.next = Secondhead;
			
		}
		return result;
	}
	
	
	private static Node PlaindromeList2(Node head) {
		Node slow= head,fast = head;
		Node slow_prev = head;
		if(head==null || head.next==null){
			System.out.println(true);
			return head;
		}
			
		while(fast!=null && fast.next!=null){
			slow_prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		Node result = null;
		if(fast==null){
			//even
			slow_prev.next = null;
			Node Secondhead = slow;
			Node reverseHead = ReverseList(Secondhead);
			 result = Comparelists(head,reverseHead);
			 result.printSLL(result);
		}else{
			slow_prev.next = null;
			Node Secondhead = slow.next;
			Node reverseHead = ReverseList(Secondhead);
			 result = Comparelists(head,reverseHead);
			 Node curr = result;
			 while(result.next!=null)
				 result= result.next;
			 slow.next = null;
			 result.next = slow;
			 curr.printSLL(curr);
			
		}
		return result;
	}

	private static Node Comparelists(Node head, Node head1) {
		Node dummy = new Node(0);
		Node pre = dummy;
		
		while(head!=null && head1!=null){
			pre.next = head;
			pre=pre.next;
			head = head.next;
			pre.next = head1;
			pre=pre.next;
			head1 = head1.next;
			
		}
		pre.next = head;
		
		return dummy.next;
	}

	private static Node ReverseList(Node secondhead) {
		Node prev=null,curr=secondhead, next;
		
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		secondhead = prev;
		return secondhead;
	}
	
	public static Node deleteDuplicates(Node a) {
		Node curr = a;
		Node prev = null;
		Node dummy = new Node(0);
		prev = dummy;
		prev.next = curr;
	   int flag =0 ;
	    while(curr!= null && curr.next!=null){
	        if(curr.data == curr.next.data){
	            curr.next = curr.next.next;	
	            flag =1;
	        }else{
	        	 if (flag ==0){
	        		 prev = curr;
	        		curr = curr.next;
	        		 
	        	 }
	        	 else{
	        		 flag=0;
	        		 prev.next = curr.next;
	        		 curr= curr.next;
	        	 }
	        	      	 
	        }
	     
	    }
	    if(flag == 1)
	    	  prev.next = curr.next;
	    return dummy.next;
	}
	
	public static Node Merge (Node head1 , Node head2){
		Node dummy = new Node(0);
	
		Node temp = dummy;
		
		if(head1==null)
			return head2;
		if(head2 ==null)
			return head1;
		while(head1!=null && head2!=null){
			if(head1.data <= head2.data){
				temp.next = head1;
				head1=head1.next;
			}
			else{
				temp.next = head2;
				head2=head2.next;
			}
			temp = temp.next;
		}
		
		if(head1 ==null)
			temp.next = head2;
		else
			temp.next = head1;
		
		return dummy.next;
	}
	
	
	
	public static Node MergeSort(Node head){
	
		Node curr = head;
	
		if(head ==null || head.next==null){
			return head;
		}
		Node a= null;
		Node b= null;
		
		if(head==null || head.next==null){
			 a = head;
			 b =null;
		}
		else{
			Node slow= head,fast = head;
			Node slow_prev = head;
				
			while(fast!=null && fast.next!=null){
				slow_prev = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			a = head;
			b = slow_prev.next;
			slow_prev.next = null;
		}
		
		Node h1 = MergeSort(a);
		Node h2 = MergeSort(b);
		
		Node merged = Merge(h1,h2);
		return merged;
	}
	
	 public static Node reverseList(Node head, int m, int n){
		 
		 Node curr = head, next = head, prev= null;
		 int count =0;
		 Node head2 = null;
		 Node head1 = null;
		 while(curr!=null){
			 count++;
			 if(count == m-1){
				 prev = curr;
				 head1 = curr.next;
			 }
			 if(count == n){
				 next = curr.next;
				 Node nextNode = next;
				 curr.next = null;
				 head2 = ReverseList(head1);
				 prev.next = head2;
				 
				 Node curr2 = head2;
				 
				 while(curr2.next!=null){
					 curr2 = curr2.next;
				 }
				 curr2.next = next;
				 curr = next;
			 }
			 if(curr!=null)
				 curr = curr.next;
			 
		 }
		
		return head;
		 
	 }
	 
	 public Node reverseBetween(Node head, int m, int n) {
		    if(head == null) return null;
		    Node dummy = new Node(0); // create a dummy node to mark the head of this list
		    dummy.next = head;
		    Node pre = dummy; // make a pointer pre as a marker for the node before reversing
		    for(int i = 0; i<m-1; i++) pre = pre.next;
		    
		    Node start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
		    Node then = start.next; // a pointer to a node that will be reversed
		    
		    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
		    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
		    
		    for(int i=0; i<n-m; i++)
		    {
		        start.next = then.next;
		        then.next = pre.next;
		        pre.next = then;
		        then = start.next;
		    }
		    
		    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
		    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
		    
		    return dummy.next;
		    
		}
	 
	 public static Node SwapPairs(Node head){
		 
		 if(head ==null || head.next== null)
			 return head;
		
		 Node dummy = new Node(0);
			    dummy.next = head;
			    Node current = dummy;
			    while (current.next != null && current.next.next != null) {
			    	Node first = current.next;
			    	Node second = current.next.next;
			        first.next = second.next;
			        current.next = second;
			        current.next.next = first;
			        current = current.next.next;
			    }
			    return dummy.next;
		
		
}
	 public static Node AddTwoNumbers(Node head1, Node head2,boolean carry){
			if(head1==null&& head2==null){
				if(carry){
					return new Node(1);
				}
				return null;
			}
			int sum =0;
			if(head1!=null){
				sum = sum +head1.data;
				head1=head1.next;
			}
			if(head2!=null){
				sum = sum +head2.data;
				head2=head2.next;
			}
			if(carry){
				sum = sum +1;
			}
			Node result = new Node(sum%10);
			carry = (sum/10==1);
			result.next = AddTwoNumbers(head1, head2, carry);
			return result;
		}
		public static Node addTwoNumbers(Node l1, Node l2) {
		    return AddTwoNumbers(l1, l2, false);
		}
		
	 public static void PartitionList(Node head, int b){
		 Node dummy = new Node(0);
		 dummy.next  = head;
		 Node prev = dummy;
		 Node curr = head;
		 while(curr!=null){
			 Node current = dummy;
			  while (current.next != null && current.next.next != null) {
				  if(current.next.data >= b && current.next.next.data < b){
			    	Node first = current.next;
			    	Node second = current.next.next;
			        first.next = second.next;
			        current.next = second;
			        current.next.next = first;
			        
			    
				  }
					
				  current = current.next;
			    }
			  curr = curr.next;
			 
		 }
		 dummy.next.printSLL(dummy.next);
	 }
	 
		public static Node deleteDuplicates1(Node head) {
			 Node dummy = new Node(0);
			 dummy.next  = head;
			
			 Node curr = dummy;
			 Node prev = curr;
			 if(head==null || head.next==null){
				 return head;
			 }
			 boolean flag = false;
			while(curr!=null && curr.next!=null){
				if(curr.data == curr.next.data){
					curr.next = curr.next.next;
					flag = true;
				}
				else{
				
					if(flag){
						prev.next = curr.next;
						flag = false;
					}
					else{
						prev = curr;
					}
						
						
					curr = curr.next;
				}
			}
			  if (flag) {
		            prev.next = curr.next;
		        }
			return dummy.next;
			
		}
		public Node mergeKLists(ArrayList<Node> a) {
			
		List<Node> result = new ArrayList<Node>();
			
		for(Node x : a){
			while(x!=null){
				result.add(x);
				x = x.next;
			}
		}
		
		Collections.sort(result, new Comparator<Node>() {
			public int compare(Node v1, Node v2){
				return v1.data - v2.data;
			}
		});
			
		Node dummy = new Node (0);
		for(Node y : result){
			dummy.next = y;
		}
		return dummy.next;
		
}
		
		public int isValidSudoku(final List<String> a) {
			HashSet<String> hs = new HashSet<>();
			for (int i = 0; i < a.size(); i++) {
				String row = a.get(i);
				for (int j = 0; j < row.length(); j++) {
					if (row.charAt(j) != '.') {
						int size = hs.size();
						String r = row.charAt(j) + "r" + i;
						String c = row.charAt(j) + "c" + j;
						String cell = row.charAt(j) + "cell" + (i / 3) + (j / 3);
						hs.add(r);
						hs.add(c);
						hs.add(cell);
						int newSize = hs.size();
						if (newSize - size != 3) {
							return 0;
						}
					}
				}
			}

			return 1;
		}
		
		
}
