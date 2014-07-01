package queue;

public class Queue {

	int q[];
	public void enQueue(int i) {
		// TODO Auto-generated method stub
		
	}

	public int deQueue() {
		return 0;
		// TODO Auto-generated method stub
		
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

	

}

class QueueMainClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue q = new Queue();
		
		q.enQueue(3);
		q.enQueue(8);
		q.enQueue(16);
		q.enQueue(5);
		q.enQueue(19);
		q.enQueue(23);
		
		int j = q.deQueue();
		System.out.println(" Number out : " + j);
		j = q.deQueue();
		System.out.println(" Number out : " + j);

		
		q.print();

	}
}