package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

class Result { 
    public int max_sofar; 
} 

public class BSTree {

	public Node root;
	public int max_level = -1;
	public static HashMap<Integer, Integer> hm = new HashMap<>();
	private int maxSoFar = 0;
	Node prev = null; // for tree to Doubly linked list conversion
	Node head; // for doubly linked list
	int sum;
	Stack<Integer> s = new Stack<Integer>();

	public BSTree() {
		root = null;
	}

	public void insert(int data) {
		root = insertFinal(root, data);
	}

	public Node insertFinal(Node root, int data) {
		if (root == null) {
			root = new Node(data);

		} else if (root.info >= data) {
			root.left = insertFinal(root.left, data);   // root of the tree may
														// change as we are adding node i.e we are returning  modified root.
		} else {
			root.right = insertFinal(root.right, data);
		}

		return root;

	}

	public Node delete(Node root, int data) {
		if (root == null)
			return root;
		else if (root.info > data) {
			root.left = delete(root.left, data);
		} else if (root.info < data) {
			root.right = delete(root.right, data);
		} else { // when you find the node to be deleted
			// case 1: no child
			if (root.left == null && root.right == null) {
				root = null;
			}
			// case 2:single child
			else if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			}
			// case 3: two children
			else {
				int minNodeFromRightSubtree = minNode(root.right);
				root.info = minNodeFromRightSubtree;
				root.right = delete(root.right, minNodeFromRightSubtree);
			}

		}
		return root;
	}

	private int minNode(Node root) {
		if (root == null)
			return 0;
		else if (root.left == null) {
			return root.info;
		} else {
			return minNode(root.left);
		}
	}

	/*
	 * void displaycount() { System.out.println(count); }
	 */

	public void display() {
		displayFinal(root);
	}

	/*
	 * void displaycount() { System.out.println(count); }
	 */

	public void displayFinal(Node t) {
		if (t == null)
			return;

		System.out.print(t.info + " ");
		displayFinal(t.left);
		displayFinal(t.right);

	}


	public void printLeafNodes(Node t) {

		if (t == null)
			return;
		if (t.left == null && t.right == null)
			System.out.print(t.info+" "); // count++;

		printLeafNodes(t.left);

		printLeafNodes(t.right);

	}

	/*
	 * void displaycount() { System.out.println(count); }
	 */

	public int maxNode(Node t, int max) {

		if (t != null) {

			maxNode(t.left, max);
			maxNode(t.right, max);
			if (t.info > max)
				max = t.info;
		}

		return max;

	}

	public int maxNodeBinaryTree(Node t) {

		if (t == null)
			return 0;

		int left = maxNodeBinaryTree(t.left);
		int right = maxNodeBinaryTree(t.right);

		return Math.max(t.info, Math.max(left, right));

	}

	/*
	 * void displaycount() { System.out.println(count); }
	 */

	public int maxNodeBST(Node t) {

		if (t.right == null)
			return t.info;
		return maxNodeBST(t.right);

	}

	public int countAllNodes(Node t) {

		if (t == null)
			return 0;

		return (1 + countAllNodes(t.left) + countAllNodes(t.right));

	}

	public int sumAllNodes(Node t) {

		if (t == null)
			return 0;

		return (t.info + sumAllNodes(t.left) + sumAllNodes(t.right));

	}

	public int sumRangeNodes(Node t, int low, int high) {
		if (t == null)
			return 0;

		if (t.info >= low && t.info <= high) {

			return (t.info + sumRangeNodes(t.left, low, high) + sumRangeNodes(t.right, low, high));
		}

		else if (t.info > low) {
			return sumRangeNodes(t.left, low, high);
		} else {
			return sumRangeNodes(t.right, low, high);
		}
	}

	public int countLeafNodes(Node t) {

		if (t == null)
			return 0;

		if (t.left == null && t.right == null)
			return 1;

		return (countLeafNodes(t.left) + countLeafNodes(t.right));

	}

	public int countLeafNodesK(Node t, int k) {

		if (t == null)
			return 0;

		if (t.left == null && t.right == null)
			return 1;

		int tlc = (countLeafNodesK(t.left, k) + countLeafNodesK(t.right, k));
		if (k == tlc)
			System.out.println(t.info);
		return tlc;

	}

	public int countLeftLeafNodes(Node root) {

		if (root == null)
			return 0;

		if (root.left != null && root.left.left == null && root.left.right == null) {

			return 1 + countLeftLeafNodes(root.right);

		} else {

			return countLeftLeafNodes(root.left) + countLeftLeafNodes(root.right);
		}
	}

	public int heightBinaryTree(Node root) {
		if (root == null) {
			return -1;
		}
		return Math.max(heightBinaryTree(root.left), heightBinaryTree(root.right)) + 1;
	}

	public boolean search(Node root, int key) {
		if (root == null)
			return false;
		if (root.info == key) {
			return true;
		} else {
			return (search(root.left, key) || search(root.right, key));
		}
	}

	public boolean searchBST(Node root, int key) {
		if (root == null)
			return false;
		if (root.info == key)
			return true;

		if (root.info > key)
			return searchBST(root.left, key);
		else
			return searchBST(root.right, key);

	}

	public boolean issubtreeLesser(Node t, int data) {

		if (t == null)
			return true;
		else if (t.info <= data && issubtreeLesser(t.left, data) && issubtreeLesser(t.right, data))
			return true;
		else
			return false;

	}

	public boolean issubtreeGreatter(Node t, int data) {

		if (t == null)
			return true;
		else if (t.info > data && issubtreeGreatter(t.left, data) && issubtreeGreatter(t.right, data))
			return true;
		else
			return false;

	}

	public boolean isBST(Node t) {

		if (t == null)
			return true;
		else if (issubtreeLesser(t.left, t.info) && issubtreeGreatter(t.right, t.info) && isBST(t.left)
				&& isBST(t.right))
			return true;
		else
			return false;

	}

	public boolean isBSTRange(Node t, int min, int max) {

		if (t == null)
			return true;
		else if (t.info >= min && t.info < max && isBSTRange(t.left, min, t.info) && isBSTRange(t.right, t.info, max))
			return true;
		else
			return false;

	}

	public Node LCA(Node root, Node n1, Node n2) {
		if (root == null) {
			return null;
		}
		// If root>n1 and root>n2 then lowest common ancestor will be in left
		// subtree.
		if (root.info > n1.info && root.info > n2.info) {
			return LCA(root.left, n1, n2);

		}
		// If root<n1 and root<n2 then lowest common ancestor will be in right
		// subtree.
		else if (root.info <= n1.info && root.info < n2.info) {
			return LCA(root.right, n1, n2);
		}
		// if I am here that means i am at the root which is lowest common
		// ancestor
		return root;
	}
	 // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    Node findLCA(Node node, Node n1, Node n2)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.info == n1.info || node.info == n2.info)
            return node;
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

	public int distanceBetweenTwoNodes(Node node, Node n1, Node n2) {
	    if (node == null) {
	      return -1;
	    }
	    
	    Node lca = findLCA(node, n1, n2);

	    if (lca == null) {
	      return -1;
	    }

	    int d1 = distanceFromParentToNode(lca, n1.info, 0);
	    int d2 = distanceFromParentToNode(lca, n2.info, 0);

	    return d1 + d2;
	  }

	  public int distanceFromParentToNode(Node node, int val, int distance) {
	    if (node == null) {
	      return -1;
	    }

	    if (node.info == val) {
	      return distance;
	    }

	    int d = distanceFromParentToNode(node.left, val, distance + 1);
	    
	    if (d != -1) {
	      return d;
	    }
	    
	    d = distanceFromParentToNode(node.right, val, distance + 1);

	    return d;
	  }
	
	// Function to print all non-root nodes that don't have a sibling
	void printSingles(Node node) {
		if (node == null)
			return;

		// If this is an internal node, recur for left
		// and right subtrees
		if (node.left != null && node.right != null) {
			printSingles(node.left);
			printSingles(node.right);
		}

		// If left child is NULL and right is not, print right child
		// and recur for right child
		else if (node.right != null) {
			System.out.print(node.right.info + " ");
			printSingles(node.right);
		}

		// If right child is NULL and left is not, print left child
		// and recur for left child
		else if (node.left != null) {
			System.out.print(node.left.info + " ");
			printSingles(node.left);
		}
	}

	public void rootToLeafPath(Node root, int[] path, int pathlen) {
		if (root == null)
			return;
		
		path[pathlen] = root.info;
		
		if (root.left == null && root.right == null) {
			System.out.println();
			for (int i : path) {
				if (i != 0)
					System.out.print(i + " ");
			}
		} else {

			rootToLeafPath(root.left, path, pathlen + 1);
			rootToLeafPath(root.right, path, pathlen + 1);
		}
	}

	public static void rootToLeafPathBinaryTree(Node root, String path, List<String> paths) {

		if (root == null)
			return;
		path += root.info;
		if (root.left == null && root.right == null) {
			paths.add(path);
		} else {
			rootToLeafPathBinaryTree(root.left, path + "->", paths);
			rootToLeafPathBinaryTree(root.right, path + "->", paths);
		}
	}

	/*
	 * public static void rootToLeafPathBinaryTreeInt(Node root, int[] path,
	 * int[] pathSum) {
	 * 
	 * if (root == null) return; path += root.info; if (root.left == null &&
	 * root.right == null) { paths.add(path); } else {
	 * rootToLeafPathBinaryTree(root.left, path + "->", paths);
	 * rootToLeafPathBinaryTree(root.right, path + "->", paths); } }
	 */
	public void rootToLeafPathBacktracking(Node t) {

		if (t == null)
			return;

		s.push(t.info); // push into stack
		if (t.left == null && t.right == null) {

			Iterator<Integer> i = s.iterator();
			while (i.hasNext()) {

				System.out.print(i.next() + "->");
			}
			System.out.println();
		}

		else {

			rootToLeafPathBacktracking(t.left); // check for lest subtree

			rootToLeafPathBacktracking(t.right); // check for right subtree

			// Remove the node from stack as we are done from root till
		} // this node
		s.pop();
	}
	
	public void rootToLeafPathBacktrackingII(Node root,Stack<Integer> s) {

		if (root == null)
			return;

		s.push(root.info); // push into stack
		if (root.left == null && root.right == null) {

			Iterator<Integer> i = s.iterator();
			while (i.hasNext()) {

				System.out.print(i.next() + "->");
			}
			System.out.println();
		}

		else {

			rootToLeafPathBacktrackingII(root.left,s); // check for lest subtree

			rootToLeafPathBacktrackingII(root.right,s); // check for right subtree

			// Remove the node from stack as we are done from root till
		} 
		s.pop();// this node
	}

	public static boolean checkRootToLeafPathSum(Node root, int sum) {

		if (root == null)
			return false;
		else if (sum == root.info && root.left == null && root.right == null) {
			return true;
		} else {

			return (checkRootToLeafPathSum(root.left, sum - root.info)
					|| checkRootToLeafPathSum(root.right, sum - root.info));
		}
	}
	
	public void rootToLeafPathGivenSum(Node root, int[] path, int pathlen, int sum) {

		if (root == null)
			return;
		   path[pathlen] = root.info;
		if (root.info == sum && root.left == null && root.right == null) {
			for (int i : path) {
				if (i != 0)
					System.out.print(i + " ");
			}
			return;
		}
		
		if (root.left != null)
			rootToLeafPathGivenSum(root.left, path, pathlen + 1, sum - root.info);
		if (root.right != null)
			rootToLeafPathGivenSum(root.right, path, pathlen + 1, sum - root.info);

	}

	public void rootToLeafPathGivenSumBacktracking(Node root, int value) {

		if (root == null)
			return;

		sum = sum + root.info;

		s.push(root.info);

		if (sum == value) {

			Iterator<Integer> i = s.iterator();
			while (i.hasNext()) {

				System.out.print(i.next() + " ");
			}
		}
		if (root.left != null)
			rootToLeafPathGivenSumBacktracking(root.left, value);
		if (root.right != null)
			rootToLeafPathGivenSumBacktracking(root.right, value);

		sum = sum - root.info;
		s.pop();

	}
	
	public void allRootToLeafPaths(Node root) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		List<Integer> currentList=new ArrayList<>();
		allRootToLeafPathsUtil(root,currentList ,paths);
		paths.forEach(l ->System.out.println(l));
	}

	

	private void allRootToLeafPathsUtil(Node root,  List<Integer> currentList, List<List<Integer>> paths) {
		if(root==null){
			return;
		}
		currentList.add(root.info);
		if(root.left==null && root.right==null){
			paths.add(currentList);
			return;	
		}
		
		allRootToLeafPathsUtil(root.left,  new ArrayList<Integer>(currentList), paths);
		allRootToLeafPathsUtil(root.right, new ArrayList<Integer>(currentList), paths);
	}
	
	public void allRootToLeafPathsSum(Node root, int sum) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		List<Integer> currentList=new ArrayList<>();
		allRootToLeafPathsSumUtil(root, sum,currentList ,paths);
		paths.forEach(l ->System.out.println(l));
	}

	

	private void allRootToLeafPathsSumUtil(Node root, int sum, List<Integer> currentList, List<List<Integer>> paths) {
		if(root==null){
			return;
		}
		currentList.add(root.info);
		if(root.info==sum && root.left==null && root.right==null){
			paths.add(currentList);
			return;	
		}
		
		allRootToLeafPathsSumUtil(root.left, sum-root.info, new ArrayList<Integer>(currentList), paths);
		allRootToLeafPathsSumUtil(root.right, sum-root.info, new ArrayList<Integer>(currentList), paths);
	}
	
	

	void kDistantFromLeafUtil(Node node, int path[], boolean visited[], int pathLen, int k) {

		if (node == null)
			return;
		/* append this Node to the path array */
		path[pathLen] = node.info;
		visited[pathLen] = false;
		pathLen++;
		/*
		 * it's a leaf, so print the ancestor at distance k only if the ancestor
		 * is not already printed
		 */
		if (node.left == null && node.right == null && pathLen - k - 1 >= 0 && visited[pathLen - k - 1] == false) {
			System.out.print(path[pathLen - k - 1] + " ");
			visited[pathLen - k - 1] = true;
			return;
		}
		/* If not leaf node, recur for left and right subtrees */
		kDistantFromLeafUtil(node.left, path, visited, pathLen, k);
		kDistantFromLeafUtil(node.right, path, visited, pathLen, k);
	}

	/*
	 * Given a binary tree and a nuber k, print all nodes that are k distant
	 * from a leaf
	 */
	void printKDistantfromLeaf(Node node, int k) {
		int path[] = new int[1000];
		boolean visited[] = new boolean[1000];
		kDistantFromLeafUtil(node, path, visited, 0, k);
	}

	public void traversalpre(Node t) {
		if (t == null)
			return;
		System.out.print(t.info + " ");
		traversalpre(t.left);
		traversalpre(t.right);

	}

	public void traversalpost(Node t) {
		if (t == null)
			return;

		traversalpost(t.left);
		traversalpost(t.right);
		System.out.print(t.info + " ");

	}

	public void traversalin(Node t) {
		if (t == null)
			return;

		traversalin(t.left);
		System.out.print(t.info + " ");
		traversalin(t.right);

	}

	public void iterativePreOrder(Node t) {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (!stack.empty()) {
			Node n = stack.pop();
			// returnList.add(n.info);
			System.out.print(n.info + " ");
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}

		}

	}
	
	public void traversalLevelRecursive(Node root) {
		
		int height=heightBinaryTree(root);
		for(int i=0;i<=height;i++){
		  printNodesGivenLevel(root,i+1);
		  System.out.println();
		}

	}

	private void printNodesGivenLevel(Node root, int level) {
		
		if(root==null)
			return;
		if(level==1){
			System.out.print(root.info+" ");
			return;
		}
		
		printNodesGivenLevel(root.left,level-1);
		printNodesGivenLevel(root.right,level-1);
		
	}

	public void traversalLevel(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.info + " ");
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);

		}

	}

	public void treeToDLLLevelorder(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			Node node = new Node(temp.info);
			if (prev == null)
				head = node;
			else {
				node.left = prev;
				prev.right = node;
			}
			prev = node;

			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);

		}

	}

	public void traversalLevelLineByLine(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {

			int noElements = q.size();
			while (noElements > 0) {
				Node temp = q.poll();
				System.out.print(temp.info + " ");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				noElements--;
			}
			System.out.println();

		}

	}

	public void traversalLevelReverse(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();
			s.add(temp);
			// System.out.print(temp.info + " ");
			if (temp.right != null) // Right child must come before the Left
									// child
				q.add(temp.right);
			if (temp.left != null)
				q.add(temp.left);

		}
		while (!s.isEmpty()) {

			Node temp = s.pop();

			System.out.print(temp.info + " ");

		}

	}

	public void traversalLevelSpiral(Node node) {
		if (node == null)
			return; // NULL check

		// Create two stacks to store alternate levels
		Stack<Node> s1 = new Stack<Node>();// For levels to be printed from
											// right to left
		Stack<Node> s2 = new Stack<Node>();// For levels to be printed from left
											// to right

		// Push first level to first stack 's1'
		s1.push(node);

		// Keep ptinting while any of the stacks has some nodes
		while (!s1.empty() || !s2.empty()) {
			// Print nodes of current level from s1 and push nodes of
			// next level to s2
			while (!s1.empty()) {
				Node temp = s1.peek();
				s1.pop();
				System.out.print(temp.info + " ");

				// Note that is right is pushed before left
				if (temp.right != null)
					s2.push(temp.right);

				if (temp.left != null)
					s2.push(temp.left);

			}

			// Print nodes of current level from s2 and push nodes of
			// next level to s1
			while (!s2.empty()) {
				Node temp = s2.peek();
				s2.pop();
				System.out.print(temp.info + " ");

				// Note that is left is pushed before right
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}
	}

	void BToDLL(Node root, Node head) {
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		BToDLL(root.right, head);

		// insert root into DLL
		root.right = head;

		// Change left pointer of previous head
		if (head != null)
			(head).left = root;

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		BToDLL(root.left, head);
	}

	public void findVerticalSum(Node root, int column) {
		if (root == null)
			return;
		if (hm.containsKey(column)) {
			hm.put(column, hm.get(column) + root.info);
		} else {
			hm.put(column, root.info);
		}
		findVerticalSum(root.left, column - 1);
		findVerticalSum(root.right, column + 1);

	}

	public void findDiagonalSum(Node root, int column, HashMap<Integer, Integer> hm) {
		if (root == null)
			return;
		if (hm.containsKey(column)) {
			hm.put(column, hm.get(column) + root.info);
		} else {
			hm.put(column, root.info);
		}
		findDiagonalSum(root.left, column + 1, hm);
		findDiagonalSum(root.right, column, hm);

	}

	public static void findDiagonalSumG(Node root, int column) {
		if (root == null)
			return;
		if (hm.containsKey(column)) {

			int temp = hm.get(column);
			int sum = temp + root.info;
			hm.put(column, sum);
		} else {
			hm.put(column, root.info);
		}
		findDiagonalSumG(root.left, column + 1);
		findDiagonalSumG(root.right, column);

	}

	public void diagonalSum(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {

			int noElements = q.size();
			while (noElements > 0) {
				int sum = 0;
				Node temp = q.poll();
				sum = sum + temp.info;
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					temp = temp.right;
				System.out.println("Sum " + sum);
				noElements--;

			}

		}

	}

	void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m) {
		// Base case
		if (root == null)
			return;

		// get the vector list at 'hd'
		Vector<Integer> get = m.get(hd);

		// Store current node in map 'm'
		if (get == null) {
			get = new Vector<>();
			get.add(root.info);
		} else
			get.add(root.info);

		m.put(hd, get);

		// Store nodes in left subtree
		getVerticalOrder(root.left, hd - 1, m);

		// Store nodes in right subtree
		getVerticalOrder(root.right, hd + 1, m);
	}

	void leftViewUtil(Node node, int level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.info);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}

	void rightViewUtil(Node node, int level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.info);
			max_level = level;
		}

		// Recur for right and left subtrees

		rightViewUtil(node.right, level + 1);
		rightViewUtil(node.left, level + 1);
	}
	
   void rightViewUtill(Node node, int level,Integer max_level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.info);
			max_level = level;
		}

		// Recur for right and left subtrees

		rightViewUtill(node.right, level + 1,max_level);
		rightViewUtill(node.left, level + 1,max_level);
	}

	public void bottomView(Node t, int column) {
		if (t == null)
			return;
		hm.put(column, t.info);

		
			bottomView(t.left, column - 1);
	
			bottomView(t.right, column + 1);
		
	}

	public void printBoundary(Node node) {
	    if (node != null) {
	      System.out.print(node.info + " ");

	      printBoundaryLeft(node.left); //left boundary except leaf node

	      printLeafNodes(node.left);
	      printLeafNodes(node.right);

	      printBoundaryRight(node.right);//right boundary except leaf node
	    }
	  }
	  
	  public void printBoundaryLeft(Node node) {
	    if (node == null) {
	      return;
	    }

	    if (node.left != null) {
	      System.out.print(node.info + " ");   //print before call
	      printBoundaryLeft(node.left);
	    } else if (node.right != null) {
	      System.out.print(node.info + " ");   //print before call
	      printBoundaryLeft(node.right);
	    }
	  }

	  public void printBoundaryRight(Node node) {
	    if (node == null) {
	      return;
	    }

	    if (node.right != null) {
	      printBoundaryRight(node.right);
	      System.out.print(node.info + " ");  //print after call
	    } else if (node.left != null) {
	      printBoundaryRight(node.left);
	      System.out.print(node.info + " ");  //print after call
	    }
	  }
	int haspath(Node t, int sum) {
		if (t == null) {
			System.out.println("empty tree");
		}
		int ans = 0;
		int subsum = sum - t.info;
		if (subsum == 0 && t.left == null && t.right == null)
			return 1;

		if (t.left != null)
			ans = ans | haspath(t.left, subsum);
		if (t.right != null)
			ans = ans | haspath(t.right, subsum);

		return ans;
	}

	public boolean identicalCheck(Node t, Node t2) {

		if (t == null && t2 == null)
			return true;
		else if (t.info == t2.info && identicalCheck(t.left, t2.left) && identicalCheck(t.right, t2.right))
			return true;
		else
			return false;

	}

	public boolean subTreeCheck(Node t, Node sub) {

		if (sub == null)
			return true;
		if (t == null)
			return false;

		if (identicalCheck(t, sub))
			return true;

		return (subTreeCheck(t.left, sub) || subTreeCheck(t.right, sub));

	}

	public static boolean printAllAncestor(Node root, int data) {

		if (root == null) {
			return false;
		}
		if (root.info == data)
			return true;

		else if (printAllAncestor(root.left, data) || printAllAncestor(root.right, data)) {
			System.out.print(root.info + "\t");
			return true;
		}
		
		else 
			return false;

	}

	static boolean isSibling(Node node, int a, int b) {
		if (node == null) {
			return false;
		} else if (node.left != null && node.right != null) {
			if ((node.left.info == a && node.right.info == b) || (node.left.info == b && node.right.info == a))
				return true;
		}

		return (isSibling(node.left, a, b) || isSibling(node.right, a, b));
	}

	static int level(Node node, int ptr, int level) {

		if (node == null)
			return 0;

		if (node.info == ptr)
			return level;
		
			return Math.max(level(node.left, ptr, level + 1), level(node.right, ptr, level + 1));
	}

	// Returns true if a and b are cousins, otherwise 0
	static boolean isCousin(Node node, int a, int b) {
		// 1. The two Nodes should be on the same level
		// in the binary tree.
		// 2. The two Nodes should not be siblings (means
		// that they should not have the same parent
		// Node).
		return ((level(node, a, 1) == level(node, b, 1)) && (!isSibling(node, a, b)));
	}

	public void printNodeAtKDistance(Node t, int k) {

		if (t == null)
			return;

		if (k == 0)
			System.out.print(t.info+"\t" );

		printNodeAtKDistance(t.left, k - 1);
		printNodeAtKDistance(t.right, k - 1);
	}

	public static boolean isIsomorphic(Node n1, Node n2) {

		// Both roots are NULL, trees isomorphic by definition
		if (n1 == null && n2 == null)
			return true;

		// Exactly one of the n1 and n2 is NULL, trees not isomorphic
		if (n1 == null || n2 == null)
			return false;

		if (n1.info != n2.info)
			return false;

		// There are two possible cases for n1 and n2 to be isomorphic
		// Case 1: The subtrees rooted at these nodes have NOT been
		// "Flipped".
		// Both of these subtrees have to be isomorphic.
		// Case 2: The subtrees rooted at these nodes have been "Flipped"
		return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
				|| (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
	}

	public int findInOrderPredecessor(Node root, Node node) {
		Node temp;
		Node store = new Node();
		if (root == null)
			return 0;
		if (node.left != null) { // case 1 when left child exists
			temp = node.left;
			while (temp.right != null)
				temp = temp.right;
			return temp.info;
		} else {
			// case 2 when left child doesn't exist
			while (root.info != node.info) {

				if (root.info < node.info) {
					store = root;
					root = root.right;
				} else
					root = root.left;
			}

			return store.info;

		}

	}

	public int findInOrderSuccessor(Node root, Node node) {
		Node temp;
		Node store = new Node();
		if (root == null)
			return 0;
		if (node.right != null) {
			temp = node.right;
			while (temp.left != null)
				temp = temp.left;
			return temp.info;
		} else {

			while (node.info != root.info) {

				if (node.info < root.info) {
					store = root;
					root = root.left;
				} else
					root = root.right;
			}

			return store.info;

		}

	}

	public Node identicalBuilt(Node t) {

		if (t == null)
			return null;

		Node n = new Node(t.info);
		n.left = identicalBuilt(t.left);
		n.right = identicalBuilt(t.right);

		return n;

	}

	public boolean isMirror(Node node1, Node node2) {
		// if both trees are empty, then they are mirror image
		if (node1 == null && node2 == null)
			return true;

		// For two trees to be mirror images, the following three
		// conditions must be true
		// 1 - Their root node's key must be same
		// 2 - left subtree of left tree and right subtree
		// of right tree have to be mirror images
		// 3 - right subtree of left tree and left subtree
		// of right tree have to be mirror images
		if (node1 != null && node2 != null && node1.info == node2.info)
			return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));

		// if neither of the above conditions is true then
		// root1 and root2 are mirror images
		return false;
	}


	public Node mirrorBuilt(Node t) {

		if (t == null)
			return null;

		Node n = new Node(t.info);
		n.left = mirrorBuilt(t.right);
		n.right = mirrorBuilt(t.left);

		return n;

	}

	// invert a binary tree
	public static  void mirrorBuiltInplace(Node t) {

		if (t == null)
			return;
		mirrorBuiltInplace(t.left);
		mirrorBuiltInplace(t.right);
		Node temp = t.left;
		t.left = t.right;
		t.right = temp;

	}

	public void doubleTree(Node root) {

		/* Function to convert a tree to double tree */

		Node oldleft;

		if (root == null)
			return;

		/* do the subtrees */
		doubleTree(root.left);
		doubleTree(root.right);

		/* duplicate this Node to its left */
		oldleft = root.left;
		root.left = new Node(root.info);
		root.left.left = oldleft;

	}

	// Order of O(n) approach and in place too
	public void treeToDLLInorder(Node root) {

		if (root == null)
			return;

		treeToDLLInorder(root.left);
		// Now convert this Node
		if (prev == null)
			head = root;

		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		treeToDLLInorder(root.right);

	}

	/* Function to print nodes in a given doubly linked list */
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.info + " ");
			node = node.right;
		}
	}
	
	// An object of Res is passed around so that the 
	// same value can be used by multiple recursive calls. 
	

	public int calculateMaxSum(Node root, Result res) {
		if (root == null)
			return 0;

		int left = calculateMaxSum(root.left, res);
		int right = calculateMaxSum(root.right, res);

		int current = Math.max(root.info, Math.max(root.info + left, root.info + right));
		int ans = Math.max(current, left + root.info + right);

		res.max_sofar = Math.max(res.max_sofar,ans );

		return current;
	}
	
	public int calculateMaxSum(Node root, int[] max_sofar) {
		if (root == null)
			return 0;

		int left = calculateMaxSum(root.left, max_sofar);
		int right = calculateMaxSum(root.right, max_sofar);

		int current = Math.max(root.info, Math.max(root.info + left, root.info + right));
		int ans = Math.max(current, left + root.info + right);

		max_sofar[0] = Math.max(max_sofar[0],ans );

		return current;
	}

	int diameter(Node root) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = heightBinaryTree(root.left);
		int rheight = heightBinaryTree(root.right);

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter
		 * of right subtree 3) Height of left subtree + height of right subtree
		 * + 1
		 */
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

	}


	public int cummulativeSum(Node root) {
		if (root == null)
			return 0;
		return root.info + cummulativeSum(root.left) + cummulativeSum(root.right);
	}

	public void cumulaSumAtEachNode(Node root) {
		if (root == null)
			return;

		cumulaSumAtEachNode(root.left);

		cumulaSumAtEachNode(root.right);

		if (root.left != null)
			root.info += root.left.info;

		if (root.right != null)
			root.info += root.right.info;

	}

	public int sumTree(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) // comment this if want
														// value 0 for all leaf
														// nodes in sum tree
			return root.info;
		int oldVal = root.info;
		root.info = sumTree(root.left) + sumTree(root.right);

		return root.info + oldVal;

	}

	public boolean checksumTree(Node root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		int total = sumAllNodes(root.left) + sumAllNodes(root.right);

		if (total == root.info && checksumTree(root.left) && checksumTree(root.right))
			return true;
		else
			return false;
	}

}
