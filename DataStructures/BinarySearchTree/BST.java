import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author enarayan
 *
 */
public class BST {
	
	Node root = null;
	BST(int[] arr){
		int n = arr.length;
		this.root = constructBST(arr,0,n);
		this.root = new Node(arr[0]);
		for(int i=0;i<n;i++){
			if(arr[i] != 0){
				
			}
		}
	}
	/**
	 * @param arr
	 * @param n
	 * @return
	 */
	public Node constructBST(int[] arr, int pos,int n) {	
		if(pos < n){
			Node root = new Node(arr[pos]);
			
			root.left = constructBST(arr, 2*pos+1, n);
			root.right = constructBST(arr, 2*pos+2, n);
			return root;
		}
		return null;
	}
	
	
	public void preorder(Node root){
		if(root == null) return;
		
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public void inorder(Node root){
		if(root == null) return;
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public void postorder(Node root){
		if(root == null) return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
		
	}
	public void inorderIterative(Node root){
		if(root ==  null)return ;
		
		Deque<Node> st = new LinkedList<Node>();
		Node cur = root;
		
		while(true){
			if(cur != null){
				st.offerFirst(cur);
				cur = cur.left;
			}else{
				if(!st.isEmpty()){
					cur = st.pollFirst();
					System.out.print(cur.data + " ");
					cur = cur.right;
				}else{
					break;
				}
			}
		}
	}
	
	public void preorderIterative(Node root){
		if(root == null) return;
		
		Deque<Node> st = new LinkedList<Node>();
		Node cur = root;
		st.offerFirst(cur);
		
		while(st.isEmpty()){
			cur = st.pollFirst();
			System.out.println(cur.data + " ");
			if(cur.right != null) st.offerFirst(cur.right);
			if(cur.left != null) st.offerFirst(cur.left);
		}
		
	}
	
	public void levelorder(Node root){
		if(root == null) return;
		
		Deque<Node> q = new LinkedList<Node>();
		q.offerLast(root);
		
		while(q.isEmpty()){
			Node cur = q.pollFirst();
			System.out.print(cur.data + " ");
			
			if(cur.left != null) q.offerLast(cur.left);
			if(cur.right != null) q.offerLast(cur.right);
		}
	}
	
	
	public Node insert(Node root,int key){
		if(root == null) return new Node(key);
		
		if(key < root.data) root.left = insert(root.left, key);
		if(root.data > key) root.right = insert(root.right, key);
		
		return root;
	}
	
	public boolean search(Node root, int key){
		if( root == null) return false;
		
		if(key == root.data) return true;
		if(key < root.data) return search(root.left, key);
		return search(root.right, key);
	}

	public Node delete(Node root,int key){
		if(root == null) return null;
		
		if(key < root.data) root.left = delete(root.left,key);
		else if(root.data > key) root.right = delete(root.right,key);
		else{
			if(root.left == null && root.right == null){
				root=null;
			}else if(root.left != null && root.right != null){
				Node temp = findMin(root.right);
				root.data = temp.data;
				root.right = delete(root.right, temp.data);
			}else if(root.left != null){
				root = root.right;
			}else{
				root = root.left;
			}
		}
		return root;
	}
	/**
	 * @param right
	 * @return
	 */
	public Node findMin(Node right) {
		if(root == null)
			return null;
		
		while(root.left != null)
			root = root.left;
		
		return root;
	}
	
	public Node findMax(Node right) {
		if(root == null)
			return null;
		
		while(root.right != null)
			root = root.right;
		
		return root;
	}
	
	public Node inorderSuc(Node root,Node n){
		if(root == null) return null;
		
		if(n.right != null) return findMin(n.right);
		
		Node insuc = null;
		
		while(true){
			if(n.data < root.data){
				insuc = root;
				root = root.left;
			}else if(n.data > root.data){
				root = root.right;
			}else{
				break;
			}
		}
		if(insuc!=null)
			System.out.println("Inorder Successor of " + n.data + " is = " + insuc.data );
		else
			System.out.println("Inorder Successor of " + n.data + " is = NULL" );
		return insuc;
	}
	
	public Node inorderPre(Node root,Node n){
		if(root == null) return null;
		
		if(n.left != null) return findMax(n.left);
		
		Node inpre = null;
		
		while(true){
			if(n.data < root.data){
				root = root.left;
			}else if(n.data > root.data){
				inpre = root;
				root = root.right;
			}else{
				break;
			}
		}
		if(inpre!=null)
			System.out.println("Inorder Predesscor of " + n.data + " is = " + inpre.data );
		else
			System.out.println("Inorder Predesscor of " + n.data + " is = NULL" );
		return inpre;
	}
	
	boolean isBST(Node root,int min, int max){
		if(root == null) return true;
		
		if(min < root.data && root.data < max)
			return isBST(root.left, min, root.data-1) &&
					isBST(root.right, root.data+1, max);
		
		return false;
	}
	
	
	int[] BSTtoSortedArray(Node root){
		int n = sizeOfBST(root);
		int[] arr = new int[n];
		
		BSTtoSortedArrayUTIL(root,0,arr);
		
		for(int i:arr)
			System.out.print(arr[i] + " ");
		return arr;	
	}

	private int BSTtoSortedArrayUTIL(Node root, int pos, int[] arr) {
		if(root.left != null){
			pos = BSTtoSortedArrayUTIL(root.left, pos, arr);
		}
		
		arr[pos] = root.data;
		pos = pos + 1;
		
		if(root.right != null){
			pos = BSTtoSortedArrayUTIL(root.right, pos, arr);
		}
			
		return pos;			
	}
	
	public Node BSTtoSortedDLLUTIL(Node root,Node prev){
		if(root.left != null){
			prev = BSTtoSortedDLLUTIL(root.left, prev);
		}
		
		if(prev != null){
			prev.right = root;
		}
		root.left = prev;
		prev = root;
		
		if(root.right != null){
			prev = BSTtoSortedDLLUTIL(root.right, prev);
		}
		
		return prev;	
	}
	
	public Node SortedArrayToBST(int[] arr){
		int n = arr.length;
		
		return SortedArrayToBSTUTIL(arr,0,n-1);
	}
	
	public Node SortedArrayToBSTUTIL(int[] arr,int l,int r){
		if(l<r){
			if(l==r) return new Node(arr[l]);
			
			int mid = l + (r-l)/2;
			Node root = new Node(arr[mid]);
			
			root.left = SortedArrayToBSTUTIL(arr, l, mid-1);
			root.right = SortedArrayToBSTUTIL(arr, mid+1, r);
			return root;
		}
		return null;
	}
	
/*	Static Node head;
	Node ConvertSortedDLLtoBST(int st, int end){
		if(st > end) return null;
		Int mid = st + (end-st)/2;

		Node left = ConvertSortedDLLtoBST(st,mid-1);
		Node root = head;
		Head = head->next;
		root->prev = left;
		Node right = ConvertSortedDLLtoBST(mid+1,end);
		root->next = right;
		
		Return root;
	}



	Static Node head;
	Node ConvertSortedLLToBST(int st,int end){
		if(st > end) return null;
		Int mid = st + (end-st)/2;

		Node left = ConvertSortedLLtoBST(st,mid-1);
		Node root = new Node(head->data);
		root->left = left;
		Head = head -> next;
		Node right = ConvertSortedLLtoBST(mid+1,end);
		root->right = right;

		Return root;
	}*/
	/**
	 * @param root2
	 * @return
	 */
	private int sizeOfBST(Node root) {
		if(root == null)
			return 0;
		
		return 1 + sizeOfBST(root.left) + sizeOfBST(root.right);
	}
	
	
	boolean findSumPair(Node root,int sum){
		if(root == null) return false;
		
		Node cur1 = root;
		Node cur2 = root;
		
		Deque<Node> st1 = new LinkedList<Node>();
		Deque<Node> st2 = new LinkedList<Node>();
		
		boolean flag1 = false;
		boolean flag2 = false;
		while(true){
			
			while(true){
				if(cur1 != null){
					st1.offerFirst(cur1);
					cur1 = cur1.left;
				}else{
					if(!st1.isEmpty()){
						cur1 = st1.pollFirst();
						flag1 = true;
						break;
					}else{
						break;
					}
				}
			}
			
			while(true){
				if(cur2 != null){
					st2.offerFirst(cur2);
					cur2 = cur2.right;
				}else{
					if(!st2.isEmpty()){
						cur2 = st2.pollFirst();
						flag2 = true;
					}else{
						break;
					}
				}
			}
			
			if(flag1 && flag2 && cur1.data < cur2.data){
				if(cur1.data + cur2.data == sum) return true;
				else if(cur1.data + cur2.data < sum){
					cur1 = cur1.right;
					flag1 = false;
				}else{
					cur2 = cur2.left;
					flag2 = false;
				}
			}else{
				return false;
			}
		}
	}
	
	
	Node convertBTtoBST(Node root){
		if(root == null) return null;
		
		int size = sizeOfBST(root);
		int[] arr = new int[size];
		BTtoArray(root,0,size,arr);
		
		Arrays.sort(arr);
		
		return SortedArrayToBST(arr);
	}

	private int BTtoArray(Node root,int pos,int n,int[] arr) {
		if(root.left == null){
			pos = BTtoArray(root.left, pos, n, arr);
		}
		
		arr[pos] = root.data;
		pos = pos + 1;
		
		if(root.left == null){
			pos = BTtoArray(root.left, pos, n, arr);
		}
		
		return pos;
	}
	
	public void printGivenLevel(Node root,int level){
		if(root == null) return;
		printGivenLevelUTIL(root, 0, level);
	}
	
	public void printGivenLevelUTIL(Node root,int cur,int level){
		if(root == null) return;
		
		if(cur == level){
			System.out.println(root.data);
		}else{
			printGivenLevelUTIL(root.left, cur+1, level);
			printGivenLevelUTIL(root.right, cur+1, level);
		}
	}
	
	public void printGivenLevelIterative(Node root,int level){
		if(root == null) return;
		Deque<Node> q = new LinkedList<Node>();
		
		q.addLast(root);
		q.addLast(null);
		int count = 0;
		while(!q.isEmpty()){
			Node cur = q.pollFirst();
			if(cur == null){
				if(q.isEmpty()){
					break;
				}else{
					q.offerLast(null);
					count++;
				}
			}else{
				if(count == level){
					System.out.println(cur.data);
				}else if(count > level){
					break;
				}
				if(cur.left!=null)q.offerLast(cur.left);
				if(cur.right!=null)q.offerLast(cur.right);
			}
		}	
	}
	
	int height(Node root){
		if(root == null) return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public int heightIterative(Node root){
		if(root == null) return 0;
		Deque<Node> q = new LinkedList<Node>();
		
		q.addLast(root);
		q.addLast(null);
		int count = 0;
		while(!q.isEmpty()){
			Node cur = q.pollFirst();
			if(cur == null){
				if(q.isEmpty()){
					break;
				}else{
					q.offerLast(null);
					count++;
				}
			}else{
				if(cur.left!=null)q.offerLast(cur.left);
				if(cur.right!=null)q.offerLast(cur.right);
			}
		}	
		return count;
	}
	
	public int diameter(Node root){
		if(root == null) return 0;
		
		int rootdiameter = 1+height(root.left) + height(root.right);
		return Math.max(rootdiameter, Math.max(diameter(root.left), diameter(root.right)));
	}
	
	public int diameter(Node root,Wrapper wrp){
		if(root == null) return 0;
		
		Wrapper lwrp = new Wrapper();
		Wrapper rwrp = new Wrapper();
		
		int ldiameter = diameter(root.left,lwrp);
		int rdiameter = diameter(root.right,rwrp);
		int rootdiameter = 1 + lwrp.h + rwrp.h;
		
		wrp.h = 1 + Math.max(lwrp.h, rwrp.h);
		
		return Math.max(rootdiameter, Math.max(ldiameter, rdiameter));
	}
	
	public int width(Node root){
		if(root == null) return 0;
		
		Deque<Node> q = new LinkedList<Node>();
		q.offerLast(root);
		q.offerLast(null);
		int count = 0;
		int max = Integer.MIN_VALUE;
		
		while(!q.isEmpty()){
			Node cur = q.pollFirst();
			if(cur == null){
				max = Math.max(count, max);
				count = 0 ;
				if(q.isEmpty()){
					break;
				}
				q.offerLast(null);
			}else{
				if(cur.left!=null)q.offerLast(cur.left);
				if(cur.right!=null)q.offerLast(cur.right);
				count++;
			}
		}
		return max;	
	}
	
	/* Inorder and Preorder */
	//Static int i = 0;
	Node ConstuctBTwithInPre(int[] in,int[] pre,int st,int end){
		int i=0;//use static above
		if(st<end){
			if(st == end) return new Node(pre[i]);
			
			int ele = pre[i];
			int index = BinarySearch(in,st,end,ele);
			i++;
			Node root = new Node(ele);
			root.left = ConstuctBTwithInPre(in,pre,st,index-1);
			root.right = ConstuctBTwithInPre(in,pre,index+1,end);
			
			return root;
		}
		return null;
	}

	/*Inorder and Levelorder*/
	//Level = 1;
	Node ConstructBTwithInLevel(int[] in,int[] lev,int st,int end,int level){
		if(st<end){
			if(st == end) return new Node(lev[level-1]);
			int ele = lev[level-1];
			int index = BinarySearch(in, st, end, ele);
			Node root = new Node(ele);
			root.left = ConstructBTwithInLevel(in,lev,st,index-1,2*level);
			root.right = ConstructBTwithInLevel(in,lev,index+1,end,2*level+1);
			return root;
		}
		return null;
	}
	
	/*Inorder and Postorder*/
	//Static int i = n-1;
	Node ConstructBtwithInPost(int[] in,int[] post,int st,int end){
		int i=n-1;
		
		if(st<end){
			if(st == end) return new Node(post[i]);
			int ele = post[i];
			i--;
			int index = BinarySearch(in, st, end, ele);
			Node root = new Node(ele);
			root.left = ConstructBtwithInPost(in, post, st, index-1);
			root.right = ConstructBtwithInPost(in, post, index+1, end);
			return root;
		}
	}
	private int BinarySearch(int[] in, int st, int end,int ele) {
		if(st<end){
			int mid = st + (end-st)/2;
			
			if(in[mid] == ele){
				return mid;
			}else if(ele < in[mid]){
				return BinarySearch(in, st, mid-1, ele);
			}else{
				return BinarySearch(in, mid+1, end, ele);
			}		
		}
		return -1;
	}
	
	public boolean printAncestors(Node root, Node n){
		if(root == null) return false;
		
		if(root.data == n.data) return true;
		
		if(printAncestors(root.left, n) || printAncestors(root.right, n)){
			System.out.println(root.data);
			return true;
		}
		
		return false;
	}
	
	public boolean checkIfSubTree(Node r, Node s){
		if(r==null && s == null) return true;
		if(s == null) return true;
		if(r == null) return false;
		
		if(r.data == s.data && checkIfSubTree(r.left, s.left) && checkIfSubTree(r.right, s.right)){
			return true;
		}
		
		return checkIfSubTree(r.left, s) || checkIfSubTree(r.right, s);
	}
	
	public boolean identical(Node r,Node s){
		if( r== null && s == null) return true;
		if( r== null || s == null) return false;
		
		if(r.data == s.data && identical(r.left, s.left) && identical(r.right, s.right)){
			return true;
		}
		
		return false;
	}
	
	public void connectNodesAtsSameLevel(Node root){
		if(root == null) return;
		
		Deque<Node> q = new LinkedList<Node>();
		
		q.offerLast(root);
		q.offerLast(null);
		
		while(!q.isEmpty()){
			Node cur = q.pollFirst();
			if(cur == null){
				if(q.isEmpty()){
					break;
				}
				q.offerLast(null);
			}else{
				cur.next = q.peek();
				if(cur.left != null) q.offerLast(cur.left);
				if(cur.right != null) q.offerLast(cur.right);
			}
		}
	}
	
	public void printTreeBoundary(Node root){
		if(root == null) return;
		
		System.out.println(root.data);
		
		printLeftBoundary(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRightBoundary(root.right);	
	}
	
	public void printLeftBoundary(Node root) {
		if(root == null) return;
		
		if(root.left == null && root.right == null) return;
		
		System.out.println(root.data);
		if(root.left != null) 
			printLeftBoundary(root.left);
		else if(root.right != null) 
			printLeftBoundary(root.right);
	}
	public void printRightBoundary(Node root) {
		if(root == null) return;
		
		if(root.left == null && root.right == null) return;
		
		if(root.right != null) 
			printRightBoundary(root.right);
		else if(root.left != null) 
			printRightBoundary(root.left);
		System.out.println(root.data);
	}
	public void printLeaves(Node root) {
		if(root == null) return;
		
		if(root.left == null && root.right == null){
			System.out.println(root.data);
			return;
		}
		printLeaves(root.left);
		printLeaves(root.right);
	}
	
	public void printTopView(Node root){
		if( root == null) return;
		
		Set<Block> st = new HashSet<Block>();
		Deque<Block> q = new LinkedList<Block>();
		Block b = new Block(root,0);
		q.offerLast(b);

		while(!q.isEmpty()){
			Block cur = q.pollFirst();
			if(!st.contains(cur)){
				st.add(cur);
			}
			
			if(cur.root.left!=null) q.offerLast(new Block(cur.root.left,cur.hd-1));
			if(cur.root.right!=null) q.offerLast(new Block(cur.root.right,cur.hd+1));
		}
		List<Block> lst = new ArrayList<Block>(st);
		Collections.sort(lst);
		for(Block x : lst){
			System.out.print(x.root.data + " ");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void printVerticalOrder(Node root){
		if(root == null) return;
		
		Deque<Block> q = new LinkedList<Block>();
		Map<Integer,Deque<Node>> hm = new HashMap<Integer,Deque<Node>>();
		Block b = new Block(root,0);
		q.offerLast(b);
		
		while(!q.isEmpty()){
			Block curblock = q.pollFirst();
			int hd = curblock.hd;
			Node cur = curblock.root;
			if(hm.containsKey(hd)){
				Deque<Node> mq = hm.get(hd);
				mq.offerLast(cur);
			}else{
				Deque<Node> mq = new LinkedList<Node>();
				mq.addLast(cur);
				hm.put(hd, mq);
			}
			
			if(cur.left != null) q.offerLast(new Block(cur.left,hd-1));
			if(cur.right != null) q.offerLast(new Block(cur.right,hd+1));
		}
		
		Set<Map.Entry<Integer, Deque<Node>>> st = hm.entrySet();
		List<Map.Entry<Integer, Deque<Node>>> lst = new ArrayList<Map.Entry<Integer, Deque<Node>>>(st);
		Collections.sort(lst,new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				Map.Entry<Integer, Deque<Node>> e1 = ((Map.Entry<Integer, Deque<Node>>)  o1);
				Map.Entry<Integer, Deque<Node>> e2 = ((Map.Entry<Integer, Deque<Node>>)  o2);
				return e1.getKey() - e2.getKey();
			}
			
		});

		for(Map.Entry<Integer, Deque<Node>> e : lst){
			Deque<Node> curq = e.getValue();
			while(!curq.isEmpty()){
				Node temp = curq.pollFirst();
				System.out.print(temp.data+" ");
			}
			System.out.println();
		}
	}
	
	Node insertJob(Node root,int time,int k){
		if( root == null) return new Node(time);
		
		if(time-k < root.data && root.data < time+k ){
			return root;
		}
		
		if(time < root.data){
			root.left = insertJob(root.left, time, k);
		}else if(root.data < time){
			root.right = insertJob(root.right, time, k);
		}
		
		return root;
	}
	
	Node removeBSTKeys(Node root,int min,int max){
		if(root == null) return null;
		
		root.left = removeBSTKeys(root.left, min, max);
		root.right = removeBSTKeys(root.right, min, max);
		if(root.data < min){
			// whole left tree wil be lesser than min
			return root.right;
		}	
		if(root.data > max){
			// whole right subtree will be greater than max
			return root.left;
		}
		return root;
	}
	
	public void printSorted(int[] arr,int pos,int n){
		if(pos<n){
			printSorted(arr, 2*pos+1, n);
			System.out.println(arr[pos]);
			printSorted(arr, 2*pos+2, n);
		}
	}
	
	public void printKthSmallest(Node root,int k){	
		// Morris traversal if no extra memory is required
		if(root == null) return;
		
		Deque<Node> st = new LinkedList<Node>();
		Node cur = root;
		
		while(true){
			if(cur != null){
				st.offerFirst(cur);
				cur = cur.left;
			}else{
				if(!st.isEmpty()){
					cur = st.pollFirst();
					k--;
					if(k == 0){
						System.out.println(cur.data);
						break;
					}
					cur = cur.right;
				}else{
					break;
				}
			}
		}
	}
	
	public void printKthLargest(Node root,int k){
		if(root == null) return;
		
		Deque<Node> st = new LinkedList<Node>();
		Node cur = root;
		
		while(true){
			if(cur != null){
				st.offerFirst(cur);
				cur = cur.right;
			}else{
				if(!st.isEmpty()){
					cur = st.pollFirst();
					k--;
					if(k == 0){
						System.err.println(cur.data);
						break;
					}
					cur =cur.left;							
				}else{
					break;
				}
			}
		}	
	}
	
	public void printBSTKeys(Node root,int min,int max){
		if(root == null) return;
		
		if(root.data > min)
			printBSTKeys(root.left, min, max);
		if(min <= root.data && root.data <= max){
			System.out.println(root.data);
		}
		if(root.data < max )
			printBSTKeys(root.right, min, max);
	}
	
	public boolean isIdenticalArrayBST(int[] a,int[] b){
		return isIdenticalArrayBST(a, b,0,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private boolean isIdenticalArrayBST(int[] a, int[] b, int i1, int j1,int minValue, int maxValue) {
		int n = a.length;
		int i,j;
		for(i=i1;i<n;i++){
			if(minValue < a[i] && a[i] < maxValue){
				break;
			}
		}
		for(j=j1;j<n;j++){
			if(minValue < b[j] && b[j] < maxValue){
				break;
			}
		}
		
		if(i==n && j==n)return true;
		
		if(i==n || j==n) return false;
		
		if(a[i] != b[j]) return false;
		
		return isIdenticalArrayBST(a, b, i+1, j+1, minValue, a[i]) &&
				isIdenticalArrayBST(a, b, i+1, j+1, a[i], maxValue);
	}
	
	public int addAllGreaterValues(Node root,int sum){
		if(root.right != null){
			sum = addAllGreaterValues(root.right,sum);
		}	
		root.data = root.data + sum;
		sum = root.data;
		if(root.right!=null){
			sum = addAllGreaterValues(root.left, sum);
		}
		return sum;
	}
	
	public void swapNodesBST(Node root){
		if(root == null) return;
		
		Deque<Node> st1 = new LinkedList<Node>();
		
		Node cur1= root;
		
		Node first = null;
		Node mid=null;
		Node prev = null;
		Node last=null;
		
		while(true){
			if(cur1!=null){
				st1.offerFirst(cur1);
				cur1=cur1.left;
			}else{
				if(!st1.isEmpty()){
					cur1 = st1.pollFirst();
					if(first == null){
						first = cur1;
					}else if(mid == null && first.data > cur1.data){
						mid = cur1;
					}else if(prev == null){
						prev = cur1;
					}else if(prev.data > cur1.data){
						last = cur1;
					}
					cur1 = cur1.right;
				}else{
					break;
				}
			}
		}
		
		if(last == null){
			Node temp = first;
			first = mid;
			mid = temp;
		}else{
			Node temp = mid ;
			mid = last;
			last = temp;
		}
	}
	
	public Node constructTreeFromPreorder(int[] arr){
		Deque<Node> st = new LinkedList<Node>();
		
		int n = arr.length;
		Node root = new Node(arr[0]);
		
		st.offerFirst(root);
		
		for(int i=1;i<n;i++){
			int ele = arr[i];
			Node cur = new Node(ele);
			Node top = st.peek();
			if(top.data > cur.data){
				top.left = cur;
			}else{
				Node parent = null;
				while(!st.isEmpty() && st.peek().data < cur.data){
					parent = st.pollFirst();
				}
				parent.right = cur;
			}
			st.offerFirst(cur);
		}
		return root;
	}	
	
	public int Ceil(Node root,int key){
		if(root == null) return -1;
		
		Node insuc = null;
		
		while(root != null){
			if(key == root.data){
				return key;
			}else if(key < root.data){
				insuc = root;
				root=root.left;
			}else{
				root=root.right;
			}
		}
		
		if(insuc != null) return insuc.data;
		return -1;
	}
	
	public int Floor(Node root,int key){
		if(root == null) return -1;
		
		Node inpre = null;
		
		while(root != null){
			if(key == root.data){
				return key;
			}else if(key < root.data){
				root= root.left;
			}else{
				inpre = root;
				root=root.right;
			}
		}
		
		if(inpre != null) return inpre.data;
		
		return -1;
	}
	
	public int addGreater(Node root,int sum){
		if(root.right != null)
			sum = addGreater(root.right, sum);
		sum = sum + root.data;
		root.data = sum;
		
		if(root.left != null)
			sum = addGreater(root.left, sum);
		
		return sum;	
	}
	
	public boolean countBST(Node root,Box b,int min,int max){
		boolean lflag = true;
		boolean rflag = true;
		Box lb = new Box();
		Box rb = new Box();
		if(root.left != null){
			lflag = countBST(root.left, lb,min,max);
		}

		if(root.right != null){
			rflag = countBST(root.right, rb,min,max);
		}
		if(min<=root.data && root.data < max && lflag && rflag){
			b.count = lb.count + rb.count + 1;
			return true;
		}else{
			b.count = lb.count + rb.count;
			return false;
		}	
	}
	
	public int countNodes(Node root,int min,int max){
		if( min <= root.data && root.data <= max){
			return 1+ countNodes(root.left, min, max) + countNodes(root.right, min, max);
		}else if(min <= root.data){
			return countNodes(root.left, min, max);
		}else{
			return countNodes(root.right, min, max);
		}
	}
	
	public Node changeKey(Node root,int oldKey,int newKey){
		root = delete(root, oldKey);
		root = insert(root, newKey);
		return root;
	}
	
	public Node lca(Node root,Node n1,Node n2){
		//https://www.youtube.com/watch?v=TIoCCStdiFo
		if(root == null) return null;
		if(n1 == null) return n2;
		if(n2 == null) return n1;
		
		if(n1.data < root.data && n2.data < root.data){
			return lca(root.left, n1, n2);
		}else if(n1.data > root.data && n2.data > root.data){
			return lca(root.right, n1, n2);
		}else{
			return root;
		}
		
	}
}
class Box{
	int count=0;
}
class Block implements Comparable<Block>{

	Node root;
	int hd;
	
	Block(Node root,int hd){
		this.root = root;
		this.hd = hd;
	}

	public int compareTo(Block o) {
		Block b = (Block) o;
		return this.hd-b.hd;
	}
	
	public boolean equals(Block b){
		if(this.hd == b.hd) return true;
		return false;
	}
	
	public int hashCode(){
		return 7*this.hd;
	}
}
class Wrapper{
	int h=0;
}
class Node{
	Node left;
	Node right;
	Node next;
	int data;
	String sdata;
	
	Node(int val){
		this.data = val;
	}
	
	Node(String s){
		this.sdata = sdata;
	}
}
