package BinarySearchTree;


public class Node<E extends Comparable<? super E>>{
	private E value;
	private Node<E> left;
	private Node<E> right;
	
	Node(E value){
		this.value = value;
		left = null;
		right = null;
	}
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	public Node<E> getLeft() {
		return left;
	}
	public void setLeft(Node<E> left) {
		this.left = left;
	}
	public Node<E> getRight() {
		return right;
	}
	public void setRight(Node<E> right) {
		this.right = right;
	}
}
