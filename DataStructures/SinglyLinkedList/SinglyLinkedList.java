package SinglyLinkedList;

public class SinglyLinkedList {

	Node1 head;
	Node1 tail;
	
	public SinglyLinkedList(){
		head = null;
		tail = head;
	}
	
	public void addFirst(int i) {
		// TODO Auto-generated method stub
		Node1 n = new Node1(i);
		if(head == null){
			head = n;
			head.next = null;
			tail = head;
		}else{
			n.next = head;
			head = n;
		}
		display();
	}


	public void addLast(int i) {
		// TODO Auto-generated method stub
		Node1 n = new Node1(i);
		if(tail == null){
			tail = n;
			head = n;
			n.next = null;
		}else{
			tail.next = n;
			n.next = null;
			tail = n;
		}
		display();
	}
	
	public int removeFirst() {
		int val;
		if(head == null){
			System.out.println("removeFirst : Nothing to remove");
			return -1;
		}else{
			System.out.println("removeFirst : " + head.value +" is reomved");
			val = head.value;
			head = head.next;
			if(head == null) tail = null;
		}
		display();
		return val;
	}

	public int removeLast() {
		int val;
		if(tail == null){
			System.out.println("removeLast : Nothing to remove");
			val = -1;
			return val;
		}else{
			System.out.println("removeLast: " + tail.value + " is removed");
			val = tail.value;
			Node1 cur = head;

			if(cur == tail){
				tail = head = null;
			}else{
				while(cur.next != tail){
					cur = cur.next;
				}
				cur.next = null;
				tail = cur;
			}
		}
		display();
		return val;
	}

	public void removeNode(int i) {
		if(head == null){
			System.out.println("removeNode : Nothing to remove");
			return;
		}else if(head.value == i){
			System.out.println("removeNode : " + head.value +" is reomved");
			head = head.next;
		}else{
			System.out.println("removeNode : " + i +" is reomved");
			Node1 cur = head.next;
			Node1 prev =head;
			while(cur.value != i){
				prev = cur;
				cur = cur.next;
			}
			prev.next = cur.next;
		}
		display();
		
	}

	public void display() {
		// TODO Auto-generated method stub
		if(head == null){
			System.out.println("List is Empy!!");
		}
		Node1 cur = head;
		while(cur != null){
			System.out.print(cur.value+"->");
			cur = cur.next;
		}
		System.out.println();
	}

	public void insertAfter(int i, int j) {
		// TODO Auto-generated method stub
		Node1 n= new Node1(i);
		Node1 cur = head;
		while(cur.value != j){
			cur = cur.next;
		}
		n.next = cur.next;
		cur.next = n;
		display();
	}

	public void insertBefore(int i, int j) {
		// TODO Auto-generated method stub
		Node1 n = new Node1(i);
		
		if(head.value == j){
			n.next = head;
			head = n;
		}else{
			Node1 prev,cur;
			prev = head;
			cur = head.next;
			
			while(cur.value != j){
				prev = cur;
				cur = cur.next;
			}
			
			prev.next = n;
			n.next = cur;
			
		}
		display();
	}

	public void reverseIterate() {
		// TODO Auto-generated method stub
		if(head == null){
			System.out.println("reverseIterate: Reverse no possible. Lsit empty!");
		}else if(head == tail){
			System.out.println("reverseIterate: Only one node.");
		}else{
			tail = head;
			Node1 cur,prev,front;
			prev = null;
			cur = head;
			 while(cur != null){
				 front = cur.next;
				 cur.next = prev;
				 prev = cur;
				 cur = front; 
			 }
			 head = prev;
		}
		display();
	}

	private void displayReverse() {
		// TODO Auto-generated method stub
		if(head == null){
			System.out.println("List is Empy!!");
		}
		Node1 cur = head;
		while(cur != null){
			System.out.print(cur.value+"<-");
			cur = cur.next;
		}
		System.out.println();
	}

	public void reverseRecurrsion() {
		// TODO Auto-generated method stub
		reverserecur(head);
		display();
	}

	private void reverserecur(Node1 n) {
		// TODO Auto-generated method stub
		if(n.next == null){
			head = n;
			return;
		}
		Node1 cur = n.next;
		reverserecur(cur);
		cur.next = n;
		tail = n;
		tail.next = null;
	}
	
	public boolean isEmpty(){
		if(head == null) return true;
		return false;
	}
}

class Node1{
	public Node1(int i) {
		this.value = i;
	}
	int value;
	Node1 next;
}
class SinglyLinkedListMainCLass{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList sl = new SinglyLinkedList();
		
		sl.addFirst(1);
		sl.removeLast();
		sl.addFirst(1);
		sl.addFirst(2);
		sl.addLast(5);
		sl.insertAfter(3,2);
		sl.insertBefore(5,1);
		sl.reverseIterate();
		sl.reverseRecurrsion();
		sl.removeFirst();
		sl.removeLast();
		sl.removeNode(1);
		//sl.display();

	}
}