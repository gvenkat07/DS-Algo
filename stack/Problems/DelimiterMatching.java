package stack.Problems;

import java.util.Stack;

class Delimiter {

	Stack<Character> stack;
	int answer;

	public boolean checkDelimiter(String sentence) {
		answer = 0;
		stack = new Stack<>();
		System.out.println("Entered String : " + sentence);
		if (sentence.isEmpty()) {
			return false;
		}
		for (int i = 0; i < sentence.length(); i++) {
			// System.out.println(sentence.charAt(i));

			if ((sentence.charAt(i) == '(') || (sentence.charAt(i) == '{') || (sentence.charAt(i) == '[')) {
				stack.push(sentence.charAt(i));
			} else if ((sentence.charAt(i) == ')') || (sentence.charAt(i) == '}') || (sentence.charAt(i) == ']')) {

				if (stack.isEmpty()) {
					return false;
				}

				if ((sentence.charAt(i) == ')') && (stack.peek() == '(')) {
					stack.pop();
					answer = 1;
				} else if ((sentence.charAt(i) == '}') && (stack.peek() == '{')) {
					stack.pop();
					answer = 1;
				} else if ((sentence.charAt(i) == ']') && (stack.peek() == '[')) {
					stack.pop();
					answer = 1;
				} else {
					return false;
				}
			}

		}

		if ((answer == 1) && stack.isEmpty()) {
			return true;
		} else {

			return false;
		}

	}

}

public class DelimiterMatching {
	public static void main(String[] args) {
		Delimiter d = new Delimiter();

		String sentence1 = "a{sd{aa}sd}(sdsd)";
		System.out.println("Answer 1: " + d.checkDelimiter(sentence1));

		String sentence2 = "a{sd{aa}sd";
		System.out.println("Answer 2: " + d.checkDelimiter(sentence2));

		String sentence3 = "a{sd{aa}sd](sdsd]";
		System.out.println("Answer 3: " + d.checkDelimiter(sentence3));

		String sentence4 = "]{sd{aa}sd}(sdsd)";
		System.out.println("Answer 4: " + d.checkDelimiter(sentence4));

		String sentence5 = "{}()";
		System.out.println("Answer 5: " + d.checkDelimiter(sentence5));

		String sentence6 = "(";
		System.out.println("Answer 6: " + d.checkDelimiter(sentence6));

	}
}
