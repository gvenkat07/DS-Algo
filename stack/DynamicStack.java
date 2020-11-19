package stack;

public class DynamicStack {

	int capacity = 2;
	int[] stack = new int[capacity];
	int top = 0;

	public void push(int data) {

		if (top < stack.length) {
			stack[top] = data;
			top += 1;
		} else {
			increaseStackSize();
			push(data);
		}

	}

	private void increaseStackSize() {

		int[] newStackArray = new int[(top) * 2];
		System.arraycopy(stack, 0, newStackArray, 0, top);
		stack = newStackArray;
		capacity = top * 2;

	}

	public void printSizeAndElements() {

		System.out.println("Stack size : " + stack.length);
		System.out.print("Stack elements : ");
		if (top == 0) {
			System.out.println("Empty Stack");
		} else {
			for (int i = top - 1; i >= 0; i--) {
				System.out.print(stack[i] + " ");
			}
		}

	}

	public void pop() {
		if (top == 0) {
			capacity = 2;
			System.out.println("Size of Array:" + stack.length);
			System.out.println("Already Empty Stack --> Cannot delete");

		} else {
			top -= 1;
			int[] newStack = new int[stack.length];
			System.arraycopy(stack, 0, newStack, 0, top);
			stack = newStack;

			shrink();
		}

	}

	private void shrink() {
		if ((top) < (stack.length / 2)) {
			int[] newStack = new int[stack.length / 2];
			System.arraycopy(stack, 0, newStack, 0, top);
			stack = newStack;
			System.out.println("Stack Size after pop : " + stack.length);
		} else {
			System.out.println("Stack Size after pop : " + stack.length);

		}

	}

}
