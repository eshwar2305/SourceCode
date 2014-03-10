package SingleLinkedList;


public class Node {
	public Object value;
	public Node next;
	
	public Node(Object Value){
		this.value = Value;
		this.next = null;
	}
	
	public Node(){
		this.value = null;
		this.next = null;
	}
	
	public Node(Object Val,Node nxt){
		this.value = Val;
		this.next = nxt;
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}
