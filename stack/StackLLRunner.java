package stack;

public class StackLLRunner {
	public static void main(String[] args) {

		StackUsingLinkedList stack = new StackUsingLinkedList();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.top();
		
		System.out.print("Stack Elements : ");
		stack.printStackElements();

	}
}
