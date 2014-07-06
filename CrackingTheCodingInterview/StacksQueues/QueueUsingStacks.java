package StacksQueues;

/*3.5 Implement a MyQueue class which implements a queue using two stacks.
 * 
 */

import Stack.StackArray;

public class QueueUsingStacks {
		
	StackArray s1,s2;
	public QueueUsingStacks(){
		StackArray s1 = new StackArray();
		StackArray s2 = new StackArray();	
	}
	
	public int size(){
		return s1.size() + s2.size();
	}
	
	public void add(int val){
		if(!s1.isEmpty()) s1.push(val);
		
		while(!s2.isEmpty()) s1.push(s2.pop());
		
		s1.push(val);
	}
	
	public int remove(){
		if(!s2.isEmpty()) return s2.pop();
		
		while(!s1.isEmpty()) s2.push(s1.pop());
		
		return s2.pop();
	}
	
	public int peek(){
		if(!s2.isEmpty()) return s2.peek();
		
		while(!s1.isEmpty()) s2.push(s1.pop());
		
		return s2.peek();
	}
	

}

class QueueUsingStacksMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackArray stArr = new StackArray();
				stArr.push(23);
				stArr.push(33);
				stArr.push(43);
				stArr.push(53);
				stArr.push(63);
				stArr.push(13);
				stArr.push(24);
				stArr.push(58);
		stArr.printStack();
		System.out.println();
		
		SortAStackInAscendingOrder sc = new SortAStackInAscendingOrder();
		
		sc.sort(stArr);
		
		stArr.printStack();
				
	}
}
