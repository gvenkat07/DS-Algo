package stack;

public class BasicStack {

	int[] stack = new int[10];
	int top = 0;

	public void push(int data) {
		if (top < stack.length) {
			stack[top] = data;
			top++;
		} else {
			System.err.println("Stack is Full : Cannot fill further");
		}

	}

	public void printStack() {

		for (int i = top - 1; i >= 0; i--) {
			System.out.print(stack[i] + " ");
		}

	}

	public int pop() {

		if (top > 0) {
			top--;
			int data = stack[top];
			stack[top] = 0;
			return data;
		} else {
			System.err.println("Empty stack : Cannot delete further");
			return 0;
		}

	}

	public int peek() {
		return stack[top - 1];
	}

	public void size() {
		System.out.println("Stack Size : " + top);

	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}

}
