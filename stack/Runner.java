package stack;

import java.util.Stack;

public class Runner {
	public static void main(String[] args) {
		// StackMain stack = new StackMain();
		// stack.push(1);
		// stack.push(2);
		// stack.push(3);
		// stack.push(4);
		// stack.push(5);
		//
		// stack.pop();
		//
		// int value = stack.peek();
		// System.out.println("Peek value of STACK : " + value);
		//
		// stack.size();
		// System.out.println("Empty Stack : " + stack.isEmpty());
		//
		// stack.printStack();

		 DynamicStack stack = new DynamicStack();
		
		 stack.push(1);
		 stack.push(2);
		 stack.push(3);
		 stack.push(4);
		 stack.push(5);
		
		 stack.pop();
		 System.out.println("Pop 1");
		 stack.pop();
		 System.out.println("Pop 2");
		 stack.pop();
		 System.out.println("Pop 3");
//		 stack.pop();
//		 System.out.println("Pop 4");
//		 stack.pop();
//		 System.out.println("Pop 5");
//		 stack.pop();
//		 System.out.println("Pop 6");
		
		 System.out.println();
		 stack.printSizeAndElements();

	}
}
