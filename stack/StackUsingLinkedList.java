package stack;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}

public class StackUsingLinkedList {
	Node head;

	public void push(int data) {
		if (isHeadNull()) {
			head = createNewNode(data);
		}

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	private Node createNewNode(int value) {
		Node newNode = new Node(value);

		return newNode;
	}

	private boolean isHeadNull() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void printStackElements() {
		Node temp = head;

		while (temp.next != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

	public void pop() {
		if (isHeadNull()) {
			System.err.println("Empty Stack --> Cannot pop");
			return;
		}
		System.out.println("Poped element : " + head.data);
		head = head.next;

	}

	public void top() {
		System.out.println("Top of Stack : " + head.data);
	}

}
