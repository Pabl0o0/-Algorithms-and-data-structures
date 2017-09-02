package lab8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class drzewo_BST {
	
	//klasa wewnêtrzna wêz³a
	private static class Node { 
		int key;
		Node left, right, parent = null;
		String value;
		Node(int key){
			this.key = key;
		}
	}
	
	public static Node root = null; // korzeñ drzewa
	
	
	public static void insert(int key){
		if (root==null)
			root = new Node(key);		
		else {
			Node actual = root;
			Node parent = null;
			while (actual != null){
				parent = actual;
				actual = (actual.key > key) ? actual.left : actual.right;
			}
			if (parent.key > key){
				parent.left = new Node(key);
				parent.left.parent = parent;
			}
			else {
				parent.right = new Node(key);
				parent.right.parent = parent;
			}
		}
	}
	
	
	public static void inOrder(Node node){
		if(node != null){
			inOrder(node.left);
			System.out.print(node.key+ ", ");
			inOrder(node.right);
		}
	}
	
	
	public static void preOrder(Node node){
        if (node == null)
            return;
        System.out.print(node.key + ", ");        
        preOrder(node.left); 
        preOrder(node.right);
    }
	
	
	public static void postOrder(Node node) {
		if (node == null)
            return;             
        postOrder(node.left); 
        postOrder(node.right);
        System.out.print(node.key + ", "); 
		}
		
	
	public static Node search(int key) throws TreeException {
		Node actual = root;
		while(actual != null && actual.key != key)
		actual = (actual.key > key) ? actual.left : actual.right;
		if(actual == null)
			throw new TreeException("Key not found :-(");
		return actual;            
		}
	
	
	private static class TreeException extends Throwable {
		TreeException() {}
		TreeException(String msg) { super(msg); }
		}
	
	
	private static Node min(Node node) {
		while(node.left != null)
		node = node.left;
		return node;
		}
	
	
	private static Node max(Node node) {
		while(node.right != null)
		node = node.right;
		return node;
		}
	

	static int i = -1;
	public static int height(Node node){		
		if(node != null){
			if(node.left != null || node.right != null){
				i++;
			}
		int a = height(node.left);
		int b = height(node.right);
		if(a>b)
			i+=a;
		}
		return i;
	}
	
	
	public static int nodeNumber(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + nodeNumber(node.left) + nodeNumber(node.right);
	}
	
	
	public static int leavesNumber(Node node) {
		if (node == null)
			return 0;

		if (node.left == null && node.right == null)
			return 1;
		else {
			return leavesNumber(node.left) + leavesNumber(node.right);
		}
	}
	
	
	public static int insideLeavesNumber(){
		return nodeNumber(root) - leavesNumber(root);
	}
	
	static int x = 0;
	public static int outsideLeavesNumber(Node node) {
		if (node == null){
			x++;
			return 0;
		}
		if (node.left == null && node.right == null)
			x++;
		else {
			return outsideLeavesNumber(node.left) + outsideLeavesNumber(node.right);
		}
		return x;
	}
	
	
	
	public static void printLevelOrder(List<Node> level) {
		List<Node> nextLevel = new LinkedList<Node>();
		for (Node node : level) {
			System.out.print(node.key + ", ");
			if (node.left != null) {
				nextLevel.add(node.left);
			}
			if (node.right != null) {
				nextLevel.add(node.right);
			}
		}
		if (!nextLevel.isEmpty()) {
			printLevelOrder(nextLevel);
		}
	}
	
	
	public static void printLevelOrder() {
		if (root != null) {
			printLevelOrder(Arrays.asList(root));
		}
	}
	

	public static Node successor(int key) throws TreeException {
		Node node = search(key);
        if (node.right != null) {
            node = node.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else if (node.right == null && node != root && node != max(root)) {
            Node parent = node.parent;
            while (parent != root && parent.key < node.key)
                parent = parent.parent;
            return parent;
        } else
            System.out.println("Nie znaleziono nastepnika");
        return null;
    }

	
	
	public static Node predecessor(int key) throws TreeException {
	Node node = search(key);
	if(node.left != null) {
	node = node.left;
	while(node.right != null)
	node = node.right;
	return node;
	}
	else if(node.left == null && node != root  && node != min(root)) {
	Node parent = node.parent;
	while(parent != root && parent.key > node.key)
	parent = parent.parent;
	return parent;
	}
	else
	throw new TreeException("Not Found Predecessor");
	}
	
	public static Node remove(int key) throws TreeException {
        Node node = search(key);
        Node parent = node.parent;
        Node tmp;
        if (node.left != null && node.right != null) {
            tmp = remove(successor(key).key);
            tmp.left = node.left;
            if (tmp.left != null)
                tmp.left.parent = tmp;
            tmp.right = node.right;
            if (tmp.right != null)
                tmp.right.parent = tmp;
        } else
            tmp = (node.left != null) ? node.left : node.right;
        if (tmp != null)
            node.parent = parent;
        if (parent == null)
            root = tmp;
        else if (parent.left == node)
            parent.left = tmp;
        else
            parent.right = tmp;
        return node;
    }
	
	
	
	public static void main(String args[]) throws TreeException{
		insert(10);
		insert(5);
		insert(4);
		insert(8);
		insert(9);
		insert(15);
		insert(13);
			
		System.out.print("InOrder:");
		inOrder(root);
		System.out.println();
		System.out.print("PreOrder:");
		preOrder(root);
		System.out.println();
		System.out.print("PostOrder:");
		postOrder(root);
		System.out.println();		
		System.out.println("Result of searching for key: " + search(4).key);
		
		System.out.println("Min. key = "+ min(root).key);	
		System.out.println("Max. key = "+ max(root).key);	
		System.out.println("Tree height = " + height(root));
		System.out.println("number of nodes = " + nodeNumber(root));
		System.out.println("number of leaves = " + leavesNumber(root));
		System.out.println("number of inside leaves = " + insideLeavesNumber());
		System.out.println("number of outside leaves = " + outsideLeavesNumber(root));
		System.out.print("Printing in level order: ");
		printLevelOrder();
		System.out.println();
		System.out.println("Successor of 9 = " +successor(9).key); 
		System.out.println("Predecessor of 10 = " +predecessor(10).key);
		remove(10);
		System.out.print("pre Order:");
		preOrder(root);
//		System.out.println("Result of searching for key: " + search(8).key);
		
		
		
	}
	
}
