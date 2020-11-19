package binary_trees;

import java.lang.Math.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.logging.Level;

class Node {
	int data;
	Node left;
	Node right;
	int height;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

class BinaryTreeNode {
	public Node createNode(int data) {
		Node node = new Node(data);
		return node;
	}

	protected void inorder(Node root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

	}

	protected void preorder(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);

	}

	protected void postorder(Node root) {
		if (root == null) {
			return;
		}

		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");

	}

	public int getSumOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		return root.data + getSumOfTree(root.left) + getSumOfTree(root.right);
	}

	public int getDifferenceOfLevels(Node root) {

		if (root == null) {
			return 0;
		}

		return root.data - getDifferenceOfLevels(root.left) - getDifferenceOfLevels(root.right);

	}

	public int totalNodes(Node root) {
		if (root == null) {
			return 0;
		}

		return 1 + totalNodes(root.left) + totalNodes(root.right);
	}

	public int totalLeafNodes(Node root) {

		if (root == null) {
			return 0;
		}

		if ((root.left == null) && (root.right == null)) {
			return 1;
		}

		return totalLeafNodes(root.left) + totalLeafNodes(root.right);

	}

	public int heightOfTheTree(Node root) {

		if (root == null) {
			return -1;
		}

		return Math.max(heightOfTheTree(root.left), heightOfTheTree(root.right)) + 1;

	}

	public void nodesAtLevelN(Node root, int level) {

		if (root == null) {
			return;
		}

		if (level == 1) {
			System.out.print(root.data + " ");
			return;
		}

		nodesAtLevelN(root.left, level - 1);
		nodesAtLevelN(root.right, level - 1);

	}

	public void printLevelOrder(Node root) {

		if (root == null) {
			return;
		}

		int height = heightOfTheTree(root);

		for (int level = 1; level <= height + 1; level++) {
			nodesAtLevelN(root, level);
			System.out.println();
		}

	}

	// Level Order Traversal without Recursion
	public void levelOrderTraversalWithoutRecursion(Node root) {
		// Write without recursion .....

		if (root == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (q.size() > 0) {
			Node node = q.remove();
			System.out.println(node.data);

			if (node.left != null) {
				q.add(node.left);
			}

			if (node.right != null) {
				q.add(node.right);
			}
		}

	}

	Stack<Node> stack;

	public void inorderIterative(Node root) {
		stack = new Stack<>();
		System.out.println("Preorder Without Recursion : ");
		if (root == null) {
			return;
		}

		while (root != null) {
			stack.add(root);
			System.out.print(root.data + " ");
			root = root.left;
		}

		Node temp;
		while (!stack.isEmpty()) {
			temp = stack.pop();
			temp = temp.right;
			// if (temp != null) {
			while (temp != null) {
				stack.add(temp);
				System.out.print(temp.data + " ");
				temp = temp.left;
			}
			// }

		}

	}

	public void postorderIterative(Node root) {

		if (root == null) {
			return;
		}

		stack = new Stack<>();
		Stack<Node> stackRoot = new Stack<>();
		stack.add(root);

		Node node;
		while (!stack.isEmpty()) {
			node = stack.pop();
			stackRoot.add(node);

			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.right != null) {
				stack.add(node.right);
			}

		}
		System.out.println("Post Order Iterative : ");
		while (!stackRoot.isEmpty()) {
			System.out.print(stackRoot.pop().data + " ");
		}

	}

	public void mirrorOfTree(Node root) {

		stack = new Stack<>();
		stack.add(root);

		Node node;
		Node swap;
		while (!stack.isEmpty()) {
			node = stack.pop();

			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.right != null) {
				stack.add(node.right);
			}

			if (node.left != null || node.right != null) {
				swap = node.right;
				node.right = node.left;
				node.left = swap;
			}

		}
		System.out.println("Inorder of Mirror tree : ");
		inorder(root);

	}

	public boolean checkIdenticalTree(Node root, Node node) {

		if (root == null && node == null) {
			return true;
		}
		if (root == null || node == null) {
			return false;
		}

		// if (root.data == node.data) {
		// checkIdenticalTree(root.left, node.left);
		// checkIdenticalTree(root.right, node.right);
		// return true;
		// } else {
		// return false;
		// }

		return (root.data == node.data) && checkIdenticalTree(root.left, node.left)
				&& checkIdenticalTree(root.right, node.right);

	}

	public int getLevelOfGivenNodeUsingQueue(Node root, int value) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node node;
		int count = 0, elements;

		while (!queue.isEmpty()) {
			elements = queue.size();
			count = count + 1;
			for (int i = 0; i < elements; i++) {
				node = queue.remove();

				if (node.data == value) {
					return count;
				}

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}

			}

		}
		System.out.println("Element " + value + " is not present in the Tree.");
		return Integer.MIN_VALUE;

	}

	public int getLevelOfGivenNodeUsingRecursion(Node root, int value, int count) {

		if (root == null) {
			return 0;
		}
		if (root.data == value) {
			return count;
		}
		int result;
		result = getLevelOfGivenNodeUsingRecursion(root.left, value, count + 1);

		if (result != 0) {
			return result;
		}

		result = getLevelOfGivenNodeUsingRecursion(root.right, value, count + 1);

		return result;

	}

	public void printTopViewOfTheTree(Node root) {

		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			Node node = queue.remove();
			int height = node.height;

			if (map.get(height) == null) {
				map.put(height, node.data);
			}

			if (node.left != null) {
				node.left.height = height - 1;
				queue.add(node.left);
			}

			if (node.right != null) {
				node.right.height = height + 1;
				queue.add(node.right);
			}

		}

		System.out.println("Top View of Tree : " + map.values());

	}

	public void printBottomViewOfTheTree(Node root) {

		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			Node node = queue.remove();
			int height = node.height;

			map.put(height, node.data);

			if (node.left != null) {
				node.left.height = height - 1;
				queue.add(node.left);
			}

			if (node.right != null) {
				node.right.height = height + 1;
				queue.add(node.right);
			}

		}

		System.out.println("Bottom View of Tree : " + map.values());

	}

	public void printBoundaryNodesOfTree(Node root) {

		if (root == null) {
			return;
		}
		System.out.println("Left Boundary :");
		printLeftBoundaryNodes(root);
		System.out.println();
		printLeafNodes(root);
		System.out.println();
		printRightBoundaryNodes(root);

	}

	private void printRightBoundaryNodes(Node root) {

		Stack<Node> stack = new Stack<>();
		if (root != null) {
			stack.add(root);
		}
		System.out.println("Right boundary nodes : ");

		Node node = stack.peek();

		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node.data + " ");
			if (node.right != null) {
				node = node.right;
				stack.add(node);
			} else if (node.left != null) {
				node = node.left;
				stack.add(node);
			}

		}

		// while (node.right != null) {
		// stack.add(node.right);
		// node = node.right;
		// }

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");

		}

	}

	private void printLeafNodes(Node root) {

		Stack<Node> stack = new Stack<>();
		stack.add(root);
		Node node;
		System.out.println("Leaf nodes");

		while (!stack.isEmpty()) {
			node = stack.pop();

			if (node.left == null && node.right == null) {
				System.out.print(node.data + " ");
				continue;
			}

			if (node.right != null) {
				stack.add(node.right);
			}

			if (node.left != null) {
				stack.add(node.left);
			}
		}

	}

	private void printLeftBoundaryNodes(Node root) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			System.out.print(root.data + " ");
			printLeftBoundaryNodes(root.left);
		} else if (root.right != null) {
			System.out.print(root.data + " ");
			printLeftBoundaryNodes(root.right);

		}

	}

	public void verticalOrderOfTree(Node root) {

		Stack<Node> stack = new Stack<>();
		TreeMap<Integer, ArrayList<Integer>> verticalLevelMap = new TreeMap<>();
		stack.add(root);

		Node node;
		ArrayList<Integer> arrayList;

		System.out.println("Vertical order of the Binary tree : ");
		while (!stack.isEmpty()) {
			node = stack.pop();

			if (verticalLevelMap.get(node.height) == null) {
				arrayList = new ArrayList<>();
				arrayList.add(node.data);
				verticalLevelMap.put(node.height, arrayList);
			} else {
				arrayList = verticalLevelMap.get(node.height);
				arrayList.add(node.data);
				verticalLevelMap.put(node.height, arrayList);
			}

			if (node.right != null) {
				node.right.height = node.height + 1;
				stack.add(node.right);
			}

			if (node.left != null) {
				node.left.height = node.height - 1;
				stack.add(node.left);
			}

		}
		printEntireMapData(verticalLevelMap);

	}

	private void printEntireMapData(TreeMap<Integer, ArrayList<Integer>> verticalLevelMap) {

		for (ArrayList<Integer> arrayList : verticalLevelMap.values()) {
			for (int data : arrayList) {
				System.out.print(data + " ");
			}
		}

	}

	public void sumOfEachLevelOrder(Node root) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node node;
		int count, level = 0;

		while (!queue.isEmpty()) {
			count = queue.size();
			int sum = 0;
			for (int i = 0; i < count; i++) {
				node = queue.remove();
				sum += node.data;

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}

			}
			level += 1;
			System.out.println("Level " + level + " : " + sum);
		}

	}

	public void printSpiralOrder(Node root) {

		Stack<Node> oddLevelStack = new Stack();
		Stack<Node> evenLevelStack = new Stack();
		Node node;
		int currentLevel = 1;
		oddLevelStack.add(root);
		System.out.print("Spiral Order : ");

		while (!oddLevelStack.isEmpty() || !evenLevelStack.isEmpty()) {

			if (currentLevel % 2 == 0) {
				while (!evenLevelStack.isEmpty()) {
					node = evenLevelStack.pop();
					System.out.print(node.data + " ");
					oddLevelStack = addLeftChildNodeIfExits(node, oddLevelStack);
					oddLevelStack = addRightChildNodeIfExists(node, oddLevelStack);

				}
			} else {
				while (!oddLevelStack.isEmpty()) {
					node = oddLevelStack.pop();
					System.out.print(node.data + " ");
					evenLevelStack = addRightChildNodeIfExists(node, evenLevelStack);
					evenLevelStack = addLeftChildNodeIfExits(node, evenLevelStack);

				}
			}
			currentLevel += 1;
		}

	}

	private Stack<Node> addLeftChildNodeIfExits(Node node, Stack<Node> stack) {

		if (node.left != null) {
			stack.add(node.left);
		}

		return stack;
	}

	private Stack<Node> addRightChildNodeIfExists(Node node, Stack<Node> stack) {
		if (node.right != null) {
			stack.add(node.right);
		}
		return stack;
	}

	public void printElementsBetweenTwoGivenLevels(Node root, int level1, int level2) {

		int level = 1, currentLevelElements;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node node;
		System.out.println("Level order : ");

		while (!queue.isEmpty()) {
			currentLevelElements = queue.size();

			while (currentLevelElements > 0) {
				node = queue.remove();
				if (level >= level1 && level <= level2) {
					System.out.print(node.data + " ");
				}

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				currentLevelElements -= 1;

			}
			level += 1;
		}

	}

	public void maximumWidthOfBinaryTree(Node root) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int maximumWidth = 0;

		while (!queue.isEmpty()) {
			int currentWidth = queue.size();
			if (currentWidth > maximumWidth) {
				maximumWidth = currentWidth;
			}
			Node node;
			while (currentWidth > 0) {
				node = queue.remove();

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}

				currentWidth -= 1;
			}

		}
		System.out.println("Maximum width of binary tree = " + maximumWidth);

	}

	public boolean checkMirrorTrees(Node root, Node node) {
		if (root == null && node == null) {
			return true;
		}

		if (root == null || node == null) {
			return false;
		}

		return (root.data == node.data) && checkIdenticalTree(root.left, node.right)
				&& checkIdenticalTree(root.right, node.left);

	}

}

public class BinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode b = new BinaryTreeNode();
		Node root = b.createNode(2);
		root.left = b.createNode(7);
		root.right = b.createNode(5);
		root.left.left = b.createNode(2);
		root.left.right = b.createNode(6);
		root.left.right.left = b.createNode(5);
		root.left.right.right = b.createNode(11);
		root.right.right = b.createNode(9);
		root.right.right.left = b.createNode(4);

		// Only added to check two Identical binary trees
		Node node = b.createNode(2);
		node.left = b.createNode(7);
		node.right = b.createNode(5);
		node.left.left = b.createNode(2);
		node.left.right = b.createNode(6);
		node.left.right.left = b.createNode(5);
		node.left.right.right = b.createNode(11);
		node.right.right = b.createNode(9);
		node.right.right.left = b.createNode(4);

		System.out.print("InOrder - ");
		b.inorder(root);

		System.out.println();
		System.out.print("PreOrder - ");
		b.preorder(root);

		System.out.println();
		System.out.print("PostOrder - ");
		b.postorder(root);

		System.out.println();
		System.out.println();

		System.out.println("Total sum of tree :" + b.getSumOfTree(root));
		System.out.println();

		System.out.println("Difference of even and odd levels : " + b.getDifferenceOfLevels(root));
		System.out.println();

		System.out.println("Total nodes : " + b.totalNodes(root));
		System.out.println();

		System.out.println("Leaf Nodes : " + b.totalLeafNodes(root));
		System.out.println();

		System.out.println("Height of Tree : " + b.heightOfTheTree(root));
		System.out.println();

		System.out.print("Nodes at level : ");
		b.nodesAtLevelN(root, 3);
		System.out.println();
		System.out.println();

		System.out.println("Nodes at each level : ");
		b.printLevelOrder(root);

		System.out.println();
		b.levelOrderTraversalWithoutRecursion(root);

		System.out.println();
		b.inorderIterative(root);
		System.out.println();

		System.out.println();
		b.postorderIterative(root);
		System.out.println();

		// Commented this Mirror tree only to print the required traversal data
		// in further implementations- otherwise will print in the mirror order
		// System.out.println();
		// b.mirrorOfTree(root);
		// System.out.println();

		// Identical trees check
		// System.out.println();
		// System.out.println("Are the Trees Identical : " +
		// b.checkIdenticalTree(root, node));

		System.out.println();
		System.out.println("Level of Node 11 using Queue--> " + b.getLevelOfGivenNodeUsingQueue(root, 4));

		System.out.println();
		System.out.println("Level of Node 11 using recursion --> " + b.getLevelOfGivenNodeUsingRecursion(root, 4, 1));

		System.out.println();
		b.printTopViewOfTheTree(root);
		System.out.println();

		System.out.println();
		b.printBottomViewOfTheTree(root);
		System.out.println();

		System.out.println();
		b.printBoundaryNodesOfTree(root);
		System.out.println();

		System.out.println();
		b.verticalOrderOfTree(root);
		System.out.println();

		System.out.println();
		b.sumOfEachLevelOrder(root);
		System.out.println();

		System.out.println();
		b.printSpiralOrder(root);
		System.out.println();

		System.out.println();
		b.printElementsBetweenTwoGivenLevels(root, 2, 4);
		System.out.println();

		System.out.println();
		b.maximumWidthOfBinaryTree(root);
		System.out.println();

		System.out.println();
		System.out.println(b.checkMirrorTrees(root, node));

	}

}
