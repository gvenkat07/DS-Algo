package binary_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

class Nodes {
	Nodes left;
	Nodes right;
	int data;

	public Nodes(int data) {
		this.data = data;
		left = null;
		right = null;
	}

}

public class Binary {

	public static void main(String[] args) {
		Binary b = new Binary();
		Nodes root = b.createNode(2);
		root.left = b.createNode(7);
		root.right = b.createNode(5);
		root.left.left = b.createNode(2);
		root.left.right = b.createNode(6);
		root.left.right.left = b.createNode(5);
		root.left.right.right = b.createNode(11);
		root.right.right = b.createNode(9);
		root.right.right.left = b.createNode(4);

		System.out.print("InOrder traversal : ");
		b.inorder(root);
		System.out.println();

		System.out.println("Sum of Nodes: " + b.sumOfNodes(root));

		System.out.println("Difference ODD-EVEN nodes: " + Math.abs(b.differenceOddEven(root)));

		System.out.println("Total nodes: " + b.totalNodes(root));

		System.out.println("Leaf nodes: " + b.leafNodes(root));

		System.out.println("Height of tree: " + b.heightOfTree(root));
		//
		// // Incomplete
		// System.out.println("Depth of a node: " + b.depthOfNode(root));
		//
		// // Incomplete
		// System.out.println("Height of node: " + b.heightOfGivenNode());

		System.out.print("Level Order Particular: ");
		b.levelOrderParticular(root, 2);
		System.out.println();

		System.out.println("Level order of Tree RECURSION:");
		b.levelOrderOfTree(root);

		System.out.println("Level order of Tree ITERATIVE: ");
		b.levelOrderIterative(root);
		System.out.println();

		System.out.println("Level Order of Tree Iterative Line By Line : ");
		b.levelOrderIterativeLineByLine(root);

		System.out.println("Reverse Level Order ITERATIVE:");
		b.reverseLevelOrderIterative(root);
		System.out.println();

		System.out.println("Left view of Tree :");
		b.leftViewOfTree(root);

		System.out.println("Right view of Tree :");
		b.rightViewOfTree(root);

		System.out.println("Inorder Traversal ITERATION :");
		b.inorderTraversalUsingIteration(root);

	}

	private void inorderTraversalUsingIteration(Nodes root) {
		
		
	}

	private void rightViewOfTree(Nodes root) {
		Queue<Nodes> queue = new LinkedList<>();
		queue.add(root);
		Nodes temp;

		while (!queue.isEmpty()) {
			int count = queue.size();

			for (int i = 0; i < count; i++) {
				if (i == count - 1) {
					temp = queue.remove();
					if (temp.left != null) {
						queue.add(temp.left);
					}
					if (temp.right != null) {
						queue.add(temp.right);
					}
					System.out.println(temp.data);

					continue;
				}

				temp = queue.remove();

				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}

			}

		}

	}

	private void leftViewOfTree(Nodes root) {
		Queue<Nodes> queue = new LinkedList<>();
		queue.add(root);
		Nodes temp;

		while (!queue.isEmpty()) {
			int count = queue.size();

			for (int i = 0; i < count; i++) {
				if (i == 0) {
					temp = queue.remove();
					if (temp.left != null) {
						queue.add(temp.left);
					}
					if (temp.right != null) {
						queue.add(temp.right);
					}
					System.out.println(temp.data);

					continue;
				}

				temp = queue.remove();

				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}

			}

		}

	}

	private void levelOrderIterativeLineByLine(Nodes root) {

		Queue<Nodes> queue = new LinkedList<>();
		queue.add(root);
		Nodes temp;

		while (!queue.isEmpty()) {
			int count = queue.size();

			for (int i = 0; i < count; i++) {
				temp = queue.remove();
				System.out.print(temp.data + " ");

				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			System.out.println();

		}

	}

	private void reverseLevelOrderIterative(Nodes root) {
		Queue<Nodes> queue = new LinkedList<>();
		Stack<Nodes> stack = new Stack<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Nodes temp = queue.remove();
			System.out.print(temp.data + " ");
			stack.add(temp);

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}

		}

		System.out.println();
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");
		}

	}

	// Iterative approach for level order traversal
	private void levelOrderIterative(Nodes root) {

		Queue<Nodes> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Nodes temp = queue.remove();
			System.out.print(temp.data + " ");

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}

		}

	}

	private void levelOrderOfTree(Nodes root) {
		if (root == null) {
			return;
		}

		for (int level = 1; level <= heightOfTree(root); level++) {
			levelOrderParticular(root, level);
			System.out.println();
		}

	}

	private void levelOrderParticular(Nodes root, int level) {
		if (root == null) {
			return;
		}

		if (level == 1) {
			System.out.print(root.data + " ");
			return;
		} else {
			levelOrderParticular(root.left, level - 1);
			levelOrderParticular(root.right, level - 1);

		}

	}

	// Line 47
	private void depthOfNode(Nodes root) {

	}

	// Line 50
	private void heightOfGivenNode(Nodes root) {

	}

	public Nodes createNode(int data) {
		Nodes new_node = new Nodes(data);
		return new_node;
	}

	// Inorder, Preorder and PostOrder - ALl similar code
	public void inorder(Nodes root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(" " + root.data);
		inorder(root.right);

	}

	public int sumOfNodes(Nodes root) {
		if (root == null) {
			return 0;
		}

		return sumOfNodes(root.left) + root.data + sumOfNodes(root.right);
	}

	public int differenceOddEven(Nodes root) {
		if (root == null) {
			return 0;
		}

		return root.data - differenceOddEven(root.left) - differenceOddEven(root.right);
	}

	private int totalNodes(Nodes root) {
		if (root == null) {
			return 0;
		}

		return 1 + totalNodes(root.left) + totalNodes(root.right);

	}

	private int leafNodes(Nodes root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		}

		return leafNodes(root.left) + leafNodes(root.right);
	}

	private int heightOfTree(Nodes root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));

	}

}
