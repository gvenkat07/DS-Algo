package doubly_linked_list;

public class CircularLinkedList {

	static Node head;
	static Node tail;

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
		tail = eight;

		first.next = two;
		first.prev = eight;
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
		eight.next = first;
		eight.prev = seven;

		insertAtFirst(10);
		insertAtFirst(20);
		insertAtFirst(30);
//		// 30 20 10 1 2 3 4 5 6 7 8
//
		insertAtPosition(40, 4);
		insertAtPosition(50, 5);
		insertAtPosition(100, 1);
		insertAtPosition(200, 1);
		insertAtPosition(500, 15);
		insertAtPosition(600, 17);
		// 200 100 30 20 10 40 50 1 2 3 4 5 6 7 500 8 600
////
//		deleteAtFirst();
//		deleteAtFirst();
//
//		// 30 20 10 40 50 1 2 3 4 5 6 7 500 8 600
//		deleteAtPosition(1);
//		deleteAtPosition(1);
//		deleteAtPosition(4);
//		deleteAtPosition(12);
//		deleteAtPosition(15);
//		// 10 40 50 2 3 4 5 6 7 500 8

		printLL();
	}

	private static void printLL() {
		// TODO Auto-generated method stub
		Node temp = head;
		while (temp != null) {
			if (temp != tail) {
				System.out.println(temp.data);
				temp = temp.next;
				continue;
			}
			System.out.println(temp.data);
			break;
		}

	}

	private static void deleteAtPosition(int i) {

	}

	private static void deleteAtFirst() {

	}

	private static void insertAtPosition(int value, int position) {
		Node node = new Node(value);
		Node temp = head;

		if (head != null) {
			if (temp.next == null) {
				if (position <= 0) {
					System.out.println("Enter valid position '>1' ");
					return;
				}
				node.next = head;
				node.prev = head;
				head.next = node;
				head.prev = node;
				if (position == 1) {
					head = node;
				} else {
					tail = node;
				}
			} else {
				if (position == 1) {
					node.next = head;
					node.prev = tail;
					temp.prev = node;
					tail.next = node;
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
					node.next = head;
					node.prev = temp;
					head.prev = node;
					temp.next = node;
				} else {
					node.next = temp.next;
					node.prev = temp;
					temp.next.prev = node;
					temp.next = node;
				}

			}

		} else {
			// Irrespective of the position...value inserted.
			head = node;
		}

	}

	private static void insertAtFirst(int value) {
		Node node = new Node(value);

		if (head == null) {
			head = node;
		} else if (head == tail) {
			node.next = head;
			node.prev = head;
			head.next = node;
			head.prev = node;
			head = node;
		} else {
			node.next = head;
			node.prev = tail;
			head.prev = node;
			node.prev.next = node;
			head = node;
		}
	}

}
