package com.queue;

public class Queue {
	public static void main(String[] args) {
		QueueImplementation queue = new QueueImplementation();
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);

		queue.printElements();
		System.out.println("Size : " + queue.getSize());

		queue.remove();
		queue.remove();
		queue.remove();
		System.out.println("Size : " + queue.getSize());
		
		queue.printElements();
	}
}

class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
		next = null;
	}

}

class QueueImplementation {

	Node head;
	Node rear;
	int size = 0;

	public void insert(int data) {
		if (size == 0) {
			head = createNewNode(data);
			rear = head;
			size++;
			return;
		}
		rear.next = createNewNode(data);
		rear = rear.next;
		size++;

	}

	public void printElements() {
		System.out.print("All Elements --> ");
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;

		}
		System.out.println();
	}

	public int getSize() {
		return size;
	}

	private Node createNewNode(int data) {
		Node newNode = new Node(data);
		return newNode;
	}

	public void remove() {
		if (size == 0) {
			System.out.println("Empty List --> Cannot remove");
			return;
		} else if (size == 1) {
			head = null;
			rear = null;
			return;
		}

		head = head.next;
		size -= 1;
		System.out.println("Element removed successfully");

	}

}
