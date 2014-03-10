/*
 * 2.1 Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */

import SingleLinkedList.*;

public class RemoveDuplicateSinglyLinkedList {

	public void removeDuplicates(LinkedList sl) {
		
		if(sl.header == null){
			return;
		}
		Node prev = sl.header;
		Node cur = prev.next;
		
		while(cur != null){// Check for earlier dups
			Node runner = sl.header;
			while(runner != cur){
				if(cur.value == runner.value){
					prev.next = cur.next;// remove current
					cur = prev.next;// update current to next node
					break;// all other dups have already been removed
				}
				runner = runner.next;
			}
			if(runner == cur){// current not updated - update now
				prev = cur;
				cur = prev.next;
			}
		}
		
		
	}



}

class RemoveDuplicateSinglyLinkedListMainClass{
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
		
		RemoveDuplicateSinglyLinkedList rmd = new RemoveDuplicateSinglyLinkedList();

		rmd.removeDuplicates(sl);
		
		sl.print();
	}	
}
