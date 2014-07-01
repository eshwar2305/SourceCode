package BinarySearchTree;

import java.math.BigInteger;
import java.util.Set;


public class BinarySearchTree<E extends Comparable<? super E>> {
	private Node<E> root;
	
	BinarySearchTree(){
		root = null;
	}
	
	public void insert(E value){
		root = insert(root, value);
	}
	
	public void remove(E value){
		root = remove(root, value);
	}
	
	public E findMin(){
		return (findMin(root)).getValue();
	}
	
	public E findMax(){
		return (findMax(root)).getValue();
	}
	
	public boolean find(E value){
		return (find(root,value))==null ? false:true;
	}
	
	private Node<E> find(Node<E> n, E value) {
		if(n == null)
			return null;
		else if(n.getValue().compareTo(value) > 0)
			return find(n.getLeft(),value);
		else if(n.getValue().compareTo(value) < 0)
			return find(n.getRight(),value);
		else
			return n;
	}

	public void printTree(){
		if(this.isEmpty())
			System.out.println("Tree is empty");
		else
			printTree(root);
	}
	
	private Node<E> insert(Node<E> n,E value){	
		if(n == null && value != null){
			n = new Node<E>(value);	
		}else if(n.getValue().compareTo(value) > 0){
			n.setLeft(insert(n.getLeft(),value));
		}else if(n.getValue().compareTo(value) < 0){
			n.setRight(insert(n.getRight(),value));
		}else{
			//do nothing ... its a duplicate
		}
		
		return n;
	}
	
	private Node<E> remove(Node<E> n, E value){
		if(n == null){
			return n;
		}else if(n.getValue().compareTo(value) > 0){
			n.setLeft(remove(n.getLeft(),value));
		}else if(n.getValue().compareTo(value) < 0){
			n.setRight(remove(n.getRight(), value));
		}else if(n.getLeft() != null && n.getRight() != null){
			E ele = (findMin(n.getRight())).getValue();
			n.setValue(ele);
			n.setRight(remove(n.getRight(),ele));
		}else{
			n = (n.getLeft() != null) ? n.getLeft() : n.getRight();
		}		
		return n;
	}

	private Node<E> findMin(Node<E> n) {		
		if(n == null)
			return null;
		else if(n.getLeft() == null)
			return n;
		else
			return findMin(n.getLeft());
	}
	
	private Node<E> findMax(Node<E> n){
		if(n==null)
			return null;
		else if(n.getRight() == null)
			return n;
		else
			return findMax(n.getRight());
	}
	
	public boolean isEmpty(){
		if(root == null) return true;
		else return false;
	}

	public void PreorderprintTree(Node<E> n){
		//preorder
		if(n != null){
			System.out.print(n.getValue() + "->");
			PreorderprintTree(n.getLeft());
			PreorderprintTree(n.getRight());
		}
	}
	
	public void printTree(Node<E> n){
		//inorder
		if(n != null){
			printTree(n.getLeft());
			System.out.print(n.getValue() + "->");
			printTree(n.getRight());
		}
	}
	
	public void PostorderprintTree(Node<E> n){
		//Postorder
		if(n != null){
			PostorderprintTree(n.getLeft());
			PostorderprintTree(n.getRight());
			System.out.print(n.getValue() + "->");
		}
	}
	
	
	
	public int depth(){
		return depth(root);
	}
	
	public int numOfNodes(){
		return numOfNodes(root);
	}
	
	public int numOfNodes(Node<E> n){
		if(n == null) return 0;
		
		return (1+numOfNodes(n.getLeft()) + numOfNodes(n.getRight()));
	}
	public int depth(Node<E> n){
		
		if(n == null) return 0;
		
		int leftTree = depth(n.getLeft());
		int rightTree = depth(n.getRight());
		
		if(leftTree > rightTree){
			return (1+leftTree);
		}else{
			return (1+rightTree);
		}
	}
	
	public boolean isBalanced(){
		return isBalanced(root);
	}
	
	private boolean isBalanced(Node<E> n){
		return maxDepth(n)-minDepth(n) <= 1 ? true:false; 
	}
	
	public int maxDepth(Node<E> n){
		if(n == null) return 0;
		
		return 1 + max(maxDepth(n.getLeft()),maxDepth(n.getRight()));
	}
	
	public int minDepth(Node<E> n){
		
		if(n == null) return 0;
		
		return 1+ min(minDepth(n.getLeft()),minDepth(n.getRight()));
	}

	private int min(int minDepth, int minDepth2) {
		return (minDepth < minDepth2) ? minDepth:minDepth2;
	}

	private int max(int maxDepth, int maxDepth2) {
		return (maxDepth > maxDepth2) ? maxDepth:maxDepth2;
	}
	
	public int LowetCommonAncestor(Node<E> root,E n1,E n2){
		
		 /* If we have reached a leaf node then LCA doesn't exist
	     If root->data is equal to any of the inputs then input is
	     not valid. For example 20, 22 in the given figure */
	 
		/* if(root == NULL || root->data == n1 || root->data == n2)
	    return -1; */
		
		 /* If any of the input nodes is child of the current node
	     we have reached the LCA. For example, in the above figure
	     if we want to calculate LCA of 12 and 14, recursion should
	     terminate when we reach 8*/
	
		/*  if((root->right != NULL) &&
	    (root->right->data == n1 || root->right->data == n2))
	    return root->data;
	  if((root->left != NULL) &&
	    (root->left->data == n1 || root->left->data == n2))
	    return root->data;    
	 
	  if(root->data > n1 && root->data < n2)
	    return root->data;
	  if(root->data > n1 && root->data > n2)
	    return leastCommanAncestor(root->left, n1, n2);
	  if(root->data < n1 && root->data < n2)
	    return leastCommanAncestor(root->right, n1, n2);*/
	  
		return 0;
	}
	
	/* This function returns true if S is a subtree of T, otherwise false */
	public boolean checkIfSubtree(Node<E> T, Node<E> S){
		   /* base cases */
	   /* if (S == NULL)
	        return true;
	 
	    if (T == NULL)
	        return false;
	 
	    /* Check the tree with root as current node */
	   /* if (areIdentical(T, S))
	        return true;*/
	 
	    /* If the tree with root as current node doesn't match then
	       try left and right subtrees one by one */
	   /* return isSubtree(T->left, S) ||
	           isSubtree(T->right, S);**/
		
		return true;
	}
	
	/* A utility function to check whether trees with roots as root1 and
	   root2 are identical or not */
	public boolean areIdentical(Node<E> root1, Node<E> root2)
	{
		
	    /* base cases */
	   /* if(root1 == NULL && root2 == NULL)
	        return true;
	 
	    if(root1 == NULL || root2 == NULL)
	        return false;*/
	 
	    /* Check if the data of both roots is same and data of left and right
	       subtrees are also same */
	   /* return (root1->data == root2->data   &&
	            areIdentical(root1->left, root2->left) &&
	            areIdentical(root1->right, root2->right) );*/
		return false;
	}
	
/*	public boolean checkBST(){
		if(checkBST(root,-1,100)){
			return true
		Else 
			return false;
	}

	private boolean checkBST(Node n,int min, int max){
		if(n ==  null ) return true;

		If(n.data > min && n.data < max){
			If(checkBST(n.left,min,n.data) && checkBST(n.right,n.data,max) ){
				Return true;
			}
		}
		Return false;
	}


	2nd method
		Int []array = new array[]MAX_SIZE];
		Int count = 0;

	Public boolean isBST(){
		inorderTraversal(root);

	//Check if array is in ascending order, then it is a bst;
		For(i=o;i<array.size;i++){
			If(array[I] > array [i+1]){
				Return false;
			}
		}
		Return true;
	}

	}
	
	Private void inorderTravesral(Node n){
	If(root == null) return;
	inorderTraversal(n.left);
	Array[count ++] = n.data;
	Inordertraversal(n.right);
	}*/
}
