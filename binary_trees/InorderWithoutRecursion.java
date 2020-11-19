package binary_trees;

import java.util.Stack;

class NodeClass {
	NodeClass left;
	NodeClass right;
	int data;

	public NodeClass(int data) {
		this.data = data;
		left = null;
		right = null;

	}

}

public class InorderWithoutRecursion {
	NodeClass root;
	Stack<NodeClass> stack;

	public static void main(String[] args) {
		InorderWithoutRecursion b = new InorderWithoutRecursion();
		NodeClass root = b.createNode(1);
		root.left = b.createNode(7);
		root.right = b.createNode(5);
		root.left.left = b.createNode(2);
		root.left.right = b.createNode(6);
		root.left.right.left = b.createNode(5);
		root.left.right.right = b.createNode(11);
		root.right.right = b.createNode(9);
		root.right.right.left = b.createNode(4);

		b.inorderWithoutRecursion(root);

		System.out.println();
		b.printBoundaryNodesOfTree(root);
		System.out.println();

	}

	public void printBoundaryNodesOfTree(NodeClass root) {

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

	private void printRightBoundaryNodes(NodeClass root) {

		Stack<NodeClass> stack = new Stack<>();
		if (root.right != null) {
			stack.add(root.right);
		}
		System.out.println("Right boundary nodes : ");

		NodeClass node = stack.peek();
		while (node.right != null) {
			stack.add(node.right);
			node = node.right;
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");

		}

	}

	private void printLeafNodes(NodeClass root) {

		Stack<NodeClass> stack = new Stack<>();
		stack.add(root);
		NodeClass node;
		System.out.println("Leaf nodes");

		while (!stack.isEmpty()) {
			node = stack.pop();

			if (node.left == null && node.right == null) {
				System.out.print(node.data + " ");
			}

			if (node.right != null) {
				stack.add(node.right);
			}

			if (node.left != null) {
				stack.add(node.left);
			}
		}

	}

	private void printLeftBoundaryNodes(NodeClass root) {
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

	private void inorderWithoutRecursion(NodeClass root) {

		stack = new Stack<>();
		NodeClass node;

		if (root == null) {
			return;
		}

		while (root != null) {
			stack.add(root);
			System.out.println(root.data);
			root = root.left;
		}

		try {
			while (!stack.isEmpty()) {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;

				if (node != null) {
					while (node != null) {
						stack.add(node);
						node = node.left;
					}
				}
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Size of Stack = " + stack.size());
			System.out.println(e);
		}

	}

	private NodeClass createNode(int data) {
		NodeClass node = new NodeClass(data);
		return node;
	}
}
