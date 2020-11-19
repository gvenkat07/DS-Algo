package stack.Problems;

import java.util.ArrayList;
import java.util.Scanner;

class StackMain {

	int top = 0;
	char[] letters;
	ArrayList<String> stack = new ArrayList<>();

	public void push(String word) {
		if (word.isEmpty()) {
			System.out.println("Empty word : Enter a word ith atleast one character");
			return;
		}

		letters = new char[word.length()];
		pushLetters(word);
		printReverseStack();
	}

	private void printReverseStack() {
		for (int i = top - 1; i >= 0; i--) {
			System.out.print(letters[i] + " ");
		}
	}

	private void pushLetters(String word) {
		for (int i = 0; i < word.length(); i++) {
			letters[i] = word.charAt(i);
			top++;
		}

	}

}

public class ReverseString {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter word to reverse :");
		String word = input.next();
		StackMain stack = new StackMain();

		stack.push(word);

	}
}
