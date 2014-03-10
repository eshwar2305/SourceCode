package SingleLinkedList;


public class LinkedList {
	public Node header;
	public Node last;
	
	public LinkedList(){
		header = null;
		last = header;
	}
	
	public void addLast(Object val){
		Node n = new Node(val);
		if(header == null){
			header = n;
			last = n;
			last.next = null;
		}else{
			last.next = n;
			last = last.next;
		}
	}
	
	public void addFirst(Object val){
		Node n = new Node(val);
			if(header == null){
				header = n;
				last = n;
				last.next = null;
			}else{
				n.next = header;
				header = n;
			}
	}
	
	public void addAfter(Object val, Object afterVal){
		Node n = new Node(val);
		
		if(header==null) {
			System.out.println("Error-Element Not added");
			return;
		}else{
			Node cur = header;
			do{
				if(cur.getValue().equals(afterVal)){
					n.next = cur.next;
					cur.next = n;
					if(cur == last){
						last = n;
					}
					break;
				}else{
					cur = cur.next;
				}
			}while(cur !=null);
		}
		
	}
	
	public void remove(Object Val){
		if(header == null){
			return;
		}else{
			Node cur = new Node();
			Node prev = null;
			cur = header;
			do{
				if(cur.getValue().equals(Val)){
					if(cur == header){
						header = cur.next;
						break;
					}
					else{
						prev.next = cur.next;
						break;
					}
				}else{
					prev = cur;
					cur = cur.next;
				}
			}while(cur != null);
		}
	}
	
	public void print(){
		Node cur = header;
		while(cur!= null){
			System.out.print(cur.getValue() + "->");
			cur = cur.next;
		}
		System.out.println("null");
	}
	
	public void reverseList(){
		Node prev = null ;
		Node cur = header;
		Node front;
		last = header;
		while(cur != null){
			front = cur.next;
			cur.next = prev;
			prev = cur;
			cur = front;
		}
		header = prev;
	}
	
	private void reverse(Node head){
		Node first,rest;
		if(head == null) return;
		
		first = head;
		rest = first.next;
		
		if(rest == null) {
			header = first;
			return;
		}
		
		reverse(rest);

		first.next.next = first;
		first.next = null;
		
	}
	public void reverseRecurrsion(){
		reverse(header);
	}
	
	
	//Finding loop in a single linked list
	Node FindLoopBeginning(Node head) { 
		Node n1 = head; 
		Node n2 = head; 

		// Find meeting point 
		while (n2.next != null) { 
		n1 = n1.next; 
		n2 = n2.next.next; 
		if (n1 == n2) { 
		break; 
		} 
		} 

		// Error check - there is no meeting point, and therefore no loop 
		if (n2.next == null) { 
		return null; 
		} 

		/* Move n1 to Head. Keep n2 at Meeting Point. Each are k steps 
		/* from the Loop Start. If they move at the same pace, they must 
		meet at Loop Start. */ 

		n1 = head; 
		while (n1 != n2) { 
		n1 = n1.next; 
		n2 = n2.next; 
		} 

		// Now n2 points to the start of the loop. 
		return n2; 

		}
	
}
