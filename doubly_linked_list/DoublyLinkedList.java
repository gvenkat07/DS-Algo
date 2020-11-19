package doubly_linked_list;

import java.awt.HeadlessException;

public class DoublyLinkedList {

	static Node head;

	public static void main(String[] args) {

		Node first = new Node(1);
		head = first;

		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);

		first.next = two;
		first.prev = null;
		two.next = three;
		two.prev = first;
		three.next = four;
		three.prev = two;
		four.next = five;
		four.prev = three;
		five.next = six;
		five.prev = four;
		six.next = seven;
		six.prev = five;
		seven.next = eight;
		seven.prev = six;
		eight.prev = seven;

		insertAtFirst(10);
		insertAtFirst(20);
		insertAtFirst(30);
		// 30 20 10 1 2 3 4 5 6 7 8

		insertAtPosition(40, 4);
		insertAtPosition(50, 5);
		insertAtPosition(100, 1);
		insertAtPosition(200, 1);
		insertAtPosition(500, 15);
		insertAtPosition(600, 17);

		deleteAtFirst();
		deleteAtFirst();

		// 30 20 10 40 50 1 2 3 4 5 6 7 500 8 600
		deleteAtPosition(1);
		deleteAtPosition(1);
		deleteAtPosition(4);
		deleteAtPosition(12);
		deleteAtPosition(15);
		// 10 40 50 2 3 4 5 6 7 500 8

		printLL();

		maximumInLL();

	}

	static void printLL() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	static void insertAtFirst(int value) {
		Node temp = head;
		Node node = new Node(value);

		node.next = head;
		node.prev = null;
		head.prev = node;
		head = node;
	}

	static void insertAtPosition(int value, int position) {
		Node node = new Node(value);
		Node temp = head;

		if (temp == null) {
			return;
		}
		if (position == 1) {
			node.next = head;
			head.prev = node;
			head = node;

			return;
		}

		for (int i = 1; i < position - 1; i++) {
			if (temp != null) {
				temp = temp.next;
			} else {
				return;
			}
		}

		if (temp.next == null) {
			temp.next = node;
			node.prev = temp;
		} else {
			node.next = temp.next;
			node.prev = temp;
			temp.next.prev = node;
			temp.next = node;
		}

	}

	static void deleteAtFirst() {

		if (head == null) {
			return;
		}
		head = head.next;
	}

	static void deleteAtPosition(int position) {
		Node temp = head;

		if (temp == null) {
			return;
		}

		if (position == 1) {
			head = head.next;
		}

		for (int i = 1; i < position - 1; i++) {
			if (temp != null) {
				temp = temp.next;
			} else {
				return;
			}
		}
		if (temp.next == null) {
			return;
		} else if (temp.next.next == null) {
			temp.next.prev = null;
			temp.next = null;
		} else {
			temp.next = temp.next.next;
			temp.next.next.prev = temp;

		}

	}

	static void maximumInLL() {
		Node temp = head;
		int max = 0;

		while (temp != null) {
			if (temp.data > max) {
				max = temp.data;
			}
			temp = temp.next;
		}
		System.out.println("Largest number --> " + max);
	}

//	static void middleOfLL() {
//		Node temp = head;
//
//		while (temp != null) {
//
//		}
//
//	}

}
