package singly_Linked_List;

public class SinglyLinkedLinked {

	static Node head;

	public static void main(String[] args) {
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(4);
		Node fourth = new Node(5);

		SinglyLinkedLinked singlyLinkedList = new SinglyLinkedLinked();

		singlyLinkedList.head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;

		insertNodeAtFirst(9);
		insertNodeAtFirst(8);
		insertNodeAtFirst(7);
		insertNodeAtFirst(6);

		insertNodeAtLast(3);
		insertNodeAtLast(10);
		insertNodeAtLast(11);

		insertInMiddle(6, 20);
		insertInMiddle(6, 22);

		deleteNode(8);
		deleteNode(9);
		deleteNode(20);
		deleteNode(6);
		deleteNode(11);

		deleteAtPosition(4);
		deleteAtPosition(0);
		deleteAtPosition(0); // 22 7 1 2 4 5 3 10
		deleteAtPosition(7);

		print();
		getCount();
		System.out.println("Recursive Count = " + getRecursiveCount(head));
	}

	private static void insertInMiddle(int data, int value) {
		Node node = new Node(value);
		Node temp = head;

		if (head == null) {
			head = node;
		} else {
			while (temp.data != data) {
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
		}

	}

	private static void insertNodeAtFirst(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;

	}

	private static void insertNodeAtLast(int value) {
		Node node = new Node(value);
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	private static void deleteNode(int value) {
		Node temp = head, prev = null;

		if ((temp != null) && (temp.data == value)) {
			head = temp.next;
			return;
		}

		while ((temp != null) && (temp.data != value)) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;
	}

	private static void deleteAtPosition(int position) {
		// 22 7 1 2 4 5 3 10

		Node temp = head, prev = null;

		if (temp == null) {
			return;
		} else if (temp.next == null) {
			if (position == 0) {
				head = null;
			}
			return;
		}

		if (position == 0) {
			head = temp.next;
		} else {
			for (int i = 0; (i < position - 1) && (temp != null); i++) {
				if (temp != null) {
					temp = temp.next;
				}
			}

			if (temp == null || temp.next == null) {
				return;
			}
			temp.next = temp.next.next;
		}

	}

	public static void getCount() {
		Node temp = head;
		int count = 0;

		while (temp != null) {
			temp = temp.next;
			count += 1;
		}
		System.out.println("Count = " + count);

	}

	public static int getRecursiveCount(Node node) {
		Node temp = node;

		if (temp == null) {
			return 0;
		} else {
			return 1 + getRecursiveCount(temp.next);
		}
	}

	public static void print() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
