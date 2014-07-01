package BinarySearchTree;


public class TreeMainProgram {
	
	public static void main(String[] args){
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>( );
        
		t.remove(6);
		t.insert(14);
		t.insert(18);
		t.insert(4);
		t.insert(56);
		t.insert(1);
		t.insert(17);
		t.printTree();
		System.out.println();
		t.remove(18);
		t.printTree();
		System.out.println("Min=" + t.findMin());
		System.out.println("Max=" + t.findMax());
		if(t.find(4))
			System.out.println("Search 4 = Yes");
		else
			System.out.println("Search 4 = No");

		System.out.println("Depth = "+t.depth());
		System.out.println("Num of Nodes = "+t.numOfNodes());
		
	}
}
