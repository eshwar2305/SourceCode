package LinkedLists;

/*
 * 2.3 Implement an algorithm to delete a node in the middle of a single linked list, 
 * given only access to that node.
EXAMPLE
Input: the node ‘c’ from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a->b->d->e
 * 
 * 
 * The solution to this is to simply copy the data from the next node into 
 * this node and then delete the next node.
	NOTE: This problem can not be solved if the node to be deleted is the last 
	node in the linked list. That’s ok—your interviewer wants to see you point 
	that out. You could consider marking it as dummy in that case. This is an 
	issue you should discuss with your interviewer.
 */

import SinglyLinkedList.*;


public class DeleteNodeInMiddleSinglyLinkedList {

	public void deleteMiddleNode(LinkedList sl,Node delNode) {
		if(delNode.next != null){
			delNode.value = delNode.next.value;
			delNode.next = delNode.next.next;
		}
	}
}

class DeleteNodeInMiddleSinglyLinkedListMainClass{

	public static void main(String[] args) {
		DeleteNodeInMiddleSinglyLinkedList dls = new DeleteNodeInMiddleSinglyLinkedList();
		
		LinkedList sl = new LinkedList();
		sl.addFirst(2);
		sl.addFirst(2);
		sl.addFirst(8);
		sl.addFirst(3);
		Node delNode = sl.header;
		sl.addFirst(2);
		sl.addFirst(8);
		sl.addFirst(1);
		sl.addFirst(3);
		sl.addFirst(2);
		
		sl.print();
		
		dls.deleteMiddleNode(sl,delNode);
		
		sl.print();
	}
}
