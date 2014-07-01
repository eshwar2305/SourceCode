/*
 * 2.2 Implement an algorithm to find the nth to last element of a singly linked list.
 * 
 */


import SingleLinkedList.Node;
import SinglyLinkedList.LinkedList;


public class NthToLastElementSinglyLinkedList {

	public int find(LinkedList sl,int n) {
		
		Node cur = sl.header;
		Node nthrunner = sl.header;
		
		while(n+1!=0){ // distance between 2 nodes must be n.
						// Hence move the cur pointer by n+1 times;
			cur = cur.next;
			n--;
		}
		
		while(cur != null){
			cur = cur.next;
			nthrunner = nthrunner.next;
		}
		return ((Integer) nthrunner.value).intValue();
	}



}

class NthToLastElementSinglyLinkedListMainClass{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		LinkedList sl = new LinkedList();
		sl.addFirst(2);
		sl.addFirst(2);
		sl.addFirst(8);
		sl.addFirst(3);
		sl.addFirst(2);
		sl.addFirst(8);
		sl.addFirst(1);
		sl.addFirst(3);
		sl.addFirst(2);
		
		sl.print();
		
		NthToLastElementSinglyLinkedList nld = new NthToLastElementSinglyLinkedList();

		int number = nld.find(sl,3);
		
		System.out.println("Nth to last number : " + number);
	
	}
	
}