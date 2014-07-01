package SinglyLinkedList;





public class SinglyLinkedListMain {

	public static void main(String []args){
		LinkedList lnklst = new LinkedList();
		
		lnklst.addFirst(15);
		lnklst.addFirst(13);
		lnklst.addFirst(11);
		lnklst.addFirst(9);
		lnklst.addLast(17);
		lnklst.addAfter(10, 9);
		lnklst.addAfter(19, 17);
		lnklst.addAfter(14, 13);
		
		lnklst.print();
		
		//lnklst.remove(17);
		
		lnklst.print();
		lnklst.reverseList();
		lnklst.print();
		lnklst.reverseRecurrsion();
		lnklst.print();
		
		
	}
}
