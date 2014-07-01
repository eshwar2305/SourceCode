/*
 * 2.5 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, 
so as to make a loop in the linked list.
EXAMPLE
input: A -> B -> C -> D -> E -> C [the same C as earlier]
output: C
*
*
*
*
*
 */

import SinglyLinkedList.*;


public class FindCircularSinglyLinkedList {

	public int getIntersectionPoint(LinkedList sl) {
		
		if(sl.header == null) return -1;
		
		Node n1,n2;
		
		n1 = sl.header.next;
		n2 = sl.header.next.next;
		
		while(n1 != n2){
			n1 = n1.next;
			n2 = n2.next.next;
		}
		
		n1=sl.header;
		
		while(n1!=n2){
			n1=n1.next;
			n2=n2.next;
		}
		
		return ((Integer)n1.value).intValue();
	}
}

class FindCircularSinglyLinkedListMainClass{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedList sl = new LinkedList();
		sl.addFirst(20);
		Node last = sl.header;
		sl.addFirst(2);
		sl.addFirst(8);
		sl.addFirst(3);
		sl.addFirst(2);
		sl.addFirst(8);
		Node point = sl.header;
		last.next = point;
		sl.addFirst(1);
		sl.addFirst(3);
		sl.addFirst(2);
		
		//sl.print();
		
		FindCircularSinglyLinkedList fsl = new FindCircularSinglyLinkedList();
		
		int val = fsl.getIntersectionPoint(sl);
		
		System.out.println("Intersection point Node value : " + val);

	}
}
